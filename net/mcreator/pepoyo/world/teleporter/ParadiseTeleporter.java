package net.mcreator.pepoyo.world.teleporter;

import com.google.common.collect.ImmutableSet;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Optional;
import java.util.function.Function;
import net.mcreator.pepoyo.init.PepoyoModBlocks;
import net.minecraft.BlockUtil;
import net.minecraft.BlockUtil.FoundRectangle;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.Vec3i;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.Direction.AxisDirection;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.TicketType;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.village.poi.PoiManager;
import net.minecraft.world.entity.ai.village.poi.PoiRecord;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.ai.village.poi.PoiManager.Occupancy;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.NetherPortalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.border.WorldBorder;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.levelgen.Heightmap.Types;
import net.minecraft.world.level.portal.PortalInfo;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.util.ITeleporter;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.ForgeRegistries.Keys;

@EventBusSubscriber(
   bus = Bus.MOD
)
public class ParadiseTeleporter implements ITeleporter {
   public static final TicketType<BlockPos> CUSTOM_PORTAL = TicketType.m_9465_("paradise_portal", Vec3i::compareTo, 300);
   public static Holder<PoiType> poi = null;
   private final ServerLevel level;
   private final BlockPos entityEnterPos;

   @SubscribeEvent
   public static void registerPointOfInterest(RegisterEvent event) {
      event.register(Keys.POI_TYPES, (registerHelper) -> {
         PoiType poiType = new PoiType(ImmutableSet.copyOf(((Block)PepoyoModBlocks.PARADISE_PORTAL.get()).m_49965_().m_61056_()), 0, 1);
         registerHelper.register("paradise_portal", poiType);
         poi = (Holder)ForgeRegistries.POI_TYPES.getHolder(poiType).get();
      });
   }

   public ParadiseTeleporter(ServerLevel worldServer, BlockPos entityEnterPos) {
      this.level = worldServer;
      this.entityEnterPos = entityEnterPos;
   }

   public Optional<FoundRectangle> findPortalAround(BlockPos p_192986_, boolean p_192987_, WorldBorder p_192988_) {
      PoiManager poimanager = this.level.m_8904_();
      int i = p_192987_ ? 16 : 128;
      poimanager.m_27056_(this.level, p_192986_, i);
      Optional<PoiRecord> optional = poimanager.m_27166_((p_230634_) -> {
         return p_230634_.m_203565_((ResourceKey)poi.m_203543_().get());
      }, p_192986_, i, Occupancy.ANY).filter((p_192981_) -> {
         return p_192988_.m_61937_(p_192981_.m_27257_());
      }).sorted(Comparator.comparingDouble((p_192984_) -> {
         return p_192984_.m_27257_().m_123331_(p_192986_);
      }).thenComparingInt((p_192992_) -> {
         return p_192992_.m_27257_().m_123342_();
      })).filter((p_192990_) -> {
         return this.level.m_8055_(p_192990_.m_27257_()).m_61138_(BlockStateProperties.f_61364_);
      }).findFirst();
      return optional.map((p_192975_) -> {
         BlockPos blockpos = p_192975_.m_27257_();
         this.level.m_7726_().m_8387_(CUSTOM_PORTAL, new ChunkPos(blockpos), 3, blockpos);
         BlockState blockstate = this.level.m_8055_(blockpos);
         return BlockUtil.m_124334_(blockpos, (Axis)blockstate.m_61143_(BlockStateProperties.f_61364_), 21, Axis.Y, 21, (p_192978_) -> {
            return this.level.m_8055_(p_192978_) == blockstate;
         });
      });
   }

