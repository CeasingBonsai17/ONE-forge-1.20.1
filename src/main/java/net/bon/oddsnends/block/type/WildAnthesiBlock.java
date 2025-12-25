package net.bon.oddsnends.block.type;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class WildAnthesiBlock extends BushBlock {
    public WildAnthesiBlock(Properties properties) {
        super(properties);
    }

    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos blockpos = pos.above();
        return state.getBlock() == this ? level.getBlockState(blockpos).canSustainPlant(level, blockpos, Direction.DOWN, this) : this.mayPlaceOn(level.getBlockState(blockpos), level, blockpos);
    }

    public VoxelShape getShape(BlockState state, BlockGetter view, BlockPos pos, CollisionContext context) {
        return Block.box(4, 10, 4, 12, 16, 12);
    }
}
