package net.bon.oddsnends.block;

import net.bon.oddsnends.OddsNEnds;
import net.bon.oddsnends.block.grower.CiderineTreeGrower;
import net.bon.oddsnends.block.type.OddPillarBlock;
import net.bon.oddsnends.item.OddItems;
import net.bon.oddsnends.sound.OddSoundType;
import net.bon.oddsnends.block.type.*;
import net.bon.oddsnends.util.CompatUtil;
import net.minecraft.core.Direction;
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

   public static final RegistryObject<Block> CIDERINE_BLOSSOM = registerBlockWithoutItem("ciderine_blossom", () ->
           new CiderineBlossomBlock(BlockBehaviour.Properties.of().noCollission().noOcclusion().instabreak().dynamicShape().offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY).sound(SoundType.AZALEA_LEAVES)));
   public static final RegistryObject<Block> CIDERINE_CROP = registerBlockWithoutItem("ciderine_crop", () ->
           new CiderineCropBlock(BlockBehaviour.Properties.of().noOcclusion().pushReaction(PushReaction.DESTROY).dynamicShape().offsetType(BlockBehaviour.OffsetType.XZ).strength(0.3F).sound(SoundType.NETHER_SPROUTS)));
   public static final RegistryObject<Block> CIDERINE = registerBlockWithoutItem("ciderine", () ->
           new HangingCiderineBlock(BlockBehaviour.Properties.of().pushReaction(PushReaction.DESTROY).noOcclusion().strength(0.3F).sound(SoundType.NETHER_SPROUTS)));
   public static final RegistryObject<Block> STRIPPED_CIDERINE_LOG = registerBlock("stripped_ciderine_log", () ->
           new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.RAW_IRON)));
   public static final RegistryObject<Block> STRIPPED_CIDERINE_WOOD = registerBlock("stripped_ciderine_wood", () ->
           new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.RAW_IRON)));
   public static final RegistryObject<Block> CIDERINE_LOG = registerBlock("ciderine_log", () ->
           new StrippablePillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).mapColor((blockState) -> {return blockState.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MapColor.RAW_IRON : MapColor.COLOR_GRAY;}), STRIPPED_CIDERINE_LOG));
   public static final RegistryObject<Block> CIDERINE_WOOD = registerBlock("ciderine_wood", () ->
           new StrippablePillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).mapColor(MapColor.COLOR_GRAY), STRIPPED_CIDERINE_WOOD));
   public static final RegistryObject<Block> CIDERINE_PLANKS = registerBlock("ciderine_planks", () ->
           new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).mapColor(MapColor.RAW_IRON)));
   public static final RegistryObject<Block> CIDERINE_SLAB = registerBlock("ciderine_slab", () ->
           new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB).mapColor(MapColor.RAW_IRON)));
   public static final RegistryObject<Block> CIDERINE_STAIRS = registerBlock("ciderine_stairs", () ->
           new StairBlock(CIDERINE_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS).mapColor(MapColor.RAW_IRON)));
   public static final RegistryObject<Block> CIDERINE_FENCE = registerBlock("ciderine_fence", () ->
           new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE).mapColor(MapColor.RAW_IRON)));
   public static final RegistryObject<Block> CIDERINE_FENCE_GATE = registerBlock("ciderine_fence_gate", () ->
           new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE).mapColor(MapColor.RAW_IRON), OddBlockTypes.CIDERINE));
   public static final RegistryObject<Block> CIDERINE_DOOR = registerBlock("ciderine_door", () ->
           new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).mapColor(MapColor.RAW_IRON), OddBlockSetType.CIDERINE));
   public static final RegistryObject<Block> CIDERINE_TRAPDOOR = registerBlock("ciderine_trapdoor", () ->
           new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR).mapColor(MapColor.RAW_IRON), OddBlockSetType.CIDERINE));
   public static final RegistryObject<Block> CIDERINE_PRESSURE_PLATE = registerBlock("ciderine_pressure_plate", () ->
           new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE).mapColor(MapColor.RAW_IRON), OddBlockSetType.CIDERINE));
   public static final RegistryObject<Block> CIDERINE_BUTTON = registerBlock("ciderine_button", () ->
           new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON),OddBlockSetType.CIDERINE,25,true));
   public static final RegistryObject<Block> CIDERINE_LEAVES = registerBlock("ciderine_leaves", () ->
           new CiderineLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).sound(SoundType.AZALEA_LEAVES)));
   public static final RegistryObject<Block> FLOWERING_CIDERINE_LEAVES = registerBlock("flowering_ciderine_leaves", () ->
           new CiderineLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).sound(SoundType.AZALEA_LEAVES)));
   public static final RegistryObject<Block> CIDERINE_SAPLING = registerBlock("ciderine_sapling", () ->
           new SaplingBlock(new CiderineTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
   public static final RegistryObject<Block> POTTED_CIDERINE_SAPLING = registerBlockWithoutItem("potted_ciderine_sapling", () ->
           new FlowerPotBlock(CIDERINE_SAPLING.get(), BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY)));
   public static final RegistryObject<Block> CIDERINE_SIGN = registerBlockWithoutItem("ciderine_sign", () ->
           new StandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN).mapColor(MapColor.RAW_IRON), OddBlockTypes.CIDERINE));
   public static final RegistryObject<Block> CIDERINE_WALL_SIGN = registerBlockWithoutItem("ciderine_wall_sign", () ->
           new WallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN).dropsLike(CIDERINE_SIGN.get()).mapColor(MapColor.RAW_IRON), OddBlockTypes.CIDERINE));
   public static final RegistryObject<Block> CIDERINE_HANGING_SIGN = registerBlockWithoutItem("ciderine_hanging_sign", () ->
           new CeilingHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN).mapColor(MapColor.RAW_IRON), OddBlockTypes.CIDERINE));
   public static final RegistryObject<Block> CIDERINE_WALL_HANGING_SIGN = registerBlockWithoutItem("ciderine_wall_hanging_sign", () ->
           new WallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN).dropsLike(CIDERINE_HANGING_SIGN.get()).mapColor(MapColor.RAW_IRON), OddBlockTypes.CIDERINE));

   public static final RegistryObject<Block> ANTHESI_CROP = registerBlock("anthesi_crop", () ->
           new AnthesiCropBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
   public static final RegistryObject<Block> WILD_ANTHESI = registerBlock("wild_anthesi", () ->
           new WildAnthesiBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
   public static final RegistryObject<Block> ANTHESI_CAKE = registerBlock("anthesi_cake", () ->
           new AnthesiCakeBlock(BlockBehaviour.Properties.copy(Blocks.CAKE)));

   public static final RegistryObject<Block> FLAX_FLOWERS = registerBlock("flax_flowers", () ->
           new FlaxFlowerBlock(MobEffects.DAMAGE_BOOST, 7, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).ignitedByLava().pushReaction(PushReaction.DESTROY)));
   public static final RegistryObject<Block> POTTED_FLAX = registerBlockWithoutItem("potted_flax", () ->
           new FlowerPotBlock(FLAX_FLOWERS.get(), BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY)));
   public static final RegistryObject<Block> DRIED_FLAX_FLOWERS = registerBlock("dried_flax_flowers", () ->
           new DriedFlaxFlowerBlock(MobEffects.DAMAGE_BOOST, 7, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).ignitedByLava().pushReaction(PushReaction.DESTROY)));
   public static final RegistryObject<Block> POTTED_DRIED_FLAX = registerBlockWithoutItem("potted_dried_flax", () ->
           new FlowerPotBlock(DRIED_FLAX_FLOWERS.get(), BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY)));
   public static final RegistryObject<Block> FLAX_CROP = registerBlockWithoutItem("flax_crop", () ->
           new FlaxCropBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().randomTicks().sound(SoundType.CROP).ignitedByLava().pushReaction(PushReaction.DESTROY)));
   public static final RegistryObject<Block> FLAX_BALE = registerBlock("flax_bale", () ->
           new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.HAY_BLOCK).mapColor(MapColor.WOOD)));
   public static final RegistryObject<Block> LINEN_BLOCK = registerBlock("linen_block", () ->
           new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).mapColor(MapColor.TERRACOTTA_WHITE).strength(0.1F).randomTicks().sound(SoundType.WOOL).ignitedByLava()));
   public static final RegistryObject<Block> LINEN_CARPET = registerBlock("linen_carpet", () ->
           new CarpetBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CARPET).mapColor(MapColor.TERRACOTTA_WHITE).strength(0.1F).randomTicks().sound(SoundType.WOOL).ignitedByLava()));

   public static final RegistryObject<Block> SPINEROOT = registerBlock("spineroot", () ->
           new SpinerootBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).noCollission().instabreak().randomTicks().sound(SoundType.CROP).ignitedByLava().pushReaction(PushReaction.DESTROY)));
