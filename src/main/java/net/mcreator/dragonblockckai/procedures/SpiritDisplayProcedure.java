package net.mcreator.dragonblockckai.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.dragonblockckai.network.DragonBlockCKaiModVariables;

public class SpiritDisplayProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "Spirit: " + new java.text.DecimalFormat("##").format((entity.getCapability(DragonBlockCKaiModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DragonBlockCKaiModVariables.PlayerVariables())).stat_spirit);
	}
}
