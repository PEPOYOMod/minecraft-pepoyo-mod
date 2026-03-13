package net.mcreator.pepoyo.procedures;

import net.mcreator.pepoyo.PepoyoMod;
import net.mcreator.pepoyo.entity.RamenbowlEntity;
import net.mcreator.pepoyo.entity.YorupoEntity;
import net.mcreator.pepoyo.entity.YorupobossEntity;
import net.mcreator.pepoyo.init.PepoyoModEntities;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class YorupobossDangShiTiChuShiShengChengShiProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (entity instanceof YorupoEntity) {
            ((YorupoEntity)entity).setAnimation("animation.yorupo.begin");
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "time set midnight");
         }

         for(int index0 = 0; index0 < 130; ++index0) {
            if (world instanceof ServerLevel) {
               ServerLevel projectileLevel = (ServerLevel)world;
               Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
                  public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
                     AbstractArrow entityToSpawn = new RamenbowlEntity((EntityType)PepoyoModEntities.RAMENBOWL.get(), level);
                     entityToSpawn.m_36781_((double)damage);
                     entityToSpawn.m_36735_(knockback);
                     entityToSpawn.m_20225_(true);
                     entityToSpawn.m_36767_(piercing);
                     return entityToSpawn;
                  }
               })).getArrow(projectileLevel, 10.0F, 1, (byte)1);
               _entityToSpawn.m_6034_(x + (double)Mth.m_216271_(RandomSource.m_216327_(), -20, 20), y + (double)Mth.m_216271_(RandomSource.m_216327_(), 30, 70), z + (double)Mth.m_216271_(RandomSource.m_216327_(), -20, 20));
               _entityToSpawn.m_6686_(0.0D, -1.0D, 0.0D, 1.0F, 0.0F);
               projectileLevel.m_7967_(_entityToSpawn);
            }
         }

         PepoyoMod.queueServerWork(4, () -> {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               Entity entityToSpawn = EntityType.f_20465_.m_262496_(_level, BlockPos.m_274561_(x, y + 1.0D, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.m_146922_(world.m_213780_().m_188501_() * 360.0F);
               }
            }

            PepoyoMod.queueServerWork(4, () -> {
               entity.m_20095_();
               PepoyoMod.queueServerWork(160, () -> {
                  if (entity instanceof YorupobossEntity) {
                     YorupobossEntity _datEntSetL = (YorupobossEntity)entity;
                     _datEntSetL.m_20088_().m_135381_(YorupobossEntity.DATA_active, true);
                  }

               });
            });
         });
      }
   }
}
