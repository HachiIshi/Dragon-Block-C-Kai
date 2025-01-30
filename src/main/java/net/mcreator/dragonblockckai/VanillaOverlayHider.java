/**
 * The code of this mod element is always locked.
 *
 * You can register new events in this class too.
 *
 * If you want to make a plain independent class, create it using
 * Project Browser -> New... and make sure to make the class
 * outside net.mcreator.test as this package is managed by MCreator.
 *
 * If you change workspace package, modid or prefix, you will need
 * to manually adapt this file to these changes or remake it.
 *
 * This class will be added in the mod root package.
*/
package net.mcreator.dragonblockckai;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.gui.overlay.VanillaGuiOverlay;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.entity.Entity;
import net.minecraft.client.Minecraft;

@Mod.EventBusSubscriber(modid = "dragon_block_c_kai", bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class VanillaOverlayHider {
	@SubscribeEvent
	public static void RenderHealthBar(RenderGuiOverlayEvent.Pre event) {
		Entity entity = Minecraft.getInstance().player;
		if (entity == null)
			return;
		if (VanillaGuiOverlay.PLAYER_HEALTH.type() == event.getOverlay()) {
                event.setCanceled(true);
 		if (VanillaGuiOverlay.FOOD_LEVEL.type() == event.getOverlay()) {
                event.setCanceled(true);
			}
		}
	}
}