package net.mcreator.pepoyo.entity;

import javax.annotation.Nullable;
import net.mcreator.pepoyo.init.PepoyoModEntities;
import net.mcreator.pepoyo.procedures.YorupobossDangShiTiChuShiShengChengShiProcedure;
import net.mcreator.pepoyo.procedures.YorupobossDangShiTiGengXinKeShiProcedure;
import net.mcreator.pepoyo.procedures.YorupobossDangShiTiShouShangShiProcedure;
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
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.BossEvent.BossBarColor;
import net.minecraft.world.BossEvent.BossBarOverlay;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.Entity.RemovalReason;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier.Builder;
import net.minecraft.world.entity.ai.goal.BreakDoorGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.OpenDoorGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
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

public class YorupobossEntity extends Monster implements GeoEntity {
   public static final EntityDataAccessor<Boolean> SHOOT;
   public static final EntityDataAccessor<String> ANIMATION;
   public static final EntityDataAccessor<String> TEXTURE;
   public static final EntityDataAccessor<Integer> DATA_glow_time;
   public static final EntityDataAccessor<Boolean> DATA_glow_bearing;
   public static final EntityDataAccessor<Integer> DATA_hurt_time;
   public static final EntityDataAccessor<Boolean> DATA_flywheel;
   public static final EntityDataAccessor<Boolean> DATA_water_CD;
   public static final EntityDataAccessor<Boolean> DATA_phase_2;
   public static final EntityDataAccessor<Integer> DATA_fire_aspect_times;
   public static final EntityDataAccessor<Boolean> DATA_active;
   public static final EntityDataAccessor<Boolean> DATA_attract;
   public static final EntityDataAccessor<Integer> DATA_attract_tick;
   public static final EntityDataAccessor<Integer> DATA_hurt_skill;
   public static final EntityDataAccessor<Boolean> DATA_summonyande;
   public static final EntityDataAccessor<Integer> DATA_water_time;
   public static final EntityDataAccessor<Boolean> DATA_lock_blood;
   private final AnimatableInstanceCache cache;
   private boolean swinging;
   private boolean lastloop;
   private long lastSwing;
   public String animationprocedure;
   private final ServerBossEvent bossInfo;
   String prevAnim;

   public YorupobossEntity(SpawnEntity packet, Level world) {
      this((EntityType)PepoyoModEntities.YORUPOBOSS.get(), world);
   }

   public YorupobossEntity(EntityType<YorupobossEntity> type, Level world) {
      super(type, world);
      this.cache = GeckoLibUtil.createInstanceCache(this);
      this.animationprocedure = "empty";
      this.bossInfo = new ServerBossEvent(this.m_5446_(), BossBarColor.RED, BossBarOverlay.NOTCHED_6);
      this.prevAnim = "empty";
      this.f_21364_ = 50;
      this.m_21557_(false);
      this.m_274367_(5.0F);
      this.m_21530_();
   }

   protected void m_8097_() {
      super.m_8097_();
      this.f_19804_.m_135372_(SHOOT, false);
      this.f_19804_.m_135372_(ANIMATION, "undefined");
      this.f_19804_.m_135372_(TEXTURE, "yorupo_rampage");
      this.f_19804_.m_135372_(DATA_glow_time, 0);
      this.f_19804_.m_135372_(DATA_glow_bearing, true);
      this.f_19804_.m_135372_(DATA_hurt_time, 0);
      this.f_19804_.m_135372_(DATA_flywheel, false);
      this.f_19804_.m_135372_(DATA_water_CD, true);
      this.f_19804_.m_135372_(DATA_phase_2, false);
      this.f_19804_.m_135372_(DATA_fire_aspect_times, 0);
      this.f_19804_.m_135372_(DATA_active, false);
      this.f_19804_.m_135372_(DATA_attract, false);
      this.f_19804_.m_135372_(DATA_attract_tick, 0);
      this.f_19804_.m_135372_(DATA_hurt_skill, 0);
      this.f_19804_.m_135372_(DATA_summonyande, false);
      this.f_19804_.m_135372_(DATA_water_time, 0);
      this.f_19804_.m_135372_(DATA_lock_blood, false);
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
      this.f_21345_.m_25352_(1, new MeleeAttackGoal(this, 1.2D, false) {
         protected double m_6639_(LivingEntity entity) {
            return (double)(this.f_25540_.m_20205_() * this.f_25540_.m_20205_() + entity.m_20205_());
         }
      });
      this.f_21345_.m_25352_(2, new RandomStrollGoal(this, 1.0D));
      this.f_21346_.m_25352_(3, new HurtByTargetGoal(this, new Class[0]));
      this.f_21346_.m_25352_(4, new NearestAttackableTargetGoal(this, Player.class, false, false));
      this.f_21345_.m_25352_(5, new OpenDoorGoal(this, false));
      this.f_21345_.m_25352_(6, new BreakDoorGoal(this, (e) -> {
         return true;
      }));
      this.f_21345_.m_25352_(7, new RandomLookAroundGoal(this));
      this.f_21345_.m_25352_(8, new FloatGoal(this));
   }

