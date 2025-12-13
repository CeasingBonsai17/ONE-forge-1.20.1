package net.bon.oddsnends.block.type;

import net.bon.oddsnends.block.OddBlocks;
import net.bon.oddsnends.state.property.OddProperties;
import net.bon.oddsnends.util.OddTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CiderineBlossomBlock extends Block implements BonemealableBlock {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_1;
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{Block.box(5.0, 12.0, 5.0, 11.0, 14.0, 11.0), Block.box(2.0, 10.0, 2.0, 14.0, 13.0, 14.0)};
    public static final BooleanProperty POLLINATED = OddProperties.POLLINATED;
    public CiderineBlossomBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(POLLINATED, false));
    }

    public boolean isRandomlyTicking(BlockState state) {
        return true;
    }

    public BlockState updateShape(BlockState state, Direction direction, BlockState blockState, LevelAccessor level, BlockPos pos, BlockPos blockPos) {
        return !state.canSurvive(level, pos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, direction, state, level, pos, blockPos);
    }

    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return level.getBlockState(pos.above()).is(OddTags.CIDERINE_LEAVES);
    }

    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (entity instanceof Bee || entity instanceof Bat && state.getValue(AGE) == 1) {
            level.setBlock(pos, state.setValue(POLLINATED, true), 11);
        }
        super.entityInside(state, level, pos, entity);
    }

    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if(state.getValue(AGE) == 0) {
            level.setBlock(pos, state.setValue(AGE, 1), 11);;
        } if(state.getValue(AGE) == 1 && random.nextInt(8) == 3) {
            level.setBlockAndUpdate(pos, OddBlocks.CIDERINE_CROP.get().defaultBlockState());
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE, POLLINATED);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state, boolean b) {
        return state.getValue(AGE) == 0 || state.getValue(POLLINATED);
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        if(state.getValue(AGE) == 0) {
            level.setBlock(pos, state.setValue(AGE, 1), 11);;
        } if(state.getValue(POLLINATED)) {
            level.setBlockAndUpdate(pos, OddBlocks.CIDERINE_CROP.get().defaultBlockState());
        }
    }

    public VoxelShape getShape(BlockState state, BlockGetter view, BlockPos pos, CollisionContext context) {
        return SHAPE_BY_AGE[state.getValue(AGE)];
    }
}