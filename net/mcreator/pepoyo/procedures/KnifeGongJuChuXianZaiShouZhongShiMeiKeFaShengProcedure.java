package net.mcreator.pepoyo.procedures;

import java.util.Comparator;
import net.mcreator.pepoyo.entity.HalfmoonEntity;
import net.mcreator.pepoyo.init.PepoyoModEntities;
import net.mcreator.pepoyo.network.PepoyoModVariables;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class KnifeGongJuChuXianZaiShouZhongShiMeiKeFaShengProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (PepoyoModVariables.MapVariables.get(world).knife_skill) {
         Entity _shootFrom = (Entity)world.m_6443_(Player.class, AABB.m_165882_(new Vec3(x, y, z), 4.0D, 4.0D, 4.0D), (e) -> {
            return true;
         }).stream().sorted(((<undefinedtype>)(new Object() {
            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
               return Comparator.comparingDouble((_entcnd) -> {
                  return _entcnd.m_20275_(_x, _y, _z);
               });
            }
         })).compareDistOf(x, y, z)).findFirst().orElse((Object)null);
         Level projectileLevel = _shootFrom.m_9236_();
         if (!projectileLevel.m_5776_()) {
            Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
               public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
                  AbstractArrow entityToSpawn = new HalfmoonEntity((EntityType)PepoyoModEntities.HALFMOON.get(), level);
                  entityToSpawn.m_36781_((double)damage);
                  entityToSpawn.m_36735_(knockback);
                  entityToSpawn.m_20225_(true);
                  entityToSpawn.m_36767_(piercing);
                  return entityToSpawn;
               }
            })).getArrow(projectileLevel, 6.0F, 1, (byte)1);
            _entityToSpawn.m_6034_(_shootFrom.m_20185_(), _shootFrom.m_20188_() - 0.1D, _shootFrom.m_20189_());
            _entityToSpawn.m_6686_(_shootFrom.m_20154_().f_82479_, _shootFrom.m_20154_().f_82480_, _shootFrom.m_20154_().f_82481_, 6.0F, 0.0F);
            projectileLevel.m_7967_(_entityToSpawn);
         }

         ++PepoyoModVariables.MapVariables.get(world).knife_halfmoon;
         PepoyoModVariables.MapVariables.get(world).syncData(world);
         if (PepoyoModVariables.MapVariables.get(world).knife_halfmoon >= 80.0D) {
            PepoyoModVariables.MapVariables.get(world).knife_skill = false;
            PepoyoModVariables.MapVariables.get(world).syncData(world);
            PepoyoModVariables.MapVariables.get(world).knife_halfmoon = 0.0D;
            PepoyoModVariables.MapVariables.get(world).syncData(world);
         }
      }

   }
}
