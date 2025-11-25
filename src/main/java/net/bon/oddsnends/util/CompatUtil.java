package net.bon.oddsnends.util;

import net.minecraftforge.fml.loading.FMLLoader;

public class CompatUtil {
    public static String FARMERSDELIGHT = "farmersdelight";
    public static String BOUNTIFULFARES = "bountifulfares";
    public static String NEAPOLITAN = "neapolitan";

    public static boolean checkFarmersDelight() {
        return FMLLoader.getLoadingModList().getModFileById(FARMERSDELIGHT) != null;
    }
    public static boolean checkBountifulFares() {
        return FMLLoader.getLoadingModList().getModFileById(BOUNTIFULFARES) != null;
    }
    public static boolean checkNeapolitan() {
        return FMLLoader.getLoadingModList().getModFileById(NEAPOLITAN) != null;
    }
}