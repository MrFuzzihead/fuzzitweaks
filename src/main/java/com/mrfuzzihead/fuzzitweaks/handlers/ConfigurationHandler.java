package com.mrfuzzihead.fuzzitweaks.handlers;

import com.mrfuzzihead.fuzzitweaks.FuzziTweaks;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigurationHandler
{
    public static Configuration configuration;

    public static boolean enableUpdateChecker = true;

    public static boolean enableDespawnModule = true;

    public static int maxMobSpawnLightLevel = 0;

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

        maxMobSpawnLightLevel = configuration.getInt("MaxMobSpawnLightLevel", Configuration.CATEGORY_GENERAL, 0, 0, 15, "Highest light level that hostile mobs will spawn at (0-15)");
    }

    public static Configuration getConfiguration() {return configuration;}
}
