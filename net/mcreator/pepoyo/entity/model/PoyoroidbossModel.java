package net.mcreator.pepoyo.entity.model;

import net.mcreator.pepoyo.entity.PoyoroidbossEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class PoyoroidbossModel extends GeoModel<PoyoroidbossEntity> {
   public ResourceLocation getAnimationResource(PoyoroidbossEntity entity) {
      return new ResourceLocation("pepoyo", "animations/poyoroid.animation.json");
   }

   public ResourceLocation getModelResource(PoyoroidbossEntity entity) {
      return new ResourceLocation("pepoyo", "geo/poyoroid.geo.json");
   }

   public ResourceLocation getTextureResource(PoyoroidbossEntity entity) {
      return new ResourceLocation("pepoyo", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(PoyoroidbossEntity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("head");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * 0.017453292F);
         head.setRotY(entityData.netHeadYaw() * 0.017453292F);
      }

   }
}
