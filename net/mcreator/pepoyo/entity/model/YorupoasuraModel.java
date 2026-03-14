package net.mcreator.pepoyo.entity.model;

import net.mcreator.pepoyo.entity.YorupoasuraEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class YorupoasuraModel extends GeoModel<YorupoasuraEntity> {
   public ResourceLocation getAnimationResource(YorupoasuraEntity entity) {
      return new ResourceLocation("pepoyo", "animations/yorupo.animation.json");
   }

   public ResourceLocation getModelResource(YorupoasuraEntity entity) {
      return new ResourceLocation("pepoyo", "geo/yorupo.geo.json");
   }

   public ResourceLocation getTextureResource(YorupoasuraEntity entity) {
      return new ResourceLocation("pepoyo", "textures/entities/" + entity.getTexture() + ".png");
   }
}
