package net.mcreator.pepoyo.network;

import java.util.Objects;
import java.util.function.Supplier;
import net.mcreator.pepoyo.PepoyoMod;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerChangedDimensionEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent.Context;
import net.minecraftforge.network.simple.SimpleChannel;

@EventBusSubscriber(
   bus = Bus.MOD
)
public class PepoyoModVariables {
   @SubscribeEvent
   public static void init(FMLCommonSetupEvent event) {
      PepoyoMod.addNetworkMessage(PepoyoModVariables.SavedDataSyncMessage.class, PepoyoModVariables.SavedDataSyncMessage::buffer, PepoyoModVariables.SavedDataSyncMessage::new, PepoyoModVariables.SavedDataSyncMessage::handler);
   }

   public static class SavedDataSyncMessage {
      private final int type;
      private SavedData data;

      public SavedDataSyncMessage(FriendlyByteBuf buffer) {
         this.type = buffer.readInt();
         CompoundTag nbt = buffer.m_130260_();
         if (nbt != null) {
            this.data = (SavedData)(this.type == 0 ? new PepoyoModVariables.MapVariables() : new PepoyoModVariables.WorldVariables());
            SavedData var5 = this.data;
            if (var5 instanceof PepoyoModVariables.MapVariables) {
               PepoyoModVariables.MapVariables mapVariables = (PepoyoModVariables.MapVariables)var5;
               mapVariables.read(nbt);
            } else {
               var5 = this.data;
               if (var5 instanceof PepoyoModVariables.WorldVariables) {
                  PepoyoModVariables.WorldVariables worldVariables = (PepoyoModVariables.WorldVariables)var5;
                  worldVariables.read(nbt);
               }
            }
         }

      }

      public SavedDataSyncMessage(int type, SavedData data) {
         this.type = type;
         this.data = data;
      }

      public static void buffer(PepoyoModVariables.SavedDataSyncMessage message, FriendlyByteBuf buffer) {
         buffer.writeInt(message.type);
         if (message.data != null) {
            buffer.m_130079_(message.data.m_7176_(new CompoundTag()));
         }

      }

      public static void handler(PepoyoModVariables.SavedDataSyncMessage message, Supplier<Context> contextSupplier) {
         Context context = (Context)contextSupplier.get();
         context.enqueueWork(() -> {
            if (!context.getDirection().getReceptionSide().isServer() && message.data != null) {
               if (message.type == 0) {
                  PepoyoModVariables.MapVariables.clientSide = (PepoyoModVariables.MapVariables)message.data;
               } else {
                  PepoyoModVariables.WorldVariables.clientSide = (PepoyoModVariables.WorldVariables)message.data;
               }
            }

         });
         context.setPacketHandled(true);
      }
   }

   public static class MapVariables extends SavedData {
      public static final String DATA_NAME = "pepoyo_mapvars";
      public double knife_halfmoon = 0.0D;
      public boolean knife_skill = false;
      public double unluck_lottery = 0.0D;
      public boolean dooropened = false;
      public boolean warning = false;
      static PepoyoModVariables.MapVariables clientSide = new PepoyoModVariables.MapVariables();

      public static PepoyoModVariables.MapVariables load(CompoundTag tag) {
         PepoyoModVariables.MapVariables data = new PepoyoModVariables.MapVariables();
         data.read(tag);
         return data;
      }

      public void read(CompoundTag nbt) {
         this.knife_halfmoon = nbt.m_128459_("knife_halfmoon");
         this.knife_skill = nbt.m_128471_("knife_skill");
         this.unluck_lottery = nbt.m_128459_("unluck_lottery");
         this.dooropened = nbt.m_128471_("dooropened");
         this.warning = nbt.m_128471_("warning");
      }

