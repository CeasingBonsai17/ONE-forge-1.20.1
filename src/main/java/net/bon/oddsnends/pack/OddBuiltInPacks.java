package net.bon.oddsnends.pack;

import net.bon.oddsnends.OddsNEnds;
import net.minecraft.SharedConstants;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.forgespi.language.IModFileInfo;

import java.nio.file.Path;

public class OddBuiltInPacks {
    public static void dpFarmersDelightCompat(AddPackFindersEvent event) {
        IModFileInfo mod = ModList.get().getModFileById(OddsNEnds.MOD_ID);
        Path file = mod.getFile().findResource("resourcepacks/farmersdelight_compat");
        event.addRepositorySource((packConsumer) ->
                packConsumer.accept(
                        Pack.create("farmersdelight_compat",
                                Component.literal("Odds n' Ends + Farmer's Delight"),
                                true,
                                (path) -> new PathPackResources(path, file, true),
                                new Pack.Info(Component.literal("Compatibility for Farmer's Delight"), SharedConstants.getCurrentVersion().getPackVersion(PackType.SERVER_DATA), FeatureFlagSet.of()),
                                PackType.SERVER_DATA, Pack.Position.TOP, true, PackSource.BUILT_IN)));
    }
}
