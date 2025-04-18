package net.bon.oddsnends.item;

import net.bon.oddsnends.OddsNEnds;
import net.bon.oddsnends.block.OddBlocks;
import net.bon.oddsnends.item.custom.ContentBookItem;
import net.minecraft.core.Direction;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class OddItems {

    public static final DeferredRegister<Item> ITEM =
            DeferredRegister.create(ForgeRegistries.ITEMS, OddsNEnds.MOD_ID);


    public static final RegistryObject<Item> FLAX_SEEDS = ITEM.register("flax_seeds", () ->
            new ItemNameBlockItem(OddBlocks.FLAX_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> FLAX_FIBERS = ITEM.register("flax_fibers", () ->
            new Item(new Item.Properties()));
    public static final RegistryObject<Item> LINEN_PATCH = ITEM.register("linen_patch", () ->
            new Item(new Item.Properties()));


    public static final RegistryObject<Item> ALGAE = ITEM.register("algae", () ->
            new ItemNameBlockItem(OddBlocks.ALGAE.get(), new Item.Properties().food(OddFoods.ALGAE)));

    public static final RegistryObject<Item> GIANT_PADMA_PETAL = ITEM.register("giant_padma_petal", () ->
            new Item(new Item.Properties()));
  

    public static final RegistryObject<Item> MANDRAKE_SEEDS = ITEM.register("mandrake_seeds", () ->
            new ItemNameBlockItem(OddBlocks.MANDRAKE_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> MANDRAKE = ITEM.register("mandrake", () ->
            new Item(new Item.Properties().food(OddFoods.MANDRAKE)));
    public static final RegistryObject<Item> PEELED_MANDRAKE = ITEM.register("peeled_mandrake", () ->
            new Item(new Item.Properties().food(OddFoods.PEELED_MANDRAKE)));
    public static final RegistryObject<Item> WILD_MELON_SLICE = ITEM.register("wild_melon_slice", () ->
            new Item(new Item.Properties().food(Foods.MELON_SLICE)));

    public static final RegistryObject<Item> DUNGEON_STEEL = ITEM.register("dungeon_steel", () ->
            new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAGE_SCONCE = ITEM.register("rage_sconce", () ->
            new StandingAndWallBlockItem(OddBlocks.RAGE_SCONCE.get(), OddBlocks.RAGE_WALL_SCONCE.get(), new Item.Properties(), Direction.DOWN));


    public static final RegistryObject<Item> ANTHESI_PIT = ITEM.register("anthesi_pit", () ->
            new Item(new Item.Properties()));


    public static final RegistryObject<Item> BOOK_OF_CONTENT = ITEM.register("book_of_content", () ->
            new ContentBookItem(new Item.Properties().stacksTo(1)));


    public static void init(IEventBus eventBus) {
        ITEM.register(eventBus);
    }
}