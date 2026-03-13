package net.mcreator.pepoyo.init;

import net.mcreator.pepoyo.entity.MikuEntity;
import net.mcreator.pepoyo.entity.PoyoEntity;
import net.mcreator.pepoyo.entity.PoyoroidEntity;
import net.mcreator.pepoyo.entity.PoyoroidbossEntity;
import net.mcreator.pepoyo.entity.PoyoroidoEntity;
import net.mcreator.pepoyo.entity.PoyoroidpoorEntity;
import net.mcreator.pepoyo.entity.SecondsEntity;
import net.mcreator.pepoyo.entity.ShadowlesshandEntity;
import net.mcreator.pepoyo.entity.ShimiyasosuEntity;
import net.mcreator.pepoyo.entity.ShindeEntity;
import net.mcreator.pepoyo.entity.SoldierEntity;
import net.mcreator.pepoyo.entity.StrawninjaEntity;
import net.mcreator.pepoyo.entity.StrawninjabossEntity;
import net.mcreator.pepoyo.entity.YandeEntity;
import net.mcreator.pepoyo.entity.YandebombEntity;
import net.mcreator.pepoyo.entity.YandeerrorEntity;
import net.mcreator.pepoyo.entity.YandegodieEntity;
import net.mcreator.pepoyo.entity.YandeoffEntity;
import net.mcreator.pepoyo.entity.YorupoEntity;
import net.mcreator.pepoyo.entity.YorupoasuraEntity;
import net.mcreator.pepoyo.entity.YorupobossEntity;
import net.mcreator.pepoyo.entity.YorupostyleEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingEvent.LivingTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class EntityAnimationFactory {
   @SubscribeEvent
   public static void onEntityTick(LivingTickEvent event) {
      if (event != null && event.getEntity() != null) {
         LivingEntity var2 = event.getEntity();
         String animation;
         if (var2 instanceof YandeEntity) {
            YandeEntity syncable = (YandeEntity)var2;
            animation = syncable.getSyncedAnimation();
            if (!animation.equals("undefined")) {
               syncable.setAnimation("undefined");
               syncable.animationprocedure = animation;
            }
         }

         var2 = event.getEntity();
         if (var2 instanceof YandeoffEntity) {
            YandeoffEntity syncable = (YandeoffEntity)var2;
            animation = syncable.getSyncedAnimation();
            if (!animation.equals("undefined")) {
               syncable.setAnimation("undefined");
               syncable.animationprocedure = animation;
            }
         }

         var2 = event.getEntity();
         if (var2 instanceof YandegodieEntity) {
            YandegodieEntity syncable = (YandegodieEntity)var2;
            animation = syncable.getSyncedAnimation();
            if (!animation.equals("undefined")) {
               syncable.setAnimation("undefined");
               syncable.animationprocedure = animation;
            }
         }

         var2 = event.getEntity();
         if (var2 instanceof ShindeEntity) {
            ShindeEntity syncable = (ShindeEntity)var2;
            animation = syncable.getSyncedAnimation();
            if (!animation.equals("undefined")) {
               syncable.setAnimation("undefined");
               syncable.animationprocedure = animation;
            }
         }

         var2 = event.getEntity();
         if (var2 instanceof PoyoroidEntity) {
            PoyoroidEntity syncable = (PoyoroidEntity)var2;
            animation = syncable.getSyncedAnimation();
            if (!animation.equals("undefined")) {
               syncable.setAnimation("undefined");
               syncable.animationprocedure = animation;
            }
         }

         var2 = event.getEntity();
         if (var2 instanceof PoyoroidbossEntity) {
            PoyoroidbossEntity syncable = (PoyoroidbossEntity)var2;
            animation = syncable.getSyncedAnimation();
            if (!animation.equals("undefined")) {
               syncable.setAnimation("undefined");
               syncable.animationprocedure = animation;
            }
         }

         var2 = event.getEntity();
         if (var2 instanceof PoyoroidoEntity) {
            PoyoroidoEntity syncable = (PoyoroidoEntity)var2;
            animation = syncable.getSyncedAnimation();
            if (!animation.equals("undefined")) {
               syncable.setAnimation("undefined");
               syncable.animationprocedure = animation;
            }
         }

         var2 = event.getEntity();
         if (var2 instanceof PoyoroidpoorEntity) {
            PoyoroidpoorEntity syncable = (PoyoroidpoorEntity)var2;
            animation = syncable.getSyncedAnimation();
            if (!animation.equals("undefined")) {
               syncable.setAnimation("undefined");
               syncable.animationprocedure = animation;
            }
         }

         var2 = event.getEntity();
         if (var2 instanceof StrawninjaEntity) {
            StrawninjaEntity syncable = (StrawninjaEntity)var2;
            animation = syncable.getSyncedAnimation();
            if (!animation.equals("undefined")) {
               syncable.setAnimation("undefined");
               syncable.animationprocedure = animation;
            }
         }

         var2 = event.getEntity();
         if (var2 instanceof StrawninjabossEntity) {
            StrawninjabossEntity syncable = (StrawninjabossEntity)var2;
            animation = syncable.getSyncedAnimation();
            if (!animation.equals("undefined")) {
               syncable.setAnimation("undefined");
               syncable.animationprocedure = animation;
            }
         }

         var2 = event.getEntity();
         if (var2 instanceof SoldierEntity) {
            SoldierEntity syncable = (SoldierEntity)var2;
            animation = syncable.getSyncedAnimation();
            if (!animation.equals("undefined")) {
               syncable.setAnimation("undefined");
               syncable.animationprocedure = animation;
            }
         }

         var2 = event.getEntity();
         if (var2 instanceof ShadowlesshandEntity) {
            ShadowlesshandEntity syncable = (ShadowlesshandEntity)var2;
            animation = syncable.getSyncedAnimation();
            if (!animation.equals("undefined")) {
               syncable.setAnimation("undefined");
               syncable.animationprocedure = animation;
            }
         }

         var2 = event.getEntity();
         if (var2 instanceof MikuEntity) {
            MikuEntity syncable = (MikuEntity)var2;
            animation = syncable.getSyncedAnimation();
            if (!animation.equals("undefined")) {
               syncable.setAnimation("undefined");
               syncable.animationprocedure = animation;
            }
         }

         var2 = event.getEntity();
         if (var2 instanceof YorupoEntity) {
            YorupoEntity syncable = (YorupoEntity)var2;
            animation = syncable.getSyncedAnimation();
            if (!animation.equals("undefined")) {
               syncable.setAnimation("undefined");
               syncable.animationprocedure = animation;
            }
         }

         var2 = event.getEntity();
         if (var2 instanceof YorupobossEntity) {
            YorupobossEntity syncable = (YorupobossEntity)var2;
            animation = syncable.getSyncedAnimation();
            if (!animation.equals("undefined")) {
               syncable.setAnimation("undefined");
               syncable.animationprocedure = animation;
            }
         }

         var2 = event.getEntity();
         if (var2 instanceof ShimiyasosuEntity) {
            ShimiyasosuEntity syncable = (ShimiyasosuEntity)var2;
            animation = syncable.getSyncedAnimation();
            if (!animation.equals("undefined")) {
               syncable.setAnimation("undefined");
               syncable.animationprocedure = animation;
            }
         }

         var2 = event.getEntity();
         if (var2 instanceof YorupostyleEntity) {
            YorupostyleEntity syncable = (YorupostyleEntity)var2;
            animation = syncable.getSyncedAnimation();
            if (!animation.equals("undefined")) {
               syncable.setAnimation("undefined");
               syncable.animationprocedure = animation;
            }
         }

         var2 = event.getEntity();
         if (var2 instanceof PoyoEntity) {
            PoyoEntity syncable = (PoyoEntity)var2;
            animation = syncable.getSyncedAnimation();
            if (!animation.equals("undefined")) {
               syncable.setAnimation("undefined");
               syncable.animationprocedure = animation;
            }
         }

         var2 = event.getEntity();
         if (var2 instanceof YandebombEntity) {
            YandebombEntity syncable = (YandebombEntity)var2;
            animation = syncable.getSyncedAnimation();
            if (!animation.equals("undefined")) {
               syncable.setAnimation("undefined");
               syncable.animationprocedure = animation;
            }
         }

         var2 = event.getEntity();
         if (var2 instanceof YandeerrorEntity) {
            YandeerrorEntity syncable = (YandeerrorEntity)var2;
            animation = syncable.getSyncedAnimation();
            if (!animation.equals("undefined")) {
               syncable.setAnimation("undefined");
               syncable.animationprocedure = animation;
            }
         }

         var2 = event.getEntity();
         if (var2 instanceof SecondsEntity) {
            SecondsEntity syncable = (SecondsEntity)var2;
            animation = syncable.getSyncedAnimation();
            if (!animation.equals("undefined")) {
               syncable.setAnimation("undefined");
               syncable.animationprocedure = animation;
            }
         }

         var2 = event.getEntity();
         if (var2 instanceof YorupoasuraEntity) {
            YorupoasuraEntity syncable = (YorupoasuraEntity)var2;
            animation = syncable.getSyncedAnimation();
            if (!animation.equals("undefined")) {
               syncable.setAnimation("undefined");
               syncable.animationprocedure = animation;
            }
         }
      }

   }
}
