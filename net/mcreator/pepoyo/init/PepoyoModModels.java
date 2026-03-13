package net.mcreator.pepoyo.init;

import net.mcreator.pepoyo.client.model.Modelhalf_moon;
import net.mcreator.pepoyo.client.model.Modelmoon;
import net.mcreator.pepoyo.client.model.Modelnail;
import net.mcreator.pepoyo.client.model.Modelramen_boom;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent.RegisterLayerDefinitions;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(
   bus = Bus.MOD,
   value = {Dist.CLIENT}
)
public class PepoyoModModels {
   @SubscribeEvent
   public static void registerLayerDefinitions(RegisterLayerDefinitions event) {
      event.registerLayerDefinition(Modelmoon.LAYER_LOCATION, Modelmoon::createBodyLayer);
      event.registerLayerDefinition(Modelhalf_moon.LAYER_LOCATION, Modelhalf_moon::createBodyLayer);
      event.registerLayerDefinition(Modelramen_boom.LAYER_LOCATION, Modelramen_boom::createBodyLayer);
      event.registerLayerDefinition(Modelnail.LAYER_LOCATION, Modelnail::createBodyLayer);
   }
}
