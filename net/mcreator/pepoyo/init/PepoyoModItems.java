package net.mcreator.pepoyo.init;

import net.mcreator.pepoyo.block.display.YorupocorpseDisplayItem;
import net.mcreator.pepoyo.item.EatableramenItem;
import net.mcreator.pepoyo.item.EmptybowlItem;
import net.mcreator.pepoyo.item.EyeItem;
import net.mcreator.pepoyo.item.HalfmoonsItem;
import net.mcreator.pepoyo.item.HammerItem;
import net.mcreator.pepoyo.item.KnifeItem;
import net.mcreator.pepoyo.item.NailItem;
import net.mcreator.pepoyo.item.NailofpoyoItem;
import net.mcreator.pepoyo.item.NailofpoyoroidoItem;
import net.mcreator.pepoyo.item.ParadiseItem;
import net.mcreator.pepoyo.item.PosonousramenItem;
import net.mcreator.pepoyo.item.RamenItem;
import net.mcreator.pepoyo.item.RiceballItem;
import net.mcreator.pepoyo.item.TaijiItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class PepoyoModItems {
   public static final DeferredRegister<Item> REGISTRY;
   public static final RegistryObject<Item> YANDE_SPAWN_EGG;
   public static final RegistryObject<Item> YANDEOFF_SPAWN_EGG;
   public static final RegistryObject<Item> TAIJI;
   public static final RegistryObject<Item> YANDEGODIE_SPAWN_EGG;
   public static final RegistryObject<Item> SHINDE_SPAWN_EGG;
   public static final RegistryObject<Item> HALFMOONS;
   public static final RegistryObject<Item> POYOROID_SPAWN_EGG;
   public static final RegistryObject<Item> POYOROIDBOSS_SPAWN_EGG;
   public static final RegistryObject<Item> NAIL;
   public static final RegistryObject<Item> POYOROIDO_SPAWN_EGG;
   public static final RegistryObject<Item> HAMMER;
   public static final RegistryObject<Item> POYOROIDPOOR_SPAWN_EGG;
   public static final RegistryObject<Item> RAMEN;
   public static final RegistryObject<Item> STRAWNINJA_SPAWN_EGG;
   public static final RegistryObject<Item> KNIFE;
   public static final RegistryObject<Item> SOLDIER_SPAWN_EGG;
   public static final RegistryObject<Item> SHADOWLESSHAND_SPAWN_EGG;
   public static final RegistryObject<Item> MIKU_SPAWN_EGG;
   public static final RegistryObject<Item> RICEBALL;
   public static final RegistryObject<Item> EYE;
   public static final RegistryObject<Item> YORUPO_SPAWN_EGG;
   public static final RegistryObject<Item> YORUPOBOSS_SPAWN_EGG;
   public static final RegistryObject<Item> EMPTYBOWL;
   public static final RegistryObject<Item> EATABLERAMEN;
   public static final RegistryObject<Item> POSONOUSRAMEN;
   public static final RegistryObject<Item> SHARDS;
   public static final RegistryObject<Item> SHARDSGREEN;
   public static final RegistryObject<Item> SHARDSSTONE;
   public static final RegistryObject<Item> SHARDSDIRT;
   public static final RegistryObject<Item> DIGITALBLOCK;
   public static final RegistryObject<Item> PARADISE;
   public static final RegistryObject<Item> SHIMIYASOSU_SPAWN_EGG;
   public static final RegistryObject<Item> YORUPOSTYLE_SPAWN_EGG;
   public static final RegistryObject<Item> POYO_SPAWN_EGG;
   public static final RegistryObject<Item> NAILOFPOYOROIDO;
   public static final RegistryObject<Item> NAILOFPOYO;
   public static final RegistryObject<Item> DEBTCOLLECTOR_SPAWN_EGG;
   public static final RegistryObject<Item> YANDEBOMB_SPAWN_EGG;
   public static final RegistryObject<Item> YORUPOCORPSE;
   public static final RegistryObject<Item> YANDEERROR_SPAWN_EGG;
   public static final RegistryObject<Item> YORUPOASURA_SPAWN_EGG;

   private static RegistryObject<Item> block(RegistryObject<Block> block) {
      return REGISTRY.register(block.getId().m_135815_(), () -> {
         return new BlockItem((Block)block.get(), new Properties());
      });
   }

   static {
      REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, "pepoyo");
      YANDE_SPAWN_EGG = REGISTRY.register("yande_spawn_egg", () -> {
         return new ForgeSpawnEggItem(PepoyoModEntities.YANDE, -16776961, -16777063, new Properties());
      });
      YANDEOFF_SPAWN_EGG = REGISTRY.register("yandeoff_spawn_egg", () -> {
         return new ForgeSpawnEggItem(PepoyoModEntities.YANDEOFF, -1, -1, new Properties());
      });
      TAIJI = REGISTRY.register("taiji", () -> {
         return new TaijiItem();
      });
      YANDEGODIE_SPAWN_EGG = REGISTRY.register("yandegodie_spawn_egg", () -> {
         return new ForgeSpawnEggItem(PepoyoModEntities.YANDEGODIE, -1, -1, new Properties());
      });
      SHINDE_SPAWN_EGG = REGISTRY.register("shinde_spawn_egg", () -> {
         return new ForgeSpawnEggItem(PepoyoModEntities.SHINDE, -26215, -39322, new Properties());
      });
      HALFMOONS = REGISTRY.register("halfmoons", () -> {
         return new HalfmoonsItem();
      });
      POYOROID_SPAWN_EGG = REGISTRY.register("poyoroid_spawn_egg", () -> {
         return new ForgeSpawnEggItem(PepoyoModEntities.POYOROID, -65383, -65434, new Properties());
      });
      POYOROIDBOSS_SPAWN_EGG = REGISTRY.register("poyoroidboss_spawn_egg", () -> {
         return new ForgeSpawnEggItem(PepoyoModEntities.POYOROIDBOSS, -1, -1, new Properties());
      });
      NAIL = REGISTRY.register("nail", () -> {
         return new NailItem();
      });
      POYOROIDO_SPAWN_EGG = REGISTRY.register("poyoroido_spawn_egg", () -> {
         return new ForgeSpawnEggItem(PepoyoModEntities.POYOROIDO, -10040065, -16750849, new Properties());
      });
      HAMMER = REGISTRY.register("hammer", () -> {
         return new HammerItem();
      });
      POYOROIDPOOR_SPAWN_EGG = REGISTRY.register("poyoroidpoor_spawn_egg", () -> {
         return new ForgeSpawnEggItem(PepoyoModEntities.POYOROIDPOOR, -3355444, -6710887, new Properties());
      });
      RAMEN = REGISTRY.register("ramen", () -> {
         return new RamenItem();
      });
      STRAWNINJA_SPAWN_EGG = REGISTRY.register("strawninja_spawn_egg", () -> {
         return new ForgeSpawnEggItem(PepoyoModEntities.STRAWNINJA, -3368704, -10079488, new Properties());
      });
      KNIFE = REGISTRY.register("knife", () -> {
         return new KnifeItem();
      });
      SOLDIER_SPAWN_EGG = REGISTRY.register("soldier_spawn_egg", () -> {
         return new ForgeSpawnEggItem(PepoyoModEntities.SOLDIER, -26317, -39424, new Properties());
      });
      SHADOWLESSHAND_SPAWN_EGG = REGISTRY.register("shadowlesshand_spawn_egg", () -> {
         return new ForgeSpawnEggItem(PepoyoModEntities.SHADOWLESSHAND, -1, -1, new Properties());
      });
      MIKU_SPAWN_EGG = REGISTRY.register("miku_spawn_egg", () -> {
         return new ForgeSpawnEggItem(PepoyoModEntities.MIKU, -1, -3355393, new Properties());
      });
      RICEBALL = REGISTRY.register("riceball", () -> {
         return new RiceballItem();
      });
      EYE = REGISTRY.register("eye", () -> {
         return new EyeItem();
      });
      YORUPO_SPAWN_EGG = REGISTRY.register("yorupo_spawn_egg", () -> {
         return new ForgeSpawnEggItem(PepoyoModEntities.YORUPO, -6710887, -13421773, new Properties());
      });
      YORUPOBOSS_SPAWN_EGG = REGISTRY.register("yorupoboss_spawn_egg", () -> {
         return new ForgeSpawnEggItem(PepoyoModEntities.YORUPOBOSS, -1, -1, new Properties());
      });
      EMPTYBOWL = REGISTRY.register("emptybowl", () -> {
         return new EmptybowlItem();
      });
      EATABLERAMEN = REGISTRY.register("eatableramen", () -> {
         return new EatableramenItem();
      });
      POSONOUSRAMEN = REGISTRY.register("posonousramen", () -> {
         return new PosonousramenItem();
      });
      SHARDS = block(PepoyoModBlocks.SHARDS);
      SHARDSGREEN = block(PepoyoModBlocks.SHARDSGREEN);
      SHARDSSTONE = block(PepoyoModBlocks.SHARDSSTONE);
      SHARDSDIRT = block(PepoyoModBlocks.SHARDSDIRT);
      DIGITALBLOCK = block(PepoyoModBlocks.DIGITALBLOCK);
      PARADISE = REGISTRY.register("paradise", () -> {
         return new ParadiseItem();
      });
      SHIMIYASOSU_SPAWN_EGG = REGISTRY.register("shimiyasosu_spawn_egg", () -> {
         return new ForgeSpawnEggItem(PepoyoModEntities.SHIMIYASOSU, -26215, -39322, new Properties());
      });
      YORUPOSTYLE_SPAWN_EGG = REGISTRY.register("yorupostyle_spawn_egg", () -> {
         return new ForgeSpawnEggItem(PepoyoModEntities.YORUPOSTYLE, -16724737, -256, new Properties());
      });
      POYO_SPAWN_EGG = REGISTRY.register("poyo_spawn_egg", () -> {
         return new ForgeSpawnEggItem(PepoyoModEntities.POYO, -6723841, -13434625, new Properties());
      });
      NAILOFPOYOROIDO = REGISTRY.register("nailofpoyoroido", () -> {
         return new NailofpoyoroidoItem();
      });
      NAILOFPOYO = REGISTRY.register("nailofpoyo", () -> {
         return new NailofpoyoItem();
      });
      DEBTCOLLECTOR_SPAWN_EGG = REGISTRY.register("debtcollector_spawn_egg", () -> {
         return new ForgeSpawnEggItem(PepoyoModEntities.DEBTCOLLECTOR, -205, -39322, new Properties());
      });
      YANDEBOMB_SPAWN_EGG = REGISTRY.register("yandebomb_spawn_egg", () -> {
         return new ForgeSpawnEggItem(PepoyoModEntities.YANDEBOMB, -1, -1, new Properties());
      });
      YORUPOCORPSE = REGISTRY.register(PepoyoModBlocks.YORUPOCORPSE.getId().m_135815_(), () -> {
         return new YorupocorpseDisplayItem((Block)PepoyoModBlocks.YORUPOCORPSE.get(), new Properties());
      });
      YANDEERROR_SPAWN_EGG = REGISTRY.register("yandeerror_spawn_egg", () -> {
         return new ForgeSpawnEggItem(PepoyoModEntities.YANDEERROR, -1, -1, new Properties());
      });
      YORUPOASURA_SPAWN_EGG = REGISTRY.register("yorupoasura_spawn_egg", () -> {
         return new ForgeSpawnEggItem(PepoyoModEntities.YORUPOASURA, -1, -1, new Properties());
      });
   }
}