   public MobType m_6336_() {
      return MobType.f_21640_;
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

   public boolean m_6469_(DamageSource source, float amount) {
      YorupobossDangShiTiShouShangShiProcedure.execute(this.m_9236_(), this.m_20185_(), this.m_20186_(), this.m_20189_(), this, source.m_7639_());
      if (source.m_276093_(DamageTypes.f_268671_)) {
         return false;
      } else if (source.m_276093_(DamageTypes.f_268585_)) {
         return false;
      } else if (source.m_276093_(DamageTypes.f_268450_)) {
         return false;
      } else if (source.m_276093_(DamageTypes.f_268565_)) {
         return false;
      } else if (source.m_276093_(DamageTypes.f_268493_)) {
         return false;
      } else {
         return source.m_276093_(DamageTypes.f_268641_) ? false : super.m_6469_(source, amount);
      }
   }

   public SpawnGroupData m_6518_(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
      SpawnGroupData retval = super.m_6518_(world, difficulty, reason, livingdata, tag);
      YorupobossDangShiTiChuShiShengChengShiProcedure.execute(world, this.m_20185_(), this.m_20186_(), this.m_20189_(), this);
      return retval;
   }

   public void m_7380_(CompoundTag compound) {
      super.m_7380_(compound);
      compound.m_128359_("Texture", this.getTexture());
      compound.m_128405_("Dataglow_time", (Integer)this.f_19804_.m_135370_(DATA_glow_time));
      compound.m_128379_("Dataglow_bearing", (Boolean)this.f_19804_.m_135370_(DATA_glow_bearing));
      compound.m_128405_("Datahurt_time", (Integer)this.f_19804_.m_135370_(DATA_hurt_time));
      compound.m_128379_("Dataflywheel", (Boolean)this.f_19804_.m_135370_(DATA_flywheel));
      compound.m_128379_("Datawater_CD", (Boolean)this.f_19804_.m_135370_(DATA_water_CD));
      compound.m_128379_("Dataphase_2", (Boolean)this.f_19804_.m_135370_(DATA_phase_2));
      compound.m_128405_("Datafire_aspect_times", (Integer)this.f_19804_.m_135370_(DATA_fire_aspect_times));
      compound.m_128379_("Dataactive", (Boolean)this.f_19804_.m_135370_(DATA_active));
      compound.m_128379_("Dataattract", (Boolean)this.f_19804_.m_135370_(DATA_attract));
      compound.m_128405_("Dataattract_tick", (Integer)this.f_19804_.m_135370_(DATA_attract_tick));
      compound.m_128405_("Datahurt_skill", (Integer)this.f_19804_.m_135370_(DATA_hurt_skill));
      compound.m_128379_("Datasummonyande", (Boolean)this.f_19804_.m_135370_(DATA_summonyande));
      compound.m_128405_("Datawater_time", (Integer)this.f_19804_.m_135370_(DATA_water_time));
      compound.m_128379_("Datalock_blood", (Boolean)this.f_19804_.m_135370_(DATA_lock_blood));
   }

   public void m_7378_(CompoundTag compound) {
      super.m_7378_(compound);
      if (compound.m_128441_("Texture")) {
         this.setTexture(compound.m_128461_("Texture"));
      }

      if (compound.m_128441_("Dataglow_time")) {
         this.f_19804_.m_135381_(DATA_glow_time, compound.m_128451_("Dataglow_time"));
      }

      if (compound.m_128441_("Dataglow_bearing")) {
         this.f_19804_.m_135381_(DATA_glow_bearing, compound.m_128471_("Dataglow_bearing"));
      }

      if (compound.m_128441_("Datahurt_time")) {
         this.f_19804_.m_135381_(DATA_hurt_time, compound.m_128451_("Datahurt_time"));
      }

      if (compound.m_128441_("Dataflywheel")) {
         this.f_19804_.m_135381_(DATA_flywheel, compound.m_128471_("Dataflywheel"));
      }

      if (compound.m_128441_("Datawater_CD")) {
         this.f_19804_.m_135381_(DATA_water_CD, compound.m_128471_("Datawater_CD"));
      }

      if (compound.m_128441_("Dataphase_2")) {
         this.f_19804_.m_135381_(DATA_phase_2, compound.m_128471_("Dataphase_2"));
      }

      if (compound.m_128441_("Datafire_aspect_times")) {
         this.f_19804_.m_135381_(DATA_fire_aspect_times, compound.m_128451_("Datafire_aspect_times"));
      }

      if (compound.m_128441_("Dataactive")) {
         this.f_19804_.m_135381_(DATA_active, compound.m_128471_("Dataactive"));
      }

      if (compound.m_128441_("Dataattract")) {
         this.f_19804_.m_135381_(DATA_attract, compound.m_128471_("Dataattract"));
      }

      if (compound.m_128441_("Dataattract_tick")) {
         this.f_19804_.m_135381_(DATA_attract_tick, compound.m_128451_("Dataattract_tick"));
      }

      if (compound.m_128441_("Datahurt_skill")) {
         this.f_19804_.m_135381_(DATA_hurt_skill, compound.m_128451_("Datahurt_skill"));
      }

      if (compound.m_128441_("Datasummonyande")) {
         this.f_19804_.m_135381_(DATA_summonyande, compound.m_128471_("Datasummonyande"));
      }

      if (compound.m_128441_("Datawater_time")) {
         this.f_19804_.m_135381_(DATA_water_time, compound.m_128451_("Datawater_time"));
      }

      if (compound.m_128441_("Datalock_blood")) {
         this.f_19804_.m_135381_(DATA_lock_blood, compound.m_128471_("Datalock_blood"));
      }

   }

   public void m_6075_() {
      super.m_6075_();
      YorupobossDangShiTiGengXinKeShiProcedure.execute(this.m_9236_(), this.m_20185_(), this.m_20186_(), this.m_20189_(), this);
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

   public static void init() {
   }

   public static Builder createAttributes() {
      Builder builder = Mob.m_21552_();
      builder = builder.m_22268_(Attributes.f_22279_, 0.4D);
      builder = builder.m_22268_(Attributes.f_22276_, 850.0D);
      builder = builder.m_22268_(Attributes.f_22284_, 18.0D);
      builder = builder.m_22268_(Attributes.f_22281_, 14.0D);
      builder = builder.m_22268_(Attributes.f_22277_, 64.0D);
      builder = builder.m_22268_(Attributes.f_22278_, 1.0D);
      builder = builder.m_22268_(Attributes.f_22282_, 0.3D);
      return builder;
   }

   private PlayState movementPredicate(AnimationState event) {
      if (this.animationprocedure.equals("empty")) {
         return !event.isMoving() && event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.15F ? event.setAndContinue(RawAnimation.begin().thenLoop("animation.yorupo.ambient")) : event.setAndContinue(RawAnimation.begin().thenLoop("animation.yorupo.hunting"));
      } else {
         return PlayState.STOP;
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
      data.add(new AnimationController[]{new AnimationController(this, "procedure", 4, this::procedurePredicate)});
   }

   public AnimatableInstanceCache getAnimatableInstanceCache() {
      return this.cache;
   }

   static {
      SHOOT = SynchedEntityData.m_135353_(YorupobossEntity.class, EntityDataSerializers.f_135035_);
      ANIMATION = SynchedEntityData.m_135353_(YorupobossEntity.class, EntityDataSerializers.f_135030_);
      TEXTURE = SynchedEntityData.m_135353_(YorupobossEntity.class, EntityDataSerializers.f_135030_);
      DATA_glow_time = SynchedEntityData.m_135353_(YorupobossEntity.class, EntityDataSerializers.f_135028_);
      DATA_glow_bearing = SynchedEntityData.m_135353_(YorupobossEntity.class, EntityDataSerializers.f_135035_);
      DATA_hurt_time = SynchedEntityData.m_135353_(YorupobossEntity.class, EntityDataSerializers.f_135028_);
      DATA_flywheel = SynchedEntityData.m_135353_(YorupobossEntity.class, EntityDataSerializers.f_135035_);
      DATA_water_CD = SynchedEntityData.m_135353_(YorupobossEntity.class, EntityDataSerializers.f_135035_);
      DATA_phase_2 = SynchedEntityData.m_135353_(YorupobossEntity.class, EntityDataSerializers.f_135035_);
      DATA_fire_aspect_times = SynchedEntityData.m_135353_(YorupobossEntity.class, EntityDataSerializers.f_135028_);
      DATA_active = SynchedEntityData.m_135353_(YorupobossEntity.class, EntityDataSerializers.f_135035_);
      DATA_attract = SynchedEntityData.m_135353_(YorupobossEntity.class, EntityDataSerializers.f_135035_);
      DATA_attract_tick = SynchedEntityData.m_135353_(YorupobossEntity.class, EntityDataSerializers.f_135028_);
      DATA_hurt_skill = SynchedEntityData.m_135353_(YorupobossEntity.class, EntityDataSerializers.f_135028_);
      DATA_summonyande = SynchedEntityData.m_135353_(YorupobossEntity.class, EntityDataSerializers.f_135035_);
      DATA_water_time = SynchedEntityData.m_135353_(YorupobossEntity.class, EntityDataSerializers.f_135028_);
      DATA_lock_blood = SynchedEntityData.m_135353_(YorupobossEntity.class, EntityDataSerializers.f_135035_);
   }
}
