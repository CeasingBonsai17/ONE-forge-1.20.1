package net.bon.oddsnends.worldgen.feature;

import net.bon.oddsnends.OddsNEnds;
import net.bon.oddsnends.worldgen.feature.custom.CaveBranchesFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class OddFeatures {
    public static final DeferredRegister<Feature<?>> FEATURE = DeferredRegister.create(ForgeRegistries.FEATURES, OddsNEnds.MOD_ID);

    public static final RegistryObject<Feature<NoneFeatureConfiguration>> CAVE_BRANCHES = FEATURE.register("cave_branches", () ->
            new CaveBranchesFeature(NoneFeatureConfiguration.CODEC));


    public static void init(IEventBus eventBus) {
        FEATURE.register(eventBus);
    }
}
