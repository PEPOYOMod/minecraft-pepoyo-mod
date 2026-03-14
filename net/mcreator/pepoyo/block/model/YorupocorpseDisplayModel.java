package net.mcreator.pepoyo.block.model;

import net.mcreator.pepoyo.block.display.YorupocorpseDisplayItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class YorupocorpseDisplayModel extends GeoModel<YorupocorpseDisplayItem> {
   public ResourceLocation getAnimationResource(YorupocorpseDisplayItem animatable) {
      return new ResourceLocation("pepoyo", "animations/yorupo_corpse.animation.json");
   }

   public ResourceLocation getModelResource(YorupocorpseDisplayItem animatable) {
      return new ResourceLocation("pepoyo", "geo/yorupo_corpse.geo.json");
   }

   public ResourceLocation getTextureResource(YorupocorpseDisplayItem entity) {
      return new ResourceLocation("pepoyo", "textures/block/bhgdyhrdt.png");
   }
}
