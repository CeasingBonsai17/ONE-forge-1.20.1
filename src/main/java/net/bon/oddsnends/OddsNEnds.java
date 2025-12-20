package net.bon.oddsnends;

import com.mojang.logging.LogUtils;
import net.bon.oddsnends.block.OddBlocks;
import net.bon.oddsnends.item.OddCreativeTab;
import net.bon.oddsnends.item.OddItems;
import net.bon.oddsnends.loot.OddLootModifiers;
import net.bon.oddsnends.pack.OddBuiltInPacks;
import net.bon.oddsnends.particle.OddParticleTypes;
import net.bon.oddsnends.potion.OddPotions;
import net.bon.oddsnends.sound.OddSoundEvents;
import net.bon.oddsnends.util.BetterBrewingRecipe;
import net.bon.oddsnends.util.CompatUtil;
import net.bon.oddsnends.worldgen.feature.OddFeatures;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerAboutToStartEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(OddsNEnds.MOD_ID)
public class OddsNEnds {
    public static final String MOD_ID = "oddsnends";
    private static final Logger LOGGER = LogUtils.getLogger();
    public OddsNEnds() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> OddsNEndsClient::init);
        OddBlocks.init(modEventBus);
        OddItems.init(modEventBus);
        OddCreativeTab.init(modEventBus);
        OddLootModifiers.init(modEventBus);
        OddParticleTypes.init(modEventBus);
        OddSoundEvents.init(modEventBus);
        OddFeatures.init(modEventBus);
        OddPotions.init(modEventBus);

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::clientSetup);
        modEventBus.addListener(OddsNEnds::addBuiltInPacks);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, OddConfig.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        registerCompostables();
        event.enqueueWork(() -> {
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(
                    Potions.STRENGTH, OddBlocks.FIELD_CLOVERS.get().asItem(), Potions.LUCK));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(
                    Potions.WEAKNESS, OddBlocks.RUSTY_CLOVERS.get().asItem(), OddPotions.BAD_LUCK_POTION.get()));
        });
    }

    protected void registerCompostables() {
        ComposterBlock.COMPOSTABLES.put(OddBlocks.CIDERINE_SAPLING.get().asItem(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(OddItems.GIANT_PADMA_PETAL.get(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(OddItems.FLAX_SEEDS.get(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(OddItems.MANDRAKE_SEEDS.get(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(OddBlocks.SPINEROOT.get().asItem(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(OddBlocks.FIELD_CLOVERS.get().asItem(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(OddBlocks.RUSTY_CLOVERS.get().asItem(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(OddBlocks.CAVE_BRANCHES.get(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(OddItems.LACO_BEANS.get(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(OddItems.MANDRAKE.get(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(OddItems.PEELED_MANDRAKE.get(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(OddBlocks.WILD_LACO.get().asItem(), 0.5f);
        ComposterBlock.COMPOSTABLES.put(OddItems.ALGAE.get(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(OddBlocks.GIANT_PADMA.get().asItem(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(OddBlocks.SHEARED_GIANT_PADMA.get().asItem(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(OddBlocks.DRIED_FLAX_FLOWERS.get().asItem(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(OddBlocks.FLAX_FLOWERS.get().asItem(), 0.65f);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        event.enqueueWork(OddsNEndsClient::registerTints);
    }

    @SubscribeEvent
    public void onServerAboutToStart(ServerAboutToStartEvent event) {
        LOGGER.info("Odds N' Ends? guh??");
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }
    }

    private static void addBuiltInPacks(AddPackFindersEvent event) {
        if (event.getPackType() == PackType.SERVER_DATA) {
            if (CompatUtil.checkBountifulFares()) {
                OddBuiltInPacks.dpBountifulFaresCompat(event);
            }
            if (CompatUtil.checkFarmersDelight()) {
                OddBuiltInPacks.dpFarmersDelightCompat(event);
            }
            if (CompatUtil.checkNeapolitan()) {
                OddBuiltInPacks.dpNeapolitanCompat(event);
            }
        }
    }
}
