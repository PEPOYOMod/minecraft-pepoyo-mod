package net.mcreator.pepoyo.procedures;

import net.mcreator.pepoyo.init.PepoyoModEntities;
import net.mcreator.pepoyo.init.PepoyoModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
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
import net.minecraft.world.item.Items;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.items.ItemHandlerHelper;

public class StrawninjaDangYouJiShiTiShiProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
      if (entity != null && sourceentity != null) {
         LivingEntity _entity;
         if (sourceentity instanceof LivingEntity) {
            _entity = (LivingEntity)sourceentity;
            if (_entity.m_21055_(Items.f_42409_)) {
               entity.m_20254_(15);
            }
         }

         if (sourceentity instanceof LivingEntity) {
            _entity = (LivingEntity)sourceentity;
            if (_entity.m_21055_((Item)PepoyoModItems.HAMMER.get())) {
               if (entity instanceof TamableAnimal) {
                  TamableAnimal _tamEnt = (TamableAnimal)entity;
                  if (_tamEnt.m_21824_()) {
                     entity.m_6469_(new DamageSource(world.m_9598_().m_175515_(Registries.f_268580_).m_246971_(DamageTypes.f_268433_)), 9999.0F);
                     return;
                  }
               }

               if (!entity.m_9236_().m_5776_()) {
                  entity.m_146870_();
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  Entity entityToSpawn = ((EntityType)PepoyoModEntities.STRAWNINJABOSS.get()).m_262496_(_level, BlockPos.m_274561_(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                  }
               }

               Player _player;
               if (entity instanceof Player) {
                  _player = (Player)entity;
                  ItemStack _setstack = (new ItemStack(Items.f_42749_)).m_41777_();
                  _setstack.m_41764_(1);
                  ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
               }

               if (entity instanceof Player) {
                  _player = (Player)entity;
                  if (!_player.m_9236_().m_5776_()) {
                     _player.m_5661_(Component.m_237113_("你拔掉了稻草忍者的钉子"), false);
                  }
               }
            }
         }

      }
   }
}
