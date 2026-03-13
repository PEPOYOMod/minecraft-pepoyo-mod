package net.mcreator.pepoyo.procedures;

import net.mcreator.pepoyo.entity.NailsEntity;
import net.mcreator.pepoyo.entity.PoyoroidbossEntity;
import net.mcreator.pepoyo.init.PepoyoModEntities;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;

public class PoyoroidbossDangShiTiShouShangShiProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         PoyoroidbossEntity _datEntI;
         if (entity instanceof PoyoroidbossEntity) {
            _datEntI = (PoyoroidbossEntity)entity;
            SynchedEntityData var10000 = _datEntI.m_20088_();
            EntityDataAccessor var10001 = PoyoroidbossEntity.DATA_hurt_time;
            int var10002;
            if (entity instanceof PoyoroidbossEntity) {
               PoyoroidbossEntity _datEntI = (PoyoroidbossEntity)entity;
               var10002 = (Integer)_datEntI.m_20088_().m_135370_(PoyoroidbossEntity.DATA_hurt_time);
            } else {
               var10002 = 0;
            }

            var10000.m_135381_(var10001, var10002 + 1);
         }

         int var5;
         if (entity instanceof PoyoroidbossEntity) {
            _datEntI = (PoyoroidbossEntity)entity;
            var5 = (Integer)_datEntI.m_20088_().m_135370_(PoyoroidbossEntity.DATA_hurt_time);
         } else {
            var5 = 0;
         }

         if (var5 == Mth.m_216271_(RandomSource.m_216327_(), 7, 12)) {
            Level projectileLevel = entity.m_9236_();
            if (!projectileLevel.m_5776_()) {
               Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
                  public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
                     AbstractArrow entityToSpawn = new NailsEntity((EntityType)PepoyoModEntities.NAILS.get(), level);
                     entityToSpawn.m_36781_((double)damage);
                     entityToSpawn.m_36735_(knockback);
                     entityToSpawn.m_20225_(true);
                     entityToSpawn.m_36767_(piercing);
                     return entityToSpawn;
                  }
               })).getArrow(projectileLevel, 12.0F, 3, (byte)1);
               _entityToSpawn.m_6034_(entity.m_20185_(), entity.m_20188_() - 0.1D, entity.m_20189_());
               _entityToSpawn.m_6686_(entity.m_20154_().f_82479_, entity.m_20154_().f_82480_, entity.m_20154_().f_82481_, 2.0F, 0.8F);
               projectileLevel.m_7967_(_entityToSpawn);
            }
         }

      }
   }
}
