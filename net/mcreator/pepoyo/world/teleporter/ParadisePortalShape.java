package net.mcreator.pepoyo.world.teleporter;

import java.util.Optional;
import java.util.function.Predicate;
import javax.annotation.Nullable;
import net.mcreator.pepoyo.init.PepoyoModBlocks;
import net.minecraft.BlockUtil.FoundRectangle;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.core.Direction.Axis;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.NetherPortalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.StatePredicate;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.portal.PortalInfo;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ParadisePortalShape {
   private static final int MIN_WIDTH = 2;
   public static final int MAX_WIDTH = 21;
   private static final int MIN_HEIGHT = 3;
   public static final int MAX_HEIGHT = 21;
   private static final StatePredicate FRAME = (p_77720_, p_77721_, p_77722_) -> {
      return p_77720_.m_60734_() == PepoyoModBlocks.DIGITALBLOCK.get();
   };
   private static final float SAFE_TRAVEL_MAX_ENTITY_XY = 4.0F;
   private static final double SAFE_TRAVEL_MAX_VERTICAL_DELTA = 1.0D;
   private final LevelAccessor level;
   private final Axis axis;
   private final Direction rightDir;
   private int numPortalBlocks;
   @Nullable
   private BlockPos bottomLeft;
   private int height;
   private final int width;

   public static Optional<ParadisePortalShape> findEmptyPortalShape(LevelAccessor p_77709_, BlockPos p_77710_, Axis p_77711_) {
      return findPortalShape(p_77709_, p_77710_, (p_77727_) -> {
         return p_77727_.isValid() && p_77727_.numPortalBlocks == 0;
      }, p_77711_);
   }

   public static Optional<ParadisePortalShape> findPortalShape(LevelAccessor p_77713_, BlockPos p_77714_, Predicate<ParadisePortalShape> p_77715_, Axis p_77716_) {
      Optional<ParadisePortalShape> optional = Optional.of(new ParadisePortalShape(p_77713_, p_77714_, p_77716_)).filter(p_77715_);
      if (optional.isPresent()) {
         return optional;
      } else {
         Axis direction$axis = p_77716_ == Axis.X ? Axis.Z : Axis.X;
         return Optional.of(new ParadisePortalShape(p_77713_, p_77714_, direction$axis)).filter(p_77715_);
      }
   }

   public ParadisePortalShape(LevelAccessor p_77695_, BlockPos p_77696_, Axis p_77697_) {
      this.level = p_77695_;
      this.axis = p_77697_;
      this.rightDir = p_77697_ == Axis.X ? Direction.WEST : Direction.SOUTH;
      this.bottomLeft = this.calculateBottomLeft(p_77696_);
      if (this.bottomLeft == null) {
         this.bottomLeft = p_77696_;
         this.width = 1;
         this.height = 1;
      } else {
         this.width = this.calculateWidth();
         if (this.width > 0) {
            this.height = this.calculateHeight();
         }
      }

   }

   @Nullable
   private BlockPos calculateBottomLeft(BlockPos p_77734_) {
      for(int i = Math.max(this.level.m_141937_(), p_77734_.m_123342_() - 21); p_77734_.m_123342_() > i && isEmpty(this.level.m_8055_(p_77734_.m_7495_())); p_77734_ = p_77734_.m_7495_()) {
      }

      Direction direction = this.rightDir.m_122424_();
      int j = this.getDistanceUntilEdgeAboveFrame(p_77734_, direction) - 1;
      return j < 0 ? null : p_77734_.m_5484_(direction, j);
   }

   private int calculateWidth() {
      int i = this.getDistanceUntilEdgeAboveFrame(this.bottomLeft, this.rightDir);
      return i >= 2 && i <= 21 ? i : 0;
   }

   private int getDistanceUntilEdgeAboveFrame(BlockPos p_77736_, Direction p_77737_) {
      MutableBlockPos blockpos$mutableblockpos = new MutableBlockPos();

      for(int i = 0; i <= 21; ++i) {
         blockpos$mutableblockpos.m_122190_(p_77736_).m_122175_(p_77737_, i);
         BlockState blockstate = this.level.m_8055_(blockpos$mutableblockpos);
         if (!isEmpty(blockstate)) {
            if (FRAME.m_61035_(blockstate, this.level, blockpos$mutableblockpos)) {
               return i;
            }
            break;
         }

         BlockState blockstate1 = this.level.m_8055_(blockpos$mutableblockpos.m_122173_(Direction.DOWN));
         if (!FRAME.m_61035_(blockstate1, this.level, blockpos$mutableblockpos)) {
            break;
         }
      }

      return 0;
   }

   private int calculateHeight() {
      MutableBlockPos blockpos$mutableblockpos = new MutableBlockPos();
      int i = this.getDistanceUntilTop(blockpos$mutableblockpos);
      return i >= 3 && i <= 21 && this.hasTopFrame(blockpos$mutableblockpos, i) ? i : 0;
   }

   private boolean hasTopFrame(MutableBlockPos p_77731_, int p_77732_) {
      for(int i = 0; i < this.width; ++i) {
         MutableBlockPos blockpos$mutableblockpos = p_77731_.m_122190_(this.bottomLeft).m_122175_(Direction.UP, p_77732_).m_122175_(this.rightDir, i);
         if (!FRAME.m_61035_(this.level.m_8055_(blockpos$mutableblockpos), this.level, blockpos$mutableblockpos)) {
            return false;
         }
      }

      return true;
   }

   private int getDistanceUntilTop(MutableBlockPos p_77729_) {
      for(int i = 0; i < 21; ++i) {
         p_77729_.m_122190_(this.bottomLeft).m_122175_(Direction.UP, i).m_122175_(this.rightDir, -1);
         if (!FRAME.m_61035_(this.level.m_8055_(p_77729_), this.level, p_77729_)) {
            return i;
         }

         p_77729_.m_122190_(this.bottomLeft).m_122175_(Direction.UP, i).m_122175_(this.rightDir, this.width);
         if (!FRAME.m_61035_(this.level.m_8055_(p_77729_), this.level, p_77729_)) {
            return i;
         }

         for(int j = 0; j < this.width; ++j) {
            p_77729_.m_122190_(this.bottomLeft).m_122175_(Direction.UP, i).m_122175_(this.rightDir, j);
            BlockState blockstate = this.level.m_8055_(p_77729_);
            if (!isEmpty(blockstate)) {
               return i;
            }

            if (blockstate.m_60734_() == PepoyoModBlocks.PARADISE_PORTAL.get()) {
               ++this.numPortalBlocks;
            }
         }
      }

      return 21;
   }

   private static boolean isEmpty(BlockState p_77718_) {
      return p_77718_.m_60795_() || p_77718_.m_60734_() == PepoyoModBlocks.PARADISE_PORTAL.get();
   }

   public boolean isValid() {
      return this.bottomLeft != null && this.width >= 2 && this.width <= 21 && this.height >= 3 && this.height <= 21;
   }

   public void createPortalBlocks() {
      BlockState blockstate = (BlockState)((Block)PepoyoModBlocks.PARADISE_PORTAL.get()).m_49966_().m_61124_(NetherPortalBlock.f_54904_, this.axis);
      BlockPos.m_121940_(this.bottomLeft, this.bottomLeft.m_5484_(Direction.UP, this.height - 1).m_5484_(this.rightDir, this.width - 1)).forEach((p_77725_) -> {
         this.level.m_7731_(p_77725_, blockstate, 18);
         if (this.level instanceof ServerLevel) {
            ((ServerLevel)this.level).m_8904_().m_217919_(p_77725_, ParadiseTeleporter.poi);
         }

      });
   }

   public boolean isComplete() {
      return this.isValid() && this.numPortalBlocks == this.width * this.height;
   }

   public static Vec3 getRelativePosition(FoundRectangle p_77739_, Axis p_77740_, Vec3 p_77741_, EntityDimensions p_77742_) {
      double d0 = (double)p_77739_.f_124349_ - (double)p_77742_.f_20377_;
      double d1 = (double)p_77739_.f_124350_ - (double)p_77742_.f_20378_;
      BlockPos blockpos = p_77739_.f_124348_;
      double d2;
      if (d0 > 0.0D) {
         float f = (float)blockpos.m_123304_(p_77740_) + p_77742_.f_20377_ / 2.0F;
         d2 = Mth.m_14008_(Mth.m_14112_(p_77741_.m_82507_(p_77740_) - (double)f, 0.0D, d0), 0.0D, 1.0D);
      } else {
         d2 = 0.5D;
      }

      double d4;
      Axis direction$axis1;
      if (d1 > 0.0D) {
         direction$axis1 = Axis.Y;
         d4 = Mth.m_14008_(Mth.m_14112_(p_77741_.m_82507_(direction$axis1) - (double)blockpos.m_123304_(direction$axis1), 0.0D, d1), 0.0D, 1.0D);
      } else {
         d4 = 0.0D;
      }

      direction$axis1 = p_77740_ == Axis.X ? Axis.Z : Axis.X;
      double d3 = p_77741_.m_82507_(direction$axis1) - ((double)blockpos.m_123304_(direction$axis1) + 0.5D);
      return new Vec3(d2, d4, d3);
   }

   public static PortalInfo createPortalInfo(ServerLevel p_259301_, FoundRectangle p_259931_, Axis p_259901_, Vec3 p_259630_, Entity p_259166_, Vec3 p_260043_, float p_259853_, float p_259667_) {
      BlockPos blockpos = p_259931_.f_124348_;
      BlockState blockstate = p_259301_.m_8055_(blockpos);
      Axis direction$axis = (Axis)blockstate.m_61145_(BlockStateProperties.f_61364_).orElse(Axis.X);
      double d0 = (double)p_259931_.f_124349_;
      double d1 = (double)p_259931_.f_124350_;
      EntityDimensions entitydimensions = p_259166_.m_6972_(p_259166_.m_20089_());
      int i = p_259901_ == direction$axis ? 0 : 90;
      Vec3 vec3 = p_259901_ == direction$axis ? p_260043_ : new Vec3(p_260043_.f_82481_, p_260043_.f_82480_, -p_260043_.f_82479_);
      double d2 = (double)entitydimensions.f_20377_ / 2.0D + (d0 - (double)entitydimensions.f_20377_) * p_259630_.m_7096_();
      double d3 = (d1 - (double)entitydimensions.f_20378_) * p_259630_.m_7098_();
      double d4 = 0.5D + p_259630_.m_7094_();
      boolean flag = direction$axis == Axis.X;
      Vec3 vec31 = new Vec3((double)blockpos.m_123341_() + (flag ? d2 : d4), (double)blockpos.m_123342_() + d3, (double)blockpos.m_123343_() + (flag ? d4 : d2));
      Vec3 vec32 = findCollisionFreePosition(vec31, p_259301_, p_259166_, entitydimensions);
      return new PortalInfo(vec32, vec3, p_259853_ + (float)i, p_259667_);
   }

   private static Vec3 findCollisionFreePosition(Vec3 p_260315_, ServerLevel p_259704_, Entity p_259626_, EntityDimensions p_259816_) {
      if (!(p_259816_.f_20377_ > 4.0F) && !(p_259816_.f_20378_ > 4.0F)) {
         double d0 = (double)p_259816_.f_20378_ / 2.0D;
         Vec3 vec3 = p_260315_.m_82520_(0.0D, d0, 0.0D);
         VoxelShape voxelshape = Shapes.m_83064_(AABB.m_165882_(vec3, (double)p_259816_.f_20377_, 0.0D, (double)p_259816_.f_20377_).m_82363_(0.0D, 1.0D, 0.0D).m_82400_(1.0E-6D));
         Optional<Vec3> optional = p_259704_.m_151418_(p_259626_, voxelshape, vec3, (double)p_259816_.f_20377_, (double)p_259816_.f_20378_, (double)p_259816_.f_20377_);
         Optional<Vec3> optional1 = optional.map((p_259019_) -> {
            return p_259019_.m_82492_(0.0D, d0, 0.0D);
         });
         return (Vec3)optional1.orElse(p_260315_);
      } else {
         return p_260315_;
      }
   }
}
