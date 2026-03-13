package net.mcreator.pepoyo.procedures;

import net.mcreator.pepoyo.init.PepoyoModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.items.ItemHandlerHelper;

public class PoyoDangYouJiShiTiShiProcedure {
   public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
      if (entity != null && sourceentity != null) {
         if (sourceentity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)sourceentity;
            if (_entity.m_21055_((Item)PepoyoModItems.HAMMER.get())) {
               entity.m_6469_(new DamageSource(world.m_9598_().m_175515_(Registries.f_268580_).m_246971_(DamageTypes.f_268433_)), 999.0F);
               if (sourceentity instanceof Player) {
                  Player _player = (Player)sourceentity;
                  ItemStack _setstack = (new ItemStack((ItemLike)PepoyoModItems.NAILOFPOYO.get())).m_41777_();
                  _setstack.m_41764_(1);
                  ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
               }
            }
         }

      }
   }
}
