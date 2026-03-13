package net.mcreator.pepoyo.world.features.configurations;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.RegistryCodecs;
import net.minecraft.core.Vec3i;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public record StructureFeatureConfiguration(ResourceLocation structure, boolean randomRotation, boolean randomMirror, HolderSet<Block> ignoredBlocks, Vec3i offset) implements FeatureConfiguration {
   public static final Codec<StructureFeatureConfiguration> CODEC = RecordCodecBuilder.create((builder) -> {
      return builder.group(ResourceLocation.f_135803_.fieldOf("structure").forGetter((config) -> {
         return config.structure;
      }), Codec.BOOL.fieldOf("random_rotation").orElse(false).forGetter((config) -> {
         return config.randomRotation;
      }), Codec.BOOL.fieldOf("random_mirror").orElse(false).forGetter((config) -> {
         return config.randomMirror;
      }), RegistryCodecs.m_206277_(Registries.f_256747_).fieldOf("ignored_blocks").forGetter((config) -> {
         return config.ignoredBlocks;
      }), Vec3i.m_194650_(48).optionalFieldOf("offset", Vec3i.f_123288_).forGetter((config) -> {
         return config.offset;
      })).apply(builder, StructureFeatureConfiguration::new);
   });

   public StructureFeatureConfiguration(ResourceLocation structure, boolean randomRotation, boolean randomMirror, HolderSet<Block> ignoredBlocks, Vec3i offset) {
      this.structure = structure;
      this.randomRotation = randomRotation;
      this.randomMirror = randomMirror;
      this.ignoredBlocks = ignoredBlocks;
      this.offset = offset;
   }

   public ResourceLocation structure() {
      return this.structure;
   }

   public boolean randomRotation() {
      return this.randomRotation;
   }

   public boolean randomMirror() {
      return this.randomMirror;
   }

   public HolderSet<Block> ignoredBlocks() {
      return this.ignoredBlocks;
   }

   public Vec3i offset() {
      return this.offset;
   }
}
