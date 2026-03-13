package net.mcreator.pepoyo.item;

import net.mcreator.pepoyo.init.PepoyoModItems;
import net.mcreator.pepoyo.procedures.PosonousramenDangShengWuShiTiBeiGaiWuPinJiZhongProcedure;
import net.mcreator.pepoyo.procedures.RamenDangWanJiaWanChengShiYongWuPinShiProcedure;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties.Builder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;

public class PosonousramenItem extends Item {
   public PosonousramenItem() {
      super((new Properties()).m_41487_(64).m_41497_(Rarity.COMMON).m_41489_((new Builder()).m_38760_(4).m_38758_(0.3F).m_38765_().m_38757_().m_38767_()));
   }

   public ItemStack m_5922_(ItemStack itemstack, Level world, LivingEntity entity) {
      ItemStack retval = new ItemStack((ItemLike)PepoyoModItems.EMPTYBOWL.get());
      super.m_5922_(itemstack, world, entity);
      double x = entity.m_20185_();
      double y = entity.m_20186_();
      double z = entity.m_20189_();
      RamenDangWanJiaWanChengShiYongWuPinShiProcedure.execute(world, x, y, z, entity);
      if (itemstack.m_41619_()) {
         return retval;
      } else {
         if (entity instanceof Player) {
            Player player = (Player)entity;
            if (!player.m_150110_().f_35937_ && !player.m_150109_().m_36054_(retval)) {
               player.m_36176_(retval, false);
            }
         }

         return itemstack;
      }
   }

   public boolean m_7579_(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
      boolean retval = super.m_7579_(itemstack, entity, sourceentity);
      PosonousramenDangShengWuShiTiBeiGaiWuPinJiZhongProcedure.execute(entity);
      return retval;
   }
}
