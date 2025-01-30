package net.mcreator.dragonblockckai.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.dragonblockckai.network.DragonBlockCKaiModVariables;

public class WillpowerDisplayProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "Willpower: " + new java.text.DecimalFormat("##").format((entity.getCapability(DragonBlockCKaiModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DragonBlockCKaiModVariables.PlayerVariables())).stat_willpower);
	}
}
