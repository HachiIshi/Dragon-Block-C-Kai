package net.mcreator.dragonblockckai.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.Entity;

import net.mcreator.dragonblockckai.network.DragonBlockCKaiModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class KiOverProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(DragonBlockCKaiModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DragonBlockCKaiModVariables.PlayerVariables())).var_current_ki > (entity
				.getCapability(DragonBlockCKaiModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DragonBlockCKaiModVariables.PlayerVariables())).var_max_ki) {
			{
				double _setval = (entity.getCapability(DragonBlockCKaiModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DragonBlockCKaiModVariables.PlayerVariables())).var_max_ki;
				entity.getCapability(DragonBlockCKaiModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.var_current_ki = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
