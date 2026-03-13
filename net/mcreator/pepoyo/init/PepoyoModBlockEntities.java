package net.mcreator.pepoyo.init;

import com.mojang.datafixers.types.Type;
import net.mcreator.pepoyo.block.entity.YorupocorpseTileEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntityType.BlockEntitySupplier;
import net.minecraft.world.level.block.entity.BlockEntityType.Builder;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class PepoyoModBlockEntities {
   public static final DeferredRegister<BlockEntityType<?>> REGISTRY;
   public static final RegistryObject<BlockEntityType<YorupocorpseTileEntity>> YORUPOCORPSE;

   private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntitySupplier<?> supplier) {
      return REGISTRY.register(registryname, () -> {
         return Builder.m_155273_(supplier, new Block[]{(Block)block.get()}).m_58966_((Type)null);
      });
   }

   static {
      REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, "pepoyo");
      YORUPOCORPSE = REGISTRY.register("yorupocorpse", () -> {
         return Builder.m_155273_(YorupocorpseTileEntity::new, new Block[]{(Block)PepoyoModBlocks.YORUPOCORPSE.get()}).m_58966_((Type)null);
      });
   }
}
