package net.bon.oddsnends.block.type;

import net.bon.oddsnends.OddConfig;
import net.bon.oddsnends.block.OddBlocks;
import net.bon.oddsnends.item.OddItems;
import net.bon.oddsnends.state.property.OddProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class MandrakeBlock extends BushBlock {
    public static final BooleanProperty GROWING = OddProperties.GROWING;
    public MandrakeBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(GROWING, false));
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (player.getItemInHand(hand).isEmpty() && OddConfig.clickHarvestMandrakes) {
            if (!state.getValue(GROWING)) {
                level.setBlock(pos, Blocks.AIR.defaultBlockState(), 11);
            } if (state.getValue(GROWING)) {
                level.setBlock(pos, OddBlocks.MANDRAKE_CROP.get().defaultBlockState(), 11);
            }
            level.playSound(player, pos, SoundEvents.CAVE_VINES_BREAK, SoundSource.BLOCKS);
            MandrakeBlock.popResource(level, pos, new ItemStack(OddItems.MANDRAKE.get(), 1));
        }
        return InteractionResult.PASS;
    }

    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos blockpos = pos.below();
        boolean land = level.getBlockState(blockpos).is(Blocks.FARMLAND);
        return state.getValue(GROWING) ? land : level.getBlockState(blockpos).is(BlockTags.DIRT) || land;
    }

    public VoxelShape getShape(BlockState state, BlockGetter view, BlockPos pos, CollisionContext context) {
        return Block.box(2, 0, 2, 14, 8, 14);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> state) {
        state.add(new Property[]{GROWING});
    }
}
