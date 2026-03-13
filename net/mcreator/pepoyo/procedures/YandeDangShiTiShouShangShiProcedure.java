package net.mcreator.pepoyo.procedures;

import net.mcreator.pepoyo.PepoyoMod;
import net.mcreator.pepoyo.entity.YandeEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class YandeDangShiTiShouShangShiProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         if (entity instanceof YandeEntity) {
            YandeEntity animatable = (YandeEntity)entity;
            animatable.setTexture("yande_death_1");
         }

         if (entity instanceof YandeEntity) {
            ((YandeEntity)entity).setAnimation("animation.yande.hurt");
         }

         PepoyoMod.queueServerWork(4, () -> {
            if (entity instanceof YandeEntity) {
               YandeEntity animatable = (YandeEntity)entity;
               animatable.setTexture("yande");
            }

         });
      }
   }
}
