package net.mcreator.pepoyo.procedures;

import net.mcreator.pepoyo.PepoyoMod;
import net.mcreator.pepoyo.init.PepoyoModEntities;
import net.mcreator.pepoyo.init.PepoyoModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;

public class YandeoffDangGaiShiTiShaSiLingGeShiTiShiProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
      if (entity != null && sourceentity != null) {
         if (entity instanceof Player) {
            Player _playerHasItem = (Player)entity;
            if (_playerHasItem.m_150109_().m_36063_(new ItemStack((ItemLike)PepoyoModItems.TAIJI.get()))) {
               Player _player;
               if (entity instanceof Player) {
                  _player = (Player)entity;
                  ItemStack _stktoremove = new ItemStack((ItemLike)PepoyoModItems.TAIJI.get());
                  _player.m_150109_().m_36022_((p) -> {
                     return _stktoremove.m_41720_() == p.m_41720_();
                  }, 1, _player.f_36095_.m_39730_());
               }

               if (entity instanceof Player) {
                  _player = (Player)entity;
                  if (!_player.m_9236_().m_5776_()) {
                     _player.m_5661_(Component.m_237113_("Yande拿回了他的taiji"), false);
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  Entity entityToSpawn = ((EntityType)PepoyoModEntities.YANDE.get()).m_262496_(_level, BlockPos.m_274561_(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                  }
               }

               sourceentity.m_6021_(x, -300.0D, z);
               if (sourceentity instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)sourceentity;
                  _serverPlayer.f_8906_.m_9774_(x, -300.0D, z, sourceentity.m_146908_(), sourceentity.m_146909_());
               }

               PepoyoMod.queueServerWork(1, () -> {
                  if (!sourceentity.m_9236_().m_5776_()) {
                     sourceentity.m_146870_();
                  }

               });
            }
         }

      }
   }
}