//   public static final RegistryObject<Block> CLOVER_GRASS_BLOCK = registerBlock("clover_grass_block", () ->
//           new GrassBlock(BlockBehaviour.Properties.copy(Blocks.GRASS_BLOCK)));
   public static final RegistryObject<Block> FIELD_CLOVERS = registerBlock("field_clovers", () ->
           new CloverBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.CROP).ignitedByLava().pushReaction(PushReaction.DESTROY)));
   public static final RegistryObject<Block> RUSTY_CLOVERS = registerBlock("rusty_clovers", () ->
           new CloverBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_RED).noCollission().instabreak().sound(SoundType.CROP).ignitedByLava().pushReaction(PushReaction.DESTROY)));

   public static final RegistryObject<Block> WILD_LACO = registerBlock("wild_laco", () ->
           new WildLacoBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).mapColor(MapColor.TERRACOTTA_WHITE)));
   public static final RegistryObject<Block> LACO_CROP = registerBlockWithoutItem("laco_crop", () ->
           new LacoCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).mapColor(MapColor.TERRACOTTA_WHITE)));
   public static final RegistryObject<Block> LACO_TILES = registerBlock("laco_tiles", () ->
           new Block(BlockBehaviour.Properties.of().strength(0.5f).mapColor(MapColor.TERRACOTTA_WHITE).sound(SoundType.BAMBOO)));
   public static final RegistryObject<Block> LACO_TILE_STAIRS = registerBlock("laco_tile_stairs", () ->
           new StairBlock(LACO_TILES.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE).strength(0.5f).sound(SoundType.BAMBOO)));
   public static final RegistryObject<Block> LACO_TILE_SLAB = registerBlock("laco_tile_slab", () ->
           new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE).strength(0.5f).sound(SoundType.BAMBOO)));


   public static final RegistryObject<Block> ALGAE = registerBlockWithoutItem("algae", () ->
           new AmethystClusterBlock(5, 2, BlockBehaviour.Properties.copy(Blocks.LILY_PAD).instabreak().noCollission().noOcclusion().replaceable().pushReaction(PushReaction.DESTROY)));
   public static final RegistryObject<Block> CAVE_BRANCHES = registerBlock("cave_branches", () ->
           new CaveBranchBlock(BlockBehaviour.Properties.copy(Blocks.VINE).noOcclusion()));
   public static final RegistryObject<Block> GIANT_PADMA = registerBlock("giant_padma", () ->
           new GiantPadmaBlock(BlockBehaviour.Properties.copy(Blocks.RED_MUSHROOM_BLOCK).noOcclusion()));
   public static final RegistryObject<Block> SHEARED_GIANT_PADMA = registerBlock("sheared_giant_padma", () ->
           new ShearedGiantPadmaBlock(BlockBehaviour.Properties.copy(Blocks.RED_MUSHROOM_BLOCK).noOcclusion()));
   public static final RegistryObject<Block> MANDRAKE_CROP = registerBlockWithoutItem("mandrake_crop", () ->
           new MandrakeCropBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().randomTicks().sound(SoundType.CROP).ignitedByLava().pushReaction(PushReaction.DESTROY)));
   public static final RegistryObject<Block> MANDRAKE = registerBlockWithoutItem("mandrake", () ->
           new MandrakeBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().randomTicks().sound(SoundType.CROP).ignitedByLava().pushReaction(PushReaction.DESTROY)));
   public static final RegistryObject<Block> POTTED_MANDRAKE = registerBlockWithoutItem("potted_mandrake", () ->
           new FlowerPotBlock(MANDRAKE.get(), BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY)));

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
   public static final RegistryObject<Block> MANASTONE_TABLET = registerBlockWithoutItem("manastone_tablet", () ->
           new WallSignBlock(BlockBehaviour.Properties.copy(Blocks.STONE), OddBlockTypes.MANASTONE));

