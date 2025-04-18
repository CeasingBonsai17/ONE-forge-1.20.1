package net.bon.oddsnends;

import net.bon.oddsnends.particle.OddParticleTypes;
import net.bon.oddsnends.particle.type.ManaRuneParticle;
import net.minecraft.client.particle.*;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
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
}