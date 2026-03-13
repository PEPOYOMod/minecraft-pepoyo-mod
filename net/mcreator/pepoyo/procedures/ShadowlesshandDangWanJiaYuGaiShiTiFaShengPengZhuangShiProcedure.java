package net.mcreator.pepoyo.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;

public class ShadowlesshandDangWanJiaYuGaiShiTiFaShengPengZhuangShiProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (!entity.m_9236_().m_5776_()) {
            entity.m_146870_();
         }

         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_254849_((Entity)null, x, y, z, 4.0F, ExplosionInteraction.MOB);
            }
         }

      }
   }
}
