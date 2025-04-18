package net.bon.oddsnends.particle;

import net.bon.oddsnends.OddsNEnds;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class OddParticleTypes {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, OddsNEnds.MOD_ID);

    public static final RegistryObject<SimpleParticleType> RAGE_FIRE_FLAME = PARTICLE_TYPES.register("rage_fire_flame", () -> new SimpleParticleType(false){});
    public static final RegistryObject<SimpleParticleType> MANA_RUNE = PARTICLE_TYPES.register("mana_rune", () -> new SimpleParticleType(false){});

    public static void init(IEventBus eventBus) {
        PARTICLE_TYPES.register(eventBus);
    }
}