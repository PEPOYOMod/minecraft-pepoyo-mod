package net.mcreator.pepoyo.entity.model;

import net.mcreator.pepoyo.entity.YorupostyleEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class YorupostyleModel extends GeoModel<YorupostyleEntity> {
   public ResourceLocation getAnimationResource(YorupostyleEntity entity) {
      return new ResourceLocation("pepoyo", "animations/yorupo_style.animation.json");
   }

   public ResourceLocation getModelResource(YorupostyleEntity entity) {
      return new ResourceLocation("pepoyo", "geo/yorupo_style.geo.json");
   }

   public ResourceLocation getTextureResource(YorupostyleEntity entity) {
      return new ResourceLocation("pepoyo", "textures/entities/" + entity.getTexture() + ".png");
   }
}
