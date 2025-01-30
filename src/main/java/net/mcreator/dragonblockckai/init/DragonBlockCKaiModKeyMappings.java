
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dragonblockckai.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.dragonblockckai.network.StatMenuOpenMessage;
import net.mcreator.dragonblockckai.network.KiChargeMessage;
import net.mcreator.dragonblockckai.network.FlightMessage;
import net.mcreator.dragonblockckai.DragonBlockCKaiMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class DragonBlockCKaiModKeyMappings {
	public static final KeyMapping STAT_MENU_OPEN = new KeyMapping("key.dragon_block_c_kai.stat_menu_open", GLFW.GLFW_KEY_V, "key.categories.dragon_block_c_kai") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				DragonBlockCKaiMod.PACKET_HANDLER.sendToServer(new StatMenuOpenMessage(0, 0));
				StatMenuOpenMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping FLIGHT = new KeyMapping("key.dragon_block_c_kai.flight", GLFW.GLFW_KEY_F, "key.categories.dragon_block_c_kai") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				DragonBlockCKaiMod.PACKET_HANDLER.sendToServer(new FlightMessage(0, 0));
				FlightMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping KI_CHARGE = new KeyMapping("key.dragon_block_c_kai.ki_charge", GLFW.GLFW_KEY_C, "key.categories.dragon_block_c_kai") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				DragonBlockCKaiMod.PACKET_HANDLER.sendToServer(new KiChargeMessage(0, 0));
				KiChargeMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				KI_CHARGE_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - KI_CHARGE_LASTPRESS);
				DragonBlockCKaiMod.PACKET_HANDLER.sendToServer(new KiChargeMessage(1, dt));
				KiChargeMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	private static long KI_CHARGE_LASTPRESS = 0;

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(STAT_MENU_OPEN);
		event.register(FLIGHT);
		event.register(KI_CHARGE);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				STAT_MENU_OPEN.consumeClick();
				FLIGHT.consumeClick();
				KI_CHARGE.consumeClick();
			}
		}
	}
}
