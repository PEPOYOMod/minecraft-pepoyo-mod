package net.mcreator.pepoyo.init;

import net.mcreator.pepoyo.block.DigitalblockBlock;
import net.mcreator.pepoyo.block.ParadisePortalBlock;
import net.mcreator.pepoyo.block.ShardsBlock;
import net.mcreator.pepoyo.block.ShardsdirtBlock;
import net.mcreator.pepoyo.block.ShardsgreenBlock;
import net.mcreator.pepoyo.block.ShardsstoneBlock;
import net.mcreator.pepoyo.block.YorupocorpseBlock;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class PepoyoModBlocks {
   public static final DeferredRegister<Block> REGISTRY;
   public static final RegistryObject<Block> SHARDS;
   public static final RegistryObject<Block> SHARDSGREEN;
   public static final RegistryObject<Block> SHARDSSTONE;
   public static final RegistryObject<Block> SHARDSDIRT;
   public static final RegistryObject<Block> DIGITALBLOCK;
   public static final RegistryObject<Block> PARADISE_PORTAL;
   public static final RegistryObject<Block> YORUPOCORPSE;

   static {
      REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, "pepoyo");
      SHARDS = REGISTRY.register("shards", () -> {
         return new ShardsBlock();
      });
      SHARDSGREEN = REGISTRY.register("shardsgreen", () -> {
         return new ShardsgreenBlock();
      });
      SHARDSSTONE = REGISTRY.register("shardsstone", () -> {
         return new ShardsstoneBlock();
      });
      SHARDSDIRT = REGISTRY.register("shardsdirt", () -> {
         return new ShardsdirtBlock();
      });
      DIGITALBLOCK = REGISTRY.register("digitalblock", () -> {
         return new DigitalblockBlock();
      });
      PARADISE_PORTAL = REGISTRY.register("paradise_portal", () -> {
         return new ParadisePortalBlock();
      });
      YORUPOCORPSE = REGISTRY.register("yorupocorpse", () -> {
         return new YorupocorpseBlock();
      });
   }

   @EventBusSubscriber(
      bus = Bus.MOD,
      value = {Dist.CLIENT}
   )
   public static class BlocksClientSideHandler {
      @SubscribeEvent
      public static void blockColorLoad(net.minecraftforge.client.event.RegisterColorHandlersEvent.Block event) {
         ShardsBlock.blockColorLoad(event);
         ShardsgreenBlock.blockColorLoad(event);
         ShardsstoneBlock.blockColorLoad(event);
         ShardsdirtBlock.blockColorLoad(event);
      }
   }
}
