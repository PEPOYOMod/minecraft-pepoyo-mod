package net.mcreator.pepoyo.block.listener;

import net.mcreator.pepoyo.block.renderer.YorupocorpseTileRenderer;
import net.mcreator.pepoyo.init.PepoyoModBlockEntities;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent.RegisterRenderers;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(
   modid = "pepoyo",
   bus = Bus.MOD
)
public class ClientListener {
   @OnlyIn(Dist.CLIENT)
   @SubscribeEvent
   public static void registerRenderers(RegisterRenderers event) {
      event.registerBlockEntityRenderer((BlockEntityType)PepoyoModBlockEntities.YORUPOCORPSE.get(), (context) -> {
         return new YorupocorpseTileRenderer();
      });
   }
}
