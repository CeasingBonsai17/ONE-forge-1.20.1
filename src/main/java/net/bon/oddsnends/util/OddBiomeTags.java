package net.bon.oddsnends.util;

import net.bon.oddsnends.OddsNEnds;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

public class OddBiomeTags {
// public static final TagKey<Biome> BIOME = createTag("biome");


    private OddBiomeTags() {
    }

    private static TagKey<Biome> createTag(String name) {
        return TagKey.create(Registries.BIOME, new ResourceLocation(OddsNEnds.MOD_ID, name));
    }
}
