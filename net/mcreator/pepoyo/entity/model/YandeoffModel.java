package net.mcreator.pepoyo.entity.model;

import net.mcreator.pepoyo.entity.YandeoffEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class YandeoffModel extends GeoModel<YandeoffEntity> {
   public ResourceLocation getAnimationResource(YandeoffEntity entity) {
      return new ResourceLocation("pepoyo", "animations/yande.animation.json");
   }

   public ResourceLocation getModelResource(YandeoffEntity entity) {
      return new ResourceLocation("pepoyo", "geo/yande.geo.json");
   }

   public ResourceLocation getTextureResource(YandeoffEntity entity) {
      return new ResourceLocation("pepoyo", "textures/entities/" + entity.getTexture() + ".png");
   }
}
