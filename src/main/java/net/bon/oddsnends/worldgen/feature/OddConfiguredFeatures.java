package net.bon.oddsnends.worldgen.feature;

import net.bon.oddsnends.OddsNEnds;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class OddConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> CIDERINE_TREE = registerKey("ciderine_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LUSH_CIDERINE_TREE = registerKey("lush_ciderine_tree");


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(OddsNEnds.MOD_ID, name));
    }
}
