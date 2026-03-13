package net.mcreator.pepoyo.procedures;

import net.mcreator.pepoyo.PepoyoMod;
import net.mcreator.pepoyo.entity.YandegodieEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraftforge.registries.ForgeRegistries;

public class YandegodieDangShiTiChuShiShengChengShiProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("pepoyo:sound.yande.death")), SoundSource.NEUTRAL, 1.0F, 1.0F);
            } else {
               _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("pepoyo:sound.yande.death")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
            }
         }

         PepoyoMod.queueServerWork(20, () -> {
            if (entity instanceof YandegodieEntity) {
               YandegodieEntity animatable = (YandegodieEntity)entity;
               animatable.setTexture("yande_death_2");
            }

            PepoyoMod.queueServerWork(3, () -> {
               if (entity instanceof YandegodieEntity) {
                  YandegodieEntity animatable = (YandegodieEntity)entity;
                  animatable.setTexture("yande_death_4");
               }

               PepoyoMod.queueServerWork(20, () -> {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_254849_((Entity)null, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), 5.0F, ExplosionInteraction.NONE);
                     }
                  }

                  entity.m_6021_(x, -200.0D, z);
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.f_8906_.m_9774_(x, -200.0D, z, entity.m_146908_(), entity.m_146909_());
                  }

                  if (!entity.m_9236_().m_5776_()) {
                     entity.m_146870_();
                  }

               });
            });
         });
      }
   }
}
