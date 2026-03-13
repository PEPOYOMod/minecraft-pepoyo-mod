package net.mcreator.pepoyo.item;

import net.mcreator.pepoyo.procedures.EmptybowlDangShengWuShiTiBeiGongJuJiZhongShiProcedure;
import net.mcreator.pepoyo.procedures.EmptybowlDangYouJiKongQiShiShiTiDeWeiZhiProcedure;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;

public class EmptybowlItem extends AxeItem {
   public EmptybowlItem() {
      super(new Tier() {
         public int m_6609_() {
            return 1;
         }

         public float m_6624_() {
            return 4.0F;
         }

         public float m_6631_() {
            return 13.0F;
         }

         public int m_6604_() {
            return 0;
         }

         public int m_6601_() {
            return 4;
         }

         public Ingredient m_6282_() {
            return Ingredient.m_151265_();
         }
      }, 1.0F, 1.0F, new Properties());
   }

   public boolean m_7579_(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
      boolean retval = super.m_7579_(itemstack, entity, sourceentity);
      EmptybowlDangShengWuShiTiBeiGongJuJiZhongShiProcedure.execute(entity.m_9236_(), entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity);
      return retval;
   }

   public InteractionResultHolder<ItemStack> m_7203_(Level world, Player entity, InteractionHand hand) {
      InteractionResultHolder<ItemStack> ar = super.m_7203_(world, entity, hand);
      EmptybowlDangYouJiKongQiShiShiTiDeWeiZhiProcedure.execute(world, entity);
      return ar;
   }
}
