package net.mcreator.dragonblockckai.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.dragonblockckai.network.DragonBlockCKaiModVariables;

public class PlayerFlightProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(DragonBlockCKaiModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DragonBlockCKaiModVariables.PlayerVariables())).isflying == false) {
			{
				boolean _setval = true;
				entity.getCapability(DragonBlockCKaiModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.isflying = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player) {
				_player.getAbilities().flying = true;
				_player.onUpdateAbilities();
			}
		} else if ((entity.getCapability(DragonBlockCKaiModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DragonBlockCKaiModVariables.PlayerVariables())).isflying == true) {
			{
				boolean _setval = false;
				entity.getCapability(DragonBlockCKaiModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.isflying = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player) {
				_player.getAbilities().flying = false;
				_player.onUpdateAbilities();
			}
		}
	}
}
