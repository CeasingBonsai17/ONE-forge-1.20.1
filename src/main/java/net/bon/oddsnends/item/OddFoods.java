package net.bon.oddsnends.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class OddFoods {
    public static final FoodProperties LACO_BEANS = new FoodProperties.Builder().nutrition(5).saturationMod(0.4f).build();
    public static final FoodProperties ALGAE = new FoodProperties.Builder().nutrition(2).saturationMod(0.1f).fast().build();
    public static final FoodProperties MANDRAKE = new FoodProperties.Builder().nutrition(3).saturationMod(0.8f).effect(new MobEffectInstance(MobEffects.CONFUSION, 300, 0), 0.5f).build();
    public static final FoodProperties PEELED_MANDRAKE = new FoodProperties.Builder().nutrition(3).saturationMod(0.8f).build();
    public static final FoodProperties CIDERINE = new FoodProperties.Builder().nutrition(6).saturationMod(0.3f).build();
    public static final FoodProperties ICE_CREAM = new FoodProperties.Builder().nutrition(6).saturationMod(0.4f).build();


    //public static final FoodProperties MINTY_ICE_CREAM = new FoodProperties.Builder().nutrition(6).saturationMod(0.4f).effect(new MobEffectInstance(NeapolitanMobEffects.BERSERKING, 700, 0), 1.0f).build();
}