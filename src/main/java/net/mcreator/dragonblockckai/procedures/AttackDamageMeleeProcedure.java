package net.mcreator.dragonblockckai.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.dragonblockckai.network.DragonBlockCKaiModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class AttackDamageMeleeProcedure {
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
		if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE) != null) {
			((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE)
					.setBaseValue((2 * (entity.getCapability(DragonBlockCKaiModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DragonBlockCKaiModVariables.PlayerVariables())).stat_strength
							+ 0.75 * (entity.getCapability(DragonBlockCKaiModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DragonBlockCKaiModVariables.PlayerVariables())).stat_strength));
		}
	}
}
