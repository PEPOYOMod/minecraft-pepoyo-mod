package net.mcreator.pepoyo.procedures;

import net.mcreator.pepoyo.init.PepoyoModEntities;
import net.mcreator.pepoyo.init.PepoyoModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.items.ItemHandlerHelper;

public class PoyoroidDangYouJiShiTiShiProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
      if (entity != null && sourceentity != null) {
         if (sourceentity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)sourceentity;
            if (_entity.m_21055_((Item)PepoyoModItems.HAMMER.get())) {
               Player _player;
               if (entity instanceof TamableAnimal) {
                  TamableAnimal _tamEnt = (TamableAnimal)entity;
                  if (_tamEnt.m_21824_()) {
                     entity.m_6469_(new DamageSource(world.m_9598_().m_175515_(Registries.f_268580_).m_246971_(DamageTypes.f_268433_)), 9999.0F);
                     if (sourceentity instanceof Player) {
                        _player = (Player)sourceentity;
                        if (!_player.m_9236_().m_5776_()) {
                           _player.m_5661_(Component.m_237113_("你获得了躁的钉子"), false);
                        }
                     }

                     if (sourceentity instanceof Player) {
                        _player = (Player)sourceentity;
                        ItemStack _setstack = (new ItemStack((ItemLike)PepoyoModItems.NAIL.get())).m_41777_();
                        _setstack.m_41764_(1);
                        ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                     }

                     return;
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  Entity entityToSpawn = ((EntityType)PepoyoModEntities.POYOROIDBOSS.get()).m_262496_(_level, BlockPos.m_274561_(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                  }
               }

               entity.m_6021_(x, -300.0D, z);
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entity;
                  _serverPlayer.f_8906_.m_9774_(x, -300.0D, z, entity.m_146908_(), entity.m_146909_());
               }

               if (sourceentity instanceof Player) {
                  _player = (Player)sourceentity;
                  if (!_player.m_9236_().m_5776_()) {
                     _player.m_5661_(Component.m_237113_("但是她拒绝了"), false);
                  }
               }
            }
         }

      }
   }
}
