package net.mcreator.pepoyo.block;

import net.mcreator.pepoyo.init.PepoyoModBlocks;
import net.mcreator.pepoyo.procedures.ShardsDangFangKuaiBeiWanJiaPoPiShiProcedure;
import net.mcreator.pepoyo.procedures.ShardsDangShiTiZaiFangKuaiShangXingZouShiProcedure;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ShardsdirtBlock extends Block {
   public static final DirectionProperty FACING;

   public ShardsdirtBlock() {
      super(Properties.m_284310_().m_280658_(NoteBlockInstrument.HAT).m_60918_(SoundType.f_56744_).m_60913_(1.0F, 10.0F).m_60955_().m_60924_((bs, br, bp) -> {
         return false;
      }));
      this.m_49959_((BlockState)((BlockState)this.f_49792_.m_61090_()).m_61124_(FACING, Direction.NORTH));
   }

   public boolean shouldDisplayFluidOverlay(BlockState state, BlockAndTintGetter world, BlockPos pos, FluidState fluidstate) {
      return true;
   }

   public boolean m_7420_(BlockState state, BlockGetter reader, BlockPos pos) {
      return true;
   }

   public int m_7753_(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 0;
   }

   public VoxelShape m_5909_(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
      return Shapes.m_83040_();
   }

   public VoxelShape m_5940_(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
      VoxelShape var10000;
      switch((Direction)state.m_61143_(FACING)) {
      case NORTH:
         var10000 = Shapes.m_83124_(m_49796_(2.0D, 0.0D, 2.0D, 5.0D, 1.0D, 4.0D), new VoxelShape[]{m_49796_(14.0D, 0.0D, 4.0D, 16.0D, 1.0D, 6.0D), m_49796_(10.0D, 0.0D, 8.0D, 12.0D, 1.0D, 9.0D), m_49796_(8.0D, 0.0D, 15.0D, 11.0D, 1.0D, 16.0D), m_49796_(15.0D, 1.0D, 4.0D, 16.0D, 2.0D, 6.0D), m_49796_(9.0D, 0.0D, 1.0D, 11.0D, 1.0D, 4.0D), m_49796_(13.0D, 0.0D, 9.0D, 15.0D, 1.0D, 13.0D), m_49796_(11.0D, 0.0D, 11.0D, 13.0D, 1.0D, 13.0D), m_49796_(13.0D, 1.0D, 12.0D, 15.0D, 2.0D, 13.0D), m_49796_(6.0D, 0.0D, 6.0D, 7.0D, 1.0D, 7.0D), m_49796_(6.0D, 0.0D, 9.0D, 8.0D, 1.0D, 11.0D), m_49796_(2.0D, 0.0D, 12.0D, 6.0D, 1.0D, 14.0D), m_49796_(5.0D, 1.0D, 13.0D, 6.0D, 2.0D, 14.0D), m_49796_(2.0D, 1.0D, 12.0D, 3.0D, 2.0D, 14.0D), m_49796_(10.0D, 1.0D, 2.0D, 11.0D, 2.0D, 3.0D), m_49796_(2.0D, 1.0D, 2.0D, 4.0D, 2.0D, 3.0D), m_49796_(2.0D, 0.0D, 4.0D, 3.0D, 1.0D, 5.0D)});
         break;
      case EAST:
         var10000 = Shapes.m_83124_(m_49796_(12.0D, 0.0D, 2.0D, 14.0D, 1.0D, 5.0D), new VoxelShape[]{m_49796_(10.0D, 0.0D, 14.0D, 12.0D, 1.0D, 16.0D), m_49796_(7.0D, 0.0D, 10.0D, 8.0D, 1.0D, 12.0D), m_49796_(0.0D, 0.0D, 8.0D, 1.0D, 1.0D, 11.0D), m_49796_(10.0D, 1.0D, 15.0D, 12.0D, 2.0D, 16.0D), m_49796_(12.0D, 0.0D, 9.0D, 15.0D, 1.0D, 11.0D), m_49796_(3.0D, 0.0D, 13.0D, 7.0D, 1.0D, 15.0D), m_49796_(3.0D, 0.0D, 11.0D, 5.0D, 1.0D, 13.0D), m_49796_(3.0D, 1.0D, 13.0D, 4.0D, 2.0D, 15.0D), m_49796_(9.0D, 0.0D, 6.0D, 10.0D, 1.0D, 7.0D), m_49796_(5.0D, 0.0D, 6.0D, 7.0D, 1.0D, 8.0D), m_49796_(2.0D, 0.0D, 2.0D, 4.0D, 1.0D, 6.0D), m_49796_(2.0D, 1.0D, 5.0D, 3.0D, 2.0D, 6.0D), m_49796_(2.0D, 1.0D, 2.0D, 4.0D, 2.0D, 3.0D), m_49796_(13.0D, 1.0D, 10.0D, 14.0D, 2.0D, 11.0D), m_49796_(13.0D, 1.0D, 2.0D, 14.0D, 2.0D, 4.0D), m_49796_(11.0D, 0.0D, 2.0D, 12.0D, 1.0D, 3.0D)});
         break;
      case WEST:
         var10000 = Shapes.m_83124_(m_49796_(2.0D, 0.0D, 11.0D, 4.0D, 1.0D, 14.0D), new VoxelShape[]{m_49796_(4.0D, 0.0D, 0.0D, 6.0D, 1.0D, 2.0D), m_49796_(8.0D, 0.0D, 4.0D, 9.0D, 1.0D, 6.0D), m_49796_(15.0D, 0.0D, 5.0D, 16.0D, 1.0D, 8.0D), m_49796_(4.0D, 1.0D, 0.0D, 6.0D, 2.0D, 1.0D), m_49796_(1.0D, 0.0D, 5.0D, 4.0D, 1.0D, 7.0D), m_49796_(9.0D, 0.0D, 1.0D, 13.0D, 1.0D, 3.0D), m_49796_(11.0D, 0.0D, 3.0D, 13.0D, 1.0D, 5.0D), m_49796_(12.0D, 1.0D, 1.0D, 13.0D, 2.0D, 3.0D), m_49796_(6.0D, 0.0D, 9.0D, 7.0D, 1.0D, 10.0D), m_49796_(9.0D, 0.0D, 8.0D, 11.0D, 1.0D, 10.0D), m_49796_(12.0D, 0.0D, 10.0D, 14.0D, 1.0D, 14.0D), m_49796_(13.0D, 1.0D, 10.0D, 14.0D, 2.0D, 11.0D), m_49796_(12.0D, 1.0D, 13.0D, 14.0D, 2.0D, 14.0D), m_49796_(2.0D, 1.0D, 5.0D, 3.0D, 2.0D, 6.0D), m_49796_(2.0D, 1.0D, 12.0D, 3.0D, 2.0D, 14.0D), m_49796_(4.0D, 0.0D, 13.0D, 5.0D, 1.0D, 14.0D)});
         break;
      default:
         var10000 = Shapes.m_83124_(m_49796_(11.0D, 0.0D, 12.0D, 14.0D, 1.0D, 14.0D), new VoxelShape[]{m_49796_(0.0D, 0.0D, 10.0D, 2.0D, 1.0D, 12.0D), m_49796_(4.0D, 0.0D, 7.0D, 6.0D, 1.0D, 8.0D), m_49796_(5.0D, 0.0D, 0.0D, 8.0D, 1.0D, 1.0D), m_49796_(0.0D, 1.0D, 10.0D, 1.0D, 2.0D, 12.0D), m_49796_(5.0D, 0.0D, 12.0D, 7.0D, 1.0D, 15.0D), m_49796_(1.0D, 0.0D, 3.0D, 3.0D, 1.0D, 7.0D), m_49796_(3.0D, 0.0D, 3.0D, 5.0D, 1.0D, 5.0D), m_49796_(1.0D, 1.0D, 3.0D, 3.0D, 2.0D, 4.0D), m_49796_(9.0D, 0.0D, 9.0D, 10.0D, 1.0D, 10.0D), m_49796_(8.0D, 0.0D, 5.0D, 10.0D, 1.0D, 7.0D), m_49796_(10.0D, 0.0D, 2.0D, 14.0D, 1.0D, 4.0D), m_49796_(10.0D, 1.0D, 2.0D, 11.0D, 2.0D, 3.0D), m_49796_(13.0D, 1.0D, 2.0D, 14.0D, 2.0D, 4.0D), m_49796_(5.0D, 1.0D, 13.0D, 6.0D, 2.0D, 14.0D), m_49796_(12.0D, 1.0D, 13.0D, 14.0D, 2.0D, 14.0D), m_49796_(13.0D, 0.0D, 11.0D, 14.0D, 1.0D, 12.0D)});
      }

      return var10000;
   }

   protected void m_7926_(Builder<Block, BlockState> builder) {
      builder.m_61104_(new Property[]{FACING});
   }

   public BlockState m_5573_(BlockPlaceContext context) {
      return (BlockState)this.m_49966_().m_61124_(FACING, context.m_8125_().m_122424_());
   }

   public BlockState m_6843_(BlockState state, Rotation rot) {
      return (BlockState)state.m_61124_(FACING, rot.m_55954_((Direction)state.m_61143_(FACING)));
   }

   public BlockState m_6943_(BlockState state, Mirror mirrorIn) {
      return state.m_60717_(mirrorIn.m_54846_((Direction)state.m_61143_(FACING)));
   }

   public boolean onDestroyedByPlayer(BlockState blockstate, Level world, BlockPos pos, Player entity, boolean willHarvest, FluidState fluid) {
      boolean retval = super.onDestroyedByPlayer(blockstate, world, pos, entity, willHarvest, fluid);
      ShardsDangFangKuaiBeiWanJiaPoPiShiProcedure.execute(world, entity);
      return retval;
   }

   public void m_7892_(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
      super.m_7892_(blockstate, world, pos, entity);
      ShardsDangShiTiZaiFangKuaiShangXingZouShiProcedure.execute(world, entity);
   }

   @OnlyIn(Dist.CLIENT)
   public static void blockColorLoad(net.minecraftforge.client.event.RegisterColorHandlersEvent.Block event) {
      event.getBlockColors().m_92589_((bs, world, pos, index) -> {
         return world != null && pos != null ? BiomeColors.m_108793_(world, pos) : GrassColor.m_46415_(0.5D, 1.0D);
      }, new Block[]{(Block)PepoyoModBlocks.SHARDSDIRT.get()});
   }

   static {
      FACING = HorizontalDirectionalBlock.f_54117_;
   }
}
