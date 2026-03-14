package net.mcreator.pepoyo.block.model;

import net.mcreator.pepoyo.block.entity.YorupocorpseTileEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class YorupocorpseBlockModel extends GeoModel<YorupocorpseTileEntity> {
   public ResourceLocation getAnimationResource(YorupocorpseTileEntity animatable) {
      return new ResourceLocation("pepoyo", "animations/yorupo_corpse.animation.json");
   }

   public ResourceLocation getModelResource(YorupocorpseTileEntity animatable) {
      return new ResourceLocation("pepoyo", "geo/yorupo_corpse.geo.json");
   }

   public ResourceLocation getTextureResource(YorupocorpseTileEntity animatable) {
      return new ResourceLocation("pepoyo", "textures/block/bhgdyhrdt.png");
   }
}
