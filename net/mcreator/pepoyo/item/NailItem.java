package net.mcreator.pepoyo.item;

import net.mcreator.pepoyo.entity.NailsEntity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow.Pickup;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.Level;

public class NailItem extends Item {
   public NailItem() {
      super((new Properties()).m_41487_(64).m_41497_(Rarity.COMMON));
   }

   public InteractionResultHolder<ItemStack> m_7203_(Level world, Player entity, InteractionHand hand) {
      InteractionResultHolder<ItemStack> ar = InteractionResultHolder.m_19100_(entity.m_21120_(hand));
      if (entity.m_150110_().f_35937_ || this.findAmmo(entity) != ItemStack.f_41583_) {
         ar = InteractionResultHolder.m_19090_(entity.m_21120_(hand));
         entity.m_6672_(hand);
      }

      return ar;
   }

   public void m_5551_(ItemStack itemstack, Level world, LivingEntity entity, int time) {
      if (!world.m_5776_() && entity instanceof ServerPlayer) {
         ServerPlayer player = (ServerPlayer)entity;
         float pullingPower = BowItem.m_40661_(this.m_8105_(itemstack) - time);
         if ((double)pullingPower < 0.1D) {
            return;
         }

         ItemStack stack = this.findAmmo(player);
         if (player.m_150110_().f_35937_ || stack != ItemStack.f_41583_) {
            NailsEntity projectile = NailsEntity.shoot(world, entity, world.m_213780_(), pullingPower);
            if (player.m_150110_().f_35937_) {
               projectile.f_36705_ = Pickup.CREATIVE_ONLY;
            } else if (stack.m_41763_()) {
               if (stack.m_220157_(1, world.m_213780_(), player)) {
                  stack.m_41774_(1);
                  stack.m_41721_(0);
                  if (stack.m_41619_()) {
                     player.m_150109_().m_36057_(stack);
                  }
               }
            } else {
               stack.m_41774_(1);
               if (stack.m_41619_()) {
                  player.m_150109_().m_36057_(stack);
               }
            }
         }
      }

   }

   private ItemStack findAmmo(Player player) {
      ItemStack stack = ProjectileWeaponItem.m_43010_(player, (e) -> {
         return e.m_41720_() == NailsEntity.PROJECTILE_ITEM.m_41720_();
      });
      if (stack == ItemStack.f_41583_) {
         for(int i = 0; i < player.m_150109_().f_35974_.size(); ++i) {
            ItemStack teststack = (ItemStack)player.m_150109_().f_35974_.get(i);
            if (teststack != null && teststack.m_41720_() == NailsEntity.PROJECTILE_ITEM.m_41720_()) {
               stack = teststack;
               break;
            }
         }
      }

      return stack;
   }
}
