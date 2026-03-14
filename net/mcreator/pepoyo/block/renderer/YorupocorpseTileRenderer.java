package net.mcreator.pepoyo.block.renderer;

import net.mcreator.pepoyo.block.entity.YorupocorpseTileEntity;
import net.mcreator.pepoyo.block.model.YorupocorpseBlockModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class YorupocorpseTileRenderer extends GeoBlockRenderer<YorupocorpseTileEntity> {
   public YorupocorpseTileRenderer() {
      super(new YorupocorpseBlockModel());
   }

   public RenderType getRenderType(YorupocorpseTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.m_110473_(this.getTextureLocation(animatable));
   }
}
