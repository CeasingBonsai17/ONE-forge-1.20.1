package net.bon.oddsnends.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class OddFoods {
    public static final FoodProperties ALGAE = new FoodProperties.Builder().nutrition(2).saturationMod(0.0f).fast().build();
    public static final FoodProperties MANDRAKE = new FoodProperties.Builder().nutrition(3).saturationMod(0.8f).effect(new MobEffectInstance(MobEffects.CONFUSION, 300, 0), 0.5f).build();
    public static final FoodProperties PEELED_MANDRAKE = new FoodProperties.Builder().nutrition(3).saturationMod(0.8f).build();
}