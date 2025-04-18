package net.bon.oddsnends.util;

import net.bon.oddsnends.OddsNEnds;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class OddBlockTags {
    public static final TagKey<Block> RAGE_FIRE_BASE_BLOCKS = createTag("rage_fire_base_blocks");


    private OddBlockTags() {
    }

    private static TagKey<Block> createTag(String name) {
        return TagKey.create(Registries.BLOCK, new ResourceLocation(OddsNEnds.MOD_ID, name));
    }
}
