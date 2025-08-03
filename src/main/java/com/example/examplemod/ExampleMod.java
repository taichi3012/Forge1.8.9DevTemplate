package com.example.examplemod;

import net.minecraft.client.Minecraft;
import net.minecraft.event.ClickEvent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(
  modid = ExampleMod.MOD_ID,
  useMetadata = true,
  clientSideOnly = true
)
public class ExampleMod {

  public static final String MOD_ID = "examplemod";

  @EventHandler
  public void init(FMLInitializationEvent event) {
    MinecraftForge.EVENT_BUS.register(this);
  }

  private static final String TEMPLATE_REPO_URL = "https://github.com/taichi3012/Forge1.8.9DevTemplate";

  @SubscribeEvent
  public void onWorldLoad(EntityJoinWorldEvent event) {
    if (event.entity == Minecraft.getMinecraft().thePlayer) {
      printChatMessage(
        new ChatComponentText("§b§lこんにちは" + event.entity.getName() + "さん。このModは、")
          .appendSibling(
            new ChatComponentText("§c§l§ntaichi3012/Forge1.8.9DevTemplate")
              .setChatStyle(new ChatStyle().setChatClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, TEMPLATE_REPO_URL)))
          )
          .appendText("§b§lを使用して作成されました。")
      );
    }
  }

  public static void printChatMessage(IChatComponent component) {
    Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(component);
  }

}
