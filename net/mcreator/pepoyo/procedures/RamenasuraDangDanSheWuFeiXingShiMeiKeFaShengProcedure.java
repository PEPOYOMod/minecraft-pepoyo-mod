package net.mcreator.pepoyo.procedures;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelAccessor;

public class RamenasuraDangDanSheWuFeiXingShiMeiKeFaShengProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (world instanceof ServerLevel) {
         ServerLevel _level = (ServerLevel)world;
         _level.m_8767_(ParticleTypes.f_123744_, x, y - 30.0D, z, 120, 0.1D, 30.0D, 0.1D, 0.01D);
      }

   }
}
