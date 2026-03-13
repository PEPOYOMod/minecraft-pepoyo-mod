package net.mcreator.pepoyo.init;

import net.mcreator.pepoyo.client.renderer.DebtcollectorRenderer;
import net.mcreator.pepoyo.client.renderer.HalfmoonRenderer;
import net.mcreator.pepoyo.client.renderer.MikuRenderer;
import net.mcreator.pepoyo.client.renderer.NailsRenderer;
import net.mcreator.pepoyo.client.renderer.PoyoRenderer;
import net.mcreator.pepoyo.client.renderer.PoyoroidRenderer;
import net.mcreator.pepoyo.client.renderer.PoyoroidbossRenderer;
import net.mcreator.pepoyo.client.renderer.PoyoroidoRenderer;
import net.mcreator.pepoyo.client.renderer.PoyoroidpoorRenderer;
import net.mcreator.pepoyo.client.renderer.RamenasuraRenderer;
import net.mcreator.pepoyo.client.renderer.RamenbowlRenderer;
import net.mcreator.pepoyo.client.renderer.SecondsRenderer;
import net.mcreator.pepoyo.client.renderer.ShadowlesshandRenderer;
import net.mcreator.pepoyo.client.renderer.ShimiyasosuRenderer;
import net.mcreator.pepoyo.client.renderer.ShindeRenderer;
import net.mcreator.pepoyo.client.renderer.SoldierRenderer;
import net.mcreator.pepoyo.client.renderer.SplinterRenderer;
import net.mcreator.pepoyo.client.renderer.StrawninjaRenderer;
import net.mcreator.pepoyo.client.renderer.StrawninjabossRenderer;
import net.mcreator.pepoyo.client.renderer.YandeRenderer;
import net.mcreator.pepoyo.client.renderer.YandebombRenderer;
import net.mcreator.pepoyo.client.renderer.YandeerrorRenderer;
import net.mcreator.pepoyo.client.renderer.YandegodieRenderer;
import net.mcreator.pepoyo.client.renderer.YandeoffRenderer;
import net.mcreator.pepoyo.client.renderer.YorupoRenderer;
import net.mcreator.pepoyo.client.renderer.YorupoasuraRenderer;
import net.mcreator.pepoyo.client.renderer.YorupobossRenderer;
import net.mcreator.pepoyo.client.renderer.YorupostyleRenderer;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent.RegisterRenderers;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(
   bus = Bus.MOD,
   value = {Dist.CLIENT}
)
public class PepoyoModEntityRenderers {
   @SubscribeEvent
   public static void registerEntityRenderers(RegisterRenderers event) {
      event.registerEntityRenderer((EntityType)PepoyoModEntities.YANDE.get(), YandeRenderer::new);
      event.registerEntityRenderer((EntityType)PepoyoModEntities.YANDEOFF.get(), YandeoffRenderer::new);
      event.registerEntityRenderer((EntityType)PepoyoModEntities.YANDEGODIE.get(), YandegodieRenderer::new);
      event.registerEntityRenderer((EntityType)PepoyoModEntities.SHINDE.get(), ShindeRenderer::new);
      event.registerEntityRenderer((EntityType)PepoyoModEntities.HALFMOON.get(), HalfmoonRenderer::new);
      event.registerEntityRenderer((EntityType)PepoyoModEntities.POYOROID.get(), PoyoroidRenderer::new);
      event.registerEntityRenderer((EntityType)PepoyoModEntities.POYOROIDBOSS.get(), PoyoroidbossRenderer::new);
      event.registerEntityRenderer((EntityType)PepoyoModEntities.NAILS.get(), NailsRenderer::new);
      event.registerEntityRenderer((EntityType)PepoyoModEntities.SPLINTER.get(), SplinterRenderer::new);
      event.registerEntityRenderer((EntityType)PepoyoModEntities.POYOROIDO.get(), PoyoroidoRenderer::new);
      event.registerEntityRenderer((EntityType)PepoyoModEntities.POYOROIDPOOR.get(), PoyoroidpoorRenderer::new);
      event.registerEntityRenderer((EntityType)PepoyoModEntities.STRAWNINJA.get(), StrawninjaRenderer::new);
      event.registerEntityRenderer((EntityType)PepoyoModEntities.STRAWNINJABOSS.get(), StrawninjabossRenderer::new);
      event.registerEntityRenderer((EntityType)PepoyoModEntities.SOLDIER.get(), SoldierRenderer::new);
      event.registerEntityRenderer((EntityType)PepoyoModEntities.SHADOWLESSHAND.get(), ShadowlesshandRenderer::new);
      event.registerEntityRenderer((EntityType)PepoyoModEntities.MIKU.get(), MikuRenderer::new);
      event.registerEntityRenderer((EntityType)PepoyoModEntities.YORUPO.get(), YorupoRenderer::new);
      event.registerEntityRenderer((EntityType)PepoyoModEntities.RAMENBOWL.get(), RamenbowlRenderer::new);
      event.registerEntityRenderer((EntityType)PepoyoModEntities.YORUPOBOSS.get(), YorupobossRenderer::new);
      event.registerEntityRenderer((EntityType)PepoyoModEntities.SHIMIYASOSU.get(), ShimiyasosuRenderer::new);
      event.registerEntityRenderer((EntityType)PepoyoModEntities.YORUPOSTYLE.get(), YorupostyleRenderer::new);
      event.registerEntityRenderer((EntityType)PepoyoModEntities.POYO.get(), PoyoRenderer::new);
      event.registerEntityRenderer((EntityType)PepoyoModEntities.DEBTCOLLECTOR.get(), DebtcollectorRenderer::new);
      event.registerEntityRenderer((EntityType)PepoyoModEntities.YANDEBOMB.get(), YandebombRenderer::new);
      event.registerEntityRenderer((EntityType)PepoyoModEntities.YANDEERROR.get(), YandeerrorRenderer::new);
      event.registerEntityRenderer((EntityType)PepoyoModEntities.SECONDS.get(), SecondsRenderer::new);
      event.registerEntityRenderer((EntityType)PepoyoModEntities.RAMENASURA.get(), RamenasuraRenderer::new);
      event.registerEntityRenderer((EntityType)PepoyoModEntities.YORUPOASURA.get(), YorupoasuraRenderer::new);
   }
}