      public CompoundTag m_7176_(CompoundTag nbt) {
         nbt.m_128347_("knife_halfmoon", this.knife_halfmoon);
         nbt.m_128379_("knife_skill", this.knife_skill);
         nbt.m_128347_("unluck_lottery", this.unluck_lottery);
         nbt.m_128379_("dooropened", this.dooropened);
         nbt.m_128379_("warning", this.warning);
         return nbt;
      }

      public void syncData(LevelAccessor world) {
         this.m_77762_();
         if (world instanceof Level && !world.m_5776_()) {
            PepoyoMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new PepoyoModVariables.SavedDataSyncMessage(0, this));
         }

      }

      public static PepoyoModVariables.MapVariables get(LevelAccessor world) {
         if (world instanceof ServerLevelAccessor) {
            ServerLevelAccessor serverLevelAcc = (ServerLevelAccessor)world;
            return (PepoyoModVariables.MapVariables)serverLevelAcc.m_6018_().m_7654_().m_129880_(Level.f_46428_).m_8895_().m_164861_((e) -> {
               return load(e);
            }, PepoyoModVariables.MapVariables::new, "pepoyo_mapvars");
         } else {
            return clientSide;
         }
      }
   }

   public static class WorldVariables extends SavedData {
      public static final String DATA_NAME = "pepoyo_worldvars";
      static PepoyoModVariables.WorldVariables clientSide = new PepoyoModVariables.WorldVariables();

      public static PepoyoModVariables.WorldVariables load(CompoundTag tag) {
         PepoyoModVariables.WorldVariables data = new PepoyoModVariables.WorldVariables();
         data.read(tag);
         return data;
      }

      public void read(CompoundTag nbt) {
      }

      public CompoundTag m_7176_(CompoundTag nbt) {
         return nbt;
      }

      public void syncData(LevelAccessor world) {
         this.m_77762_();
         if (world instanceof Level) {
            Level level = (Level)world;
            if (!level.m_5776_()) {
               SimpleChannel var10000 = PepoyoMod.PACKET_HANDLER;
               PacketDistributor var10001 = PacketDistributor.DIMENSION;
               Objects.requireNonNull(level);
               var10000.send(var10001.with(level::m_46472_), new PepoyoModVariables.SavedDataSyncMessage(1, this));
            }
         }

      }

      public static PepoyoModVariables.WorldVariables get(LevelAccessor world) {
         if (world instanceof ServerLevel) {
            ServerLevel level = (ServerLevel)world;
            return (PepoyoModVariables.WorldVariables)level.m_8895_().m_164861_((e) -> {
               return load(e);
            }, PepoyoModVariables.WorldVariables::new, "pepoyo_worldvars");
         } else {
            return clientSide;
         }
      }
   }

   @EventBusSubscriber
   public static class EventBusVariableHandlers {
      @SubscribeEvent
      public static void onPlayerLoggedIn(PlayerLoggedInEvent event) {
         if (!event.getEntity().m_9236_().m_5776_()) {
            SavedData mapdata = PepoyoModVariables.MapVariables.get(event.getEntity().m_9236_());
            SavedData worlddata = PepoyoModVariables.WorldVariables.get(event.getEntity().m_9236_());
            if (mapdata != null) {
               PepoyoMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> {
                  return (ServerPlayer)event.getEntity();
               }), new PepoyoModVariables.SavedDataSyncMessage(0, mapdata));
            }

            if (worlddata != null) {
               PepoyoMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> {
                  return (ServerPlayer)event.getEntity();
               }), new PepoyoModVariables.SavedDataSyncMessage(1, worlddata));
            }
         }

      }

      @SubscribeEvent
      public static void onPlayerChangedDimension(PlayerChangedDimensionEvent event) {
         if (!event.getEntity().m_9236_().m_5776_()) {
            SavedData worlddata = PepoyoModVariables.WorldVariables.get(event.getEntity().m_9236_());
            if (worlddata != null) {
               PepoyoMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> {
                  return (ServerPlayer)event.getEntity();
               }), new PepoyoModVariables.SavedDataSyncMessage(1, worlddata));
            }
         }

      }
   }
}
