package net.bon.oddsnends.item;

import net.bon.oddsnends.OddsNEnds;
import net.bon.oddsnends.block.OddBlocks;
import net.bon.oddsnends.util.CompatUtil;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class OddCreativeTab {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, OddsNEnds.MOD_ID);


    public static final RegistryObject<CreativeModeTab> ODDSNENDS = CREATIVE_MODE_TAB.register("oddsnends_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(OddItems.LINEN_PATCH.get()))
                    .title(Component.translatable("creativetab.oddsnends"))
                    .displayItems((parameters, output) -> {
                        output.accept(OddBlocks.FLAX_FLOWERS.get());
                        output.accept(OddBlocks.DRIED_FLAX_FLOWERS.get());
                        output.accept(OddItems.FLAX_SEEDS.get());
                        output.accept(OddItems.FLAX_FIBERS.get());
                        if (CompatUtil.checkFarmersDelight()) {
                            output.accept(OddBlocks.FLAX_FIBER_BAG.get());
                        }
                        output.accept(OddItems.LINEN_PATCH.get());
                        output.accept(OddBlocks.LINEN_BLOCK.get());
                        output.accept(OddBlocks.LINEN_CARPET.get());
                        output.accept(OddItems.ALGAE.get());
                        if (CompatUtil.checkFarmersDelight()) {
                            output.accept(OddBlocks.ALGAE_CRATE.get());
                        }
                        output.accept(OddBlocks.CAVE_BRANCHES.get());
                        output.accept(OddBlocks.GIANT_PADMA.get());
                        output.accept(OddItems.GIANT_PADMA_PETAL.get());
                        output.accept(OddItems.MANDRAKE_SEEDS.get());
                        output.accept(OddItems.MANDRAKE.get());
                        if (CompatUtil.checkFarmersDelight()) {
                            output.accept(OddBlocks.MANDRAKE_CRATE.get());
                        }
                        output.accept(OddItems.PEELED_MANDRAKE.get());
                        if (CompatUtil.checkFarmersDelight()) {
                            output.accept(OddBlocks.PEELED_MANDRAKE_CRATE.get());
                        }
                        output.accept(Items.MELON_SEEDS);
                        output.accept(Items.MELON_SLICE);
                        output.accept(OddItems.WILD_MELON_SLICE.get());
                        output.accept(OddBlocks.MANASTONE.get());
                        output.accept(OddBlocks.MANASTONE_STAIRS.get());
                        output.accept(OddBlocks.MANASTONE_SLAB.get());
                        output.accept(OddBlocks.MANASTONE_BRICKS.get());
                        output.accept(OddBlocks.MANASTONE_BRICK_STAIRS.get());
                        output.accept(OddBlocks.MANASTONE_BRICK_SLAB.get());
                        output.accept(OddBlocks.MANASTONE_BRICK_WALL.get());
                        output.accept(OddBlocks.SMALL_MANASTONE_BRICKS.get());
                        output.accept(OddBlocks.SMALL_MANASTONE_BRICK_STAIRS.get());
                        output.accept(OddBlocks.SMALL_MANASTONE_BRICK_SLAB.get());
                        output.accept(OddBlocks.SMALL_MANASTONE_BRICK_WALL.get());
                        output.accept(OddBlocks.MANASTONE_PILLAR.get());
                        output.accept(OddBlocks.SMOOTH_MANASTONE.get());
                        output.accept(OddBlocks.SMOOTH_MANASTONE_SLAB.get());
                        output.accept(OddBlocks.DUNGEON_STEEL_ORE.get());
                        output.accept(OddItems.DUNGEON_STEEL.get());
                        output.accept(OddBlocks.DUNGEON_STEEL_BLOCK.get());
                        output.accept(OddItems.RAGE_SCONCE.get());
                        output.accept(OddBlocks.RAGE_LANTERN.get());
                        output.accept(OddBlocks.SHALE.get());
                        output.accept(OddBlocks.SHALE_BRICKS.get());
                        output.accept(OddBlocks.SHALE_BRICK_STAIRS.get());
                        output.accept(OddBlocks.SHALE_BRICK_SLAB.get());
                        output.accept(OddBlocks.CHISELED_SHALE_PILLAR.get());
                        output.accept(OddBlocks.SHALE_PILLAR.get());
                        output.accept(OddBlocks.POLISHED_SHALE.get());
                        output.accept(OddBlocks.POLISHED_SHALE_STAIRS.get());
                        output.accept(OddBlocks.POLISHED_SHALE_SLAB.get());
                        output.accept(OddBlocks.QUARTZ_SAND.get());
                        output.accept(OddBlocks.ROUGH_QUARTZ.get());
                        output.accept(OddBlocks.ROUGH_QUARTZ_STAIRS.get());
                        output.accept(OddBlocks.ROUGH_QUARTZ_SLAB.get());
                        output.accept(OddBlocks.SUSPICIOUS_QUARTZ_SAND.get());
                        output.accept(OddBlocks.QUARTZ_GLASS.get());
                        output.accept(OddBlocks.QUARTZ_GLASS_PANE.get());
                        output.accept(Items.GRAVEL);
                        output.accept(OddBlocks.SHORESTONE.get());
                        output.accept(OddBlocks.SHORESTONE_BRICKS.get());
                        output.accept(OddBlocks.SHORESTONE_BRICK_STAIRS.get());
                        output.accept(OddBlocks.SHORESTONE_BRICK_SLAB.get());
                        output.accept(Items.SUSPICIOUS_GRAVEL);
                    })
                    .build());

    public static void init(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}