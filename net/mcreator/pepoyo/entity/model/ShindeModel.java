package net.mcreator.pepoyo.entity.model;

import net.mcreator.pepoyo.entity.ShindeEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ShindeModel extends GeoModel<ShindeEntity> {
   public ResourceLocation getAnimationResource(ShindeEntity entity) {
      return new ResourceLocation("pepoyo", "animations/shinde.animation.json");
   }

   public ResourceLocation getModelResource(ShindeEntity entity) {
      return new ResourceLocation("pepoyo", "geo/shinde.geo.json");
   }

   public ResourceLocation getTextureResource(ShindeEntity entity) {
      return new ResourceLocation("pepoyo", "textures/entities/" + entity.getTexture() + ".png");
   }
}
