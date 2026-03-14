package net.mcreator.pepoyo.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.mcreator.pepoyo.entity.ShimiyasosuEntity;
import net.mcreator.pepoyo.entity.model.ShimiyasosuModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ShimiyasosuRenderer extends GeoEntityRenderer<ShimiyasosuEntity> {
   public ShimiyasosuRenderer(Context renderManager) {
      super(renderManager, new ShimiyasosuModel());
      this.f_114477_ = 0.5F;
   }

   public RenderType getRenderType(ShimiyasosuEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.m_110473_(this.m_5478_(animatable));
   }

   public void preRender(PoseStack poseStack, ShimiyasosuEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      float scale = 1.6F;
      this.scaleHeight = scale;
      this.scaleWidth = scale;
      super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
   }

   protected float getDeathMaxRotation(ShimiyasosuEntity entityLivingBaseIn) {
      return 0.0F;
   }
}
