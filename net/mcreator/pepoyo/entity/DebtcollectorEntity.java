package net.mcreator.pepoyo.entity;

import net.mcreator.pepoyo.init.PepoyoModEntities;
import net.mcreator.pepoyo.procedures.DebtcollectorDangWanJiaYuGaiShiTiFaShengPengZhuangShiProcedure;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.SpawnPlacements.Type;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier.Builder;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.Heightmap.Types;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages.SpawnEntity;
import net.minecraftforge.registries.ForgeRegistries;

public class DebtcollectorEntity extends Monster {
   public DebtcollectorEntity(SpawnEntity packet, Level world) {
      this((EntityType)PepoyoModEntities.DEBTCOLLECTOR.get(), world);
   }

   public DebtcollectorEntity(EntityType<DebtcollectorEntity> type, Level world) {
      super(type, world);
      this.m_274367_(0.6F);
      this.f_21364_ = 0;
      this.m_21557_(false);
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
      this.f_21346_.m_25352_(2, new NearestAttackableTargetGoal(this, Player.class, false, false));
      this.f_21345_.m_25352_(3, new RandomStrollGoal(this, 1.0D));
      this.f_21346_.m_25352_(4, new HurtByTargetGoal(this, new Class[0]));
      this.f_21345_.m_25352_(5, new RandomLookAroundGoal(this));
      this.f_21345_.m_25352_(6, new FloatGoal(this));
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

   public void m_6123_(Player sourceentity) {
      super.m_6123_(sourceentity);
      DebtcollectorDangWanJiaYuGaiShiTiFaShengPengZhuangShiProcedure.execute(this.m_9236_(), this.m_20185_(), this.m_20186_(), this.m_20189_(), this, sourceentity);
   }

   public static void init() {
      SpawnPlacements.m_21754_((EntityType)PepoyoModEntities.DEBTCOLLECTOR.get(), Type.ON_GROUND, Types.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> {
         return world.m_46791_() != Difficulty.PEACEFUL && Monster.m_219009_(world, pos, random) && Mob.m_217057_(entityType, world, reason, pos, random);
      });
   }

   public static Builder createAttributes() {
      Builder builder = Mob.m_21552_();
      builder = builder.m_22268_(Attributes.f_22279_, 0.4D);
      builder = builder.m_22268_(Attributes.f_22276_, 50.0D);
      builder = builder.m_22268_(Attributes.f_22284_, 10.0D);
      builder = builder.m_22268_(Attributes.f_22281_, 0.0D);
      builder = builder.m_22268_(Attributes.f_22277_, 64.0D);
      return builder;
   }
}
