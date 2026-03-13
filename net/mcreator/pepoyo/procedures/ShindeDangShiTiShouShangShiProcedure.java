package net.mcreator.pepoyo.procedures;

import java.util.Comparator;
import net.mcreator.pepoyo.entity.YandeEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class ShindeDangShiTiShouShangShiProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity sourceentity) {
      if (sourceentity != null) {
         Entity var10 = (Entity)world.m_6443_(YandeEntity.class, AABB.m_165882_(new Vec3(x, y, z), 32.0D, 32.0D, 32.0D), (e) -> {
            return true;
         }).stream().sorted(((<undefinedtype>)(new Object() {
            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
               return Comparator.comparingDouble((_entcnd) -> {
                  return _entcnd.m_20275_(_x, _y, _z);
               });
            }
         })).compareDistOf(x, y, z)).findFirst().orElse((Object)null);
         if (var10 instanceof Mob) {
            Mob _entity = (Mob)var10;
            if (sourceentity instanceof LivingEntity) {
               LivingEntity _ent = (LivingEntity)sourceentity;
               _entity.m_6710_(_ent);
            }
         }

      }
   }
}
