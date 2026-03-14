package net.mcreator.pepoyo.entity;

import java.util.List;
import net.mcreator.pepoyo.init.PepoyoModBlocks;
import net.mcreator.pepoyo.init.PepoyoModEntities;
import net.mcreator.pepoyo.init.PepoyoModItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.Entity.RemovalReason;
import net.minecraft.world.entity.SpawnPlacements.Type;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier.Builder;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.MoveBackToVillageGoal;
import net.minecraft.world.entity.ai.goal.OpenDoorGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap.Types;
import net.minecraftforge.event.ForgeEventFactory;
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

public class ShimiyasosuEntity extends TamableAnimal implements GeoEntity {
   public static final EntityDataAccessor<Boolean> SHOOT;
   public static final EntityDataAccessor<String> ANIMATION;
   public static final EntityDataAccessor<String> TEXTURE;
   private final AnimatableInstanceCache cache;
   private boolean swinging;
   private boolean lastloop;
   private long lastSwing;
   public String animationprocedure;
   String prevAnim;

   public ShimiyasosuEntity(SpawnEntity packet, Level world) {
      this((EntityType)PepoyoModEntities.SHIMIYASOSU.get(), world);
   }

   public ShimiyasosuEntity(EntityType<ShimiyasosuEntity> type, Level world) {
      super(type, world);
      this.cache = GeckoLibUtil.createInstanceCache(this);
      this.animationprocedure = "empty";
      this.prevAnim = "empty";
      this.f_21364_ = 5;
      this.m_21557_(false);
      this.m_274367_(0.6F);
   }

