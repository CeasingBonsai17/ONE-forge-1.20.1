package net.bon.oddsnends.block;

import net.bon.oddsnends.OddsNEnds;
import net.bon.oddsnends.block.type.FullPillarBlock;
import net.bon.oddsnends.item.OddItems;
import net.bon.oddsnends.particle.OddParticleTypes;
import net.bon.oddsnends.sound.OddSoundType;
import net.bon.oddsnends.block.type.*;
import net.bon.oddsnends.util.CompatUtil;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.loading.FMLLoader;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unused")

public class OddBlocks {

    public static final DeferredRegister<Block> BLOCK =
            DeferredRegister.create(ForgeRegistries.BLOCKS, OddsNEnds.MOD_ID);


    public static final RegistryObject<Block> FLAX_FLOWERS = registerBlock("flax_flowers", () ->
            new FlaxFlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> DRIED_FLAX_FLOWERS = registerBlock("dried_flax_flowers", () ->
            new DriedFlaxFlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> FLAX_CROP = registerBlockWithoutItem("flax_crop", () ->
            new FlaxCropBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().randomTicks().sound(SoundType.CROP).ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> LINEN_BLOCK = registerBlock("linen_block", () ->
            new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).mapColor(MapColor.TERRACOTTA_WHITE).strength(0.1F).randomTicks().sound(SoundType.WOOL).ignitedByLava()));
    public static final RegistryObject<Block> LINEN_CARPET = registerBlock("linen_carpet", () ->
            new CarpetBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CARPET).mapColor(MapColor.TERRACOTTA_WHITE).strength(0.1F).randomTicks().sound(SoundType.WOOL).ignitedByLava()));



    public static final RegistryObject<Block> POTTED_FLAX = registerBlockWithoutItem("potted_flax", () ->
            new FlowerPotBlock(FLAX_FLOWERS.get(), BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> POTTED_DRIED_FLAX = registerBlockWithoutItem("potted_dried_flax", () ->
            new FlowerPotBlock(DRIED_FLAX_FLOWERS.get(), BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY)));


    public static final RegistryObject<Block> ALGAE = registerBlockWithoutItem("algae", () ->
            new AmethystClusterBlock(5, 2, BlockBehaviour.Properties.copy(Blocks.LILY_PAD).instabreak().noCollission().noOcclusion().replaceable().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> CAVE_BRANCHES = registerBlock("cave_branches", () ->
            new CaveBranchBlock(BlockBehaviour.Properties.copy(Blocks.VINE).noOcclusion()));
    public static final RegistryObject<Block> GIANT_PADMA = registerBlock("giant_padma", () ->
            new GiantPadmaBlock(8, 1, BlockBehaviour.Properties.copy(Blocks.RED_MUSHROOM_BLOCK).noOcclusion()));

    public static final RegistryObject<Block> MANDRAKE_CROP = registerBlockWithoutItem("mandrake_crop", () ->
            new MandrakeCropBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().randomTicks().sound(SoundType.CROP).ignitedByLava().pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> MANASTONE = registerBlock("manastone", () ->
            new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> MANASTONE_SLAB = registerBlock("manastone_slab", () ->
            new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_SLAB)));
    public static final RegistryObject<Block> MANASTONE_STAIRS = registerBlock("manastone_stairs", () ->
            new StairBlock(MANASTONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.STONE_SLAB)));
    public static final RegistryObject<Block> MANASTONE_BRICKS = registerBlock("manastone_bricks", () ->
            new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)));
    public static final RegistryObject<Block> MANASTONE_BRICK_SLAB = registerBlock("manastone_brick_slab", () ->
            new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));
    public static final RegistryObject<Block> MANASTONE_BRICK_STAIRS = registerBlock("manastone_brick_stairs", () ->
            new StairBlock(MANASTONE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));
    public static final RegistryObject<Block> MANASTONE_BRICK_WALL = registerBlock("manastone_brick_wall", () ->
            new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)));
    public static final RegistryObject<Block> SMALL_MANASTONE_BRICKS = registerBlock("small_manastone_bricks", () ->
            new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)));
    public static final RegistryObject<Block> SMALL_MANASTONE_BRICK_SLAB = registerBlock("small_manastone_brick_slab", () ->
            new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));
    public static final RegistryObject<Block> SMALL_MANASTONE_BRICK_STAIRS = registerBlock("small_manastone_brick_stairs", () ->
            new StairBlock(SMALL_MANASTONE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));
    public static final RegistryObject<Block> SMALL_MANASTONE_BRICK_WALL = registerBlock("small_manastone_brick_wall", () ->
            new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)));
    public static final RegistryObject<Block> SMOOTH_MANASTONE = registerBlock("smooth_manastone", () ->
            new Block(BlockBehaviour.Properties.copy(Blocks.SMOOTH_STONE)));
    public static final RegistryObject<Block> SMOOTH_MANASTONE_SLAB = registerBlock("smooth_manastone_slab", () ->
            new SlabBlock(BlockBehaviour.Properties.copy(Blocks.SMOOTH_STONE_SLAB)));
    public static final RegistryObject<Block> MANASTONE_PILLAR = registerBlock("manastone_pillar", () ->
            new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));

    public static final RegistryObject<Block> DUNGEON_STEEL_ORE = registerBlock("dungeon_steel_ore", () ->
            new DungeonSteelBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE)));
    public static final RegistryObject<Block> DUNGEON_STEEL_BLOCK = registerBlock("dungeon_steel_block", () ->
            new DungeonSteelBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));


    public static final RegistryObject<Block> RAGE_FIRE = registerBlockWithoutItem("rage_fire", () ->
            new RageFireBlock(BlockBehaviour.Properties.copy(Blocks.SOUL_FIRE).lightLevel(state -> 14).mapColor(MapColor.COLOR_LIGHT_GREEN)));
    public static final RegistryObject<Block> RAGE_SCONCE = registerBlockWithoutItem("rage_sconce", () ->
            new RageSconceBlock(BlockBehaviour.Properties.copy(Blocks.SOUL_TORCH).lightLevel(state -> 13)));
    public static final RegistryObject<Block> RAGE_WALL_SCONCE = registerBlockWithoutItem("rage_wall_sconce", () ->
            new WallRageSconceBlock(BlockBehaviour.Properties.copy(Blocks.SOUL_WALL_TORCH).lightLevel(state -> 13)));
    public static final RegistryObject<Block> RAGE_LANTERN = registerBlock("rage_lantern", () ->
            new RageLanternBlock(BlockBehaviour.Properties.copy(Blocks.SOUL_LANTERN).lightLevel(state -> 14)));

    public static final RegistryObject<Block> HANGING_SPAWNER = registerBlock("hanging_spawner", () ->
            new SpawnerBlock(BlockBehaviour.Properties.copy(Blocks.SPAWNER).mapColor(MapColor.STONE)));

    public static final RegistryObject<Block> SHALE = registerBlock("shale", () ->
            new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));
    public static final RegistryObject<Block> POLISHED_SHALE = registerBlock("polished_shale", () ->
            new Block(BlockBehaviour.Properties.copy(Blocks.POLISHED_DEEPSLATE)));
    public static final RegistryObject<Block> POLISHED_SHALE_STAIRS = registerBlock("polished_shale_stairs", () ->
            new StairBlock(POLISHED_SHALE.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.POLISHED_DEEPSLATE_STAIRS)));
    public static final RegistryObject<Block> POLISHED_SHALE_SLAB = registerBlock("polished_shale_slab", () ->
            new SlabBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_DEEPSLATE_SLAB)));
    public static final RegistryObject<Block> SHALE_BRICKS = registerBlock("shale_bricks", () ->
            new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICKS)));
    public static final RegistryObject<Block> SHALE_BRICK_STAIRS = registerBlock("shale_brick_stairs", () ->
            new StairBlock(SHALE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICK_STAIRS)));
    public static final RegistryObject<Block> SHALE_BRICK_SLAB = registerBlock("shale_brick_slab", () ->
            new SlabBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICK_SLAB)));
    public static final RegistryObject<Block> SHALE_PILLAR = registerBlock("shale_pillar", () ->
            new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICKS)));
    public static final RegistryObject<Block> CHISELED_SHALE_PILLAR = registerBlock("chiseled_shale_pillar", () ->
            new FullPillarBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICKS)));


    public static final RegistryObject<Block> ROUGH_QUARTZ = registerBlock("rough_quartz", () ->
            new Block(BlockBehaviour.Properties.copy(Blocks.QUARTZ_BLOCK)));
    public static final RegistryObject<Block> ROUGH_QUARTZ_STAIRS = registerBlock("rough_quartz_stairs", () ->
            new StairBlock(ROUGH_QUARTZ.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.QUARTZ_STAIRS)));
    public static final RegistryObject<Block> ROUGH_QUARTZ_SLAB = registerBlock("rough_quartz_slab", () ->
            new SlabBlock(BlockBehaviour.Properties.copy(Blocks.QUARTZ_SLAB)));


    public static final RegistryObject<Block> QUARTZ_SAND = registerBlock("quartz_sand", () ->
            new SandBlock(14010806, BlockBehaviour.Properties.copy(Blocks.SAND).mapColor(MapColor.QUARTZ).instrument(NoteBlockInstrument.BASEDRUM).sound(OddSoundType.QUARTZ_SAND)));
    public static final RegistryObject<Block> SUSPICIOUS_QUARTZ_SAND = registerBlock("suspicious_quartz_sand", () ->
            new BrushableBlock(OddBlocks.QUARTZ_SAND.get(), BlockBehaviour.Properties.copy(Blocks.SUSPICIOUS_SAND).mapColor(MapColor.QUARTZ).instrument(NoteBlockInstrument.SNARE).sound(OddSoundType.SUSPICIOUS_QUARTZ_SAND), SoundEvents.BRUSH_SAND, SoundEvents.BRUSH_SAND_COMPLETED));
    public static final RegistryObject<Block> QUARTZ_GLASS = registerBlock("quartz_glass", () ->
            new GlassBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_STAINED_GLASS)));
    public static final RegistryObject<Block> QUARTZ_GLASS_PANE = registerBlock("quartz_glass_pane", () ->
            new IronBarsBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_STAINED_GLASS_PANE)));


    public static final RegistryObject<Block> SHORESTONE = registerBlock("shorestone", () ->
            new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));
    public static final RegistryObject<Block> SHORESTONE_BRICKS = registerBlock("shorestone_bricks", () ->
            new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)));
    public static final RegistryObject<Block> SHORESTONE_BRICK_STAIRS = registerBlock("shorestone_brick_stairs", () ->
            new StairBlock(SHORESTONE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));
    public static final RegistryObject<Block> SHORESTONE_BRICK_SLAB = registerBlock("shorestone_brick_slab", () ->
            new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> ALGAE_CRATE = registerCompatBlock("algae_crate", () ->
            new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F).sound(SoundType.WOOD)), CompatUtil.FARMERSDELIGHT);
    public static final RegistryObject<Block> MANDRAKE_CRATE = registerCompatBlock("mandrake_crate", () ->
            new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F).sound(SoundType.WOOD)), CompatUtil.FARMERSDELIGHT);
    public static final RegistryObject<Block> PEELED_MANDRAKE_CRATE = registerCompatBlock("peeled_mandrake_crate", () ->
            new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F).sound(SoundType.WOOD)), CompatUtil.FARMERSDELIGHT);
    public static final RegistryObject<Block> FLAX_FIBER_BAG = registerCompatBlock("flax_fiber_bag", () ->
            new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)), CompatUtil.FARMERSDELIGHT);





    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCK.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<T> registerBlockWithoutItem(String name, Supplier<T> block) {
        return BLOCK.register(name, block);
    }

    public static <T extends Block> RegistryObject<T> registerCompatBlock(String name, Supplier<T> block, String modId) {
        RegistryObject<T> toReturn = BLOCK.register(name, block);
        if (FMLLoader.getLoadingModList().getModFileById(modId) != null) {
            OddItems.ITEM.register(name, () -> new BlockItem(toReturn.get(), new Item.Properties()));
        }
        return toReturn;
    }

    public static <T extends Block> RegistryObject<T> registerCompatBlockItem(String name, Supplier<T> block, Item.Properties properties, String modId) {
        RegistryObject<T> toReturn = BLOCK.register(name, block);
        if (FMLLoader.getLoadingModList().getModFileById(modId) != null) {
            OddItems.ITEM.register(name, () -> new BlockItem(toReturn.get(), properties));
        }
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return OddItems.ITEM.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void init(IEventBus eventBus) {
        BLOCK.register(eventBus);
    }
}