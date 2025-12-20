package net.bon.oddsnends.sound;

import net.bon.oddsnends.OddsNEnds;
import net.bon.oddsnends.util.CompatUtil;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.loading.FMLLoader;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class OddSoundEvents {
    public static final DeferredRegister<SoundEvent> SOUND_EVENT = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, OddsNEnds.MOD_ID);

    public static RegistryObject<SoundEvent> QUARTZ_SAND_BREAK = registerSoundEvent("block.quartz_sand.break");


    public static RegistryObject<SoundEvent> QUARTZ_SAND_STEP = registerSoundEvent("block.quartz_sand.step");


    public static RegistryObject<SoundEvent> NEAPOLITAN_ICE_CREAM_EAT = registerCompatSoundEvent("item.ice_cream.eat", CompatUtil.NEAPOLITAN);


    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENT.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(OddsNEnds.MOD_ID, name)));
    }

    private static RegistryObject<SoundEvent> registerCompatSoundEvent(String name, String modId) {
        if (FMLLoader.getLoadingModList().getModFileById(modId) != null) {
            return SOUND_EVENT.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(OddsNEnds.MOD_ID, name)));
        } else {
            return null;
        }
    }

    public static void init(IEventBus eventBus) {
        SOUND_EVENT.register(eventBus);
    }
}
