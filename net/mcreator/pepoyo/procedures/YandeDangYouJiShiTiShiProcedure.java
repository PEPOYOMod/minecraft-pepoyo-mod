package net.mcreator.pepoyo.procedures;

import net.mcreator.pepoyo.init.PepoyoModEntities;
import net.mcreator.pepoyo.init.PepoyoModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.items.ItemHandlerHelper;

public class YandeDangYouJiShiTiShiProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
      if (entity != null && sourceentity != null) {
         LivingEntity _entity;
         ServerLevel _level;
         Entity entityToSpawn;
         ServerPlayer _serverPlayer;
         if (sourceentity instanceof LivingEntity) {
            _entity = (LivingEntity)sourceentity;
            if (_entity.m_21055_(Items.f_42574_)) {
               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawn = ((EntityType)PepoyoModEntities.YANDEOFF.get()).m_262496_(_level, BlockPos.m_274561_(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                  }
               }

               if (sourceentity instanceof Player) {
                  Player _player = (Player)sourceentity;
                  ItemStack _setstack = (new ItemStack((ItemLike)PepoyoModItems.TAIJI.get())).m_41777_();
                  _setstack.m_41764_(1);
                  ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
               }

               entity.m_6021_(x, -300.0D, z);
               if (entity instanceof ServerPlayer) {
                  _serverPlayer = (ServerPlayer)entity;
                  _serverPlayer.f_8906_.m_9774_(x, -300.0D, z, entity.m_146908_(), entity.m_146909_());
               }

               if (!entity.m_9236_().m_5776_()) {
                  entity.m_146870_();
               }
            }
         }

         if (sourceentity instanceof LivingEntity) {
            _entity = (LivingEntity)sourceentity;
            if (_entity.m_21055_(Items.f_42409_)) {
               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawn = ((EntityType)PepoyoModEntities.YANDEGODIE.get()).m_262496_(_level, BlockPos.m_274561_(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                  }
               }

               entity.m_6021_(x, -300.0D, z);
               if (entity instanceof ServerPlayer) {
                  _serverPlayer = (ServerPlayer)entity;
                  _serverPlayer.f_8906_.m_9774_(x, -300.0D, z, entity.m_146908_(), entity.m_146909_());
               }

               if (!entity.m_9236_().m_5776_()) {
                  entity.m_146870_();
               }
            }
         }

         if (sourceentity instanceof LivingEntity) {
            _entity = (LivingEntity)sourceentity;
            if (_entity.m_21055_(Items.f_42613_)) {
               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawn = ((EntityType)PepoyoModEntities.YANDEGODIE.get()).m_262496_(_level, BlockPos.m_274561_(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                  }
               }

               entity.m_6021_(x, -300.0D, z);
               if (entity instanceof ServerPlayer) {
                  _serverPlayer = (ServerPlayer)entity;
                  _serverPlayer.f_8906_.m_9774_(x, -300.0D, z, entity.m_146908_(), entity.m_146909_());
               }

               if (!entity.m_9236_().m_5776_()) {
                  entity.m_146870_();
               }
            }
         }

         if (sourceentity instanceof LivingEntity) {
            _entity = (LivingEntity)sourceentity;
            if (_entity.m_21055_((Item)PepoyoModItems.PARADISE.get())) {
               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawn = ((EntityType)PepoyoModEntities.YANDEERROR.get()).m_262496_(_level, BlockPos.m_274561_(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                  }
               }

               entity.m_6021_(x, -300.0D, z);
               if (entity instanceof ServerPlayer) {
                  _serverPlayer = (ServerPlayer)entity;
                  _serverPlayer.f_8906_.m_9774_(x, -300.0D, z, entity.m_146908_(), entity.m_146909_());
               }

               if (!entity.m_9236_().m_5776_()) {
                  entity.m_146870_();
               }
            }
         }

      }
   }
}
