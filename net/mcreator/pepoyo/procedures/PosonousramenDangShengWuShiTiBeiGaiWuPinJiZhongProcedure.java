package net.mcreator.pepoyo.procedures;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class PosonousramenDangShengWuShiTiBeiGaiWuPinJiZhongProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         LivingEntity _entity;
         if (entity instanceof LivingEntity) {
            _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19620_, 20, 30, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19607_, 400, 1, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19613_, 400, 1, false, false));
            }
         }

      }
   }
}
