package net.bon.oddsnends.worldgen.structure;

import net.bon.oddsnends.OddsNEnds;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.Structure;

public class SoulfulStructureKeys {
//    public static final ResourceKey<Structure> DUNGEON = createKey("dungeon");

    public static ResourceKey<Structure> createKey(String name) {
        return ResourceKey.create(Registries.STRUCTURE, new ResourceLocation(OddsNEnds.MOD_ID, name));
    }
}
