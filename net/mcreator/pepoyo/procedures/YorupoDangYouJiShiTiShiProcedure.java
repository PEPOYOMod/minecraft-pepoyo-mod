package net.mcreator.pepoyo.procedures;

import net.mcreator.pepoyo.entity.YorupoEntity;
import net.mcreator.pepoyo.init.PepoyoModEntities;
import net.mcreator.pepoyo.init.PepoyoModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class YorupoDangYouJiShiTiShiProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
      if (entity != null && sourceentity != null) {
         LivingEntity _entity;
         if (sourceentity instanceof LivingEntity) {
            _entity = (LivingEntity)sourceentity;
            if (_entity.m_21055_((Item)PepoyoModItems.RAMEN.get())) {
               if (!entity.m_9236_().m_5776_()) {
                  entity.m_146870_();
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  Entity entityToSpawn = ((EntityType)PepoyoModEntities.YORUPOBOSS.get()).m_262496_(_level, BlockPos.m_274561_(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                  }
               }
            }
         }

         Level _level;
         Player _player;
         if (sourceentity instanceof LivingEntity) {
            _entity = (LivingEntity)sourceentity;
            if (_entity.m_21055_((Item)PepoyoModItems.EMPTYBOWL.get())) {
               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("pepoyo:sound.yorupo.posonous_ramen")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("pepoyo:sound.yorupo.posonous_ramen")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               sourceentity.m_6469_(new DamageSource(world.m_9598_().m_175515_(Registries.f_268580_).m_246971_(DamageTypes.f_268433_)), 999.0F);
               if (sourceentity instanceof Player) {
                  _player = (Player)sourceentity;
                  if (!_player.m_9236_().m_5776_()) {
                     _player.m_5661_(Component.m_237113_("<夜步及> 用吃剩的碗来讨好我，去死吧！"), false);
                  }
               }
            }
         }

         if (sourceentity instanceof LivingEntity) {
            _entity = (LivingEntity)sourceentity;
            if (_entity.m_21055_((Item)PepoyoModItems.EATABLERAMEN.get())) {
               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("pepoyo:sound.yorupo.posonous_ramen")), SoundSource.NEUTRAL, 1.0F, 2.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("pepoyo:sound.yorupo.posonous_ramen")), SoundSource.NEUTRAL, 1.0F, 2.0F, false);
                  }
               }

               sourceentity.m_6469_(new DamageSource(world.m_9598_().m_175515_(Registries.f_268580_).m_246971_(DamageTypes.f_268433_)), 999.0F);
               if (sourceentity instanceof Player) {
                  _player = (Player)sourceentity;
                  if (!_player.m_9236_().m_5776_()) {
                     _player.m_5661_(Component.m_237113_("<夜步及> 混账！居然敢用脏水亵渎我的拉面，去死吧！！！"), false);
                  }
               }

               if (entity instanceof YorupoEntity) {
                  ((YorupoEntity)entity).setAnimation("animation.yorupo.lalala");
               }
            }
         }

         if (sourceentity instanceof LivingEntity) {
            _entity = (LivingEntity)sourceentity;
            if (_entity.m_21055_((Item)PepoyoModItems.POSONOUSRAMEN.get()) && sourceentity instanceof Player) {
               _player = (Player)sourceentity;
               if (!_player.m_9236_().m_5776_()) {
                  _player.m_5661_(Component.m_237113_("<夜步及> 这碗特色拉面，只留给你，吃吧"), false);
               }
            }
         }

      }
   }
}
