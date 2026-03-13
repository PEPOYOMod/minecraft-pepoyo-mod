package net.mcreator.pepoyo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.AbstractMap.SimpleEntry;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;
import net.mcreator.pepoyo.init.PepoyoModBlockEntities;
import net.mcreator.pepoyo.init.PepoyoModBlocks;
import net.mcreator.pepoyo.init.PepoyoModEntities;
import net.mcreator.pepoyo.init.PepoyoModItems;
import net.mcreator.pepoyo.init.PepoyoModMobEffects;
import net.mcreator.pepoyo.init.PepoyoModSounds;
import net.mcreator.pepoyo.init.PepoyoModTabs;
import net.mcreator.pepoyo.world.features.StructureFeature;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.event.TickEvent.ServerTickEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.util.thread.SidedThreadGroups;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.NetworkEvent.Context;
import net.minecraftforge.network.simple.SimpleChannel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("pepoyo")
public class PepoyoMod {
   public static final Logger LOGGER = LogManager.getLogger(PepoyoMod.class);
   public static final String MODID = "pepoyo";
   private static final String PROTOCOL_VERSION = "1";
   public static final SimpleChannel PACKET_HANDLER = NetworkRegistry.newSimpleChannel(new ResourceLocation("pepoyo", "pepoyo"), () -> {
      return "1";
   }, "1"::equals, "1"::equals);
   private static int messageID = 0;
   private static final Collection<SimpleEntry<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue();

   public PepoyoMod() {
      MinecraftForge.EVENT_BUS.register(this);
      IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
      PepoyoModSounds.REGISTRY.register(bus);
      PepoyoModBlocks.REGISTRY.register(bus);
      PepoyoModBlockEntities.REGISTRY.register(bus);
      PepoyoModItems.REGISTRY.register(bus);
      PepoyoModEntities.REGISTRY.register(bus);
      PepoyoModTabs.REGISTRY.register(bus);
      StructureFeature.REGISTRY.register(bus);
      PepoyoModMobEffects.REGISTRY.register(bus);
   }

   public static <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, FriendlyByteBuf> encoder, Function<FriendlyByteBuf, T> decoder, BiConsumer<T, Supplier<Context>> messageConsumer) {
      PACKET_HANDLER.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
      ++messageID;
   }

   public static void queueServerWork(int tick, Runnable action) {
      if (Thread.currentThread().getThreadGroup() == SidedThreadGroups.SERVER) {
         workQueue.add(new SimpleEntry(action, tick));
      }

   }

   @SubscribeEvent
   public void tick(ServerTickEvent event) {
      if (event.phase == Phase.END) {
         List<SimpleEntry<Runnable, Integer>> actions = new ArrayList();
         workQueue.forEach((work) -> {
            work.setValue((Integer)work.getValue() - 1);
            if ((Integer)work.getValue() == 0) {
               actions.add(work);
            }

         });
         actions.forEach((e) -> {
            ((Runnable)e.getKey()).run();
         });
         workQueue.removeAll(actions);
      }

   }
}
