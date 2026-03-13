package net.mcreator.pepoyo.init;

import net.mcreator.pepoyo.entity.DebtcollectorEntity;
import net.mcreator.pepoyo.entity.HalfmoonEntity;
import net.mcreator.pepoyo.entity.MikuEntity;
import net.mcreator.pepoyo.entity.NailsEntity;
import net.mcreator.pepoyo.entity.PoyoEntity;
import net.mcreator.pepoyo.entity.PoyoroidEntity;
import net.mcreator.pepoyo.entity.PoyoroidbossEntity;
import net.mcreator.pepoyo.entity.PoyoroidoEntity;
import net.mcreator.pepoyo.entity.PoyoroidpoorEntity;
import net.mcreator.pepoyo.entity.RamenasuraEntity;
import net.mcreator.pepoyo.entity.RamenbowlEntity;
import net.mcreator.pepoyo.entity.SecondsEntity;
import net.mcreator.pepoyo.entity.ShadowlesshandEntity;
import net.mcreator.pepoyo.entity.ShimiyasosuEntity;
import net.mcreator.pepoyo.entity.ShindeEntity;
import net.mcreator.pepoyo.entity.SoldierEntity;
import net.mcreator.pepoyo.entity.SplinterEntity;
import net.mcreator.pepoyo.entity.StrawninjaEntity;
import net.mcreator.pepoyo.entity.StrawninjabossEntity;
import net.mcreator.pepoyo.entity.YandeEntity;
import net.mcreator.pepoyo.entity.YandebombEntity;
import net.mcreator.pepoyo.entity.YandeerrorEntity;
import net.mcreator.pepoyo.entity.YandegodieEntity;
import net.mcreator.pepoyo.entity.YandeoffEntity;
import net.mcreator.pepoyo.entity.YorupoEntity;
import net.mcreator.pepoyo.entity.YorupoasuraEntity;
import net.mcreator.pepoyo.entity.YorupobossEntity;
import net.mcreator.pepoyo.entity.YorupostyleEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType.Builder;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@EventBusSubscriber(
   bus = Bus.MOD
)
public class PepoyoModEntities {
   public static final DeferredRegister<EntityType<?>> REGISTRY;
   public static final RegistryObject<EntityType<YandeEntity>> YANDE;
   public static final RegistryObject<EntityType<YandeoffEntity>> YANDEOFF;
   public static final RegistryObject<EntityType<YandegodieEntity>> YANDEGODIE;
   public static final RegistryObject<EntityType<ShindeEntity>> SHINDE;
   public static final RegistryObject<EntityType<HalfmoonEntity>> HALFMOON;
   public static final RegistryObject<EntityType<PoyoroidEntity>> POYOROID;
   public static final RegistryObject<EntityType<PoyoroidbossEntity>> POYOROIDBOSS;
   public static final RegistryObject<EntityType<NailsEntity>> NAILS;
   public static final RegistryObject<EntityType<SplinterEntity>> SPLINTER;
   public static final RegistryObject<EntityType<PoyoroidoEntity>> POYOROIDO;
   public static final RegistryObject<EntityType<PoyoroidpoorEntity>> POYOROIDPOOR;
   public static final RegistryObject<EntityType<StrawninjaEntity>> STRAWNINJA;
   public static final RegistryObject<EntityType<StrawninjabossEntity>> STRAWNINJABOSS;
   public static final RegistryObject<EntityType<SoldierEntity>> SOLDIER;
   public static final RegistryObject<EntityType<ShadowlesshandEntity>> SHADOWLESSHAND;
   public static final RegistryObject<EntityType<MikuEntity>> MIKU;
   public static final RegistryObject<EntityType<YorupoEntity>> YORUPO;
   public static final RegistryObject<EntityType<RamenbowlEntity>> RAMENBOWL;
   public static final RegistryObject<EntityType<YorupobossEntity>> YORUPOBOSS;
   public static final RegistryObject<EntityType<ShimiyasosuEntity>> SHIMIYASOSU;
   public static final RegistryObject<EntityType<YorupostyleEntity>> YORUPOSTYLE;
   public static final RegistryObject<EntityType<PoyoEntity>> POYO;
   public static final RegistryObject<EntityType<DebtcollectorEntity>> DEBTCOLLECTOR;
   public static final RegistryObject<EntityType<YandebombEntity>> YANDEBOMB;
   public static final RegistryObject<EntityType<YandeerrorEntity>> YANDEERROR;
   public static final RegistryObject<EntityType<SecondsEntity>> SECONDS;
   public static final RegistryObject<EntityType<RamenasuraEntity>> RAMENASURA;
   public static final RegistryObject<EntityType<YorupoasuraEntity>> YORUPOASURA;