   protected void m_8097_() {
      super.m_8097_();
      this.f_19804_.m_135372_(SHOOT, false);
      this.f_19804_.m_135372_(ANIMATION, "undefined");
      this.f_19804_.m_135372_(TEXTURE, "shimiya_sosu");
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
      this.f_21345_.m_25352_(2, new OwnerHurtByTargetGoal(this));
      this.f_21346_.m_25352_(3, new OwnerHurtTargetGoal(this));
      this.f_21345_.m_25352_(4, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F, false));
      this.f_21345_.m_25352_(5, new RandomStrollGoal(this, 1.0D));
      this.f_21346_.m_25352_(6, (new HurtByTargetGoal(this, new Class[0])).m_26044_(new Class[0]));
      this.f_21345_.m_25352_(7, new RandomLookAroundGoal(this));
      this.f_21345_.m_25352_(8, new FloatGoal(this));
      this.f_21345_.m_25352_(9, new OpenDoorGoal(this, true));
      this.f_21345_.m_25352_(10, new OpenDoorGoal(this, false));
      this.f_21345_.m_25352_(11, new MoveBackToVillageGoal(this, 0.6D, false));
   }

   public MobType m_6336_() {
      return MobType.f_21640_;
   }

   public SoundEvent m_7975_(DamageSource ds) {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
   }

   public SoundEvent m_5592_() {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
   }

   public void m_7380_(CompoundTag compound) {
      super.m_7380_(compound);
      compound.m_128359_("Texture", this.getTexture());
   }

   public void m_7378_(CompoundTag compound) {
      super.m_7378_(compound);
      if (compound.m_128441_("Texture")) {
         this.setTexture(compound.m_128461_("Texture"));
      }

   }

   public InteractionResult m_6071_(Player sourceentity, InteractionHand hand) {
      ItemStack itemstack = sourceentity.m_21120_(hand);
      InteractionResult retval = InteractionResult.m_19078_(this.m_9236_().m_5776_());
      Item item = itemstack.m_41720_();
      if (itemstack.m_41720_() instanceof SpawnEggItem) {
         retval = super.m_6071_(sourceentity, hand);
      } else if (this.m_9236_().m_5776_()) {
         retval = (!this.m_21824_() || !this.m_21830_(sourceentity)) && !this.m_6898_(itemstack) ? InteractionResult.PASS : InteractionResult.m_19078_(this.m_9236_().m_5776_());
      } else if (this.m_21824_()) {
         if (this.m_21830_(sourceentity)) {
            if (item.m_41472_() && this.m_6898_(itemstack) && this.m_21223_() < this.m_21233_()) {
               this.m_142075_(sourceentity, hand, itemstack);
               this.m_5634_((float)item.m_41473_().m_38744_());
               retval = InteractionResult.m_19078_(this.m_9236_().m_5776_());
            } else if (this.m_6898_(itemstack) && this.m_21223_() < this.m_21233_()) {
               this.m_142075_(sourceentity, hand, itemstack);
               this.m_5634_(4.0F);
               retval = InteractionResult.m_19078_(this.m_9236_().m_5776_());
            } else {
               retval = super.m_6071_(sourceentity, hand);
            }
         }
      } else if (this.m_6898_(itemstack)) {
         this.m_142075_(sourceentity, hand, itemstack);
         if (this.f_19796_.m_188503_(3) == 0 && !ForgeEventFactory.onAnimalTame(this, sourceentity)) {
            this.m_21828_(sourceentity);
            this.m_9236_().m_7605_(this, (byte)7);
         } else {
            this.m_9236_().m_7605_(this, (byte)6);
         }

         this.m_21530_();
         retval = InteractionResult.m_19078_(this.m_9236_().m_5776_());
      } else {
         retval = super.m_6071_(sourceentity, hand);
         if (retval == InteractionResult.SUCCESS || retval == InteractionResult.CONSUME) {
            this.m_21530_();
         }
      }

      return retval;
   }

   public void m_6075_() {
      super.m_6075_();
      this.m_6210_();
   }

   public EntityDimensions m_6972_(Pose p_33597_) {
      return super.m_6972_(p_33597_).m_20388_(1.0F);
   }

   public AgeableMob m_142606_(ServerLevel serverWorld, AgeableMob ageable) {
      ShimiyasosuEntity retval = (ShimiyasosuEntity)((EntityType)PepoyoModEntities.SHIMIYASOSU.get()).m_20615_(serverWorld);
      retval.m_6518_(serverWorld, serverWorld.m_6436_(retval.m_20183_()), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
      return retval;
   }

   public boolean m_6898_(ItemStack stack) {
      return List.of(new Item[]{Blocks.f_50092_.m_5456_(), Blocks.f_50145_.m_5456_(), Items.f_42446_, Items.f_42447_, Items.f_42456_, Items.f_42457_, Items.f_42458_, Items.f_42459_, Items.f_151057_, Items.f_220210_, Items.f_42448_, Items.f_42455_, Items.f_151055_, Items.f_42410_, Items.f_42436_, Items.f_42437_, Items.f_42398_, Items.f_42751_, Items.f_42399_, Items.f_42400_, Items.f_42718_, Items.f_42401_, Items.f_42402_, Items.f_42403_, Items.f_42404_, Items.f_42405_, Items.f_42619_, Items.f_42620_, Items.f_42674_, Items.f_42675_, Items.f_42687_, Items.f_42677_, Items.f_42406_, Items.f_42577_, Items.f_271133_, Items.f_276594_, Items.f_42484_, Items.f_42454_, Items.f_42450_, Items.f_42460_, Items.f_42691_, Items.f_42461_, Items.f_41909_, Items.f_42516_, Items.f_42576_, Items.f_42518_, Items.f_42521_, Items.f_42525_, Items.f_42500_, Items.f_42501_, Items.f_42502_, Blocks.f_152525_.m_5456_(), Blocks.f_152526_.m_5456_(), Blocks.f_152527_.m_5456_(), Blocks.f_152528_.m_5456_(), Blocks.f_152529_.m_5456_(), Blocks.f_152530_.m_5456_(), Blocks.f_152531_.m_5456_(), Blocks.f_152532_.m_5456_(), Blocks.f_152533_.m_5456_(), Blocks.f_152534_.m_5456_(), Blocks.f_152535_.m_5456_(), Blocks.f_152536_.m_5456_(), Blocks.f_152485_.m_5456_(), Blocks.f_152486_.m_5456_(), Blocks.f_152487_.m_5456_(), Blocks.f_152488_.m_5456_(), Blocks.f_152489_.m_5456_(), Items.f_42503_, Items.f_42572_, Items.f_42575_, Items.f_42578_, Items.f_42780_, Items.f_151079_, Items.f_42526_, Items.f_42527_, Items.f_42528_, Items.f_42529_, Items.f_42530_, Items.f_42531_, Items.f_42485_, Items.f_42486_, Items.f_42579_, Items.f_42580_, Items.f_42581_, Items.f_42582_, Items.f_42697_, Items.f_42698_, Items.f_42648_, Items.f_42649_, Items.f_42699_, Items.f_42658_, Items.f_42659_, Items.f_42583_, Items.f_42584_, Items.f_42545_, Items.f_42729_, Items.f_42748_, Items.f_42730_, Items.f_42731_, Items.f_42732_, Items.f_42733_, Items.f_42734_, Items.f_42586_, Items.f_42588_, Items.f_42590_, Items.f_42589_, Items.f_42736_, Items.f_42739_, Items.f_42735_, Items.f_42591_, Items.f_42592_, Items.f_42585_, Items.f_42593_, Items.f_42542_, Items.f_42612_, Items.f_42613_, Items.f_42678_, Items.f_42679_, Items.f_42680_, Items.f_42681_, Items.f_42682_, Items.f_260451_, Items.f_42787_, Items.f_220219_, (Item)PepoyoModItems.RAMEN.get(), (Item)PepoyoModItems.RICEBALL.get(), (Item)PepoyoModItems.EYE.get(), (Item)PepoyoModItems.EMPTYBOWL.get(), (Item)PepoyoModItems.EATABLERAMEN.get(), (Item)PepoyoModItems.POSONOUSRAMEN.get(), ((Block)PepoyoModBlocks.SHARDS.get()).m_5456_(), Blocks.f_50111_.m_5456_(), Blocks.f_50112_.m_5456_(), Blocks.f_50113_.m_5456_(), Blocks.f_50114_.m_5456_(), Blocks.f_50115_.m_5456_(), Blocks.f_50116_.m_5456_(), Blocks.f_50117_.m_5456_(), Blocks.f_50118_.m_5456_(), Blocks.f_50119_.m_5456_(), Blocks.f_50120_.m_5456_(), Blocks.f_50121_.m_5456_(), Blocks.f_50071_.m_5456_(), Blocks.f_50070_.m_5456_(), Blocks.f_271329_.m_5456_(), Blocks.f_271445_.m_5456_(), Blocks.f_50355_.m_5456_(), Blocks.f_50356_.m_5456_(), Blocks.f_50359_.m_5456_(), Blocks.f_50360_.m_5456_(), Blocks.f_50357_.m_5456_(), Blocks.f_50358_.m_5456_(), Blocks.f_276668_.m_5456_()}).contains(stack.m_41720_());
   }

   public void m_8107_() {
      super.m_8107_();
      this.m_21203_();
   }

   public static void init() {
      SpawnPlacements.m_21754_((EntityType)PepoyoModEntities.SHIMIYASOSU.get(), Type.ON_GROUND, Types.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> {
         return world.m_46791_() != Difficulty.PEACEFUL && Monster.m_219009_(world, pos, random) && Mob.m_217057_(entityType, world, reason, pos, random);
      });
   }

   public static Builder createAttributes() {
      Builder builder = Mob.m_21552_();
      builder = builder.m_22268_(Attributes.f_22279_, 0.25D);
      builder = builder.m_22268_(Attributes.f_22276_, 120.0D);
      builder = builder.m_22268_(Attributes.f_22284_, 8.0D);
      builder = builder.m_22268_(Attributes.f_22281_, 12.0D);
      builder = builder.m_22268_(Attributes.f_22277_, 64.0D);
      return builder;
   }

   private PlayState movementPredicate(AnimationState event) {
      if (this.animationprocedure.equals("empty")) {
         if (!event.isMoving() && event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.15F) {
            return this.m_21224_() ? event.setAndContinue(RawAnimation.begin().thenPlay("animation.shimiya_sosu.death")) : event.setAndContinue(RawAnimation.begin().thenLoop("animation.shimiya_sosu.ambient"));
         } else {
            return event.setAndContinue(RawAnimation.begin().thenLoop("animation.shimiya_sosu.walk"));
         }
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
         return event.setAndContinue(RawAnimation.begin().thenPlay("animation.shimiya_sosu.attack"));
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
      SHOOT = SynchedEntityData.m_135353_(ShimiyasosuEntity.class, EntityDataSerializers.f_135035_);
      ANIMATION = SynchedEntityData.m_135353_(ShimiyasosuEntity.class, EntityDataSerializers.f_135030_);
      TEXTURE = SynchedEntityData.m_135353_(ShimiyasosuEntity.class, EntityDataSerializers.f_135030_);
   }
}
