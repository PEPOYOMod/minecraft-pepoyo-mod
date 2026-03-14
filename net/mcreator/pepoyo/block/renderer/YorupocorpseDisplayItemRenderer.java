package net.mcreator.pepoyo.block.renderer;

import net.mcreator.pepoyo.block.display.YorupocorpseDisplayItem;
import net.mcreator.pepoyo.block.model.YorupocorpseDisplayModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class YorupocorpseDisplayItemRenderer extends GeoItemRenderer<YorupocorpseDisplayItem> {
   public YorupocorpseDisplayItemRenderer() {
      super(new YorupocorpseDisplayModel());
   }

   public RenderType getRenderType(YorupocorpseDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.m_110473_(this.getTextureLocation(animatable));
   }
}
