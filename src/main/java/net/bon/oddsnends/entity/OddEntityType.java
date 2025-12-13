package net.bon.oddsnends.entity;

import net.bon.oddsnends.OddsNEnds;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class OddEntityType {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPE =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, OddsNEnds.MOD_ID);

    public static void init(IEventBus eventBus) {
        ENTITY_TYPE.register(eventBus);
    }
}
