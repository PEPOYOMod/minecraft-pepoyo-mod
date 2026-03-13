package net.mcreator.pepoyo.procedures;

import net.mcreator.pepoyo.init.PepoyoModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
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

public class PoyoroidoDangYouJiShiTiShiProcedure {
   public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
      if (entity != null && sourceentity != null) {
         if (sourceentity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)sourceentity;
            if (_entity.m_21055_((Item)PepoyoModItems.HAMMER.get())) {
               Player _player;
               if (sourceentity instanceof Player) {
                  _player = (Player)sourceentity;
                  ItemStack _setstack = (new ItemStack((ItemLike)PepoyoModItems.NAILOFPOYOROIDO.get())).m_41777_();
                  _setstack.m_41764_(1);
                  ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
               }

               if (sourceentity instanceof Player) {
                  _player = (Player)sourceentity;
                  if (!_player.m_9236_().m_5776_()) {
                     _player.m_5661_(Component.m_237113_("你得到了郁的钉子"), false);
                  }
               }

               entity.m_6469_(new DamageSource(world.m_9598_().m_175515_(Registries.f_268580_).m_246971_(DamageTypes.f_268433_)), 99999.0F);
            }
         }

      }
   }
}
