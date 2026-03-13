package net.mcreator.pepoyo.procedures;

import javax.annotation.Nullable;
import net.mcreator.pepoyo.PepoyoMod;
import net.mcreator.pepoyo.network.PepoyoModVariables;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.entity.player.AdvancementEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class DooropenXianShiYouXiNeiDieJiaCengProcedure {
   @SubscribeEvent
   public static void onAdvancement(AdvancementEvent event) {
      execute(event, event.getEntity().m_9236_());
   }

   public static boolean execute(LevelAccessor world) {
      return execute((Event)null, world);
   }

   private static boolean execute(@Nullable Event event, LevelAccessor world) {
      if (PepoyoModVariables.MapVariables.get(world).dooropened) {
         PepoyoMod.queueServerWork(10, () -> {
            PepoyoModVariables.MapVariables.get(world).dooropened = false;
            PepoyoModVariables.MapVariables.get(world).syncData(world);
         });
      }

      return true;
   }
}
