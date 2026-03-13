package net.mcreator.pepoyo.procedures;

import net.mcreator.pepoyo.init.PepoyoModItems;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;

public class YorupoDangShiTiSiWangShiProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      ServerLevel _level;
      ItemEntity entityToSpawn;
      if (world instanceof ServerLevel) {
         _level = (ServerLevel)world;
         entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)PepoyoModItems.KNIFE.get()));
         entityToSpawn.m_32010_(10);
         entityToSpawn.m_149678_();
         _level.m_7967_(entityToSpawn);
      }

      if (world instanceof ServerLevel) {
         _level = (ServerLevel)world;
         entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)PepoyoModItems.RAMEN.get()));
         entityToSpawn.m_32010_(10);
         entityToSpawn.m_149678_();
         _level.m_7967_(entityToSpawn);
      }

      if (world instanceof ServerLevel) {
         _level = (ServerLevel)world;
         entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)PepoyoModItems.RAMEN.get()));
         entityToSpawn.m_32010_(10);
         entityToSpawn.m_149678_();
         _level.m_7967_(entityToSpawn);
      }

      if (world instanceof ServerLevel) {
         _level = (ServerLevel)world;
         entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)PepoyoModItems.RAMEN.get()));
         entityToSpawn.m_32010_(10);
         entityToSpawn.m_149678_();
         _level.m_7967_(entityToSpawn);
      }

   }
}
