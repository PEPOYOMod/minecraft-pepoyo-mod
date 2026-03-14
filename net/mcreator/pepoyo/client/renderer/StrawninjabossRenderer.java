package net.mcreator.pepoyo.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.mcreator.pepoyo.entity.StrawninjabossEntity;
import net.mcreator.pepoyo.entity.model.StrawninjabossModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class StrawninjabossRenderer extends GeoEntityRenderer<StrawninjabossEntity> {
   public StrawninjabossRenderer(Context renderManager) {
      super(renderManager, new StrawninjabossModel());
      this.f_114477_ = 0.5F;
   }

   public RenderType getRenderType(StrawninjabossEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.m_110473_(this.m_5478_(animatable));
   }

   public void preRender(PoseStack poseStack, StrawninjabossEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      float scale = 1.8F;
      this.scaleHeight = scale;
      this.scaleWidth = scale;
      super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
   }

   protected float getDeathMaxRotation(StrawninjabossEntity entityLivingBaseIn) {
      return 0.0F;
   }
}
