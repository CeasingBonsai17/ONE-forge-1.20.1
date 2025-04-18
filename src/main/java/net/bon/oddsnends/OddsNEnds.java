package net.bon.oddsnends;

import com.mojang.logging.LogUtils;
import net.bon.oddsnends.block.OddBlocks;
import net.bon.oddsnends.item.OddCreativeTab;
import net.bon.oddsnends.item.OddItems;
import net.bon.oddsnends.pack.OddBuiltInPacks;
import net.bon.oddsnends.particle.OddParticleTypes;
import net.bon.oddsnends.sound.OddSoundEvents;
import net.bon.oddsnends.util.CompatUtil;
import net.bon.oddsnends.worldgen.feature.OddFeatures;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
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
public class OddsNEnds
{
    public static final String MOD_ID = "oddsnends";
    private static final Logger LOGGER = LogUtils.getLogger();
    public OddsNEnds() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> OddsNEndsClient::init);
        OddBlocks.init(modEventBus);
        OddItems.init(modEventBus);
        OddCreativeTab.init(modEventBus);
        OddParticleTypes.init(modEventBus);
        OddSoundEvents.init(modEventBus);
        OddFeatures.init(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    @SubscribeEvent
    public void onServerAboutToStart(ServerAboutToStartEvent event) {

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }
    }

    private static void addBuiltInPacks(AddPackFindersEvent event) {
        if (event.getPackType() == PackType.SERVER_DATA) {
            if (CompatUtil.checkFarmersDelight()) {
                OddBuiltInPacks.dpFarmersDelightCompat(event);
            }
        }
    }
}
