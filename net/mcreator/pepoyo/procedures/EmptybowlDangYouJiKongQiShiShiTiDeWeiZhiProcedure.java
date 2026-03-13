package net.mcreator.pepoyo.procedures;

import net.mcreator.pepoyo.init.PepoyoModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.items.ItemHandlerHelper;

public class EmptybowlDangYouJiKongQiShiShiTiDeWeiZhiProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         if (world.m_6425_(new BlockPos(entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(2.0D)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_(), entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(2.0D)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_(), entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(2.0D)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_())).m_76188_().m_60734_() == Blocks.f_49990_) {
            world.m_7731_(new BlockPos(entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(2.0D)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_(), entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(2.0D)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_(), entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(2.0D)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_()), Blocks.f_50016_.m_49966_(), 3);
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
