package net.bon.oddsnends.item;

import net.bon.oddsnends.OddsNEnds;
import net.bon.oddsnends.block.OddBlocks;
import net.bon.oddsnends.item.type.CiderineCiderItem;
import net.bon.oddsnends.item.type.ContentBookItem;
import net.bon.oddsnends.item.type.IceCreamItem;
import net.bon.oddsnends.util.CompatUtil;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.loading.FMLLoader;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class OddItems {
    public static final DeferredRegister<Item> ITEM =
            DeferredRegister.create(ForgeRegistries.ITEMS, OddsNEnds.MOD_ID);


    public static final RegistryObject<Item> CIDERINE = ITEM.register("ciderine", () ->
            new BlockItem(OddBlocks.CIDERINE.get(), new Item.Properties().food(OddFoods.CIDERINE)));
    public static final RegistryObject<Item> CARAMELIZED_CIDERINE = ITEM.register("caramelized_ciderine", () ->
            new Item(new Item.Properties().food(OddFoods.CARAMELIZED_CIDERINE)));
    public static final RegistryObject<Item> CANDIED_CIDERINE = registerCompatItem("candied_ciderine", () ->
            new Item(new Item.Properties().food(OddFoods.CANDIED_CIDERINE)), CompatUtil.BOUNTIFULFARES);
    public static final RegistryObject<Item> CIDERINE_CIDER = registerCompatItem("ciderine_cider", () ->
            new CiderineCiderItem(new Item.Properties().food(OddFoods.CIDERINE_CIDER)), CompatUtil.FARMERSDELIGHT);
    public static final RegistryObject<Item> CIDERINE_SIGN = ITEM.register("ciderine_sign", () ->
            new SignItem(new Item.Properties().stacksTo(16), OddBlocks.CIDERINE_SIGN.get(), OddBlocks.CIDERINE_WALL_SIGN.get()));
    public static final RegistryObject<Item> CIDERINE_HANGING_SIGN = ITEM.register("ciderine_hanging_sign", () ->
            new HangingSignItem(OddBlocks.CIDERINE_HANGING_SIGN.get(), OddBlocks.CIDERINE_WALL_HANGING_SIGN.get(), new Item.Properties()));
//    public static final RegistryObject<Item> CIDERINE_BOAT = ITEM.register("ciderine_boat", () ->
//            new BoatItem(false, CIDERINE_BOAT_TYPE, new Item.Properties()));
//    public static final RegistryObject<Item> CIDERINE_CHEST_BOAT = ITEM.register("ciderine_chest_boat", () ->
//            new BoatItem(true, CIDERINE_BOAT_TYPE, new Item.Properties()));
    public static final RegistryObject<Item> FLAX_SEEDS = ITEM.register("flax_seeds", () ->
            new ItemNameBlockItem(OddBlocks.FLAX_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> FLAX_FIBERS = ITEM.register("flax_fibers", () ->
            new Item(new Item.Properties()));
    public static final RegistryObject<Item> LINEN_PATCH = ITEM.register("linen_patch", () ->
            new Item(new Item.Properties()));


    public static final RegistryObject<Item> LACO_BEANS = ITEM.register("laco_beans", () ->
            new ItemNameBlockItem(OddBlocks.LACO_CROP.get(), new Item.Properties().food(OddFoods.LACO_BEANS)));
    public static final RegistryObject<Item> CANDIED_LACO_BEAN = registerCompatItem("candied_laco_bean", () ->
            new Item(new Item.Properties().food(OddFoods.CANDIED_LACO_BEAN)), CompatUtil.BOUNTIFULFARES);
    public static final RegistryObject<Item> LACO_BAR = ITEM.register("laco_bar", () ->
            new Item(new Item.Properties().food(OddFoods.LACO_BAR)));


    public static final RegistryObject<Item> ALGAE = ITEM.register("algae", () ->
            new BlockItem(OddBlocks.ALGAE.get(), new Item.Properties().food(OddFoods.ALGAE)));

    public static final RegistryObject<Item> GIANT_PADMA_PETAL = ITEM.register("giant_padma_petal", () ->
            new Item(new Item.Properties()));

    public static final RegistryObject<Item> MANASTONE_TABLET = ITEM.register("manastone_tablet", () ->
            new ItemNameBlockItem(OddBlocks.MANASTONE_TABLET.get(), new Item.Properties()));


    public static final RegistryObject<Item> MANDRAKE_SEEDS = ITEM.register("mandrake_seeds", () ->
            new ItemNameBlockItem(OddBlocks.MANDRAKE_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> MANDRAKE = ITEM.register("mandrake", () ->
            new BlockItem(OddBlocks.MANDRAKE.get(), new Item.Properties().food(OddFoods.MANDRAKE)));
    public static final RegistryObject<Item> PEELED_MANDRAKE = ITEM.register("peeled_mandrake", () ->
            new Item(new Item.Properties().food(OddFoods.PEELED_MANDRAKE)));

//    public static final RegistryObject<Item> DUNGEON_STEEL = ITEM.register("dungeon_steel", () ->
//            new Item(new Item.Properties()));

    //public static final RegistryObject<Item> RAGE_SCONCE = ITEM.register("rage_sconce", () ->
    //        new StandingAndWallBlockItem(OddBlocks.RAGE_SCONCE.get(), OddBlocks.RAGE_WALL_SCONCE.get(), new Item.Properties(), Direction.DOWN));

//    public static final RegistryObject<Item> ANTHESI_PIT = ITEM.register("anthesi_pit", () ->
//            new Item(new Item.Properties()));
//
//    public static final RegistryObject<Item> BOOK_OF_CONTENT = ITEM.register("book_of_content", () ->
//            new ContentBookItem(new Item.Properties().stacksTo(1)));


    public static final RegistryObject<Item> CIDERINE_ICE_CREAM = registerCompatItem("ciderine_ice_cream", () ->
            new IceCreamItem(new Item.Properties().food(OddFoods.CIDERINE_ICE_CREAM)), CompatUtil.NEAPOLITAN);
    public static final RegistryObject<Item> MINTY_CIDERINE_ICE_CREAM = registerCompatItem("minty_ciderine_ice_cream", () ->
            new IceCreamItem(new Item.Properties().food(OddFoods.MINTY_CIDERINE_ICE_CREAM)), CompatUtil.NEAPOLITAN);
    public static final RegistryObject<Item> ANTHESI_ICE_CREAM = registerCompatItem("anthesi_ice_cream", () ->
            new IceCreamItem(new Item.Properties().food(OddFoods.ICE_CREAM)), CompatUtil.NEAPOLITAN);
    public static final RegistryObject<Item> LACO_SORBET = registerCompatItem("laco_sorbet", () ->
            new IceCreamItem(new Item.Properties().food(OddFoods.ICE_CREAM)), CompatUtil.NEAPOLITAN);
    public static final RegistryObject<Item> MANDRAKE_ICE_CREAM = registerCompatItem("mandrake_ice_cream", () ->
            new IceCreamItem(new Item.Properties().food(OddFoods.ICE_CREAM)), CompatUtil.NEAPOLITAN);

    private static <T extends Item> RegistryObject<T> registerCompatItem(String name, Supplier<T> item, String modId) {
        if(FMLLoader.getLoadingModList().getModFileById(modId) != null) {
            return ITEM.register(name, item);
        } else {
            return null;
        }
    }

    public static void init(IEventBus eventBus) {
        ITEM.register(eventBus);
    }
}