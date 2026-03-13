package net.mcreator.pepoyo.procedures;

import net.mcreator.pepoyo.entity.StrawninjabossEntity;
import net.mcreator.pepoyo.init.PepoyoModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;

public class StrawninjabossDangShiTiShouShangShiProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         StrawninjabossEntity _datEntI;
         StrawninjabossEntity _datEntSetI;
         if (entity instanceof StrawninjabossEntity) {
            _datEntI = (StrawninjabossEntity)entity;
            SynchedEntityData var10000 = _datEntI.m_20088_();
            EntityDataAccessor var10001 = StrawninjabossEntity.DATA_hurt_tick;
            int var10002;
            if (entity instanceof StrawninjabossEntity) {
               _datEntSetI = (StrawninjabossEntity)entity;
               var10002 = (Integer)_datEntSetI.m_20088_().m_135370_(StrawninjabossEntity.DATA_hurt_tick);
            } else {
               var10002 = 0;
            }

            var10000.m_135381_(var10001, var10002 + 1);
         }

         int var12;
         if (entity instanceof StrawninjabossEntity) {
            _datEntI = (StrawninjabossEntity)entity;
            var12 = (Integer)_datEntI.m_20088_().m_135370_(StrawninjabossEntity.DATA_hurt_tick);
         } else {
            var12 = 0;
         }

         Entity entityToSpawn;
         ServerLevel _level;
         if (var12 >= Mth.m_216271_(RandomSource.m_216327_(), 7, 9)) {
            if (world instanceof ServerLevel) {
               _level = (ServerLevel)world;
               entityToSpawn = ((EntityType)PepoyoModEntities.SHADOWLESSHAND.get()).m_262496_(_level, BlockPos.m_274561_(x, y, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
               }
            }

            if (entity instanceof StrawninjabossEntity) {
               _datEntSetI = (StrawninjabossEntity)entity;
               _datEntSetI.m_20088_().m_135381_(StrawninjabossEntity.DATA_hurt_tick, 0);
            }
         }

         if (entity instanceof StrawninjabossEntity) {
            _datEntI = (StrawninjabossEntity)entity;
            var12 = (Integer)_datEntI.m_20088_().m_135370_(StrawninjabossEntity.DATA_hurt_tick);
         } else {
            var12 = 0;
         }

         if (var12 >= Mth.m_216271_(RandomSource.m_216327_(), 10, 20)) {
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

            if (world instanceof ServerLevel) {
               _level = (ServerLevel)world;
               entityToSpawn = ((EntityType)PepoyoModEntities.SOLDIER.get()).m_262496_(_level, BlockPos.m_274561_(x, y, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
               }
            }

            if (entity instanceof StrawninjabossEntity) {
               _datEntSetI = (StrawninjabossEntity)entity;
               _datEntSetI.m_20088_().m_135381_(StrawninjabossEntity.DATA_hurt_tick, 0);
            }
         }

      }
   }
}
