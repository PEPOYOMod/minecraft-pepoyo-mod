package net.mcreator.pepoyo.entity.model;

import net.mcreator.pepoyo.entity.YandegodieEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class YandegodieModel extends GeoModel<YandegodieEntity> {
   public ResourceLocation getAnimationResource(YandegodieEntity entity) {
      return new ResourceLocation("pepoyo", "animations/yande.animation.json");
   }

   public ResourceLocation getModelResource(YandegodieEntity entity) {
      return new ResourceLocation("pepoyo", "geo/yande.geo.json");
   }

   public ResourceLocation getTextureResource(YandegodieEntity entity) {
      return new ResourceLocation("pepoyo", "textures/entities/" + entity.getTexture() + ".png");
   }
}
