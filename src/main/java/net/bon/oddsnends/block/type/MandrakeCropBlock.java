package net.bon.oddsnends.block.type;

import net.bon.oddsnends.block.OddBlocks;
import net.bon.oddsnends.item.OddItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class MandrakeCropBlock extends CropBlock {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_2;
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{Block.box(2.0, 0.0, 2.0, 14.0, 2.0, 14.0), Block.box(2.0, 0.0, 2.0, 14.0, 4.0, 14.0), Block.box(2.0, 0.0, 2.0, 14.0, 6.0, 14.0)};

    public MandrakeCropBlock(Properties properties) {
        super(properties);
    }

    protected IntegerProperty getAgeProperty() {
        return AGE;
    }

    public int getMaxAge() {
        return 2;
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return true;
    }

    protected ItemLike getBaseSeedId() {
        return OddItems.MANDRAKE_SEEDS.get();
    }

    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource source) {
        if (source.nextInt(2) != 0 && state.getValue(AGE) <= 1) {
            super.randomTick(state, level, pos, source);
        } if (source.nextInt(2) != 0 && state.getValue(AGE) == 2) {
            level.setBlockAndUpdate(pos, OddBlocks.MANDRAKE.get().defaultBlockState().setValue(MandrakeBlock.GROWING, true));
        }
    }

    public void performBonemeal(ServerLevel level, RandomSource source, BlockPos pos, BlockState state) {
        if(state.getValue(AGE) <= 1) {
            this.growCrops(level, pos, state);
        } if (state.getValue(AGE) == 2) {
            level.setBlockAndUpdate(pos, OddBlocks.MANDRAKE.get().defaultBlockState().setValue(MandrakeBlock.GROWING, true));
        }
    }

    protected int getBonemealAgeIncrease(Level level) {
        return super.getBonemealAgeIncrease(level) / 2;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> state) {
        state.add(new Property[]{AGE});
    }

    public VoxelShape getShape(BlockState state, BlockGetter view, BlockPos pos, CollisionContext context) {
        return SHAPE_BY_AGE[this.getAge(state)];
    }
}