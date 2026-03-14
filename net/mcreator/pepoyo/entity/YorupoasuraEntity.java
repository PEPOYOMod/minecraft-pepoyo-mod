package net.mcreator.pepoyo.entity;

import javax.annotation.Nullable;
import net.mcreator.pepoyo.init.PepoyoModEntities;
import net.mcreator.pepoyo.procedures.YorupoasuraDangShiTiChuShiShengChengShiProcedure;
import net.mcreator.pepoyo.procedures.YorupoasuraDangShiTiGengXinK1eShiProcedure;
import net.mcreator.pepoyo.procedures.YorupoasuraDangShiTiShouShangShiProcedure;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.BossEvent.BossBarColor;
import net.minecraft.world.BossEvent.BossBarOverlay;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.Entity.RemovalReason;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier.Builder;
import net.minecraft.world.entity.raid.Raider;
import net.minecraft.world.entity.raid.Raid.RaiderType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages.SpawnEntity;
import net.minecraftforge.registries.ForgeRegistries;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimatableManager.ControllerRegistrar;
import software.bernie.geckolib.core.animation.AnimationController.State;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class YorupoasuraEntity extends Raider implements GeoEntity {
   public static final EntityDataAccessor<Boolean> SHOOT;
   public static final EntityDataAccessor<String> ANIMATION;
   public static final EntityDataAccessor<String> TEXTURE;
   public static final EntityDataAccessor<Integer> DATA_hurt_time;
   public static final EntityDataAccessor<Boolean> DATA_grinder;
   public static final EntityDataAccessor<Integer> DATA_grinder_time;
   public static final EntityDataAccessor<Boolean> DATA_hurt_allow;
   public static final EntityDataAccessor<Boolean> DATA_lock_health;
   public static final EntityDataAccessor<Integer> DATA_health_set;
   private final AnimatableInstanceCache cache;
   private boolean swinging;
   private boolean lastloop;
   private long lastSwing;
   public String animationprocedure;
   private final ServerBossEvent bossInfo;
   String prevAnim;

   public YorupoasuraEntity(SpawnEntity packet, Level world) {
      this((EntityType)PepoyoModEntities.YORUPOASURA.get(), world);
   }

   public YorupoasuraEntity(EntityType<YorupoasuraEntity> type, Level world) {
      super(type, world);
      this.cache = GeckoLibUtil.createInstanceCache(this);
      this.animationprocedure = "empty";
      this.bossInfo = new ServerBossEvent(this.m_5446_(), BossBarColor.YELLOW, BossBarOverlay.NOTCHED_10);
      this.prevAnim = "empty";
      this.f_21364_ = 45;
      this.m_21557_(false);
      this.m_274367_(5.0F);
      this.m_21530_();
      this.m_8061_(EquipmentSlot.CHEST, new ItemStack(Items.f_42481_));
   }

   protected void m_8097_() {
      super.m_8097_();
      this.f_19804_.m_135372_(SHOOT, false);
      this.f_19804_.m_135372_(ANIMATION, "undefined");
      this.f_19804_.m_135372_(TEXTURE, "yorupo");
      this.f_19804_.m_135372_(DATA_hurt_time, 0);
      this.f_19804_.m_135372_(DATA_grinder, false);
      this.f_19804_.m_135372_(DATA_grinder_time, 0);
      this.f_19804_.m_135372_(DATA_hurt_allow, false);
      this.f_19804_.m_135372_(DATA_lock_health, true);
      this.f_19804_.m_135372_(DATA_health_set, 1000);
   }

   public void setTexture(String texture) {
      this.f_19804_.m_135381_(TEXTURE, texture);
   }

   public String getTexture() {
      return (String)this.f_19804_.m_135370_(TEXTURE);
   }

   public Packet<ClientGamePacketListener> m_5654_() {
      return NetworkHooks.getEntitySpawningPacket(this);
   }

   protected void m_8099_() {
      super.m_8099_();
   }

   public MobType m_6336_() {
      return MobType.f_21641_;
   }

   public boolean m_6785_(double distanceToClosestPlayer) {
      return false;
   }

   public SoundEvent m_7975_(DamageSource ds) {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
   }

   public SoundEvent m_5592_() {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
   }

   public SoundEvent m_7930_() {
      return SoundEvents.f_271165_;
   }

   public boolean m_6469_(DamageSource source, float amount) {
      YorupoasuraDangShiTiShouShangShiProcedure.execute(this.m_9236_(), this.m_20185_(), this.m_20186_(), this.m_20189_(), this);
      if (source.m_276093_(DamageTypes.f_268631_)) {
         return false;
      } else {
         return source.m_276093_(DamageTypes.f_268585_) ? false : super.m_6469_(source, amount);
      }
   }

   public SpawnGroupData m_6518_(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
      SpawnGroupData retval = super.m_6518_(world, difficulty, reason, livingdata, tag);
      YorupoasuraDangShiTiChuShiShengChengShiProcedure.execute(world, this.m_20185_(), this.m_20186_(), this.m_20189_(), this);
      return retval;
   }

   public void m_7380_(CompoundTag compound) {
      super.m_7380_(compound);
      compound.m_128359_("Texture", this.getTexture());
      compound.m_128405_("Datahurt_time", (Integer)this.f_19804_.m_135370_(DATA_hurt_time));
      compound.m_128379_("Datagrinder", (Boolean)this.f_19804_.m_135370_(DATA_grinder));
      compound.m_128405_("Datagrinder_time", (Integer)this.f_19804_.m_135370_(DATA_grinder_time));
      compound.m_128379_("Datahurt_allow", (Boolean)this.f_19804_.m_135370_(DATA_hurt_allow));
      compound.m_128379_("Datalock_health", (Boolean)this.f_19804_.m_135370_(DATA_lock_health));
      compound.m_128405_("Datahealth_set", (Integer)this.f_19804_.m_135370_(DATA_health_set));
   }

   public void m_7378_(CompoundTag compound) {
      super.m_7378_(compound);
      if (compound.m_128441_("Texture")) {
         this.setTexture(compound.m_128461_("Texture"));
      }

      if (compound.m_128441_("Datahurt_time")) {
         this.f_19804_.m_135381_(DATA_hurt_time, compound.m_128451_("Datahurt_time"));
      }

      if (compound.m_128441_("Datagrinder")) {
         this.f_19804_.m_135381_(DATA_grinder, compound.m_128471_("Datagrinder"));
      }

      if (compound.m_128441_("Datagrinder_time")) {
         this.f_19804_.m_135381_(DATA_grinder_time, compound.m_128451_("Datagrinder_time"));
      }

      if (compound.m_128441_("Datahurt_allow")) {
         this.f_19804_.m_135381_(DATA_hurt_allow, compound.m_128471_("Datahurt_allow"));
      }

      if (compound.m_128441_("Datalock_health")) {
         this.f_19804_.m_135381_(DATA_lock_health, compound.m_128471_("Datalock_health"));
      }

      if (compound.m_128441_("Datahealth_set")) {
         this.f_19804_.m_135381_(DATA_health_set, compound.m_128451_("Datahealth_set"));
      }

   }

   public void m_6075_() {
      super.m_6075_();
      YorupoasuraDangShiTiGengXinK1eShiProcedure.execute();
      this.m_6210_();
   }

   public EntityDimensions m_6972_(Pose p_33597_) {
      return super.m_6972_(p_33597_).m_20388_(1.0F);
   }

   public boolean m_6072_() {
      return false;
   }

   public void m_6457_(ServerPlayer player) {
      super.m_6457_(player);
      this.bossInfo.m_6543_(player);
   }

   public void m_6452_(ServerPlayer player) {
      super.m_6452_(player);
      this.bossInfo.m_6539_(player);
   }

   public void m_8024_() {
      super.m_8024_();
      this.bossInfo.m_142711_(this.m_21223_() / this.m_21233_());
   }

   public void m_8107_() {
      super.m_8107_();
      this.m_21203_();
   }

   public static void init() {
      RaiderType.create("yorupoasura", (EntityType)PepoyoModEntities.YORUPOASURA.get(), new int[]{0, 4, 3, 3, 4, 4, 4, 2});
   }

   public void m_7895_(int num, boolean logic) {
   }

   public static Builder createAttributes() {
      Builder builder = Mob.m_21552_();
      builder = builder.m_22268_(Attributes.f_22279_, 0.3D);
      builder = builder.m_22268_(Attributes.f_22276_, 1000.0D);
      builder = builder.m_22268_(Attributes.f_22284_, 100.0D);
      builder = builder.m_22268_(Attributes.f_22281_, 180.0D);
      builder = builder.m_22268_(Attributes.f_22277_, 16.0D);
      builder = builder.m_22268_(Attributes.f_22278_, 20.0D);
      builder = builder.m_22268_(Attributes.f_22282_, 0.5D);
      return builder;
   }

   private PlayState movementPredicate(AnimationState event) {
      if (this.animationprocedure.equals("empty")) {
         return !event.isMoving() && event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.15F ? event.setAndContinue(RawAnimation.begin().thenLoop("animation.yorupo.ambient")) : event.setAndContinue(RawAnimation.begin().thenLoop("animation.yorupo.hunting"));
      } else {
         return PlayState.STOP;
      }
   }

   private PlayState attackingPredicate(AnimationState event) {
      double d1 = this.m_20185_() - this.f_19790_;
      double d0 = this.m_20189_() - this.f_19792_;
      float velocity = (float)Math.sqrt(d1 * d1 + d0 * d0);
      if (this.m_21324_(event.getPartialTick()) > 0.0F && !this.swinging) {
         this.swinging = true;
         this.lastSwing = this.m_9236_().m_46467_();
      }

      if (this.swinging && this.lastSwing + 7L <= this.m_9236_().m_46467_()) {
         this.swinging = false;
      }

      if (this.swinging && event.getController().getAnimationState() == State.STOPPED) {
         event.getController().forceAnimationReset();
         return event.setAndContinue(RawAnimation.begin().thenPlay("animation.yorupo.attack"));
      } else {
         return PlayState.CONTINUE;
      }
   }

   private PlayState procedurePredicate(AnimationState event) {
      if ((this.animationprocedure.equals("empty") || event.getController().getAnimationState() != State.STOPPED) && (this.animationprocedure.equals(this.prevAnim) || this.animationprocedure.equals("empty"))) {
         if (this.animationprocedure.equals("empty")) {
            this.prevAnim = "empty";
            return PlayState.STOP;
         }
      } else {
         if (!this.animationprocedure.equals(this.prevAnim)) {
            event.getController().forceAnimationReset();
         }

         event.getController().setAnimation(RawAnimation.begin().thenPlay(this.animationprocedure));
         if (event.getController().getAnimationState() == State.STOPPED) {
            this.animationprocedure = "empty";
            event.getController().forceAnimationReset();
         }
      }

      this.prevAnim = this.animationprocedure;
      return PlayState.CONTINUE;
   }

   protected void m_6153_() {
      ++this.f_20919_;
      if (this.f_20919_ == 20) {
         this.m_142687_(RemovalReason.KILLED);
         this.m_21226_();
      }

   }

   public String getSyncedAnimation() {
      return (String)this.f_19804_.m_135370_(ANIMATION);
   }

   public void setAnimation(String animation) {
      this.f_19804_.m_135381_(ANIMATION, animation);
   }

   public void registerControllers(ControllerRegistrar data) {
      data.add(new AnimationController[]{new AnimationController(this, "movement", 4, this::movementPredicate)});
      data.add(new AnimationController[]{new AnimationController(this, "attacking", 4, this::attackingPredicate)});
      data.add(new AnimationController[]{new AnimationController(this, "procedure", 4, this::procedurePredicate)});
   }

   public AnimatableInstanceCache getAnimatableInstanceCache() {
      return this.cache;
   }

   static {
      SHOOT = SynchedEntityData.m_135353_(YorupoasuraEntity.class, EntityDataSerializers.f_135035_);
      ANIMATION = SynchedEntityData.m_135353_(YorupoasuraEntity.class, EntityDataSerializers.f_135030_);
      TEXTURE = SynchedEntityData.m_135353_(YorupoasuraEntity.class, EntityDataSerializers.f_135030_);
      DATA_hurt_time = SynchedEntityData.m_135353_(YorupoasuraEntity.class, EntityDataSerializers.f_135028_);
      DATA_grinder = SynchedEntityData.m_135353_(YorupoasuraEntity.class, EntityDataSerializers.f_135035_);
      DATA_grinder_time = SynchedEntityData.m_135353_(YorupoasuraEntity.class, EntityDataSerializers.f_135028_);
      DATA_hurt_allow = SynchedEntityData.m_135353_(YorupoasuraEntity.class, EntityDataSerializers.f_135035_);
      DATA_lock_health = SynchedEntityData.m_135353_(YorupoasuraEntity.class, EntityDataSerializers.f_135035_);
      DATA_health_set = SynchedEntityData.m_135353_(YorupoasuraEntity.class, EntityDataSerializers.f_135028_);
   }
}
