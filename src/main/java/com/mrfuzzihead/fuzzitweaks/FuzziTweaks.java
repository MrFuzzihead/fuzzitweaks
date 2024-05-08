package com.mrfuzzihead.fuzzitweaks;

import com.mrfuzzihead.fuzzitweaks.handlers.ConfigurationHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = FuzziTweaks.MODID, version = FuzziTweaks.VERSION, name = FuzziTweaks.MODNAME, dependencies = "required-after:spongemixins@[1.1.0,)")
public final class FuzziTweaks
{
    public static final String MODID = "fuzzitweaks";
    public static final String VERSION = "1.7.10-r1";
    public static final String MODNAME = "FuzziTweaks";

    @Mod.Instance("fuzzitweaks")
    public static FuzziTweaks instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        String configDir = event.getModConfigurationDirectory().toString();
        ConfigurationHandler.init(configDir);
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    }

    // Configuration Options
    public static final boolean enableUpdateChecker = true;

    public static final boolean enableDespawnModule = true;

    public static int maxMobSpawnLightLevel = 0;

    // Logging
    public static final Logger log = LogManager.getLogger(MODID);

    public FuzziTweaks()
    {
    }

    public static String getVersion()
    {
        return "${version}";
    }
}
