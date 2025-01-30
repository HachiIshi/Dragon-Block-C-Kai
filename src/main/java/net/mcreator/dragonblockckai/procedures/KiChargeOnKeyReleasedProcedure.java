package net.mcreator.dragonblockckai.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.dragonblockckai.network.DragonBlockCKaiModVariables;

public class KiChargeOnKeyReleasedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			boolean _setval = false;
			entity.getCapability(DragonBlockCKaiModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.Ki_charge = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
