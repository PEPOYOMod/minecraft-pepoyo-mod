package net.mcreator.pepoyo.procedures;

import java.util.Comparator;
import net.mcreator.pepoyo.PepoyoMod;
import net.mcreator.pepoyo.entity.NailsEntity;
import net.mcreator.pepoyo.entity.PoyoroidbossEntity;
import net.mcreator.pepoyo.init.PepoyoModEntities;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class PoyoroidbossDangShiTiChuShiShengChengShiProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (entity instanceof PoyoroidbossEntity) {
            ((PoyoroidbossEntity)entity).setAnimation("animation.poyoroid.switch");
         }

         for(int index0 = 0; index0 < 60; ++index0) {
            if (world instanceof ServerLevel) {
               ServerLevel projectileLevel = (ServerLevel)world;
               Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
                  public Projectile getArrow(Level level, float damage, int knockback) {
                     AbstractArrow entityToSpawn = new NailsEntity((EntityType)PepoyoModEntities.NAILS.get(), level);
                     entityToSpawn.m_36781_((double)damage);
                     entityToSpawn.m_36735_(knockback);
                     entityToSpawn.m_20225_(true);
                     return entityToSpawn;
                  }
               })).getArrow(projectileLevel, 5.0F, 1);
               _entityToSpawn.m_6034_(x + (double)Mth.m_216271_(RandomSource.m_216327_(), -20, 20), y + (double)Mth.m_216271_(RandomSource.m_216327_(), 30, 60), z + (double)Mth.m_216271_(RandomSource.m_216327_(), -20, 20));
               _entityToSpawn.m_6686_(0.0D, -1.0D, 0.0D, 1.0F, 0.0F);
               projectileLevel.m_7967_(_entityToSpawn);
            }
         }

         PepoyoMod.queueServerWork(5, () -> {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle minecraft:lava ~ ~ ~ 3 0.1 3 0.1 200 force @a");
            }

            ((Entity)world.m_6443_(Player.class, AABB.m_165882_(new Vec3(x, y, z), 8.0D, 8.0D, 8.0D), (e) -> {
               return true;
            }).stream().sorted(((<undefinedtype>)(new Object() {
               Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                  return Comparator.comparingDouble((_entcnd) -> {
                     return _entcnd.m_20275_(_x, _y, _z);
                  });
               }
            })).compareDistOf(x, y, z)).findFirst().orElse((Object)null)).m_20256_(new Vec3(0.0D, 4.0D, 0.0D));
         });
      }
   }
}
