package net.mcreator.pepoyo.entity.model;

import net.mcreator.pepoyo.entity.PoyoroidoEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class PoyoroidoModel extends GeoModel<PoyoroidoEntity> {
   public ResourceLocation getAnimationResource(PoyoroidoEntity entity) {
      return new ResourceLocation("pepoyo", "animations/poyoroid_o.animation.json");
   }

   public ResourceLocation getModelResource(PoyoroidoEntity entity) {
      return new ResourceLocation("pepoyo", "geo/poyoroid_o.geo.json");
   }

   public ResourceLocation getTextureResource(PoyoroidoEntity entity) {
      return new ResourceLocation("pepoyo", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(PoyoroidoEntity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("head");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * 0.017453292F);
         head.setRotY(entityData.netHeadYaw() * 0.017453292F);
      }

   }
}
