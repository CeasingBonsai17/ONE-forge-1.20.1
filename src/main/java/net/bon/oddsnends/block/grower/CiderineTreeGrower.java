package net.bon.oddsnends.block.grower;

import net.bon.oddsnends.worldgen.feature.OddConfiguredFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class CiderineTreeGrower extends AbstractTreeGrower {
    public CiderineTreeGrower() {
    }

    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource source, boolean bl) {
        if (source.nextInt(15) == 0) {
            return OddConfiguredFeatures.LUSH_CIDERINE_TREE;
        } else {
            return OddConfiguredFeatures.CIDERINE_TREE;
        }
    }
}