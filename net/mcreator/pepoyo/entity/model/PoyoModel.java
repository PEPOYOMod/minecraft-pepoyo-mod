package net.mcreator.pepoyo.entity.model;

import net.mcreator.pepoyo.entity.PoyoEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class PoyoModel extends GeoModel<PoyoEntity> {
   public ResourceLocation getAnimationResource(PoyoEntity entity) {
      return new ResourceLocation("pepoyo", "animations/poyo.animation.json");
   }

   public ResourceLocation getModelResource(PoyoEntity entity) {
      return new ResourceLocation("pepoyo", "geo/poyo.geo.json");
   }

   public ResourceLocation getTextureResource(PoyoEntity entity) {
      return new ResourceLocation("pepoyo", "textures/entities/" + entity.getTexture() + ".png");
   }
}
