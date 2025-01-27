package net.mcreator.dragonblockckai.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.dragonblockckai.world.inventory.StatMenuMenu;
import net.mcreator.dragonblockckai.procedures.WillpowerDisplayProcedure;
import net.mcreator.dragonblockckai.procedures.StrengthdisplayProcedure;
import net.mcreator.dragonblockckai.procedures.SpiritDisplayProcedure;
import net.mcreator.dragonblockckai.procedures.MindDisplayProcedure;
import net.mcreator.dragonblockckai.procedures.DisplaytrainingPointsProcedure;
import net.mcreator.dragonblockckai.procedures.DisplayTotalMeleeDmgProcedure;
import net.mcreator.dragonblockckai.procedures.DisplayMaxHpProcedure;
import net.mcreator.dragonblockckai.procedures.DexterityDisplayProcedure;
import net.mcreator.dragonblockckai.procedures.ConstitutionDisplayProcedure;
import net.mcreator.dragonblockckai.network.StatMenuButtonMessage;
import net.mcreator.dragonblockckai.DragonBlockCKaiMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class StatMenuScreen extends AbstractContainerScreen<StatMenuMenu> {
	private final static HashMap<String, Object> guistate = StatMenuMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_stataddbutton;
	ImageButton imagebutton_stataddbutton1;
	ImageButton imagebutton_stataddbutton2;
	ImageButton imagebutton_stataddbutton3;
	ImageButton imagebutton_stataddbutton4;
	ImageButton imagebutton_stataddbutton5;

	public StatMenuScreen(StatMenuMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 190;
		this.imageHeight = 100;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(new ResourceLocation("dragon_block_c_kai:textures/screens/smaller_teststatmenubg.png"), this.leftPos + -95, this.topPos + -135, 0, 0, 375, 375, 375, 375);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font,

				DisplaytrainingPointsProcedure.execute(entity), -65, -21, -16777216, false);
		guiGraphics.drawString(this.font,

				StrengthdisplayProcedure.execute(entity), -58, 4, -13261, false);
		guiGraphics.drawString(this.font,

				DisplayTotalMeleeDmgProcedure.execute(entity), 139, 1, -12829636, false);
		guiGraphics.drawString(this.font,

				DexterityDisplayProcedure.execute(entity), -59, 19, -13261, false);
		guiGraphics.drawString(this.font,

				ConstitutionDisplayProcedure.execute(entity), -59, 37, -13261, false);
		guiGraphics.drawString(this.font,

				SpiritDisplayProcedure.execute(entity), -59, 55, -13261, false);
		guiGraphics.drawString(this.font,

				WillpowerDisplayProcedure.execute(entity), -59, 73, -13261, false);
		guiGraphics.drawString(this.font,

				MindDisplayProcedure.execute(entity), -59, 91, -13261, false);
		guiGraphics.drawString(this.font,

				DisplayMaxHpProcedure.execute(entity), 139, 37, -12829636, false);
		guiGraphics.drawString(this.font,

				DexterityDisplayProcedure.execute(entity), 139, 20, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_stataddbutton = new ImageButton(this.leftPos + 58, this.topPos + 5, 9, 9, 0, 0, 9, new ResourceLocation("dragon_block_c_kai:textures/screens/atlas/imagebutton_stataddbutton.png"), 9, 18, e -> {
			if (true) {
				DragonBlockCKaiMod.PACKET_HANDLER.sendToServer(new StatMenuButtonMessage(0, x, y, z));
				StatMenuButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_stataddbutton", imagebutton_stataddbutton);
		this.addRenderableWidget(imagebutton_stataddbutton);
		imagebutton_stataddbutton1 = new ImageButton(this.leftPos + 58, this.topPos + 20, 9, 9, 0, 0, 9, new ResourceLocation("dragon_block_c_kai:textures/screens/atlas/imagebutton_stataddbutton1.png"), 9, 18, e -> {
			if (true) {
				DragonBlockCKaiMod.PACKET_HANDLER.sendToServer(new StatMenuButtonMessage(1, x, y, z));
				StatMenuButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_stataddbutton1", imagebutton_stataddbutton1);
		this.addRenderableWidget(imagebutton_stataddbutton1);
		imagebutton_stataddbutton2 = new ImageButton(this.leftPos + 58, this.topPos + 38, 9, 9, 0, 0, 9, new ResourceLocation("dragon_block_c_kai:textures/screens/atlas/imagebutton_stataddbutton2.png"), 9, 18, e -> {
			if (true) {
				DragonBlockCKaiMod.PACKET_HANDLER.sendToServer(new StatMenuButtonMessage(2, x, y, z));
				StatMenuButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_stataddbutton2", imagebutton_stataddbutton2);
		this.addRenderableWidget(imagebutton_stataddbutton2);
		imagebutton_stataddbutton3 = new ImageButton(this.leftPos + 58, this.topPos + 56, 9, 9, 0, 0, 9, new ResourceLocation("dragon_block_c_kai:textures/screens/atlas/imagebutton_stataddbutton3.png"), 9, 18, e -> {
		});
		guistate.put("button:imagebutton_stataddbutton3", imagebutton_stataddbutton3);
		this.addRenderableWidget(imagebutton_stataddbutton3);
		imagebutton_stataddbutton4 = new ImageButton(this.leftPos + 58, this.topPos + 74, 9, 9, 0, 0, 9, new ResourceLocation("dragon_block_c_kai:textures/screens/atlas/imagebutton_stataddbutton4.png"), 9, 18, e -> {
		});
		guistate.put("button:imagebutton_stataddbutton4", imagebutton_stataddbutton4);
		this.addRenderableWidget(imagebutton_stataddbutton4);
		imagebutton_stataddbutton5 = new ImageButton(this.leftPos + 58, this.topPos + 92, 9, 9, 0, 0, 9, new ResourceLocation("dragon_block_c_kai:textures/screens/atlas/imagebutton_stataddbutton5.png"), 9, 18, e -> {
		});
		guistate.put("button:imagebutton_stataddbutton5", imagebutton_stataddbutton5);
		this.addRenderableWidget(imagebutton_stataddbutton5);
	}
}
