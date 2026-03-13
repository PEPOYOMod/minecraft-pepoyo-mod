package net.mcreator.pepoyo.procedures;

import net.mcreator.pepoyo.init.PepoyoModMobEffects;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class RamenDangWanJiaWanChengShiYongWuPin1ShiProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt0 = (LivingEntity)entity;
            if (_livEnt0.m_21023_((MobEffect)PepoyoModMobEffects.PAYRAMEN.get())) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21195_((MobEffect)PepoyoModMobEffects.PAYRAMEN.get());
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (!_player.m_9236_().m_5776_()) {
                     _player.m_5661_(Component.m_237113_("<讨债拉面> 谢谢你支付一碗普通拉面"), false);
                  }
               }
            }
         }

      }
   }
}
