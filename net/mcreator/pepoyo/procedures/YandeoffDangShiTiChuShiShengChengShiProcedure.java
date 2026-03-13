package net.mcreator.pepoyo.procedures;

import java.util.Comparator;
import net.mcreator.pepoyo.PepoyoMod;
import net.mcreator.pepoyo.entity.YandeoffEntity;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class YandeoffDangShiTiChuShiShengChengShiProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (entity instanceof Mob) {
            Mob _entity = (Mob)entity;
            Entity var10 = (Entity)world.m_6443_(Player.class, AABB.m_165882_(new Vec3(x, y, z), 4.0D, 4.0D, 4.0D), (e) -> {
               return true;
            }).stream().sorted(((<undefinedtype>)(new Object() {
               Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                  return Comparator.comparingDouble((_entcnd) -> {
                     return _entcnd.m_20275_(_x, _y, _z);
                  });
               }
            })).compareDistOf(x, y, z)).findFirst().orElse((Object)null);
            if (var10 instanceof LivingEntity) {
               LivingEntity _ent = (LivingEntity)var10;
               _entity.m_6710_(_ent);
            }
         }

         Entity var12 = (Entity)world.m_6443_(Player.class, AABB.m_165882_(new Vec3(x, y, z), 4.0D, 4.0D, 4.0D), (e) -> {
            return true;
         }).stream().sorted(((<undefinedtype>)(new Object() {
            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
               return Comparator.comparingDouble((_entcnd) -> {
                  return _entcnd.m_20275_(_x, _y, _z);
               });
            }
         })).compareDistOf(x, y, z)).findFirst().orElse((Object)null);
         if (var12 instanceof Player) {
            Player _player = (Player)var12;
            if (!_player.m_9236_().m_5776_()) {
               _player.m_5661_(Component.m_237113_("<Yande> 还给我，把Taiji还给我"), false);
            }
         }

         if (entity instanceof YandeoffEntity) {
            ((YandeoffEntity)entity).setAnimation("animation.yande_lose.lose_car");
         }

         PepoyoMod.queueServerWork(30, () -> {
            if (entity instanceof YandeoffEntity) {
               ((YandeoffEntity)entity).setAnimation("empty");
            }

         });
      }
   }
}
