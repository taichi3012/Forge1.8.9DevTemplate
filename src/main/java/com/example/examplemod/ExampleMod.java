package com.example.examplemod;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = ExampleMod.MOD_ID, useMetadata = true, clientSideOnly = true)
public class ExampleMod {

  public static final String MOD_ID = "examplemod";

  @EventHandler
  public void init(FMLInitializationEvent event) {
    System.out.println("DIRT BLOCK >> "+Blocks.dirt.getUnlocalizedName());
  }
}
