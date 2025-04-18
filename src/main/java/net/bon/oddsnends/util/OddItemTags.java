package net.bon.oddsnends.util;

import net.bon.oddsnends.OddsNEnds;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class OddItemTags {
//    public static final TagKey<Item> ITEM = createTag("item");

    private OddItemTags() {
    }

    private static TagKey<Item> createTag(String name) {
        return TagKey.create(Registries.ITEM, new ResourceLocation(OddsNEnds.MOD_ID, name));
    }
}
