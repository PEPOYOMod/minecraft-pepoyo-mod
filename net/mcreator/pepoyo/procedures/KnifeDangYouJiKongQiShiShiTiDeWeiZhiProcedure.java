package net.mcreator.pepoyo.procedures;

import net.mcreator.pepoyo.network.PepoyoModVariables;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class KnifeDangYouJiKongQiShiShiTiDeWeiZhiProcedure {
   public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         PepoyoModVariables.MapVariables.get(world).knife_skill = false;
         PepoyoModVariables.MapVariables.get(world).syncData(world);
         if (entity instanceof Player) {
            Player _player = (Player)entity;
            _player.m_36335_().m_41524_(itemstack.m_41720_(), 1);
         }

         entity.m_20256_(new Vec3(entity.m_20154_().f_82479_, entity.m_20154_().f_82480_, entity.m_20154_().f_82481_));
      }
   }
}
