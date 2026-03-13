package net.mcreator.pepoyo.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class PepoyoModTabs {
   public static final DeferredRegister<CreativeModeTab> REGISTRY;
   public static final RegistryObject<CreativeModeTab> PEPOYO;

   static {
      REGISTRY = DeferredRegister.create(Registries.f_279569_, "pepoyo");
      PEPOYO = REGISTRY.register("pepoyo", () -> {
         return CreativeModeTab.builder().m_257941_(Component.m_237115_("item_group.pepoyo.pepoyo")).m_257737_(() -> {
            return new ItemStack((ItemLike)PepoyoModItems.RAMEN.get());
         }).m_257501_((parameters, tabData) -> {
            tabData.m_246326_((ItemLike)PepoyoModItems.YANDE_SPAWN_EGG.get());
            tabData.m_246326_((ItemLike)PepoyoModItems.TAIJI.get());
            tabData.m_246326_((ItemLike)PepoyoModItems.SHINDE_SPAWN_EGG.get());
            tabData.m_246326_((ItemLike)PepoyoModItems.POYOROID_SPAWN_EGG.get());
            tabData.m_246326_((ItemLike)PepoyoModItems.NAIL.get());
            tabData.m_246326_((ItemLike)PepoyoModItems.POYOROIDO_SPAWN_EGG.get());
            tabData.m_246326_((ItemLike)PepoyoModItems.HAMMER.get());
            tabData.m_246326_((ItemLike)PepoyoModItems.POYOROIDPOOR_SPAWN_EGG.get());
            tabData.m_246326_((ItemLike)PepoyoModItems.RAMEN.get());
            tabData.m_246326_((ItemLike)PepoyoModItems.STRAWNINJA_SPAWN_EGG.get());
            tabData.m_246326_((ItemLike)PepoyoModItems.KNIFE.get());
            tabData.m_246326_((ItemLike)PepoyoModItems.SOLDIER_SPAWN_EGG.get());
            tabData.m_246326_((ItemLike)PepoyoModItems.MIKU_SPAWN_EGG.get());
            tabData.m_246326_((ItemLike)PepoyoModItems.RICEBALL.get());
            tabData.m_246326_((ItemLike)PepoyoModItems.EYE.get());
            tabData.m_246326_((ItemLike)PepoyoModItems.YORUPO_SPAWN_EGG.get());
            tabData.m_246326_((ItemLike)PepoyoModItems.EMPTYBOWL.get());
            tabData.m_246326_((ItemLike)PepoyoModItems.EATABLERAMEN.get());
            tabData.m_246326_((ItemLike)PepoyoModItems.POSONOUSRAMEN.get());
            tabData.m_246326_(((Block)PepoyoModBlocks.SHARDS.get()).m_5456_());
            tabData.m_246326_(((Block)PepoyoModBlocks.SHARDSGREEN.get()).m_5456_());
            tabData.m_246326_(((Block)PepoyoModBlocks.SHARDSSTONE.get()).m_5456_());
            tabData.m_246326_(((Block)PepoyoModBlocks.SHARDSDIRT.get()).m_5456_());
            tabData.m_246326_((ItemLike)PepoyoModItems.SHIMIYASOSU_SPAWN_EGG.get());
            tabData.m_246326_((ItemLike)PepoyoModItems.YORUPOSTYLE_SPAWN_EGG.get());
            tabData.m_246326_((ItemLike)PepoyoModItems.POYO_SPAWN_EGG.get());
            tabData.m_246326_((ItemLike)PepoyoModItems.NAILOFPOYOROIDO.get());
            tabData.m_246326_((ItemLike)PepoyoModItems.NAILOFPOYO.get());
            tabData.m_246326_((ItemLike)PepoyoModItems.DEBTCOLLECTOR_SPAWN_EGG.get());
            tabData.m_246326_((ItemLike)PepoyoModItems.YORUPOASURA_SPAWN_EGG.get());
         }).m_257652_();
      });
   }
}
