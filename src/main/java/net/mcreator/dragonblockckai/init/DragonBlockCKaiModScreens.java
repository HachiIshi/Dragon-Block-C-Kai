
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dragonblockckai.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.dragonblockckai.client.gui.StatMenuScreen;
import net.mcreator.dragonblockckai.client.gui.CustomizescreenScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DragonBlockCKaiModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(DragonBlockCKaiModMenus.STAT_MENU.get(), StatMenuScreen::new);
			MenuScreens.register(DragonBlockCKaiModMenus.CUSTOMIZESCREEN.get(), CustomizescreenScreen::new);
		});
	}
}
