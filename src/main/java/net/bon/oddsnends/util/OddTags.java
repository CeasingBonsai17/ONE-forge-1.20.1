package net.bon.oddsnends.util;

import net.bon.oddsnends.OddsNEnds;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

public class OddTags {
    public static final TagKey<Block> RAGE_FIRE_BASE_BLOCKS = createBlockTag("rage_fire_base_blocks");
    public static final TagKey<Block> CIDERINE_LEAVES = createBlockTag("ciderine_leaves");




    private OddTags() {
    }

    private static TagKey<Block> createBlockTag(String name) {
        return TagKey.create(Registries.BLOCK, location(name));
    }
    private static TagKey<Biome> createBiomeTag(String name) {
        return TagKey.create(Registries.BIOME, location(name));
    }
    private static TagKey<Item> createItemTag(String name) {
        return TagKey.create(Registries.ITEM, location(name));
    }
    private static TagKey<EntityType<?>> createEntityTag(String name) {
        return TagKey.create(Registries.ENTITY_TYPE, location(name));
    }
    public static ResourceLocation location(String name) {
        return new ResourceLocation(OddsNEnds.MOD_ID, name);
    }
}
