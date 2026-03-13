package net.mcreator.pepoyo.procedures;

import net.mcreator.pepoyo.PepoyoMod;
import net.mcreator.pepoyo.init.PepoyoModEntities;
import net.mcreator.pepoyo.init.PepoyoModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.LevelAccessor;

public class YandeoffDangYouJiShiTiShiProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
      if (entity != null && sourceentity != null) {
         if (sourceentity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)sourceentity;
            if (_entity.m_21055_((Item)PepoyoModItems.TAIJI.get())) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  Entity entityToSpawn = ((EntityType)PepoyoModEntities.YANDE.get()).m_262496_(_level, BlockPos.m_274561_(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                  }
               }

               entity.m_6021_(x, -100.0D, z);
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entity;
                  _serverPlayer.f_8906_.m_9774_(x, -100.0D, z, entity.m_146908_(), entity.m_146909_());
               }

               PepoyoMod.queueServerWork(1, () -> {
                  if (!entity.m_9236_().m_5776_()) {
                     entity.m_146870_();
                  }

               });
            }
         }

      }
   }
}
