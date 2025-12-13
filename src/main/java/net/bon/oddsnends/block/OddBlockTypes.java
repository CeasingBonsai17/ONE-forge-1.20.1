package net.bon.oddsnends.block;

import net.bon.oddsnends.OddsNEnds;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

import java.util.HashSet;
import java.util.Set;

import static net.minecraft.client.renderer.Sheets.SIGN_SHEET;

public class OddBlockTypes {

    public static final Set<WoodType> WOOD_TYPES = new HashSet<>();

    public static final WoodType MANASTONE = registerBlockType("manastone",
            OddBlockSetType.MANASTONE, SoundType.STONE,
            SoundType.HANGING_SIGN,
            SoundEvents.NETHER_WOOD_FENCE_GATE_CLOSE,
            SoundEvents.NETHER_WOOD_FENCE_GATE_OPEN);
    public static final WoodType CIDERINE = registerBlockType("ciderine",
            OddBlockSetType.CIDERINE, SoundType.WOOD,
            SoundType.HANGING_SIGN,
            SoundEvents.FENCE_GATE_CLOSE,
            SoundEvents.FENCE_GATE_OPEN);

    private static WoodType registerBlockType(String path, BlockSetType blockSetType, SoundType soundType, SoundType hangingSignSoundType, SoundEvent fenceGateCloseSound, SoundEvent fenceGateOpenSound) {
        String name = new ResourceLocation(OddsNEnds.MOD_ID, path).toString();
        WoodType result = new WoodType(name, blockSetType, soundType, hangingSignSoundType, fenceGateCloseSound, fenceGateOpenSound);
        WoodType.register(result);
        WOOD_TYPES.add(result);
        return result;
    }

    public static void add() {
        for (WoodType woodType : WOOD_TYPES) {
            String name = new ResourceLocation(woodType.name()).getPath();
            Sheets.SIGN_MATERIALS.put(woodType, new Material(SIGN_SHEET, new ResourceLocation(OddsNEnds.MOD_ID, "entity/signs/" + name)));
            Sheets.HANGING_SIGN_MATERIALS.put(woodType, new Material(SIGN_SHEET, new ResourceLocation(OddsNEnds.MOD_ID, "entity/signs/hanging/" + name)));
        }
    }
}