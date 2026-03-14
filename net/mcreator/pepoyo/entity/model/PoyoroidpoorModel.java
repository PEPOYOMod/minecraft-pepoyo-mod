package net.mcreator.pepoyo.entity.model;

import net.mcreator.pepoyo.entity.PoyoroidpoorEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class PoyoroidpoorModel extends GeoModel<PoyoroidpoorEntity> {
   public ResourceLocation getAnimationResource(PoyoroidpoorEntity entity) {
      return new ResourceLocation("pepoyo", "animations/poyoroid_poor.animation.json");
   }

   public ResourceLocation getModelResource(PoyoroidpoorEntity entity) {
      return new ResourceLocation("pepoyo", "geo/poyoroid_poor.geo.json");
   }

   public ResourceLocation getTextureResource(PoyoroidpoorEntity entity) {
      return new ResourceLocation("pepoyo", "textures/entities/" + entity.getTexture() + ".png");
   }
}
