package net.bon.oddsnends.util;

import net.minecraftforge.fml.loading.FMLLoader;

public class CompatUtil {
    public static String FARMERSDELIGHT = "farmersdelight";

    public static boolean checkFarmersDelight() {
        return FMLLoader.getLoadingModList().getModFileById(FARMERSDELIGHT) != null;
    }
}