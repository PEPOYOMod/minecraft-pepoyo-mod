package net.mcreator.pepoyo.entity.model;

import net.mcreator.pepoyo.entity.YandeerrorEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class YandeerrorModel extends GeoModel<YandeerrorEntity> {
   public ResourceLocation getAnimationResource(YandeerrorEntity entity) {
      return new ResourceLocation("pepoyo", "animations/yande.animation.json");
   }

   public ResourceLocation getModelResource(YandeerrorEntity entity) {
      return new ResourceLocation("pepoyo", "geo/yande.geo.json");
   }

   public ResourceLocation getTextureResource(YandeerrorEntity entity) {
      return new ResourceLocation("pepoyo", "textures/entities/" + entity.getTexture() + ".png");
   }
}
