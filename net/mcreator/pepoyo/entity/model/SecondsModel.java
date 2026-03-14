package net.mcreator.pepoyo.entity.model;

import net.mcreator.pepoyo.entity.SecondsEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SecondsModel extends GeoModel<SecondsEntity> {
   public ResourceLocation getAnimationResource(SecondsEntity entity) {
      return new ResourceLocation("pepoyo", "animations/seconds.animation.json");
   }

   public ResourceLocation getModelResource(SecondsEntity entity) {
      return new ResourceLocation("pepoyo", "geo/seconds.geo.json");
   }

   public ResourceLocation getTextureResource(SecondsEntity entity) {
      return new ResourceLocation("pepoyo", "textures/entities/" + entity.getTexture() + ".png");
   }
}
