package net.mcreator.pepoyo.entity.model;

import net.mcreator.pepoyo.entity.ShadowlesshandEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ShadowlesshandModel extends GeoModel<ShadowlesshandEntity> {
   public ResourceLocation getAnimationResource(ShadowlesshandEntity entity) {
      return new ResourceLocation("pepoyo", "animations/shadowless_hand.animation.json");
   }

   public ResourceLocation getModelResource(ShadowlesshandEntity entity) {
      return new ResourceLocation("pepoyo", "geo/shadowless_hand.geo.json");
   }

   public ResourceLocation getTextureResource(ShadowlesshandEntity entity) {
      return new ResourceLocation("pepoyo", "textures/entities/" + entity.getTexture() + ".png");
   }
}
