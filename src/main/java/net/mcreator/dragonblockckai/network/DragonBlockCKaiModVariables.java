package net.mcreator.dragonblockckai.network;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import net.mcreator.dragonblockckai.DragonBlockCKaiMod;

import java.util.function.Supplier;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DragonBlockCKaiModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		DragonBlockCKaiMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				for (Entity entityiterator : new ArrayList<>(event.getEntity().level().players())) {
					((PlayerVariables) entityiterator.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(entityiterator);
				}
			}
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				for (Entity entityiterator : new ArrayList<>(event.getEntity().level().players())) {
					((PlayerVariables) entityiterator.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(entityiterator);
				}
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				for (Entity entityiterator : new ArrayList<>(event.getEntity().level().players())) {
					((PlayerVariables) entityiterator.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(entityiterator);
				}
			}
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			clone.isflying = original.isflying;
			clone.dbckRace = original.dbckRace;
			clone.stat_constitution = original.stat_constitution;
			clone.stat_dexterity = original.stat_dexterity;
			clone.stat_mind = original.stat_mind;
			clone.stat_spirit = original.stat_spirit;
			clone.stat_strength = original.stat_strength;
			clone.stat_trainingpoints = original.stat_trainingpoints;
			clone.stat_upgradecost = original.stat_upgradecost;
			clone.stat_willpower = original.stat_willpower;
			clone.sys_healthbarFill = original.sys_healthbarFill;
			clone.sys_kibarFill = original.sys_kibarFill;
			clone.var_current_ki = original.var_current_ki;
			clone.var_level = original.var_level;
			clone.var_levelcost = original.var_levelcost;
			clone.var_max_ki = original.var_max_ki;
			clone.var_currentHP = original.var_currentHP;
			clone.var_maxHP = original.var_maxHP;
			clone.plr_hascustomized = original.plr_hascustomized;
			if (!event.isWasDeath()) {
			}
			if (!event.getEntity().level().isClientSide()) {
				for (Entity entityiterator : new ArrayList<>(event.getEntity().level().players())) {
					((PlayerVariables) entityiterator.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(entityiterator);
				}
			}
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("dragon_block_c_kai", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public boolean isflying = false;
		public String dbckRace = "\"minecraftsteve\"";
		public double stat_constitution = 1.0;
		public double stat_dexterity = 1.0;
		public double stat_mind = 1.0;
		public double stat_spirit = 1.0;
		public double stat_strength = 1.0;
		public double stat_trainingpoints = 5000.0;
		public double stat_upgradecost = 10.0;
		public double stat_willpower = 1.0;
		public double sys_healthbarFill = 0;
		public double sys_kibarFill = 0;
		public double var_current_ki = 100.0;
		public double var_level = 0;
		public double var_levelcost = 10.0;
		public double var_max_ki = 100.0;
		public double var_currentHP = 100.0;
		public double var_maxHP = 100.0;
		public boolean plr_hascustomized = false;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				DragonBlockCKaiMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(entity.level()::dimension), new PlayerVariablesSyncMessage(this, entity.getId()));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putBoolean("isflying", isflying);
			nbt.putString("dbckRace", dbckRace);
			nbt.putDouble("stat_constitution", stat_constitution);
			nbt.putDouble("stat_dexterity", stat_dexterity);
			nbt.putDouble("stat_mind", stat_mind);
			nbt.putDouble("stat_spirit", stat_spirit);
			nbt.putDouble("stat_strength", stat_strength);
			nbt.putDouble("stat_trainingpoints", stat_trainingpoints);
			nbt.putDouble("stat_upgradecost", stat_upgradecost);
			nbt.putDouble("stat_willpower", stat_willpower);
			nbt.putDouble("sys_healthbarFill", sys_healthbarFill);
			nbt.putDouble("sys_kibarFill", sys_kibarFill);
			nbt.putDouble("var_current_ki", var_current_ki);
			nbt.putDouble("var_level", var_level);
			nbt.putDouble("var_levelcost", var_levelcost);
			nbt.putDouble("var_max_ki", var_max_ki);
			nbt.putDouble("var_currentHP", var_currentHP);
			nbt.putDouble("var_maxHP", var_maxHP);
			nbt.putBoolean("plr_hascustomized", plr_hascustomized);
			return nbt;
		}

		public void readNBT(Tag Tag) {
			CompoundTag nbt = (CompoundTag) Tag;
			isflying = nbt.getBoolean("isflying");
			dbckRace = nbt.getString("dbckRace");
			stat_constitution = nbt.getDouble("stat_constitution");
			stat_dexterity = nbt.getDouble("stat_dexterity");
			stat_mind = nbt.getDouble("stat_mind");
			stat_spirit = nbt.getDouble("stat_spirit");
			stat_strength = nbt.getDouble("stat_strength");
			stat_trainingpoints = nbt.getDouble("stat_trainingpoints");
			stat_upgradecost = nbt.getDouble("stat_upgradecost");
			stat_willpower = nbt.getDouble("stat_willpower");
			sys_healthbarFill = nbt.getDouble("sys_healthbarFill");
			sys_kibarFill = nbt.getDouble("sys_kibarFill");
			var_current_ki = nbt.getDouble("var_current_ki");
			var_level = nbt.getDouble("var_level");
			var_levelcost = nbt.getDouble("var_levelcost");
			var_max_ki = nbt.getDouble("var_max_ki");
			var_currentHP = nbt.getDouble("var_currentHP");
			var_maxHP = nbt.getDouble("var_maxHP");
			plr_hascustomized = nbt.getBoolean("plr_hascustomized");
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		DragonBlockCKaiMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	public static class PlayerVariablesSyncMessage {
		private final int target;
		private final PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
			this.target = buffer.readInt();
		}

		public PlayerVariablesSyncMessage(PlayerVariables data, int entityid) {
			this.data = data;
			this.target = entityid;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
			buffer.writeInt(message.target);
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.level().getEntity(message.target).getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.isflying = message.data.isflying;
					variables.dbckRace = message.data.dbckRace;
					variables.stat_constitution = message.data.stat_constitution;
					variables.stat_dexterity = message.data.stat_dexterity;
					variables.stat_mind = message.data.stat_mind;
					variables.stat_spirit = message.data.stat_spirit;
					variables.stat_strength = message.data.stat_strength;
					variables.stat_trainingpoints = message.data.stat_trainingpoints;
					variables.stat_upgradecost = message.data.stat_upgradecost;
					variables.stat_willpower = message.data.stat_willpower;
					variables.sys_healthbarFill = message.data.sys_healthbarFill;
					variables.sys_kibarFill = message.data.sys_kibarFill;
					variables.var_current_ki = message.data.var_current_ki;
					variables.var_level = message.data.var_level;
					variables.var_levelcost = message.data.var_levelcost;
					variables.var_max_ki = message.data.var_max_ki;
					variables.var_currentHP = message.data.var_currentHP;
					variables.var_maxHP = message.data.var_maxHP;
					variables.plr_hascustomized = message.data.plr_hascustomized;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
