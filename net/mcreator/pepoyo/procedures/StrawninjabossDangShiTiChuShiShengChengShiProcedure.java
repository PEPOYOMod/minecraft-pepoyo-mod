package net.mcreator.pepoyo.procedures;

import net.mcreator.pepoyo.PepoyoMod;
import net.mcreator.pepoyo.entity.StrawninjabossEntity;
import net.mcreator.pepoyo.init.PepoyoModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;

public class StrawninjabossDangShiTiChuShiShengChengShiProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (entity instanceof StrawninjabossEntity) {
            ((StrawninjabossEntity)entity).setAnimation("animation.straw_ninja_boss.summon");
         }

         PepoyoMod.queueServerWork(4, () -> {
            ServerLevel _level;
            Entity entityToSpawn;
            if (world instanceof ServerLevel) {
               _level = (ServerLevel)world;
               entityToSpawn = ((EntityType)PepoyoModEntities.SOLDIER.get()).m_262496_(_level, BlockPos.m_274561_(x, y, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
               }
            }

            if (world instanceof ServerLevel) {
               _level = (ServerLevel)world;
               entityToSpawn = ((EntityType)PepoyoModEntities.SOLDIER.get()).m_262496_(_level, BlockPos.m_274561_(x, y, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
               }
            }

            if (world instanceof ServerLevel) {
               _level = (ServerLevel)world;
               entityToSpawn = ((EntityType)PepoyoModEntities.SOLDIER.get()).m_262496_(_level, BlockPos.m_274561_(x, y, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
               }
            }

            if (world instanceof ServerLevel) {
               _level = (ServerLevel)world;
               entityToSpawn = ((EntityType)PepoyoModEntities.SOLDIER.get()).m_262496_(_level, BlockPos.m_274561_(x, y, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
               }
            }

         });
         PepoyoMod.queueServerWork(30, () -> {
            if (entity instanceof StrawninjabossEntity) {
               ((StrawninjabossEntity)entity).setAnimation("animation.straw_ninja_boss.ject");
            }

            PepoyoMod.queueServerWork(3, () -> {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  Entity entityToSpawn = ((EntityType)PepoyoModEntities.SHADOWLESSHAND.get()).m_262496_(_level, BlockPos.m_274561_(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.m_20334_(0.0D, 0.0D, 0.0D);
                  }
               }

            });
         });
      }
   }
}
