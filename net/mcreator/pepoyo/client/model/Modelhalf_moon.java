package net.mcreator.pepoyo.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class Modelhalf_moon<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("pepoyo", "modelhalf_moon"), "main");
   public final ModelPart bone;

   public Modelhalf_moon(ModelPart root) {
      this.bone = root.m_171324_("bone");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      partdefinition.m_171599_("bone", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.0F, 6.9F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-2.0F, -8.1F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-2.0F, 5.0F, -1.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-2.0F, -6.0F, -1.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-2.0F, 3.0F, -2.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-2.0F, -4.0F, -2.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-2.0F, -2.0F, -4.0F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(1.0F, 15.1F, 0.0F, 0.0F, 0.0F, 1.5708F));
      return LayerDefinition.m_171565_(meshdefinition, 24, 24);
   }

   public void m_6973_(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.bone.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }
}
