package net.mcreator.pepoyo.procedures;

import net.mcreator.pepoyo.PepoyoMod;
import net.mcreator.pepoyo.entity.YandeEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class YandeoffDangShiTiShouShangShiProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         if (entity instanceof YandeEntity) {
            ((YandeEntity)entity).setAnimation("animation.yande.hurt");
         }

         if (entity instanceof YandeEntity) {
            YandeEntity animatable = (YandeEntity)entity;
            animatable.setTexture("yande_death_1.png");
         }

         PepoyoMod.queueServerWork(4, () -> {
            if (entity instanceof YandeEntity) {
               YandeEntity animatable = (YandeEntity)entity;
               animatable.setTexture("yande.png");
            }

         });
      }
   }
}
