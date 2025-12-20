package net.bon.oddsnends.worldgen.structure;

import net.bon.oddsnends.OddsNEnds;
import net.bon.oddsnends.worldgen.structure.type.DungeonStructure;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class OddStructureType {
    public static final DeferredRegister<StructureType<?>> STRUCTURE_TYPE =
            DeferredRegister.create(Registries.STRUCTURE_TYPE, OddsNEnds.MOD_ID);

//    public static final RegistryObject<StructureType<DungeonStructure>> DUNGEON = STRUCTURE_TYPE.register("dungeon", () ->
//            DungeonStructure.CODEC);
}
