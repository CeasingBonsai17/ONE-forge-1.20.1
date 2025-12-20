package net.bon.oddsnends.worldgen.feature.custom;

import com.mojang.serialization.Codec;
import net.bon.oddsnends.block.OddBlocks;
import net.bon.oddsnends.block.type.CaveBranchBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.VineBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class CaveBranchesFeature extends Feature<NoneFeatureConfiguration> {
    public CaveBranchesFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> ctx) {
        WorldGenLevel level = ctx.level();
        BlockPos origin = ctx.origin();
        ctx.config();
        if (!level.isEmptyBlock(origin)) {
            return false;
        } else {
            Direction[] direction = Direction.values();
            int length = direction.length;

            for(int var6 = 0; var6 < length; ++var6) {
                Direction direction2 = direction[var6];
                if (direction2 != Direction.DOWN && CaveBranchBlock.isAcceptableNeighbour(level, origin.relative(direction2), direction2)) {
                    level.setBlock(origin, OddBlocks.CAVE_BRANCHES.get().defaultBlockState().setValue(CaveBranchBlock.getPropertyForFace(direction2), true), 2);
                    return true;
                }
            }
            return false;
        }
    }
}