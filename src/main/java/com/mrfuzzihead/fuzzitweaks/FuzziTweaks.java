package com.mrfuzzihead.fuzzitweaks;

import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = FuzziTweaks.MODID, version = FuzziTweaks.VERSION, name = FuzziTweaks.MODNAME, dependencies = "required-after:spongemixins@[1.1.0,)")
public class FuzziTweaks
{
    public static final String MODID = "fuzzitweaks";
    public static final String VERSION = "1.0";
    public static final String MODNAME = "FuzziTweaks";
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    }
}
