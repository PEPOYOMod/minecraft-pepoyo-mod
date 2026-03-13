package net.mcreator.pepoyo.world.dimension;

import net.mcreator.pepoyo.procedures.ParadiseWanJiaJinRuWeiDuShiProcedure;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.client.renderer.DimensionSpecialEffects.SkyType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RegisterDimensionSpecialEffectsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerChangedDimensionEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber
public class ParadiseDimension {
   @SubscribeEvent
   public static void onPlayerChangedDimensionEvent(PlayerChangedDimensionEvent event) {
      Entity entity = event.getEntity();
      Level world = entity.m_9236_();
      double x = entity.m_20185_();
      double y = entity.m_20186_();
      double z = entity.m_20189_();
      if (event.getTo() == ResourceKey.m_135785_(Registries.f_256858_, new ResourceLocation("pepoyo:paradise"))) {
         ParadiseWanJiaJinRuWeiDuShiProcedure.execute(world, x, y, z, entity);
      }

   }

   @EventBusSubscriber(
      bus = Bus.MOD
   )
   public static class ParadiseSpecialEffectsHandler {
      @SubscribeEvent
      @OnlyIn(Dist.CLIENT)
      public static void registerDimensionSpecialEffects(RegisterDimensionSpecialEffectsEvent event) {
         DimensionSpecialEffects customEffect = new DimensionSpecialEffects(Float.NaN, true, SkyType.NONE, false, false) {
            {
               super(arg0, arg1, arg2, arg3, arg4);
            }

            public Vec3 m_5927_(Vec3 color, float sunHeight) {
               return new Vec3(1.0D, 0.2D, 0.2D);
            }

            public boolean m_5781_(int x, int y) {
               return true;
            }
         };
         event.register(new ResourceLocation("pepoyo:paradise"), customEffect);
      }
   }
}
