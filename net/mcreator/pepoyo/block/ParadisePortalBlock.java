package net.mcreator.pepoyo.block;

import java.util.Optional;
import net.mcreator.pepoyo.world.teleporter.ParadisePortalShape;
import net.mcreator.pepoyo.world.teleporter.ParadiseTeleporter;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.NetherPortalBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.ForgeRegistries;

public class ParadisePortalBlock extends NetherPortalBlock {
   public ParadisePortalBlock() {
      super(Properties.m_284310_().m_60910_().m_60977_().m_278166_(PushReaction.BLOCK).m_60978_(-1.0F).m_60918_(SoundType.f_56744_).m_60953_((s) -> {
         return 15;
      }).m_222994_());
   }

   public void m_213898_(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
   }

   public static void portalSpawn(Level world, BlockPos pos) {
      Optional<ParadisePortalShape> optional = ParadisePortalShape.findEmptyPortalShape(world, pos, Axis.X);
      if (optional.isPresent()) {
         ((ParadisePortalShape)optional.get()).createPortalBlocks();
      }

   }

   public BlockState m_7417_(BlockState p_54928_, Direction p_54929_, BlockState p_54930_, LevelAccessor p_54931_, BlockPos p_54932_, BlockPos p_54933_) {
      Axis direction$axis = p_54929_.m_122434_();
      Axis direction$axis1 = (Axis)p_54928_.m_61143_(f_54904_);
      boolean flag = direction$axis1 != direction$axis && direction$axis.m_122479_();
      return !flag && !p_54930_.m_60713_(this) && !(new ParadisePortalShape(p_54931_, p_54932_, direction$axis1)).isComplete() ? Blocks.f_50016_.m_49966_() : super.m_7417_(p_54928_, p_54929_, p_54930_, p_54931_, p_54932_, p_54933_);
   }

   @OnlyIn(Dist.CLIENT)
   public void m_214162_(BlockState state, Level world, BlockPos pos, RandomSource random) {
      for(int i = 0; i < 4; ++i) {
         double px = (double)((float)pos.m_123341_() + random.m_188501_());
         double py = (double)((float)pos.m_123342_() + random.m_188501_());
         double pz = (double)((float)pos.m_123343_() + random.m_188501_());
         double vx = ((double)random.m_188501_() - 0.5D) / 2.0D;
         double vy = ((double)random.m_188501_() - 0.5D) / 2.0D;
         double vz = ((double)random.m_188501_() - 0.5D) / 2.0D;
         int j = random.m_188503_(4) - 1;
         if (world.m_8055_(pos.m_122024_()).m_60734_() != this && world.m_8055_(pos.m_122029_()).m_60734_() != this) {
            px = (double)pos.m_123341_() + 0.5D + 0.25D * (double)j;
            vx = (double)(random.m_188501_() * 2.0F * (float)j);
         } else {
            pz = (double)pos.m_123343_() + 0.5D + 0.25D * (double)j;
            vz = (double)(random.m_188501_() * 2.0F * (float)j);
         }

         world.m_7106_(ParticleTypes.f_123799_, px, py, pz, vx, vy, vz);
      }

      if (random.m_188503_(110) == 0) {
         world.m_6263_((Player)null, (double)pos.m_123341_() + 0.5D, (double)pos.m_123342_() + 0.5D, (double)pos.m_123343_() + 0.5D, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.portal.ambient")), SoundSource.BLOCKS, 0.5F, random.m_188501_() * 0.4F + 0.8F);
      }

   }

   public void m_7892_(BlockState state, Level world, BlockPos pos, Entity entity) {
      if (entity.m_6072_() && !entity.m_9236_().m_5776_()) {
         if (entity.m_20092_()) {
            entity.m_20091_();
         } else if (entity.m_9236_().m_46472_() != ResourceKey.m_135785_(Registries.f_256858_, new ResourceLocation("pepoyo:paradise"))) {
            entity.m_20091_();
            this.teleportToDimension(entity, pos, ResourceKey.m_135785_(Registries.f_256858_, new ResourceLocation("pepoyo:paradise")));
         } else {
            entity.m_20091_();
            this.teleportToDimension(entity, pos, Level.f_46428_);
         }
      }

   }

   private void teleportToDimension(Entity entity, BlockPos pos, ResourceKey<Level> destinationType) {
      entity.changeDimension(entity.m_20194_().m_129880_(destinationType), new ParadiseTeleporter(entity.m_20194_().m_129880_(destinationType), pos));
   }
}