   public Optional<FoundRectangle> createPortal(BlockPos p_77667_, Axis p_77668_) {
      Direction direction = Direction.m_122390_(AxisDirection.POSITIVE, p_77668_);
      double d0 = -1.0D;
      BlockPos blockpos = null;
      double d1 = -1.0D;
      BlockPos blockpos1 = null;
      WorldBorder worldborder = this.level.m_6857_();
      int i = Math.min(this.level.m_151558_(), this.level.m_141937_() + this.level.m_143344_()) - 1;
      MutableBlockPos blockpos$mutableblockpos = p_77667_.m_122032_();
      Iterator var13 = BlockPos.m_121935_(p_77667_, 16, Direction.EAST, Direction.SOUTH).iterator();

      while(true) {
         MutableBlockPos blockpos$mutableblockpos1;
         int l2;
         int l;
         int k3;
         do {
            do {
               if (!var13.hasNext()) {
                  if (d0 == -1.0D && d1 != -1.0D) {
                     blockpos = blockpos1;
                     d0 = d1;
                  }

                  int l1;
                  int k2;
                  if (d0 == -1.0D) {
                     l1 = Math.max(this.level.m_141937_() - -1, 70);
                     k2 = i - 9;
                     if (k2 < l1) {
                        return Optional.empty();
                     }

                     blockpos = (new BlockPos(p_77667_.m_123341_(), Mth.m_14045_(p_77667_.m_123342_(), l1, k2), p_77667_.m_123343_())).m_7949_();
                     Direction direction1 = direction.m_122427_();
                     if (!worldborder.m_61937_(blockpos)) {
                        return Optional.empty();
                     }

                     for(int i3 = -1; i3 < 2; ++i3) {
                        for(l = 0; l < 2; ++l) {
                           for(k3 = -1; k3 < 3; ++k3) {
                              BlockState blockstate1 = k3 < 0 ? ((Block)PepoyoModBlocks.DIGITALBLOCK.get()).m_49966_() : Blocks.f_50016_.m_49966_();
                              blockpos$mutableblockpos.m_122154_(blockpos, l * direction.m_122429_() + i3 * direction1.m_122429_(), k3, l * direction.m_122431_() + i3 * direction1.m_122431_());
                              this.level.m_46597_(blockpos$mutableblockpos, blockstate1);
                           }
                        }
                     }
                  }

                  for(l1 = -1; l1 < 3; ++l1) {
                     for(k2 = -1; k2 < 4; ++k2) {
                        if (l1 == -1 || l1 == 2 || k2 == -1 || k2 == 3) {
                           blockpos$mutableblockpos.m_122154_(blockpos, l1 * direction.m_122429_(), k2, l1 * direction.m_122431_());
                           this.level.m_7731_(blockpos$mutableblockpos, ((Block)PepoyoModBlocks.DIGITALBLOCK.get()).m_49966_(), 3);
                        }
                     }
                  }

                  BlockState blockstate = (BlockState)((Block)PepoyoModBlocks.PARADISE_PORTAL.get()).m_49966_().m_61124_(NetherPortalBlock.f_54904_, p_77668_);

                  for(k2 = 0; k2 < 2; ++k2) {
                     for(l2 = 0; l2 < 3; ++l2) {
                        blockpos$mutableblockpos.m_122154_(blockpos, k2 * direction.m_122429_(), l2, k2 * direction.m_122431_());
                        this.level.m_7731_(blockpos$mutableblockpos, blockstate, 18);
                        this.level.m_8904_().m_217919_(blockpos$mutableblockpos, poi);
                     }
                  }

                  return Optional.of(new FoundRectangle(blockpos.m_7949_(), 2, 3));
               }

               blockpos$mutableblockpos1 = (MutableBlockPos)var13.next();
               l2 = Math.min(i, this.level.m_6924_(Types.MOTION_BLOCKING, blockpos$mutableblockpos1.m_123341_(), blockpos$mutableblockpos1.m_123343_()));
               int k = true;
            } while(!worldborder.m_61937_(blockpos$mutableblockpos1));
         } while(!worldborder.m_61937_(blockpos$mutableblockpos1.m_122175_(direction, 1)));

         blockpos$mutableblockpos1.m_122175_(direction.m_122424_(), 1);

         for(l = l2; l >= this.level.m_141937_(); --l) {
            blockpos$mutableblockpos1.m_142448_(l);
            if (this.canPortalReplaceBlock(blockpos$mutableblockpos1)) {
               for(k3 = l; l > this.level.m_141937_() && this.canPortalReplaceBlock(blockpos$mutableblockpos1.m_122173_(Direction.DOWN)); --l) {
               }

               if (l + 4 <= i) {
                  int j1 = k3 - l;
                  if (j1 <= 0 || j1 >= 3) {
                     blockpos$mutableblockpos1.m_142448_(l);
                     if (this.canHostFrame(blockpos$mutableblockpos1, blockpos$mutableblockpos, direction, 0)) {
                        double d2 = p_77667_.m_123331_(blockpos$mutableblockpos1);
                        if (this.canHostFrame(blockpos$mutableblockpos1, blockpos$mutableblockpos, direction, -1) && this.canHostFrame(blockpos$mutableblockpos1, blockpos$mutableblockpos, direction, 1) && (d0 == -1.0D || d0 > d2)) {
                           d0 = d2;
                           blockpos = blockpos$mutableblockpos1.m_7949_();
                        }

                        if (d0 == -1.0D && (d1 == -1.0D || d1 > d2)) {
                           d1 = d2;
                           blockpos1 = blockpos$mutableblockpos1.m_7949_();
                        }
                     }
                  }
               }
            }
         }
      }
   }

