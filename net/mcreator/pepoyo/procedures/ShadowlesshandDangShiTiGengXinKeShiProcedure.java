package net.mcreator.pepoyo.procedures;

import net.mcreator.pepoyo.entity.ShadowlesshandEntity;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;

public class ShadowlesshandDangShiTiGengXinKeShiProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         ShadowlesshandEntity _datEntI;
         if (entity instanceof ShadowlesshandEntity) {
            _datEntI = (ShadowlesshandEntity)entity;
            SynchedEntityData var10000 = _datEntI.m_20088_();
            EntityDataAccessor var10001 = ShadowlesshandEntity.DATA_tick;
            int var10002;
            if (entity instanceof ShadowlesshandEntity) {
               ShadowlesshandEntity _datEntI = (ShadowlesshandEntity)entity;
               var10002 = (Integer)_datEntI.m_20088_().m_135370_(ShadowlesshandEntity.DATA_tick);
            } else {
               var10002 = 0;
            }

            var10000.m_135381_(var10001, var10002 + 1);
         }

         int var10;
         if (entity instanceof ShadowlesshandEntity) {
            _datEntI = (ShadowlesshandEntity)entity;
            var10 = (Integer)_datEntI.m_20088_().m_135370_(ShadowlesshandEntity.DATA_tick);
         } else {
            var10 = 0;
         }

         if (var10 >= 120) {
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_254849_((Entity)null, x, y, z, 3.0F, ExplosionInteraction.MOB);
               }
            }

            if (!entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }
         }

      }
   }
}
