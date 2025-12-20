package net.bon.oddsnends.potion;

import net.bon.oddsnends.OddsNEnds;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class OddPotions {
    public static final DeferredRegister<Potion> POTION =
            DeferredRegister.create(ForgeRegistries.POTIONS, OddsNEnds.MOD_ID);

    public static final RegistryObject<Potion> BAD_LUCK_POTION = POTION.register("odd_bad_luck", () ->
            new Potion(new MobEffectInstance(MobEffects.UNLUCK, 6000)));


    public static void init(IEventBus eventBus) {
        POTION.register(eventBus);
    }
}