   private boolean canHostFrame(BlockPos p_77662_, MutableBlockPos p_77663_, Direction p_77664_, int p_77665_) {
      Direction direction = p_77664_.m_122427_();

      for(int i = -1; i < 3; ++i) {
         for(int j = -1; j < 4; ++j) {
            p_77663_.m_122154_(p_77662_, p_77664_.m_122429_() * i + direction.m_122429_() * p_77665_, j, p_77664_.m_122431_() * i + direction.m_122431_() * p_77665_);
            if (j < 0 && !this.level.m_8055_(p_77663_).m_280296_()) {
               return false;
            }

            if (j >= 0 && !this.canPortalReplaceBlock(p_77663_)) {
               return false;
            }
         }
      }

      return true;
   }

   public Entity placeEntity(Entity entity, ServerLevel currentWorld, ServerLevel server, float yaw, Function<Boolean, Entity> repositionEntity) {
      PortalInfo portalinfo = this.getPortalInfo(entity, server);
      if (entity instanceof ServerPlayer) {
         ServerPlayer player = (ServerPlayer)entity;
         player.m_284127_(server);
         server.m_8817_(player);
         player.f_8906_.m_9774_(portalinfo.f_77676_.f_82479_, portalinfo.f_77676_.f_82480_, portalinfo.f_77676_.f_82481_, portalinfo.f_77678_, portalinfo.f_77679_);
         player.f_8906_.m_9953_();
         CriteriaTriggers.f_10588_.m_19757_(player, currentWorld.m_46472_(), server.m_46472_());
         return entity;
      } else {
         Entity entityNew = entity.m_6095_().m_20615_(server);
         if (entityNew != null) {
            entityNew.m_20361_(entity);
            entityNew.m_7678_(portalinfo.f_77676_.f_82479_, portalinfo.f_77676_.f_82480_, portalinfo.f_77676_.f_82481_, portalinfo.f_77678_, entityNew.m_146909_());
            entityNew.m_20256_(portalinfo.f_77677_);
            server.m_143334_(entityNew);
         }

         return entityNew;
      }
   }

   private PortalInfo getPortalInfo(Entity entity, ServerLevel server) {
      WorldBorder worldborder = server.m_6857_();
      double d0 = DimensionType.m_63908_(entity.m_9236_().m_6042_(), server.m_6042_());
      BlockPos blockpos1 = worldborder.m_187569_(entity.m_20185_() * d0, entity.m_20186_(), entity.m_20189_() * d0);
      return (PortalInfo)this.getExitPortal(entity, blockpos1, worldborder).map((repositioner) -> {
         BlockState blockstate = entity.m_9236_().m_8055_(this.entityEnterPos);
         Axis direction$axis;
         Vec3 vector3d;
         if (blockstate.m_61138_(BlockStateProperties.f_61364_)) {
            direction$axis = (Axis)blockstate.m_61143_(BlockStateProperties.f_61364_);
            FoundRectangle teleportationrepositioner$result = BlockUtil.m_124334_(this.entityEnterPos, direction$axis, 21, Axis.Y, 21, (pos) -> {
               return entity.m_9236_().m_8055_(pos) == blockstate;
            });
            vector3d = ParadisePortalShape.getRelativePosition(teleportationrepositioner$result, direction$axis, entity.m_20182_(), entity.m_6972_(entity.m_20089_()));
         } else {
            direction$axis = Axis.X;
            vector3d = new Vec3(0.5D, 0.0D, 0.0D);
         }

         return ParadisePortalShape.createPortalInfo(server, repositioner, direction$axis, vector3d, entity, entity.m_20184_(), entity.m_146908_(), entity.m_146909_());
      }).orElse(new PortalInfo(entity.m_20182_(), Vec3.f_82478_, entity.m_146908_(), entity.m_146909_()));
   }

   protected Optional<FoundRectangle> getExitPortal(Entity entity, BlockPos pos, WorldBorder worldBorder) {
      Optional<FoundRectangle> optional = this.findPortalAround(pos, false, worldBorder);
      if (entity instanceof ServerPlayer) {
         if (optional.isPresent()) {
            return optional;
         } else {
            Axis direction$axis = (Axis)entity.m_9236_().m_8055_(this.entityEnterPos).m_61145_(NetherPortalBlock.f_54904_).orElse(Axis.X);
            return this.createPortal(pos, direction$axis);
         }
      } else {
         return optional;
      }
   }

   private boolean canPortalReplaceBlock(MutableBlockPos pos) {
      BlockState blockstate = this.level.m_8055_(pos);
      return blockstate.m_247087_() && blockstate.m_60819_().m_76178_();
   }
}
