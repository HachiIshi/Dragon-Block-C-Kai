package net.mcreator.dragonblockckai.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class DisplayTotalMeleeDmgProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "Total Melee Dmg: " + new java.text.DecimalFormat("##.##").format(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getValue());
	}
}
