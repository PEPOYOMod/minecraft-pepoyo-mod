package net.mcreator.pepoyo.item;

import net.mcreator.pepoyo.block.ParadisePortalBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class ParadiseItem extends Item {
   public ParadiseItem() {
      super((new Properties()).m_41497_(Rarity.EPIC).m_41503_(64));
   }

   public InteractionResult m_6225_(UseOnContext context) {
      Player entity = context.m_43723_();
      BlockPos pos = context.m_8083_().m_121945_(context.m_43719_());
      ItemStack itemstack = context.m_43722_();
      Level world = context.m_43725_();
      if (!entity.m_36204_(pos, context.m_43719_(), itemstack)) {
         return InteractionResult.FAIL;
      } else {
         int x = pos.m_123341_();
         int y = pos.m_123342_();
         int z = pos.m_123343_();
         boolean success = false;
         if (world.m_46859_(pos)) {
            ParadisePortalBlock.portalSpawn(world, pos);
            itemstack.m_41622_(1, entity, (c) -> {
               c.m_21190_(context.m_43724_());
            });
            success = true;
         }

         return success ? InteractionResult.SUCCESS : InteractionResult.FAIL;
      }
   }
}
