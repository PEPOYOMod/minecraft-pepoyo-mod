package net.mcreator.pepoyo.procedures;

import net.mcreator.pepoyo.init.PepoyoModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraftforge.items.ItemHandlerHelper;

public class EmptybowlDangYouJiFangKuaiShiFangKuaiDeWeiZhiProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60734_() instanceof SimpleWaterloggedBlock) {
            world.m_7731_(BlockPos.m_274561_(x, y, z), Blocks.f_50016_.m_49966_(), 3);
            Player _player;
            ItemStack _setstack;
            if (entity instanceof Player) {
               _player = (Player)entity;
               _setstack = new ItemStack((ItemLike)PepoyoModItems.EMPTYBOWL.get());
               _player.m_150109_().m_36022_((p) -> {
                  return _setstack.m_41720_() == p.m_41720_();
               }, 1, _player.f_36095_.m_39730_());
            }

            if (entity instanceof Player) {
               _player = (Player)entity;
               _setstack = (new ItemStack((ItemLike)PepoyoModItems.EATABLERAMEN.get())).m_41777_();
               _setstack.m_41764_(1);
               ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
            }
         }

      }
   }
}
