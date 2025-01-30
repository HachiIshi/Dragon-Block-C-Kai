
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dragonblockckai.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.dragonblockckai.world.inventory.StatMenuMenu;
import net.mcreator.dragonblockckai.world.inventory.CustomizescreenMenu;
import net.mcreator.dragonblockckai.DragonBlockCKaiMod;

public class DragonBlockCKaiModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, DragonBlockCKaiMod.MODID);
	public static final RegistryObject<MenuType<StatMenuMenu>> STAT_MENU = REGISTRY.register("stat_menu", () -> IForgeMenuType.create(StatMenuMenu::new));
	public static final RegistryObject<MenuType<CustomizescreenMenu>> CUSTOMIZESCREEN = REGISTRY.register("customizescreen", () -> IForgeMenuType.create(CustomizescreenMenu::new));
}
