package net.mcreator.pepoyo.procedures;

import net.mcreator.pepoyo.init.PepoyoModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class ShardsDangFangKuaiBeiDanSheWuJiZhongShiProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      world.m_7731_(BlockPos.m_274561_(x, y, z), Blocks.f_50016_.m_49966_(), 3);
      world.m_46796_(2001, BlockPos.m_274561_(x, y, z), Block.m_49956_(((Block)PepoyoModBlocks.SHARDS.get()).m_49966_()));
   }
}
