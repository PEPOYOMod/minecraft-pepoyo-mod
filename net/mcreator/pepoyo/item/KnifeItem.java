package net.mcreator.pepoyo.item;

import net.mcreator.pepoyo.procedures.KnifeDangYouJiKongQiShiShiTiDeWeiZhiProcedure;
import net.mcreator.pepoyo.procedures.KnifeGongJuChuXianZaiShouZhongShiMeiKeFaShengProcedure;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;

public class KnifeItem extends SwordItem {
   public KnifeItem() {
      super(new Tier() {
         public int m_6609_() {
            return 600;
         }

         public float m_6624_() {
            return 4.0F;
         }

         public float m_6631_() {
            return 8.0F;
         }

         public int m_6604_() {
            return 0;
         }

         public int m_6601_() {
            return 8;
         }

         public Ingredient m_6282_() {
            return Ingredient.m_43927_(new ItemStack[]{new ItemStack(Items.f_42416_)});
         }
      }, 3, -1.0F, (new Properties()).m_41486_());
   }

   public InteractionResultHolder<ItemStack> m_7203_(Level world, Player entity, InteractionHand hand) {
      InteractionResultHolder<ItemStack> ar = super.m_7203_(world, entity, hand);
      KnifeDangYouJiKongQiShiShiTiDeWeiZhiProcedure.execute(world, entity, (ItemStack)ar.m_19095_());
      return ar;
   }

   public void m_6883_(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
      super.m_6883_(itemstack, world, entity, slot, selected);
      if (selected) {
         KnifeGongJuChuXianZaiShouZhongShiMeiKeFaShengProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_());
      }

   }
}
