package net.mcreator.pepoyo.entity.model;

import net.mcreator.pepoyo.entity.YorupobossEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class YorupobossModel extends GeoModel<YorupobossEntity> {
   public ResourceLocation getAnimationResource(YorupobossEntity entity) {
      return new ResourceLocation("pepoyo", "animations/yorupo.animation.json");
   }

   public ResourceLocation getModelResource(YorupobossEntity entity) {
      return new ResourceLocation("pepoyo", "geo/yorupo.geo.json");
   }

   public ResourceLocation getTextureResource(YorupobossEntity entity) {
      return new ResourceLocation("pepoyo", "textures/entities/" + entity.getTexture() + ".png");
   }
}
