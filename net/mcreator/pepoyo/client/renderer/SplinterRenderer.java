package net.mcreator.pepoyo.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.mcreator.pepoyo.client.model.Modelnail;
import net.mcreator.pepoyo.entity.SplinterEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class SplinterRenderer extends EntityRenderer<SplinterEntity> {
   private static final ResourceLocation texture = new ResourceLocation("pepoyo:textures/entities/nail.png");
   private final Modelnail model;

   public SplinterRenderer(Context context) {
      super(context);
      this.model = new Modelnail(context.m_174023_(Modelnail.LAYER_LOCATION));
   }

   public void render(SplinterEntity entityIn, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn) {
      VertexConsumer vb = bufferIn.m_6299_(RenderType.m_110452_(this.getTextureLocation(entityIn)));
      poseStack.m_85836_();
      poseStack.m_252781_(Axis.f_252436_.m_252977_(Mth.m_14179_(partialTicks, entityIn.f_19859_, entityIn.m_146908_()) - 90.0F));
      poseStack.m_252781_(Axis.f_252403_.m_252977_(90.0F + Mth.m_14179_(partialTicks, entityIn.f_19860_, entityIn.m_146909_())));
      this.model.m_7695_(poseStack, vb, packedLightIn, OverlayTexture.f_118083_, 1.0F, 1.0F, 1.0F, 1.0F);
      poseStack.m_85849_();
      super.m_7392_(entityIn, entityYaw, partialTicks, poseStack, bufferIn, packedLightIn);
   }

   public ResourceLocation getTextureLocation(SplinterEntity entity) {
      return texture;
   }
}
