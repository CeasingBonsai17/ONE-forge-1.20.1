package net.bon.oddsnends.block.type;

import net.bon.oddsnends.state.property.OddProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CloverBlock extends BushBlock implements BonemealableBlock {
    public static final IntegerProperty CLOVERS = OddProperties.CLOVERS;
    public CloverBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state, boolean b) {
        return state.getValue(CLOVERS) < 3;
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        level.setBlock(pos, state.setValue(CLOVERS, Math.min(3, state.getValue(CLOVERS) + 1)), 11);
    }

    public boolean canBeReplaced(BlockState state, BlockPlaceContext ctx) {
        return !ctx.isSecondaryUseActive() && ctx.getItemInHand().is(this.asItem()) && state.getValue(CLOVERS) < 3 || super.canBeReplaced(state, ctx);
    }

    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        BlockState state = ctx.getLevel().getBlockState(ctx.getClickedPos());
        return state.is(this) ? state.setValue(CLOVERS, Math.min(3, state.getValue(CLOVERS) + 1)) : this.defaultBlockState();
    }

    public VoxelShape getShape(BlockState state, BlockGetter view, BlockPos pos, CollisionContext context) {
        return Block.box(0, 0, 0, 16, 3, 16);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{CLOVERS});
    }
}