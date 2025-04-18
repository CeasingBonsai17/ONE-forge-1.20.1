package net.bon.oddsnends.worldgen.feature;

import net.bon.oddsnends.OddsNEnds;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class OddFeatures {
    public static final DeferredRegister<Feature<?>> FEATURE = DeferredRegister.create(ForgeRegistries.FEATURES, OddsNEnds.MOD_ID);


//    public static final RegistryObject<Feature<theConfiguration>> NAME = FEATURE.register("name", () ->
//            new theFeature(theConfiguration.CODEC));


    public static void init(IEventBus eventBus) {
        FEATURE.register(eventBus);
    }
}
