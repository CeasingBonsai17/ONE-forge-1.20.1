package net.bon.oddsnends;

import net.bon.oddsnends.block.OddBlocks;
import net.bon.oddsnends.particle.OddParticleTypes;
import net.bon.oddsnends.particle.type.ManaRuneParticle;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.*;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.GrassColor;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class OddsNEndsClient  {
    public static void init() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addListener(OddsNEndsClient::particles);
    }

    public static void particles(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(OddParticleTypes.RAGE_FIRE_FLAME.get(), FlameParticle.Provider::new);
        event.registerSpriteSet(OddParticleTypes.MANA_RUNE.get(), ManaRuneParticle.Factory::new);
    }

    @SubscribeEvent
    public static void registerTints() {
//        Minecraft.getInstance().getBlockColors().register(((state, tintGetter, pos, i) -> tintGetter != null && pos != null
//                ? BiomeColors.getAverageGrassColor(tintGetter, pos) : GrassColor.getDefaultColor()
//        ), OddBlocks.CLOVER_GRASS_BLOCK.get());
    }
}