   private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, Builder<T> entityTypeBuilder) {
      return REGISTRY.register(registryname, () -> {
         return entityTypeBuilder.m_20712_(registryname);
      });
   }

   @SubscribeEvent
   public static void init(FMLCommonSetupEvent event) {
      event.enqueueWork(() -> {
         YandeEntity.init();
         YandeoffEntity.init();
         YandegodieEntity.init();
         ShindeEntity.init();
         PoyoroidEntity.init();
         PoyoroidbossEntity.init();
         PoyoroidoEntity.init();
         PoyoroidpoorEntity.init();
         StrawninjaEntity.init();
         StrawninjabossEntity.init();
         SoldierEntity.init();
         ShadowlesshandEntity.init();
         MikuEntity.init();
         YorupoEntity.init();
         YorupobossEntity.init();
         ShimiyasosuEntity.init();
         YorupostyleEntity.init();
         PoyoEntity.init();
         DebtcollectorEntity.init();
         YandebombEntity.init();
         YandeerrorEntity.init();
         SecondsEntity.init();
         YorupoasuraEntity.init();
      });
   }

   @SubscribeEvent
   public static void registerAttributes(EntityAttributeCreationEvent event) {
      event.put((EntityType)YANDE.get(), YandeEntity.createAttributes().m_22265_());
      event.put((EntityType)YANDEOFF.get(), YandeoffEntity.createAttributes().m_22265_());
      event.put((EntityType)YANDEGODIE.get(), YandegodieEntity.createAttributes().m_22265_());
      event.put((EntityType)SHINDE.get(), ShindeEntity.createAttributes().m_22265_());
      event.put((EntityType)POYOROID.get(), PoyoroidEntity.createAttributes().m_22265_());
      event.put((EntityType)POYOROIDBOSS.get(), PoyoroidbossEntity.createAttributes().m_22265_());
      event.put((EntityType)POYOROIDO.get(), PoyoroidoEntity.createAttributes().m_22265_());
      event.put((EntityType)POYOROIDPOOR.get(), PoyoroidpoorEntity.createAttributes().m_22265_());
      event.put((EntityType)STRAWNINJA.get(), StrawninjaEntity.createAttributes().m_22265_());
      event.put((EntityType)STRAWNINJABOSS.get(), StrawninjabossEntity.createAttributes().m_22265_());
      event.put((EntityType)SOLDIER.get(), SoldierEntity.createAttributes().m_22265_());
      event.put((EntityType)SHADOWLESSHAND.get(), ShadowlesshandEntity.createAttributes().m_22265_());
      event.put((EntityType)MIKU.get(), MikuEntity.createAttributes().m_22265_());
      event.put((EntityType)YORUPO.get(), YorupoEntity.createAttributes().m_22265_());
      event.put((EntityType)YORUPOBOSS.get(), YorupobossEntity.createAttributes().m_22265_());
      event.put((EntityType)SHIMIYASOSU.get(), ShimiyasosuEntity.createAttributes().m_22265_());
      event.put((EntityType)YORUPOSTYLE.get(), YorupostyleEntity.createAttributes().m_22265_());
      event.put((EntityType)POYO.get(), PoyoEntity.createAttributes().m_22265_());
      event.put((EntityType)DEBTCOLLECTOR.get(), DebtcollectorEntity.createAttributes().m_22265_());
      event.put((EntityType)YANDEBOMB.get(), YandebombEntity.createAttributes().m_22265_());
      event.put((EntityType)YANDEERROR.get(), YandeerrorEntity.createAttributes().m_22265_());
      event.put((EntityType)SECONDS.get(), SecondsEntity.createAttributes().m_22265_());
      event.put((EntityType)YORUPOASURA.get(), YorupoasuraEntity.createAttributes().m_22265_());
   }

   static {
      REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, "pepoyo");
      YANDE = register("yande", Builder.m_20704_(YandeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(YandeEntity::new).m_20699_(0.6F, 1.8F));
      YANDEOFF = register("yandeoff", Builder.m_20704_(YandeoffEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(YandeoffEntity::new).m_20699_(0.6F, 1.8F));
      YANDEGODIE = register("yandegodie", Builder.m_20704_(YandegodieEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(YandegodieEntity::new).m_20719_().m_20699_(0.6F, 1.8F));
      SHINDE = register("shinde", Builder.m_20704_(ShindeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ShindeEntity::new).m_20699_(0.6F, 1.8F));
      HALFMOON = register("halfmoon", Builder.m_20704_(HalfmoonEntity::new, MobCategory.MISC).setCustomClientFactory(HalfmoonEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).m_20699_(0.5F, 0.5F));
      POYOROID = register("poyoroid", Builder.m_20704_(PoyoroidEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PoyoroidEntity::new).m_20699_(0.6F, 1.8F));
      POYOROIDBOSS = register("poyoroidboss", Builder.m_20704_(PoyoroidbossEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PoyoroidbossEntity::new).m_20699_(0.6F, 1.8F));
      NAILS = register("nails", Builder.m_20704_(NailsEntity::new, MobCategory.MISC).setCustomClientFactory(NailsEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).m_20699_(0.5F, 0.5F));
      SPLINTER = register("splinter", Builder.m_20704_(SplinterEntity::new, MobCategory.MISC).setCustomClientFactory(SplinterEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).m_20699_(0.5F, 0.5F));
      POYOROIDO = register("poyoroido", Builder.m_20704_(PoyoroidoEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PoyoroidoEntity::new).m_20699_(0.6F, 1.8F));
      POYOROIDPOOR = register("poyoroidpoor", Builder.m_20704_(PoyoroidpoorEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PoyoroidpoorEntity::new).m_20699_(0.6F, 1.8F));
      STRAWNINJA = register("strawninja", Builder.m_20704_(StrawninjaEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(StrawninjaEntity::new).m_20699_(0.6F, 1.8F));
      STRAWNINJABOSS = register("strawninjaboss", Builder.m_20704_(StrawninjabossEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(StrawninjabossEntity::new).m_20699_(0.6F, 1.8F));
      SOLDIER = register("soldier", Builder.m_20704_(SoldierEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SoldierEntity::new).m_20699_(0.6F, 1.8F));
      SHADOWLESSHAND = register("shadowlesshand", Builder.m_20704_(ShadowlesshandEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ShadowlesshandEntity::new).m_20719_().m_20699_(0.6F, 1.8F));
      MIKU = register("miku", Builder.m_20704_(MikuEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MikuEntity::new).m_20699_(0.6F, 1.8F));
      YORUPO = register("yorupo", Builder.m_20704_(YorupoEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(YorupoEntity::new).m_20699_(0.6F, 1.8F));
      RAMENBOWL = register("ramenbowl", Builder.m_20704_(RamenbowlEntity::new, MobCategory.MISC).setCustomClientFactory(RamenbowlEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).m_20699_(0.5F, 0.5F));
      YORUPOBOSS = register("yorupoboss", Builder.m_20704_(YorupobossEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(YorupobossEntity::new).m_20699_(0.6F, 1.8F));
      SHIMIYASOSU = register("shimiyasosu", Builder.m_20704_(ShimiyasosuEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ShimiyasosuEntity::new).m_20699_(0.6F, 1.8F));
      YORUPOSTYLE = register("yorupostyle", Builder.m_20704_(YorupostyleEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(YorupostyleEntity::new).m_20699_(0.6F, 1.8F));
      POYO = register("poyo", Builder.m_20704_(PoyoEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PoyoEntity::new).m_20699_(0.6F, 1.8F));
      DEBTCOLLECTOR = register("debtcollector", Builder.m_20704_(DebtcollectorEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(DebtcollectorEntity::new).m_20699_(0.6F, 1.8F));
      YANDEBOMB = register("yandebomb", Builder.m_20704_(YandebombEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(YandebombEntity::new).m_20699_(0.6F, 1.8F));
      YANDEERROR = register("yandeerror", Builder.m_20704_(YandeerrorEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(YandeerrorEntity::new).m_20699_(0.6F, 1.8F));
      SECONDS = register("seconds", Builder.m_20704_(SecondsEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SecondsEntity::new).m_20699_(0.6F, 1.8F));
      RAMENASURA = register("ramenasura", Builder.m_20704_(RamenasuraEntity::new, MobCategory.MISC).setCustomClientFactory(RamenasuraEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).m_20699_(0.5F, 0.5F));
      YORUPOASURA = register("yorupoasura", Builder.m_20704_(YorupoasuraEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(YorupoasuraEntity::new).m_20719_().m_20699_(0.6F, 1.8F));
   }
}
