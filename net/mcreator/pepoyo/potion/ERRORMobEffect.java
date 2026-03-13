package net.mcreator.pepoyo.potion;

import net.mcreator.pepoyo.procedures.ERRORDangXiaoGuoJieShuProcedure;
import net.mcreator.pepoyo.procedures.ERRORDangYaoShuiXiaoGuoKaiShiYingYongShiProcedure;
import net.mcreator.pepoyo.procedures.ERRORXiaoGuoChiXuShiMeiKeFaShengProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;

public class ERRORMobEffect extends MobEffect {
   public ERRORMobEffect() {
      super(MobEffectCategory.NEUTRAL, -1);
   }

   public void m_6385_(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
      ERRORDangYaoShuiXiaoGuoKaiShiYingYongShiProcedure.execute(entity.m_9236_(), entity.m_20185_(), entity.m_20186_(), entity.m_20189_());
   }

   public void m_6742_(LivingEntity entity, int amplifier) {
      ERRORXiaoGuoChiXuShiMeiKeFaShengProcedure.execute(entity);
   }

   public void m_6386_(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
      super.m_6386_(entity, attributeMap, amplifier);
      ERRORDangXiaoGuoJieShuProcedure.execute(entity.m_9236_(), entity.m_20185_(), entity.m_20186_(), entity.m_20189_());
   }

   public boolean m_6584_(int duration, int amplifier) {
      return true;
   }
}
