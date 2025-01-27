package net.mcreator.dragonblockckai.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.dragonblockckai.network.DragonBlockCKaiModVariables;

public class ConstitutionAddFunctionProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(DragonBlockCKaiModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DragonBlockCKaiModVariables.PlayerVariables())).stat_trainingpoints > (entity
				.getCapability(DragonBlockCKaiModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DragonBlockCKaiModVariables.PlayerVariables())).stat_upgradecost) {
			{
				double _setval = (entity.getCapability(DragonBlockCKaiModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DragonBlockCKaiModVariables.PlayerVariables())).stat_trainingpoints
						- ((entity.getCapability(DragonBlockCKaiModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DragonBlockCKaiModVariables.PlayerVariables())).stat_upgradecost / 2 + 2);
				entity.getCapability(DragonBlockCKaiModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.stat_trainingpoints = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (entity.getCapability(DragonBlockCKaiModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DragonBlockCKaiModVariables.PlayerVariables())).stat_constitution + 1;
				entity.getCapability(DragonBlockCKaiModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.stat_constitution = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
