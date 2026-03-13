package net.mcreator.pepoyo.procedures;

import net.mcreator.pepoyo.PepoyoMod;
import net.minecraft.world.level.LevelAccessor;

public class YandeerrorDangShiTiChuShiShengChengShiProcedure {
   public static void execute(LevelAccessor world) {
      PepoyoMod.queueServerWork(20, () -> {
         PepoyoMod.LOGGER.error("<Yande> 我们创造，我们玩乐，我们分享，我们体验");
         PepoyoMod.queueServerWork(20, () -> {
            PepoyoMod.LOGGER.error("<Yande> 躁郁症");
         });
      });
   }
}
