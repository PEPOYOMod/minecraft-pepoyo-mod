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

public class Modelmoon<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("pepoyo", "modelmoon"), "main");
   public final ModelPart moon;

   public Modelmoon(ModelPart root) {
      this.moon = root.m_171324_("moon");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      partdefinition.m_171599_("moon", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-1.0F, 6.0F, -5.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-1.0F, -7.0F, -5.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(0.0F, -9.0F, -3.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-1.0F, -9.0F, 1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-1.0F, -2.0F, -10.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(0.0F, 3.0F, -10.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-1.0F, 8.0F, -4.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(0.0F, 8.0F, 1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(0.0F, 8.0F, 5.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-1.0F, 3.0F, 8.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(0.0F, -1.0F, 8.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-1.0F, -5.0F, 8.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-1.0F, 4.0F, -7.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-1.0F, 4.0F, 4.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-1.0F, -5.0F, -7.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-1.0F, -5.0F, 4.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-1.0F, -3.0F, -8.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-1.0F, -3.0F, 6.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, 14.0F, 1.0F));
      return LayerDefinition.m_171565_(meshdefinition, 32, 32);
   }

   public void m_6973_(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.moon.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }
}
