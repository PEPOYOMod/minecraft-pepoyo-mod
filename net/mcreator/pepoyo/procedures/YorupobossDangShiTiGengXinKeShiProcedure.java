package net.mcreator.pepoyo.procedures;

import net.mcreator.pepoyo.PepoyoMod;
import net.mcreator.pepoyo.entity.YorupobossEntity;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class YorupobossDangShiTiGengXinKeShiProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         YorupobossEntity _datEntL57;
         boolean var10000;
         label237: {
            if (entity instanceof YorupobossEntity) {
               _datEntL57 = (YorupobossEntity)entity;
               if ((Boolean)_datEntL57.m_20088_().m_135370_(YorupobossEntity.DATA_glow_bearing)) {
                  var10000 = true;
                  break label237;
               }
            }

            var10000 = false;
         }

         LivingEntity _entity;
         YorupobossEntity _datEntI;
         YorupobossEntity _datEntSetL;
         EntityDataAccessor var10001;
         int var10002;
         SynchedEntityData var19;
         int var20;
         if (var10000) {
            if (entity.m_142038_()) {
               if (entity instanceof LivingEntity) {
                  _entity = (LivingEntity)entity;
                  _entity.m_21195_(MobEffects.f_19619_);
               }

               LivingEntity var18;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var18 = _mobEnt.m_5448_();
               } else {
                  var18 = null;
               }

               LivingEntity var11 = var18;
               if (var11 instanceof Player) {
                  Player _player = (Player)var11;
                  if (!_player.m_9236_().m_5776_()) {
                     _player.m_5661_(Component.m_237113_("夜步及 拒绝了暴露自己"), false);
                  }
               }

               if (entity instanceof YorupobossEntity) {
                  _datEntI = (YorupobossEntity)entity;
                  var19 = _datEntI.m_20088_();
                  var10001 = YorupobossEntity.DATA_glow_time;
                  if (entity instanceof YorupobossEntity) {
                     _datEntSetL = (YorupobossEntity)entity;
                     var10002 = (Integer)_datEntSetL.m_20088_().m_135370_(YorupobossEntity.DATA_glow_time);
                  } else {
                     var10002 = 0;
                  }

                  var19.m_135381_(var10001, var10002 + 1);
               }
            }

            if (entity instanceof YorupobossEntity) {
               _datEntI = (YorupobossEntity)entity;
               var20 = (Integer)_datEntI.m_20088_().m_135370_(YorupobossEntity.DATA_glow_time);
            } else {
               var20 = 0;
            }

            if (var20 >= 5 && entity instanceof YorupobossEntity) {
               _datEntSetL = (YorupobossEntity)entity;
               _datEntSetL.m_20088_().m_135381_(YorupobossEntity.DATA_glow_bearing, false);
            }
         }

         if (entity.m_6060_()) {
            label229: {
               if (entity instanceof YorupobossEntity) {
                  _datEntL57 = (YorupobossEntity)entity;
                  if ((Boolean)_datEntL57.m_20088_().m_135370_(YorupobossEntity.DATA_water_CD)) {
                     var10000 = true;
                     break label229;
                  }
               }

               var10000 = false;
            }

            if (var10000) {
               if (entity instanceof YorupobossEntity) {
                  _datEntI = (YorupobossEntity)entity;
                  _datEntI.m_20088_().m_135381_(YorupobossEntity.DATA_water_CD, false);
               }

               if (entity instanceof YorupobossEntity) {
                  ((YorupobossEntity)entity).setAnimation("animation.yorupo.extinguish");
               }

               PepoyoMod.queueServerWork(4, () -> {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 20, 5, false, false));
                     }
                  }

                  world.m_7731_(BlockPos.m_274561_(x, y, z), Blocks.f_49990_.m_49966_(), 3);
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.underwater.enter")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.underwater.enter")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                     }
                  }

                  PepoyoMod.queueServerWork(5, () -> {
                     world.m_7731_(BlockPos.m_274561_(x, y, z), Blocks.f_50016_.m_49966_(), 3);
                     PepoyoMod.queueServerWork(2, () -> {
                        entity.m_20256_(new Vec3(entity.m_20154_().f_82479_ * 2.0D, entity.m_20154_().f_82480_ + 0.5D, entity.m_20154_().f_82481_));
                        PepoyoMod.queueServerWork(40, () -> {
                           if (entity instanceof YorupobossEntity) {
                              YorupobossEntity _datEntSetL = (YorupobossEntity)entity;
                              _datEntSetL.m_20088_().m_135381_(YorupobossEntity.DATA_water_CD, true);
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              _entity.m_21219_();
                           }

                        });
                     });
                  });
               });
            }
         }

         if (entity.m_20159_()) {
            if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "say no");
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_254849_((Entity)null, x, y, z, 4.0F, ExplosionInteraction.NONE);
               }
            }
         }

         label223: {
            if (entity instanceof YorupobossEntity) {
               _datEntL57 = (YorupobossEntity)entity;
               if ((Boolean)_datEntL57.m_20088_().m_135370_(YorupobossEntity.DATA_attract)) {
                  var10000 = true;
                  break label223;
               }
            }

            var10000 = false;
         }

         Level _level;
         if (var10000) {
            if (entity instanceof LivingEntity) {
               _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19596_, 20, 2, false, false));
               }
            }

            if (entity instanceof LivingEntity) {
               _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, 20, 2, false, false));
               }
            }

            if (entity instanceof YorupobossEntity) {
               ((YorupobossEntity)entity).setAnimation("animation.yorupo.grinder");
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle minecraft:sweep_attack ~ ~ ~ 2 0.5 2 0.01 80 force @a");
            }

            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, 1.0F, 1.0F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
               }
            }

            if (entity instanceof YorupobossEntity) {
               _datEntI = (YorupobossEntity)entity;
               var19 = _datEntI.m_20088_();
               var10001 = YorupobossEntity.DATA_attract_tick;
               if (entity instanceof YorupobossEntity) {
                  _datEntSetL = (YorupobossEntity)entity;
                  var10002 = (Integer)_datEntSetL.m_20088_().m_135370_(YorupobossEntity.DATA_attract_tick);
               } else {
                  var10002 = 0;
               }

               var19.m_135381_(var10001, var10002 + 1);
            }

            if (entity instanceof YorupobossEntity) {
               _datEntI = (YorupobossEntity)entity;
               var20 = (Integer)_datEntI.m_20088_().m_135370_(YorupobossEntity.DATA_attract_tick);
            } else {
               var20 = 0;
            }

            if (var20 >= 120) {
               if (entity instanceof YorupobossEntity) {
                  _datEntSetL = (YorupobossEntity)entity;
                  _datEntSetL.m_20088_().m_135381_(YorupobossEntity.DATA_attract_tick, 0);
               }

               if (entity instanceof YorupobossEntity) {
                  ((YorupobossEntity)entity).setAnimation("empty");
               }

               if (entity instanceof YorupobossEntity) {
                  _datEntSetL = (YorupobossEntity)entity;
                  _datEntSetL.m_20088_().m_135381_(YorupobossEntity.DATA_attract, false);
               }

               if (entity instanceof YorupobossEntity) {
                  _datEntSetL = (YorupobossEntity)entity;
                  _datEntSetL.m_20088_().m_135381_(YorupobossEntity.DATA_active, true);
               }
            }
         }

         if (entity.m_20072_()) {
            if (entity instanceof YorupobossEntity) {
               _datEntL57 = (YorupobossEntity)entity;
               var19 = _datEntL57.m_20088_();
               var10001 = YorupobossEntity.DATA_water_time;
               if (entity instanceof YorupobossEntity) {
                  _datEntI = (YorupobossEntity)entity;
                  var10002 = (Integer)_datEntI.m_20088_().m_135370_(YorupobossEntity.DATA_water_time);
               } else {
                  var10002 = 0;
               }

               var19.m_135381_(var10001, var10002 + 1);
            }
         } else if (entity instanceof YorupobossEntity) {
            _datEntL57 = (YorupobossEntity)entity;
            var19 = _datEntL57.m_20088_();
            var10001 = YorupobossEntity.DATA_water_time;
            if (entity instanceof YorupobossEntity) {
               _datEntI = (YorupobossEntity)entity;
               var10002 = (Integer)_datEntI.m_20088_().m_135370_(YorupobossEntity.DATA_water_time);
            } else {
               var10002 = 0;
            }

            var19.m_135381_(var10001, var10002 - 5);
         }

         if (entity instanceof YorupobossEntity) {
            _datEntL57 = (YorupobossEntity)entity;
            var20 = (Integer)_datEntL57.m_20088_().m_135370_(YorupobossEntity.DATA_water_time);
         } else {
            var20 = 0;
         }

         if (var20 <= 0 && entity instanceof YorupobossEntity) {
            _datEntI = (YorupobossEntity)entity;
            _datEntI.m_20088_().m_135381_(YorupobossEntity.DATA_water_time, 0);
         }

         if (entity instanceof YorupobossEntity) {
            _datEntL57 = (YorupobossEntity)entity;
            var20 = (Integer)_datEntL57.m_20088_().m_135370_(YorupobossEntity.DATA_water_time);
         } else {
            var20 = 0;
         }

         if (var20 >= 100) {
            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_254849_((Entity)null, x, y, z, 10.0F, ExplosionInteraction.BLOCK);
               }
            }

            entity.m_20256_(new Vec3(entity.m_20154_().f_82479_, 5.0D, entity.m_20154_().f_82481_));
            PepoyoMod.queueServerWork(40, () -> {
               if (entity instanceof YorupobossEntity) {
                  YorupobossEntity _datEntSetI = (YorupobossEntity)entity;
                  _datEntSetI.m_20088_().m_135381_(YorupobossEntity.DATA_water_time, 0);
               }

            });
         }

         label212: {
            if (entity instanceof YorupobossEntity) {
               _datEntL57 = (YorupobossEntity)entity;
               if ((Boolean)_datEntL57.m_20088_().m_135370_(YorupobossEntity.DATA_lock_blood)) {
                  var10000 = true;
                  break label212;
               }
            }

            var10000 = false;
         }

         if (var10000) {
            if (entity instanceof LivingEntity) {
               _entity = (LivingEntity)entity;
               _entity.m_21153_(80.0F);
            }

            if (entity instanceof LivingEntity) {
               _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 60, 255, false, false));
               }
            }

            if (entity instanceof YorupobossEntity) {
               ((YorupobossEntity)entity).setAnimation("animation.yorupo.death_speech");
            }
         }

      }
   }
}
