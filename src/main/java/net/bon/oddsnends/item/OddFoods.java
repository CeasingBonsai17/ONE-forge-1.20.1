package net.bon.oddsnends.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class OddFoods {
    public static final FoodProperties CIDERINE = new FoodProperties.Builder().nutrition(4).saturationMod(0.4f).build();
    public static final FoodProperties CARAMELIZED_CIDERINE = new FoodProperties.Builder().fast().nutrition(2).saturationMod(0.5f).build();
    public static final FoodProperties CANDIED_CIDERINE = new FoodProperties.Builder().fast().nutrition(2).saturationMod(0.2f).build();
    public static final FoodProperties CIDERINE_CIDER = new FoodProperties.Builder().saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 1000), 1.0f).alwaysEat().build();
    public static final FoodProperties ICE_CREAM = new FoodProperties.Builder().nutrition(6).saturationMod(0.4f).build();
    public static final FoodProperties CIDERINE_ICE_CREAM = new FoodProperties.Builder().nutrition(6).saturationMod(0.4f).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 500), 1.0f).build();
    public static final FoodProperties MINTY_CIDERINE_ICE_CREAM = new FoodProperties.Builder().nutrition(6).saturationMod(0.4f).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 300), 1.0f).build();
    public static final FoodProperties ANTHESI_FRUIT = new FoodProperties.Builder().nutrition(4).saturationMod(0.4f).build();
    public static final FoodProperties ANTHESI_FRUIT_HALF = new FoodProperties.Builder().nutrition(2).saturationMod(0.3f).fast().build();
    public static final FoodProperties ANTHESI_ICE_CREAM = new FoodProperties.Builder().nutrition(6).saturationMod(0.4f).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 500), 1.0f).build();
    public static final FoodProperties LACO_BEANS = new FoodProperties.Builder().nutrition(3).saturationMod(0.4f).build();
    public static final FoodProperties CANDIED_LACO_BEAN = new FoodProperties.Builder().nutrition(2).saturationMod(0.3f).fast().build();
    public static final FoodProperties LACO_BAR = new FoodProperties.Builder().nutrition(5).saturationMod(0.6f).build();
    public static final FoodProperties ALGAE = new FoodProperties.Builder().nutrition(2).saturationMod(0.1f).fast().build();
    public static final FoodProperties MANDRAKE = new FoodProperties.Builder().nutrition(3).saturationMod(0.8f).effect(new MobEffectInstance(MobEffects.CONFUSION, 300), 0.65f).build();
    public static final FoodProperties PEELED_MANDRAKE = new FoodProperties.Builder().nutrition(3).saturationMod(0.8f).build();
    public static final FoodProperties LACO_COVERED_MANDRAKE = new FoodProperties.Builder().nutrition(7).saturationMod(0.9f).build();

    public static final FoodProperties ANTHESI_CAKE_SLICE = new FoodProperties.Builder().nutrition(2).saturationMod(1.5f).alwaysEat().build();
    public static final FoodProperties MILKSHAKE = new FoodProperties.Builder().nutrition(2).saturationMod(0.1f).fast().effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 240, 1), 1.0f).build();
    public static final FoodProperties CIDERINE_MILKSHAKE = new FoodProperties.Builder().nutrition(2).saturationMod(1.5f).alwaysEat().effect(new MobEffectInstance(MobEffects.REGENERATION, 700), 1.0f).build();
    public static final FoodProperties ANTHESI_MILKSHAKE = new FoodProperties.Builder().nutrition(2).saturationMod(1.5f).alwaysEat().effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 700), 1.0f).build();

    //public static final FoodProperties MINTY_ICE_CREAM = new FoodProperties.Builder().nutrition(6).saturationMod(0.4f).effect(new MobEffectInstance(NeapolitanMobEffects.BERSERKING, 700, 0), 1.0f).build();
}