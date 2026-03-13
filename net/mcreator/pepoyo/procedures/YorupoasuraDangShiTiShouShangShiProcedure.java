package net.mcreator.pepoyo.procedures;

import net.mcreator.pepoyo.PepoyoMod;
import net.mcreator.pepoyo.entity.RamenasuraEntity;
import net.mcreator.pepoyo.entity.YorupoasuraEntity;
import net.mcreator.pepoyo.init.PepoyoModEntities;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class YorupoasuraDangShiTiShouShangShiProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean var10000;
         label112: {
            if (entity instanceof YorupoasuraEntity) {
               YorupoasuraEntity _datEntL0 = (YorupoasuraEntity)entity;
               if ((Boolean)_datEntL0.m_20088_().m_135370_(YorupoasuraEntity.DATA_hurt_allow)) {
                  var10000 = true;
                  break label112;
               }
            }

            var10000 = false;
         }

         if (var10000) {
            YorupoasuraEntity _datEntI;
            if (entity instanceof YorupoasuraEntity) {
               _datEntI = (YorupoasuraEntity)entity;
               _datEntI.m_20088_().m_135381_(YorupoasuraEntity.DATA_hurt_time, Mth.m_216271_(RandomSource.m_216327_(), 1, 25));
            }

            int var17;
            if (entity instanceof YorupoasuraEntity) {
               _datEntI = (YorupoasuraEntity)entity;
               var17 = (Integer)_datEntI.m_20088_().m_135370_(YorupoasuraEntity.DATA_hurt_time);
            } else {
               var17 = 0;
            }

            YorupoasuraEntity _datEntSetL;
            LivingEntity _livEnt;
            EntityDataAccessor var10001;
            float var10002;
            SynchedEntityData var19;
            if (var17 == 7) {
               if (entity instanceof YorupoasuraEntity) {
                  _datEntSetL = (YorupoasuraEntity)entity;
                  _datEntSetL.m_20088_().m_135381_(YorupoasuraEntity.DATA_hurt_allow, false);
               }

               if (entity instanceof YorupoasuraEntity) {
                  _datEntSetL = (YorupoasuraEntity)entity;
                  _datEntSetL.m_20088_().m_135381_(YorupoasuraEntity.DATA_hurt_time, 0);
               }

               if (entity instanceof YorupoasuraEntity) {
                  _datEntSetL = (YorupoasuraEntity)entity;
                  var19 = _datEntSetL.m_20088_();
                  var10001 = YorupoasuraEntity.DATA_health_set;
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10002 = _livEnt.m_21223_();
                  } else {
                     var10002 = -1.0F;
                  }

                  var19.m_135381_(var10001, (int)var10002);
               }

               PepoyoMod.queueServerWork(5, () -> {
                  if (entity instanceof YorupoasuraEntity) {
                     YorupoasuraEntity _datEntSetL = (YorupoasuraEntity)entity;
                     _datEntSetL.m_20088_().m_135381_(YorupoasuraEntity.DATA_lock_health, true);
                  }

               });

               for(int index0 = 0; index0 < 180; ++index0) {
                  if (world instanceof ServerLevel) {
                     ServerLevel projectileLevel = (ServerLevel)world;
                     Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
                        public Projectile getArrow(Level level, float damage, int knockback) {
                           AbstractArrow entityToSpawn = new RamenasuraEntity((EntityType)PepoyoModEntities.RAMENASURA.get(), level);
                           entityToSpawn.m_36781_((double)damage);
                           entityToSpawn.m_36735_(knockback);
                           entityToSpawn.m_20225_(true);
                           return entityToSpawn;
                        }
                     })).getArrow(projectileLevel, 200.0F, 1);
                     _entityToSpawn.m_6034_(x + (double)Mth.m_216271_(RandomSource.m_216327_(), -40, 40), y + (double)Mth.m_216271_(RandomSource.m_216327_(), 30, 80), z + (double)Mth.m_216271_(RandomSource.m_216327_(), -40, 40));
                     _entityToSpawn.m_6686_(1.0D, 1.0D, 1.0D, 1.0F, 0.5F);
                     projectileLevel.m_7967_(_entityToSpawn);
                  }
               }

               PepoyoMod.queueServerWork(40, () -> {
                  entity.m_20256_(new Vec3(0.0D, -6.0D, 0.0D));
                  if (entity instanceof YorupoasuraEntity) {
                     YorupoasuraEntity _datEntSetL = (YorupoasuraEntity)entity;
                     _datEntSetL.m_20088_().m_135381_(YorupoasuraEntity.DATA_hurt_allow, true);
                  }

               });
            }

            if (entity instanceof YorupoasuraEntity) {
               _datEntI = (YorupoasuraEntity)entity;
               var17 = (Integer)_datEntI.m_20088_().m_135370_(YorupoasuraEntity.DATA_hurt_time);
            } else {
               var17 = 0;
            }

            if (var17 == 13) {
               if (entity instanceof YorupoasuraEntity) {
                  _datEntSetL = (YorupoasuraEntity)entity;
                  _datEntSetL.m_20088_().m_135381_(YorupoasuraEntity.DATA_hurt_time, 0);
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  float var18;
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var18 = _livEnt.m_21223_();
                  } else {
                     var18 = -1.0F;
                  }

                  _entity.m_21153_(var18 + 40.0F);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123750_, x, y, z, 40, 3.0D, 3.0D, 3.0D, 1.0D);
               }
            }

            if (entity instanceof YorupoasuraEntity) {
               _datEntI = (YorupoasuraEntity)entity;
               var17 = (Integer)_datEntI.m_20088_().m_135370_(YorupoasuraEntity.DATA_hurt_time);
            } else {
               var17 = 0;
            }

            if (var17 == 17) {
               if (entity instanceof YorupoasuraEntity) {
                  _datEntSetL = (YorupoasuraEntity)entity;
                  var19 = _datEntSetL.m_20088_();
                  var10001 = YorupoasuraEntity.DATA_health_set;
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10002 = _livEnt.m_21223_();
                  } else {
                     var10002 = -1.0F;
                  }

                  var19.m_135381_(var10001, (int)var10002);
               }

               if (entity instanceof YorupoasuraEntity) {
                  _datEntSetL = (YorupoasuraEntity)entity;
                  _datEntSetL.m_20088_().m_135381_(YorupoasuraEntity.DATA_hurt_time, 0);
               }

               if (entity instanceof YorupoasuraEntity) {
                  _datEntSetL = (YorupoasuraEntity)entity;
                  _datEntSetL.m_20088_().m_135381_(YorupoasuraEntity.DATA_grinder, true);
               }

               PepoyoMod.queueServerWork(5, () -> {
                  if (entity instanceof YorupoasuraEntity) {
                     YorupoasuraEntity _datEntSetL = (YorupoasuraEntity)entity;
                     _datEntSetL.m_20088_().m_135381_(YorupoasuraEntity.DATA_lock_health, true);
                  }

               });
            }
         }

      }
   }
}
