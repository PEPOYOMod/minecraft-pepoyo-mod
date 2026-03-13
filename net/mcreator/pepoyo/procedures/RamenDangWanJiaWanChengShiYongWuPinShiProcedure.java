package net.mcreator.pepoyo.procedures;

import net.mcreator.pepoyo.network.PepoyoModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraftforge.registries.ForgeRegistries;

public class RamenDangWanJiaWanChengShiYongWuPinShiProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         LivingEntity _entity;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt0 = (LivingEntity)entity;
            if (_livEnt0.m_21023_(MobEffects.f_19621_)) {
               if (entity instanceof LivingEntity) {
                  _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19605_, 280, 5, false, false));
                  }
               }

               if (entity instanceof LivingEntity) {
                  _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19596_, 600, 2, false, false));
                  }
               }

               if (entity instanceof LivingEntity) {
                  _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19611_, 600, 1, false, false));
                  }
               }

               if (entity instanceof LivingEntity) {
                  _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19598_, 300, 5, false, false));
                     return;
                  }
               }

               return;
            }
         }

         PepoyoModVariables.MapVariables.get(world).unluck_lottery = (double)Mth.m_216271_(RandomSource.m_216327_(), 1, 5);
         PepoyoModVariables.MapVariables.get(world).syncData(world);
         Level _level;
         if (PepoyoModVariables.MapVariables.get(world).unluck_lottery == 1.0D) {
            if (entity instanceof LivingEntity) {
               _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19620_, 20, 25, false, false));
               }
            }

            if (entity instanceof LivingEntity) {
               _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19619_, 60, 255, false, false));
               }
            }

            if (entity instanceof LivingEntity) {
               _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19596_, 60, 255, false, false));
               }
            }

            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("pepoyo:sound.yorupo.posonous_ramen")), SoundSource.NEUTRAL, 1.0F, 1.0F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("pepoyo:sound.yorupo.posonous_ramen")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
               }
            }
         }

         if (PepoyoModVariables.MapVariables.get(world).unluck_lottery == 2.0D) {
            if (entity instanceof LivingEntity) {
               _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19604_, 3000, 1, false, false));
               }
            }

            if (entity instanceof LivingEntity) {
               _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19613_, 200, 1, false, false));
               }
            }

            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("pepoyo:sound.yorupo.posonous_ramen")), SoundSource.NEUTRAL, 1.0F, 1.0F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("pepoyo:sound.yorupo.posonous_ramen")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
               }
            }
         }

         if (PepoyoModVariables.MapVariables.get(world).unluck_lottery == 3.0D) {
            entity.m_6469_(new DamageSource(world.m_9598_().m_175515_(Registries.f_268580_).m_246971_(ResourceKey.m_135785_(Registries.f_268580_, new ResourceLocation("pepoyo:ramnegood")))), 999.0F);
         }

         if (PepoyoModVariables.MapVariables.get(world).unluck_lottery == 4.0D) {
            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("pepoyo:sound.yorupo.posonous_ramen")), SoundSource.NEUTRAL, 1.0F, 2.0F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("pepoyo:sound.yorupo.posonous_ramen")), SoundSource.NEUTRAL, 1.0F, 2.0F, false);
               }
            }

            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_254849_((Entity)null, x, y, z, 6.0F, ExplosionInteraction.NONE);
               }
            }

            if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "say 好吃到爆啊！！！！");
            }
         }

         if (PepoyoModVariables.MapVariables.get(world).unluck_lottery == 5.0D) {
            if (entity instanceof LivingEntity) {
               _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19605_, 160, 5, false, false));
               }
            }

            if (entity instanceof LivingEntity) {
               _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19596_, 300, 2, false, false));
               }
            }

            if (entity instanceof LivingEntity) {
               _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19611_, 600, 1, false, false));
               }
            }

            if (entity instanceof LivingEntity) {
               _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19598_, 300, 5, false, false));
               }
            }
         }

      }
   }
}
