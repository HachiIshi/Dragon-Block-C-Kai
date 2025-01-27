package net.mcreator.dragonblockckai.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.client.gui.components.EditBox;

import net.mcreator.dragonblockckai.network.DragonBlockCKaiModVariables;

import java.util.HashMap;

public class StatMenuOpenedGuiProcedure {
	public static void execute(Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		if (guistate.get("text:test") instanceof EditBox _tf)
			_tf.setValue(("Strength: " + new java.text.DecimalFormat("##").format((entity.getCapability(DragonBlockCKaiModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DragonBlockCKaiModVariables.PlayerVariables())).stat_strength)));
	}
}
