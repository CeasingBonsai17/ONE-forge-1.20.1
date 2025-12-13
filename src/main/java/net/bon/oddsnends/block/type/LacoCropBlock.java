package net.bon.oddsnends.block.type;

import net.bon.oddsnends.item.OddItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Iterator;

public class LacoCropBlock extends CropBlock {
    public LacoCropBlock(Properties properties) {
        super(properties);
    }

    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        if (level.getBlockState(pos.below()).is(Blocks.FARMLAND)) {

            for (Direction direction : Direction.Plane.HORIZONTAL) {
                if (state.canBeHydrated(level, pos, level.getFluidState(pos.below().relative(direction)), pos.below().relative(direction)) || level.getBlockState(pos.below().relative(direction)).is(Blocks.FROSTED_ICE)) {
                    return true;
                }
            }
        }
        return false;
    }

    protected ItemLike getBaseSeedId() {
        return OddItems.LACO_BEANS.get();
    }
}
