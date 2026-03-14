package net.mcreator.pepoyo.entity.model;

import net.mcreator.pepoyo.entity.YandebombEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class YandebombModel extends GeoModel<YandebombEntity> {
   public ResourceLocation getAnimationResource(YandebombEntity entity) {
      return new ResourceLocation("pepoyo", "animations/yande.animation.json");
   }

   public ResourceLocation getModelResource(YandebombEntity entity) {
      return new ResourceLocation("pepoyo", "geo/yande.geo.json");
   }

   public ResourceLocation getTextureResource(YandebombEntity entity) {
      return new ResourceLocation("pepoyo", "textures/entities/" + entity.getTexture() + ".png");
   }
}
