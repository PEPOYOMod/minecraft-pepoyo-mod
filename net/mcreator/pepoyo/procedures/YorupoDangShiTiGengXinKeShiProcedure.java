package net.mcreator.pepoyo.procedures;

import net.mcreator.pepoyo.entity.YorupoEntity;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;

public class YorupoDangShiTiGengXinKeShiProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if (entity.m_142038_()) {
            LivingEntity _entity;
            if (entity instanceof LivingEntity) {
               _entity = (LivingEntity)entity;
               _entity.m_21219_();
            }

            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            LivingEntity var3 = var10000;
            if (var3 instanceof Player) {
               Player _player = (Player)var3;
               if (!_player.m_9236_().m_5776_()) {
                  _player.m_5661_(Component.m_237113_("但是他拒绝了"), false);
               }
            }

            if (entity instanceof YorupoEntity) {
               ((YorupoEntity)entity).setAnimation("animation.yorupo.refuse");
            }

            if (entity instanceof LivingEntity) {
               _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19596_, 30, 2, false, false));
               }
            }
         }

      }
   }
}
