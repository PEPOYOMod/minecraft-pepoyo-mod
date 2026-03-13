package net.mcreator.pepoyo.procedures;

import net.mcreator.pepoyo.PepoyoMod;
import net.mcreator.pepoyo.entity.HalfmoonEntity;
import net.mcreator.pepoyo.init.PepoyoModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;

public class RamenasuraDanSheWuJiZhongFangKuaiShiProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (world instanceof Level) {
         Level _level = (Level)world;
         if (!_level.m_5776_()) {
            _level.m_254849_((Entity)null, x, y, z, 6.0F, ExplosionInteraction.BLOCK);
         }
      }

      PepoyoMod.queueServerWork(Mth.m_216271_(RandomSource.m_216327_(), 20, 50), () -> {
         ServerLevel projectileLevel;
         if (world instanceof ServerLevel) {
            projectileLevel = (ServerLevel)world;
            Entity entityToSpawn = EntityType.f_20465_.m_262496_(projectileLevel, BlockPos.m_274561_(x, y, z), MobSpawnType.MOB_SUMMONED);
            if (entityToSpawn != null) {
               entityToSpawn.m_20334_(0.0D, 0.0D, 0.0D);
            }
         }

         Projectile _entityToSpawn;
         if (world instanceof ServerLevel) {
            projectileLevel = (ServerLevel)world;
            _entityToSpawn = ((<undefinedtype>)(new Object() {
               public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
                  AbstractArrow entityToSpawn = new HalfmoonEntity((EntityType)PepoyoModEntities.HALFMOON.get(), level);
                  entityToSpawn.m_36781_((double)damage);
                  entityToSpawn.m_36735_(knockback);
                  entityToSpawn.m_20225_(true);
                  entityToSpawn.m_36767_(piercing);
                  return entityToSpawn;
               }
            })).getArrow(projectileLevel, 40.0F, 1, (byte)1);
            _entityToSpawn.m_6034_(x, y, z);
            _entityToSpawn.m_6686_(1.0D, 0.0D, 0.0D, 2.0F, 0.0F);
            projectileLevel.m_7967_(_entityToSpawn);
         }

         if (world instanceof ServerLevel) {
            projectileLevel = (ServerLevel)world;
            _entityToSpawn = ((<undefinedtype>)(new Object() {
               public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
                  AbstractArrow entityToSpawn = new HalfmoonEntity((EntityType)PepoyoModEntities.HALFMOON.get(), level);
                  entityToSpawn.m_36781_((double)damage);
                  entityToSpawn.m_36735_(knockback);
                  entityToSpawn.m_20225_(true);
                  entityToSpawn.m_36767_(piercing);
                  return entityToSpawn;
               }
            })).getArrow(projectileLevel, 40.0F, 1, (byte)1);
            _entityToSpawn.m_6034_(x, y, z);
            _entityToSpawn.m_6686_(0.0D, 0.0D, 1.0D, 2.0F, 0.0F);
            projectileLevel.m_7967_(_entityToSpawn);
         }

         if (world instanceof ServerLevel) {
            projectileLevel = (ServerLevel)world;
            _entityToSpawn = ((<undefinedtype>)(new Object() {
               public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
                  AbstractArrow entityToSpawn = new HalfmoonEntity((EntityType)PepoyoModEntities.HALFMOON.get(), level);
                  entityToSpawn.m_36781_((double)damage);
                  entityToSpawn.m_36735_(knockback);
                  entityToSpawn.m_20225_(true);
                  entityToSpawn.m_36767_(piercing);
                  return entityToSpawn;
               }
            })).getArrow(projectileLevel, 40.0F, 1, (byte)1);
            _entityToSpawn.m_6034_(x, y, z);
            _entityToSpawn.m_6686_(-1.0D, 0.0D, 0.0D, 2.0F, 0.0F);
            projectileLevel.m_7967_(_entityToSpawn);
         }

         if (world instanceof ServerLevel) {
            projectileLevel = (ServerLevel)world;
            _entityToSpawn = ((<undefinedtype>)(new Object() {
               public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
                  AbstractArrow entityToSpawn = new HalfmoonEntity((EntityType)PepoyoModEntities.HALFMOON.get(), level);
                  entityToSpawn.m_36781_((double)damage);
                  entityToSpawn.m_36735_(knockback);
                  entityToSpawn.m_20225_(true);
                  entityToSpawn.m_36767_(piercing);
                  return entityToSpawn;
               }
            })).getArrow(projectileLevel, 40.0F, 1, (byte)1);
            _entityToSpawn.m_6034_(x, y, z);
            _entityToSpawn.m_6686_(0.0D, 0.0D, -1.0D, 2.0F, 0.0F);
            projectileLevel.m_7967_(_entityToSpawn);
         }

      });
   }
}
