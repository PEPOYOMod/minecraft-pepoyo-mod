package net.mcreator.pepoyo.item;

import net.minecraft.world.food.FoodProperties.Builder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;

public class RiceballItem extends Item {
   public RiceballItem() {
      super((new Properties()).m_41487_(64).m_41497_(Rarity.COMMON).m_41489_((new Builder()).m_38760_(5).m_38758_(0.2F).m_38767_()));
   }

   public int m_8105_(ItemStack itemstack) {
      return 16;
   }
}
