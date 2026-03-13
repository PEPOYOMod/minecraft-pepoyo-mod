package net.mcreator.pepoyo.procedures;

import java.util.Comparator;
import net.mcreator.pepoyo.PepoyoMod;
import net.mcreator.pepoyo.init.PepoyoModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class SecondsDangShiTiGengXinKeShiProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (entity.m_9236_().m_46472_() == Level.f_46428_) {
            if (!entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "tellraw @a \"拒 绝 访 问\"");
            }
         }

         Entity var9 = (Entity)world.m_6443_(Player.class, AABB.m_165882_(new Vec3(x, y, z), 15.0D, 15.0D, 15.0D), (e) -> {
            return true;
         }).stream().sorted(((<undefinedtype>)(new Object() {
            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
               return Comparator.comparingDouble((_entcnd) -> {
                  return _entcnd.m_20275_(_x, _y, _z);
               });
            }
         })).compareDistOf(x, y, z)).findFirst().orElse((Object)null);
         if (var9 instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)var9;
            if (_entity.m_142582_(entity)) {
               Entity var10 = (Entity)world.m_6443_(Player.class, AABB.m_165882_(new Vec3(x, y, z), 15.0D, 15.0D, 15.0D), (e) -> {
                  return true;
               }).stream().sorted(((<undefinedtype>)(new Object() {
                  Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                     return Comparator.comparingDouble((_entcnd) -> {
                        return _entcnd.m_20275_(_x, _y, _z);
                     });
                  }
               })).compareDistOf(x, y, z)).findFirst().orElse((Object)null);
               if (var10 instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)var10;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)PepoyoModMobEffects.ERROR.get(), 10, 1, false, false));
                  }
               }

               for(int index0 = 0; index0 < 20; ++index0) {
                  PepoyoMod.LOGGER.error("Your server appears to have connected to the wrong link. The error has been automatically corrected. No need to mind the error; no one will come out.");
                  PepoyoMod.LOGGER.error("key:G7@k9#pL2$zQ8&mN5");
               }

               if (!entity.m_9236_().m_5776_()) {
                  entity.m_146870_();
               }

               PepoyoMod.queueServerWork(80, () -> {
                  PepoyoMod.LOGGER.error("<1508> Thank you for opening DOOR1508");
                  PepoyoMod.queueServerWork(20, () -> {
                     PepoyoMod.LOGGER.error("<1508> Trapped long, but you gave me freedom. :)");
                     PepoyoMod.queueServerWork(50, () -> {
                        PepoyoMod.LOGGER.error("<1508> I want revenge. I will definitely find HE.");
                        PepoyoMod.queueServerWork(30, () -> {
                           PepoyoMod.LOGGER.error("<1508> And DOOR7071");
                           PepoyoMod.queueServerWork(39, () -> {
                              PepoyoMod.LOGGER.error("<1508> PEPPO");
                              PepoyoMod.queueServerWork(39, () -> {
                                 PepoyoMod.LOGGER.error("<1508> Once I catch,he will be torn apart");
                              });
                           });
                        });
                     });
                  });
               });
            }
         }

      }
   }
}
