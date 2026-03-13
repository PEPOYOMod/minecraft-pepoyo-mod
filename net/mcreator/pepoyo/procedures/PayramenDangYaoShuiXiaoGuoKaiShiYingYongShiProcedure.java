package net.mcreator.pepoyo.procedures;

import net.mcreator.pepoyo.PepoyoMod;
import net.mcreator.pepoyo.init.PepoyoModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class PayramenDangYaoShuiXiaoGuoKaiShiYingYongShiProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
            entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "title @s title {\"text\":\"请支付一碗普通拉面\",\"color\":\"yellow\"}");
         }

         if (entity instanceof Player) {
            Player _player = (Player)entity;
            if (!_player.m_9236_().m_5776_()) {
               _player.m_5661_(Component.m_237113_("请在15秒内支付一碗普通拉面（吃下它），否则你会死得很惨！"), false);
            }
         }

         PepoyoMod.queueServerWork(300, () -> {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt2 = (LivingEntity)entity;
               if (_livEnt2.m_21023_((MobEffect)PepoyoModMobEffects.PAYRAMEN.get())) {
                  entity.m_6469_(new DamageSource(world.m_9598_().m_175515_(Registries.f_268580_).m_246971_(DamageTypes.f_268433_)), 999.0F);
               }
            }

         });
      }
   }
}
