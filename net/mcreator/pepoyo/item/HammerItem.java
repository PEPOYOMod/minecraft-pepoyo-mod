package net.mcreator.pepoyo.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.ImmutableMultimap.Builder;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import net.mcreator.pepoyo.procedures.HammerDangShengWuShiTiBeiGongJuJiZhongShiProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class HammerItem extends Item {
   public HammerItem() {
      super((new Properties()).m_41503_(300));
   }

   public float m_8102_(ItemStack itemstack, BlockState blockstate) {
      float var3;
      if (!List.of(new Block[]{Blocks.f_50058_, Blocks.f_152498_, Blocks.f_50147_, Blocks.f_50148_, Blocks.f_50202_, Blocks.f_50203_, Blocks.f_50204_, Blocks.f_50205_, Blocks.f_50206_, Blocks.f_50207_, Blocks.f_50208_, Blocks.f_50209_, Blocks.f_50210_, Blocks.f_50211_, Blocks.f_50212_, Blocks.f_50213_, Blocks.f_50214_, Blocks.f_50215_, Blocks.f_50185_, Blocks.f_50303_, Blocks.f_50304_, Blocks.f_50305_, Blocks.f_50306_, Blocks.f_50307_, Blocks.f_50361_, Blocks.f_50362_, Blocks.f_50363_, Blocks.f_50364_, Blocks.f_50365_, Blocks.f_50366_, Blocks.f_50367_, Blocks.f_50368_, Blocks.f_50369_, Blocks.f_50370_, Blocks.f_50371_, Blocks.f_50126_, Blocks.f_50354_, Blocks.f_50449_, Blocks.f_50568_, Blocks.f_50746_, Blocks.f_50747_, Blocks.f_50748_, Blocks.f_50749_, Blocks.f_50750_, Blocks.f_50751_, Blocks.f_220831_, Blocks.f_50074_, Blocks.f_50156_, Blocks.f_50030_, Blocks.f_50031_, Blocks.f_50285_, Blocks.f_50066_, Blocks.f_50067_, Blocks.f_50068_, Blocks.f_50017_, Blocks.f_50018_, Blocks.f_50019_, Blocks.f_50020_, Blocks.f_50021_, Blocks.f_50022_, Blocks.f_50023_, Blocks.f_50024_, Blocks.f_50025_, Blocks.f_50026_, Blocks.f_50027_, Blocks.f_50028_, Blocks.f_50029_, Blocks.f_50154_, Blocks.f_50484_, Blocks.f_50485_, Blocks.f_50486_, Blocks.f_50487_, Blocks.f_50488_, Blocks.f_220853_, Blocks.f_244648_, Blocks.f_50077_, Blocks.f_50040_, Blocks.f_50110_, Blocks.f_50081_, Blocks.f_50082_, Blocks.f_50139_, Blocks.f_50140_, Blocks.f_50083_, Blocks.f_50084_, Blocks.f_50681_, Blocks.f_50682_, Blocks.f_50184_, Blocks.f_50683_, Blocks.f_50684_, Blocks.f_152482_, Blocks.f_152483_, Blocks.f_152484_, Blocks.f_152511_, Blocks.f_152512_, Blocks.f_152513_, Blocks.f_152514_, Blocks.f_152515_, Blocks.f_152516_, Blocks.f_152517_, Blocks.f_152518_, Blocks.f_152519_, Blocks.f_152520_, Blocks.f_152521_, Blocks.f_50088_, Blocks.f_50146_, Blocks.f_50146_, Blocks.f_50328_, Blocks.f_50328_, Blocks.f_50261_, Blocks.f_50261_}).contains(blockstate.m_60734_())) {
         Stream var10000 = Stream.of(BlockTags.create(new ResourceLocation("forge:stained_glass")), BlockTags.create(new ResourceLocation("forge:stained_glass_panes")), BlockTags.create(new ResourceLocation("minecraft:saplings")), BlockTags.create(new ResourceLocation("minecraft:candles")));
         Objects.requireNonNull(blockstate);
         if (!var10000.anyMatch(blockstate::m_204336_)) {
            var3 = 1.0F;
            return var3;
         }
      }

      var3 = 15.0F;
      return var3;
   }

   public boolean m_6813_(ItemStack itemstack, Level world, BlockState blockstate, BlockPos pos, LivingEntity entity) {
      itemstack.m_41622_(1, entity, (i) -> {
         i.m_21166_(EquipmentSlot.MAINHAND);
      });
      return true;
   }

   public boolean m_7579_(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
      itemstack.m_41622_(2, entity, (i) -> {
         i.m_21166_(EquipmentSlot.MAINHAND);
      });
      HammerDangShengWuShiTiBeiGongJuJiZhongShiProcedure.execute(entity.m_9236_(), entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity);
      return true;
   }

   public int m_6473_() {
      return 5;
   }

   public Multimap<Attribute, AttributeModifier> m_7167_(EquipmentSlot equipmentSlot) {
      if (equipmentSlot == EquipmentSlot.MAINHAND) {
         Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
         builder.putAll(super.m_7167_(equipmentSlot));
         builder.put(Attributes.f_22281_, new AttributeModifier(f_41374_, "Tool modifier", 5.0D, Operation.ADDITION));
         builder.put(Attributes.f_22283_, new AttributeModifier(f_41375_, "Tool modifier", 1.0D, Operation.ADDITION));
         return builder.build();
      } else {
         return super.m_7167_(equipmentSlot);
      }
   }
}
