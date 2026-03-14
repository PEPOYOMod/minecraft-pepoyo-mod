package net.mcreator.pepoyo.client.renderer;

import net.mcreator.pepoyo.client.model.Modelramen_boom;
import net.mcreator.pepoyo.entity.DebtcollectorEntity;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;

public class DebtcollectorRenderer extends MobRenderer<DebtcollectorEntity, Modelramen_boom<DebtcollectorEntity>> {
   public DebtcollectorRenderer(Context context) {
      super(context, new Modelramen_boom(context.m_174023_(Modelramen_boom.LAYER_LOCATION)), 0.5F);
   }

   public ResourceLocation getTextureLocation(DebtcollectorEntity entity) {
      return new ResourceLocation("pepoyo:textures/entities/ramen_bowl.png");
   }
}
