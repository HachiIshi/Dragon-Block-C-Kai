package net.mcreator.dragonblockckai.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.dragonblockckai.network.DragonBlockCKaiModVariables;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class SetStatHandleProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		if ((StringArgumentType.getString(arguments, "stat")).equals("str")) {
			{
				double _setval = DoubleArgumentType.getDouble(arguments, "newvalue");
				entity.getCapability(DragonBlockCKaiModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.stat_strength = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((StringArgumentType.getString(arguments, "stat")).equals("dex")) {
			{
				double _setval = DoubleArgumentType.getDouble(arguments, "newvalue");
				entity.getCapability(DragonBlockCKaiModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.stat_dexterity = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((StringArgumentType.getString(arguments, "stat")).equals("con")) {
			{
				double _setval = DoubleArgumentType.getDouble(arguments, "newvalue");
				entity.getCapability(DragonBlockCKaiModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.stat_constitution = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((StringArgumentType.getString(arguments, "stat")).equals("spi")) {
			{
				double _setval = DoubleArgumentType.getDouble(arguments, "newvalue");
				entity.getCapability(DragonBlockCKaiModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.stat_spirit = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((StringArgumentType.getString(arguments, "stat")).equals("wil")) {
			{
				double _setval = DoubleArgumentType.getDouble(arguments, "newvalue");
				entity.getCapability(DragonBlockCKaiModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.stat_willpower = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((StringArgumentType.getString(arguments, "stat")).equals("mnd")) {
			{
				double _setval = DoubleArgumentType.getDouble(arguments, "newvalue");
				entity.getCapability(DragonBlockCKaiModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.stat_mind = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((StringArgumentType.getString(arguments, "stat")).equals("all")) {
			{
				double _setval = DoubleArgumentType.getDouble(arguments, "newvalue");
				entity.getCapability(DragonBlockCKaiModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.stat_strength = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = DoubleArgumentType.getDouble(arguments, "newvalue");
				entity.getCapability(DragonBlockCKaiModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.stat_dexterity = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = DoubleArgumentType.getDouble(arguments, "newvalue");
				entity.getCapability(DragonBlockCKaiModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.stat_constitution = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = DoubleArgumentType.getDouble(arguments, "newvalue");
				entity.getCapability(DragonBlockCKaiModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.stat_spirit = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = DoubleArgumentType.getDouble(arguments, "newvalue");
				entity.getCapability(DragonBlockCKaiModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.stat_willpower = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = DoubleArgumentType.getDouble(arguments, "newvalue");
				entity.getCapability(DragonBlockCKaiModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.stat_mind = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
