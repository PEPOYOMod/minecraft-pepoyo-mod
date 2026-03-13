package net.mcreator.pepoyo.procedures;

import net.mcreator.pepoyo.PepoyoMod;
import net.mcreator.pepoyo.entity.HalfmoonEntity;
import net.mcreator.pepoyo.entity.YorupoasuraEntity;
import net.mcreator.pepoyo.init.PepoyoModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class YorupoasuraDangShiTiGengXinKeShiProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         YorupoasuraEntity _datEntL18;
         boolean var10000;
         label94: {
            if (entity instanceof YorupoasuraEntity) {
               _datEntL18 = (YorupoasuraEntity)entity;
               if ((Boolean)_datEntL18.m_20088_().m_135370_(YorupoasuraEntity.DATA_grinder)) {
                  var10000 = true;
                  break label94;
               }
            }

            var10000 = false;
         }

         YorupoasuraEntity _datEntSetI;
         LivingEntity _entity;
         if (var10000) {
            ServerLevel projectileLevel;
            if (world instanceof ServerLevel) {
               projectileLevel = (ServerLevel)world;
               projectileLevel.m_8767_(ParticleTypes.f_123766_, x, y, z, 80, 2.0D, 0.1D, 2.0D, 1.0D);
            }

            YorupoasuraEntity _datEntI;
            if (entity instanceof YorupoasuraEntity) {
               _datEntI = (YorupoasuraEntity)entity;
               SynchedEntityData var15 = _datEntI.m_20088_();
               EntityDataAccessor var10001 = YorupoasuraEntity.DATA_grinder_time;
               int var10002;
               if (entity instanceof YorupoasuraEntity) {
                  _datEntSetI = (YorupoasuraEntity)entity;
                  var10002 = (Integer)_datEntSetI.m_20088_().m_135370_(YorupoasuraEntity.DATA_grinder_time);
               } else {
                  var10002 = 0;
               }

               var15.m_135381_(var10001, var10002 + 1);
            }

            if (entity instanceof LivingEntity) {
               _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19596_, 10, 1, false, false));
               }
            }

            if (entity instanceof LivingEntity) {
               _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, 10, 3, false, false));
               }
            }

            if (world instanceof ServerLevel) {
               projectileLevel = (ServerLevel)world;
               Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
                  public Projectile getArrow(Level level, float damage, int knockback) {
                     AbstractArrow entityToSpawn = new HalfmoonEntity((EntityType)PepoyoModEntities.HALFMOON.get(), level);
                     entityToSpawn.m_36781_((double)damage);
                     entityToSpawn.m_36735_(knockback);
                     entityToSpawn.m_20225_(true);
                     entityToSpawn.m_20254_(100);
                     entityToSpawn.m_36762_(true);
                     return entityToSpawn;
                  }
               })).getArrow(projectileLevel, 180.0F, 1);
               _entityToSpawn.m_6034_(x, y, z);
               _entityToSpawn.m_6686_((double)Mth.m_216271_(RandomSource.m_216327_(), -3, 3), 3.0D, (double)Mth.m_216271_(RandomSource.m_216327_(), -3, 3), 3.0F, 0.0F);
               projectileLevel.m_7967_(_entityToSpawn);
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.PLAYERS, 1.0F, 1.0F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.PLAYERS, 1.0F, 1.0F, false);
               }
            }

            int var17;
            if (entity instanceof YorupoasuraEntity) {
               _datEntI = (YorupoasuraEntity)entity;
               var17 = (Integer)_datEntI.m_20088_().m_135370_(YorupoasuraEntity.DATA_grinder_time);
            } else {
               var17 = 0;
            }

            if (var17 >= 140) {
               if (entity instanceof YorupoasuraEntity) {
                  _datEntSetI = (YorupoasuraEntity)entity;
                  _datEntSetI.m_20088_().m_135381_(YorupoasuraEntity.DATA_grinder, false);
               }

               if (entity instanceof YorupoasuraEntity) {
                  _datEntSetI = (YorupoasuraEntity)entity;
                  _datEntSetI.m_20088_().m_135381_(YorupoasuraEntity.DATA_grinder_time, 0);
               }

               PepoyoMod.queueServerWork(120, () -> {
                  if (entity instanceof YorupoasuraEntity) {
                     YorupoasuraEntity _datEntSetL = (YorupoasuraEntity)entity;
                     _datEntSetL.m_20088_().m_135381_(YorupoasuraEntity.DATA_lock_health, false);
                  }

               });
            }
         }

         if (entity.m_6060_()) {
            entity.m_20095_();
         }

         label86: {
            if (entity instanceof YorupoasuraEntity) {
               _datEntL18 = (YorupoasuraEntity)entity;
               if ((Boolean)_datEntL18.m_20088_().m_135370_(YorupoasuraEntity.DATA_lock_health)) {
                  var10000 = true;
                  break label86;
               }
            }

            var10000 = false;
         }

         if (var10000 && entity instanceof LivingEntity) {
            _entity = (LivingEntity)entity;
            int var16;
            if (entity instanceof YorupoasuraEntity) {
               _datEntSetI = (YorupoasuraEntity)entity;
               var16 = (Integer)_datEntSetI.m_20088_().m_135370_(YorupoasuraEntity.DATA_health_set);
            } else {
               var16 = 0;
            }

            _entity.m_21153_((float)var16);
         }

      }
   }
}
