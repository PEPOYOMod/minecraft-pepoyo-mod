package net.mcreator.pepoyo.potion;

import net.mcreator.pepoyo.procedures.PayramenDangYaoShuiXiaoGuoKaiShiYingYongShiProcedure;
import net.mcreator.pepoyo.procedures.PayramenXiaoGuoChiXuShiMeiKeFaShengProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;

public class PayramenMobEffect extends MobEffect {
   public PayramenMobEffect() {
      super(MobEffectCategory.NEUTRAL, -1);
   }

   public void m_6385_(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
      PayramenDangYaoShuiXiaoGuoKaiShiYingYongShiProcedure.execute(entity.m_9236_(), entity);
   }

   public void m_6742_(LivingEntity entity, int amplifier) {
      PayramenXiaoGuoChiXuShiMeiKeFaShengProcedure.execute(entity.m_9236_(), entity);
   }

   public boolean m_6584_(int duration, int amplifier) {
      return true;
   }
}