//   public static final RegistryObject<Block> DUNGEON_STEEL_ORE = registerBlock("dungeon_steel_ore", () ->
//           new DungeonSteelBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE)));
//   public static final RegistryObject<Block> DUNGEON_STEEL_BLOCK = registerBlock("dungeon_steel_block", () ->
//           new DungeonSteelBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

//   public static final RegistryObject<Block> HANGING_SPAWNER = registerBlock("hanging_spawner", () ->
//           new SpawnerBlock(BlockBehaviour.Properties.copy(Blocks.SPAWNER).mapColor(MapColor.STONE)));

   public static final RegistryObject<Block> SHALE = registerBlock("shale", () ->
           new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).sound(SoundType.DEEPSLATE_BRICKS)));
   public static final RegistryObject<Block> POLISHED_SHALE = registerBlock("polished_shale", () ->
           new Block(BlockBehaviour.Properties.copy(Blocks.POLISHED_DEEPSLATE).sound(SoundType.DEEPSLATE_BRICKS)));
   public static final RegistryObject<Block> POLISHED_SHALE_STAIRS = registerBlock("polished_shale_stairs", () ->
           new StairBlock(POLISHED_SHALE.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.POLISHED_DEEPSLATE_STAIRS).sound(SoundType.DEEPSLATE_BRICKS)));
   public static final RegistryObject<Block> POLISHED_SHALE_SLAB = registerBlock("polished_shale_slab", () ->
           new SlabBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_DEEPSLATE_SLAB).sound(SoundType.DEEPSLATE_BRICKS)));
   public static final RegistryObject<Block> SHALE_BRICKS = registerBlock("shale_bricks", () ->
           new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICKS)));
   public static final RegistryObject<Block> SHALE_BRICK_STAIRS = registerBlock("shale_brick_stairs", () ->
           new StairBlock(SHALE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICK_STAIRS)));
   public static final RegistryObject<Block> SHALE_BRICK_SLAB = registerBlock("shale_brick_slab", () ->
           new SlabBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICK_SLAB)));
   public static final RegistryObject<Block> SHALE_PILLAR = registerBlock("shale_pillar", () ->
           new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICKS)));
   public static final RegistryObject<Block> CHISELED_SHALE_PILLAR = registerBlock("chiseled_shale_pillar", () ->
           new OddPillarBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICKS)));


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

   public static final RegistryObject<Block> RUSTY_BASALT = registerBlock("rusty_basalt", () ->
           new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.BASALT)));
   public static final RegistryObject<Block> POLISHED_RUSTY_BASALT = registerBlock("polished_rusty_basalt", () ->
           new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_BASALT)));
   public static final RegistryObject<Block> SMOOTH_RUSTY_BASALT = registerBlock("smooth_rusty_basalt", () ->
           new Block(BlockBehaviour.Properties.copy(Blocks.SMOOTH_BASALT)));


   public static final RegistryObject<Block> CIDERINE_CRATE = registerCompatBlock("ciderine_crate", () ->
           new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F).sound(SoundType.WOOD)), CompatUtil.FARMERSDELIGHT);
   public static final RegistryObject<Block> CIDERINE_BLOCK = registerCompatBlock("ciderine_block", () ->
           new CiderineBlock(6, 0.6f, BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).instrument(NoteBlockInstrument.DIDGERIDOO).sound(SoundType.WOOD).mapColor(MapColor.CRIMSON_STEM).pushReaction(PushReaction.DESTROY).strength(1f)), CompatUtil.BOUNTIFULFARES);
   public static final RegistryObject<Block> CIDERINE_ICE_CREAM_BLOCK = registerCompatBlock("ciderine_ice_cream_block", () ->
           new Block(BlockBehaviour.Properties.of().mapColor(MapColor.RAW_IRON).instrument(NoteBlockInstrument.CHIME).strength(0.2F).sound(SoundType.SNOW)), CompatUtil.NEAPOLITAN);
   public static final RegistryObject<Block> ANTHESI_CRATE = registerCompatBlock("anthesi_crate", () ->
           new Block(BlockBehaviour.Properties.copy(CIDERINE_CRATE.get())), CompatUtil.FARMERSDELIGHT);
   public static final RegistryObject<Block> ANTHESI_ICE_CREAM_BLOCK = registerCompatBlock("anthesi_ice_cream_block", () ->
           new Block(BlockBehaviour.Properties.copy(CIDERINE_ICE_CREAM_BLOCK.get()).mapColor(MapColor.TERRACOTTA_WHITE)), CompatUtil.NEAPOLITAN);
   public static final RegistryObject<Block> LACO_BEAN_BAG = registerCompatBlock("laco_bean_bag", () ->
           new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)), CompatUtil.FARMERSDELIGHT);
   public static final RegistryObject<Block> LACO_SORBET_BLOCK = registerCompatBlock("laco_sorbet_block", () ->
           new Block(BlockBehaviour.Properties.copy(CIDERINE_ICE_CREAM_BLOCK.get()).mapColor(MapColor.QUARTZ)), CompatUtil.NEAPOLITAN);
   public static final RegistryObject<Block> ALGAE_CRATE = registerCompatBlock("algae_crate", () ->
           new Block(BlockBehaviour.Properties.copy(CIDERINE_CRATE.get())), CompatUtil.FARMERSDELIGHT);
   public static final RegistryObject<Block> MANDRAKE_CRATE = registerCompatBlock("mandrake_crate", () ->
           new Block(BlockBehaviour.Properties.copy(CIDERINE_CRATE.get())), CompatUtil.FARMERSDELIGHT);
   public static final RegistryObject<Block> PEELED_MANDRAKE_CRATE = registerCompatBlock("peeled_mandrake_crate", () ->
           new Block(BlockBehaviour.Properties.copy(CIDERINE_CRATE.get())), CompatUtil.FARMERSDELIGHT);
   public static final RegistryObject<Block> MANDRAKE_ICE_CREAM_BLOCK = registerCompatBlock("mandrake_ice_cream_block", () ->
           new Block(BlockBehaviour.Properties.copy(CIDERINE_ICE_CREAM_BLOCK.get()).mapColor(MapColor.SAND)), CompatUtil.NEAPOLITAN);





   private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
       RegistryObject<T> toReturn = BLOCK.register(name, block);
       registerBlockItem(name, toReturn);
       return toReturn;
   }

   private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
      return OddItems.ITEM.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
   }

   private static <T extends Block> RegistryObject<T> registerBlockWithoutItem(String name, Supplier<T> block) {
       return BLOCK.register(name, block);
   }

   public static <T extends Block> RegistryObject<T> registerCompatBlock(String name, Supplier<T> block, String modId) {
       if (FMLLoader.getLoadingModList().getModFileById(modId) != null) {
          RegistryObject<T> toReturn = BLOCK.register(name, block);
          OddItems.ITEM.register(name, () -> new BlockItem(toReturn.get(), new Item.Properties()));
          return toReturn;
       } else {
          return null;
       }
   }

   public static void init(IEventBus eventBus) {
       BLOCK.register(eventBus);
   }
}