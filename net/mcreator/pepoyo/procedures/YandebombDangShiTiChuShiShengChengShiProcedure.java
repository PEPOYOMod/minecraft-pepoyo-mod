package net.mcreator.pepoyo.procedures;

import net.mcreator.pepoyo.PepoyoMod;
import net.mcreator.pepoyo.init.PepoyoModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;

public class YandebombDangShiTiChuShiShengChengShiProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         PepoyoMod.queueServerWork(Mth.m_216271_(RandomSource.m_216327_(), 40, 80), () -> {
            if (!entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               Entity entityToSpawn = ((EntityType)PepoyoModEntities.YANDEGODIE.get()).m_262496_(_level, BlockPos.m_274561_(x, y, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.m_146922_(world.m_213780_().m_188501_() * 360.0F);
               }
            }

         });
      }
   }
}
