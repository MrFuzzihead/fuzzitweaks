package com.mrfuzzihead.fuzzitweaks.handlers;

import com.mrfuzzihead.fuzzitweaks.FuzziTweaks;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigurationHandler
{
    public static Configuration configuration;

    public static boolean enableUpdateChecker = true;

    public static boolean enableDespawnModule = true;

    public static int mobSpawnLightLevelCutoff = 1;

    public static void init(String configDir)
    {
        if (configuration == null)
        {
            File path = new File(configDir + FuzziTweaks.MODID + ".cfg");

            configuration = new Configuration(path);
            loadConfiguration();
        }
    }

    private static void loadConfiguration()
    {
        enableUpdateChecker = configuration.getBoolean("EnableUpdateChecker", Configuration.CATEGORY_GENERAL, true, "Allow this mod to check for updates");

        enableDespawnModule = configuration.getBoolean("EnableDespawnModule", Configuration.CATEGORY_GENERAL, true, "Enable module that lets mobs holding items/armor despawn");

        mobSpawnLightLevelCutoff = configuration.getInt("MobSpawnLightLevelCutoff", Configuration.CATEGORY_GENERAL, 1, 0, 16, "Light level that hostile mobs will no longer spawn at (0-16)");
    }

    public static Configuration getConfiguration() {return configuration;}
}
