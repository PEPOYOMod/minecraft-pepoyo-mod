package net.mcreator.pepoyo.procedures;

import java.util.Iterator;
import java.util.Map;
import net.mcreator.pepoyo.PepoyoMod;
import net.mcreator.pepoyo.entity.RamenbowlEntity;
import net.mcreator.pepoyo.entity.YorupobossEntity;
import net.mcreator.pepoyo.init.PepoyoModBlocks;
import net.mcreator.pepoyo.init.PepoyoModEntities;
import net.mcreator.pepoyo.init.PepoyoModItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class YorupobossDangShiTiShouShangShiProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
      if (entity != null && sourceentity != null) {
         boolean var10000;
         label282: {
            if (entity instanceof YorupobossEntity) {
               YorupobossEntity _datEntL0 = (YorupobossEntity)entity;
               if ((Boolean)_datEntL0.m_20088_().m_135370_(YorupobossEntity.DATA_active)) {
                  var10000 = true;
                  break label282;
               }
            }

            var10000 = false;
         }

         if (var10000) {
            YorupobossEntity _datEntI;
            YorupobossEntity _datEntSetL;
            if (entity instanceof YorupobossEntity) {
               _datEntI = (YorupobossEntity)entity;
               SynchedEntityData var29 = _datEntI.m_20088_();
               EntityDataAccessor var10001 = YorupobossEntity.DATA_hurt_time;
               int var10002;
               if (entity instanceof YorupobossEntity) {
                  _datEntSetL = (YorupobossEntity)entity;
                  var10002 = (Integer)_datEntSetL.m_20088_().m_135370_(YorupobossEntity.DATA_hurt_time);
               } else {
                  var10002 = 0;
               }

               var29.m_135381_(var10001, var10002 + 1);
            }

            int var31;
            if (entity instanceof YorupobossEntity) {
               _datEntI = (YorupobossEntity)entity;
               var31 = (Integer)_datEntI.m_20088_().m_135370_(YorupobossEntity.DATA_hurt_time);
            } else {
               var31 = 0;
            }

            if (var31 >= Mth.m_216271_(RandomSource.m_216327_(), 12, 40)) {
               if (entity instanceof YorupobossEntity) {
                  _datEntSetL = (YorupobossEntity)entity;
                  _datEntSetL.m_20088_().m_135381_(YorupobossEntity.DATA_hurt_time, 0);
               }

               if (entity instanceof YorupobossEntity) {
                  _datEntSetL = (YorupobossEntity)entity;
                  _datEntSetL.m_20088_().m_135381_(YorupobossEntity.DATA_hurt_skill, Mth.m_216271_(RandomSource.m_216327_(), 1, 4));
               }
            }

            if (entity instanceof YorupobossEntity) {
               _datEntI = (YorupobossEntity)entity;
               var31 = (Integer)_datEntI.m_20088_().m_135370_(YorupobossEntity.DATA_hurt_skill);
            } else {
               var31 = 0;
            }

            ServerLevel _level;
            if (var31 == 1) {
               if (entity instanceof YorupobossEntity) {
                  _datEntSetL = (YorupobossEntity)entity;
                  _datEntSetL.m_20088_().m_135381_(YorupobossEntity.DATA_hurt_skill, 0);
               }

               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle minecraft:dragon_breath ~ ~ ~ 0.1 1 0.1 0.5 100 force @a");
               }

               PepoyoMod.queueServerWork(2, () -> {
                  entity.m_20256_(new Vec3(entity.m_20154_().f_82479_ * 3.0D, entity.m_20154_().f_82480_ + 0.5D, entity.m_20154_().f_82481_));
                  PepoyoMod.queueServerWork(30, () -> {
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle minecraft:lava ~ ~ ~ 2 1 0.1 2 200 force @a");
                     }

                     if (world instanceof Level) {
                        Level _levelx = (Level)world;
                        if (!_levelx.m_5776_()) {
                           _levelx.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie_villager.cure")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                        } else {
                           _levelx.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie_villager.cure")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                        }
                     }

                     PepoyoMod.queueServerWork(20, () -> {
                        YorupobossEntity _datEntSetL;
                        if (entity instanceof YorupobossEntity) {
                           _datEntSetL = (YorupobossEntity)entity;
                           _datEntSetL.m_20088_().m_135381_(YorupobossEntity.DATA_attract, true);
                        }

                        if (entity instanceof YorupobossEntity) {
                           _datEntSetL = (YorupobossEntity)entity;
                           _datEntSetL.m_20088_().m_135381_(YorupobossEntity.DATA_active, false);
                        }

                     });
                  });
               });
            }

            if (entity instanceof YorupobossEntity) {
               _datEntI = (YorupobossEntity)entity;
               var31 = (Integer)_datEntI.m_20088_().m_135370_(YorupobossEntity.DATA_hurt_skill);
            } else {
               var31 = 0;
            }

            LightningBolt entityToSpawn;
            if (var31 == 2) {
               if (entity instanceof YorupobossEntity) {
                  _datEntSetL = (YorupobossEntity)entity;
                  _datEntSetL.m_20088_().m_135381_(YorupobossEntity.DATA_hurt_skill, 0);
               }

               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawn = (LightningBolt)EntityType.f_20465_.m_20615_(_level);
                  entityToSpawn.m_20219_(Vec3.m_82539_(BlockPos.m_274561_(x, y, z)));
                  entityToSpawn.m_20874_(true);
                  _level.m_7967_(entityToSpawn);
               }

               Entity entityToSpawn;
               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawn = ((EntityType)PepoyoModEntities.DEBTCOLLECTOR.get()).m_262496_(_level, BlockPos.m_274561_(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.m_20334_(0.0D, 1.0D, 0.0D);
                  }
               }

               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawn = ((EntityType)PepoyoModEntities.DEBTCOLLECTOR.get()).m_262496_(_level, BlockPos.m_274561_(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.m_20334_(2.0D, 0.0D, 0.0D);
                  }
               }

               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawn = ((EntityType)PepoyoModEntities.DEBTCOLLECTOR.get()).m_262496_(_level, BlockPos.m_274561_(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.m_20334_(0.0D, 0.0D, 2.0D);
                  }
               }

               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawn = ((EntityType)PepoyoModEntities.DEBTCOLLECTOR.get()).m_262496_(_level, BlockPos.m_274561_(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.m_20334_(2.0D, 1.0D, 2.0D);
                  }
               }

               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawn = ((EntityType)PepoyoModEntities.DEBTCOLLECTOR.get()).m_262496_(_level, BlockPos.m_274561_(x, y, z), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.m_20334_(2.0D, 0.0D, 0.0D);
                  }
               }
            }

            if (entity instanceof YorupobossEntity) {
               _datEntI = (YorupobossEntity)entity;
               var31 = (Integer)_datEntI.m_20088_().m_135370_(YorupobossEntity.DATA_hurt_skill);
            } else {
               var31 = 0;
            }

            ServerLevel _level;
            if (var31 == 3) {
               if (entity instanceof YorupobossEntity) {
                  _datEntSetL = (YorupobossEntity)entity;
                  _datEntSetL.m_20088_().m_135381_(YorupobossEntity.DATA_hurt_skill, 0);
               }

               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawn = (LightningBolt)EntityType.f_20465_.m_20615_(_level);
                  entityToSpawn.m_20219_(Vec3.m_82539_(BlockPos.m_274561_(x, y, z)));
                  entityToSpawn.m_20874_(true);
                  _level.m_7967_(entityToSpawn);
               }

               for(int index0 = 0; index0 < 50; ++index0) {
                  if (world instanceof ServerLevel) {
                     _level = (ServerLevel)world;
                     Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
                        public Projectile getArrow(Level level, float damage, int knockback) {
                           AbstractArrow entityToSpawn = new RamenbowlEntity((EntityType)PepoyoModEntities.RAMENBOWL.get(), level);
                           entityToSpawn.m_36781_((double)damage);
                           entityToSpawn.m_36735_(knockback);
                           entityToSpawn.m_20225_(true);
                           return entityToSpawn;
                        }
                     })).getArrow(_level, 13.0F, 1);
                     _entityToSpawn.m_6034_((double)Mth.m_216271_(RandomSource.m_216327_(), -25, 25) + x, y + (double)Mth.m_216271_(RandomSource.m_216327_(), 30, 60), (double)Mth.m_216271_(RandomSource.m_216327_(), -25, 25) + z);
                     _entityToSpawn.m_6686_(0.0D, -2.0D, 0.0D, 1.0F, 0.0F);
                     _level.m_7967_(_entityToSpawn);
                  }
               }
            }

            if (entity instanceof YorupobossEntity) {
               _datEntI = (YorupobossEntity)entity;
               var31 = (Integer)_datEntI.m_20088_().m_135370_(YorupobossEntity.DATA_hurt_skill);
            } else {
               var31 = 0;
            }

            if (var31 == 4) {
               if (entity instanceof YorupobossEntity) {
                  _datEntSetL = (YorupobossEntity)entity;
                  _datEntSetL.m_20088_().m_135381_(YorupobossEntity.DATA_hurt_skill, 0);
               }

               if (entity instanceof YorupobossEntity) {
                  ((YorupobossEntity)entity).setAnimation("animation.yorupo.loading");
               }
            }

            LivingEntity _livEnt;
            float var35;
            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var35 = _livEnt.m_21223_();
            } else {
               var35 = -1.0F;
            }

            LivingEntity _livEnt;
            if (var35 <= 300.0F) {
               label249: {
                  if (entity instanceof YorupobossEntity) {
                     _datEntSetL = (YorupobossEntity)entity;
                     if ((Boolean)_datEntSetL.m_20088_().m_135370_(YorupobossEntity.DATA_phase_2)) {
                        var10000 = true;
                        break label249;
                     }
                  }

                  var10000 = false;
               }

               if (!var10000) {
                  if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "say 现在是我的特殊攻击！");
                  }

                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     if (!_livEnt.m_9236_().m_5776_()) {
                        _livEnt.m_7292_(new MobEffectInstance(MobEffects.f_19600_, 1600, 3, false, false));
                     }
                  }

                  if (entity instanceof YorupobossEntity) {
                     YorupobossEntity _datEntSetL = (YorupobossEntity)entity;
                     _datEntSetL.m_20088_().m_135381_(YorupobossEntity.DATA_phase_2, true);
                  }

                  if (world instanceof ServerLevel) {
                     _level = (ServerLevel)world;
                     Entity entityToSpawn = EntityType.f_20465_.m_262496_(_level, BlockPos.m_274561_(x, y, z), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.enderman.scream")), SoundSource.NEUTRAL, 1.0F, 0.0F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.enderman.scream")), SoundSource.NEUTRAL, 1.0F, 0.0F, false);
                     }
                  }

                  for(int index1 = 0; index1 < 200; ++index1) {
                     if (world instanceof ServerLevel) {
                        ServerLevel projectileLevel = (ServerLevel)world;
                        Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
                           public Projectile getArrow(Level level, float damage, int knockback) {
                              AbstractArrow entityToSpawn = new RamenbowlEntity((EntityType)PepoyoModEntities.RAMENBOWL.get(), level);
                              entityToSpawn.m_36781_((double)damage);
                              entityToSpawn.m_36735_(knockback);
                              entityToSpawn.m_20225_(true);
                              return entityToSpawn;
                           }
                        })).getArrow(projectileLevel, 30.0F, 1);
                        _entityToSpawn.m_6034_((double)Mth.m_216271_(RandomSource.m_216327_(), -25, 25) + x, y + (double)Mth.m_216271_(RandomSource.m_216327_(), 30, 80), (double)Mth.m_216271_(RandomSource.m_216327_(), -25, 25) + z);
                        _entityToSpawn.m_6686_(0.0D, -2.0D, 0.0D, 2.0F, 0.0F);
                        projectileLevel.m_7967_(_entityToSpawn);
                     }
                  }

                  PepoyoMod.queueServerWork(20, () -> {
                     YorupobossEntity _datEntSetL;
                     if (entity instanceof YorupobossEntity) {
                        _datEntSetL = (YorupobossEntity)entity;
                        _datEntSetL.m_20088_().m_135381_(YorupobossEntity.DATA_attract, true);
                     }

                     if (entity instanceof YorupobossEntity) {
                        _datEntSetL = (YorupobossEntity)entity;
                        _datEntSetL.m_20088_().m_135381_(YorupobossEntity.DATA_active, false);
                     }

                     PepoyoMod.queueServerWork(20, () -> {
                        ServerLevel _level;
                        Entity entityToSpawn;
                        if (world instanceof ServerLevel) {
                           _level = (ServerLevel)world;
                           entityToSpawn = ((EntityType)PepoyoModEntities.DEBTCOLLECTOR.get()).m_262496_(_level, BlockPos.m_274561_(x, y, z), MobSpawnType.MOB_SUMMONED);
                           if (entityToSpawn != null) {
                              entityToSpawn.m_20334_(0.0D, 0.0D, 0.0D);
                           }
                        }

                        if (world instanceof ServerLevel) {
                           _level = (ServerLevel)world;
                           entityToSpawn = ((EntityType)PepoyoModEntities.DEBTCOLLECTOR.get()).m_262496_(_level, BlockPos.m_274561_(x, y, z), MobSpawnType.MOB_SUMMONED);
                           if (entityToSpawn != null) {
                              entityToSpawn.m_20334_(0.0D, 0.0D, 0.0D);
                           }
                        }

                        if (world instanceof ServerLevel) {
                           _level = (ServerLevel)world;
                           entityToSpawn = ((EntityType)PepoyoModEntities.DEBTCOLLECTOR.get()).m_262496_(_level, BlockPos.m_274561_(x, y, z), MobSpawnType.MOB_SUMMONED);
                           if (entityToSpawn != null) {
                              entityToSpawn.m_20334_(0.0D, 0.0D, 0.0D);
                           }
                        }

                        if (world instanceof ServerLevel) {
                           _level = (ServerLevel)world;
                           entityToSpawn = ((EntityType)PepoyoModEntities.DEBTCOLLECTOR.get()).m_262496_(_level, BlockPos.m_274561_(x, y, z), MobSpawnType.MOB_SUMMONED);
                           if (entityToSpawn != null) {
                              entityToSpawn.m_20334_(0.0D, 0.0D, 0.0D);
                           }
                        }

                        if (world instanceof ServerLevel) {
                           _level = (ServerLevel)world;
                           entityToSpawn = ((EntityType)PepoyoModEntities.DEBTCOLLECTOR.get()).m_262496_(_level, BlockPos.m_274561_(x, y, z), MobSpawnType.MOB_SUMMONED);
                           if (entityToSpawn != null) {
                              entityToSpawn.m_20334_(0.0D, 0.0D, 0.0D);
                           }
                        }

                        if (world instanceof ServerLevel) {
                           _level = (ServerLevel)world;
                           entityToSpawn = ((EntityType)PepoyoModEntities.DEBTCOLLECTOR.get()).m_262496_(_level, BlockPos.m_274561_(x, y, z), MobSpawnType.MOB_SUMMONED);
                           if (entityToSpawn != null) {
                              entityToSpawn.m_20334_(0.0D, 0.0D, 0.0D);
                           }
                        }

                        if (entity instanceof YorupobossEntity) {
                           YorupobossEntity _datEntSetL = (YorupobossEntity)entity;
                           _datEntSetL.m_20088_().m_135381_(YorupobossEntity.DATA_active, false);
                        }

                        PepoyoMod.queueServerWork(20, () -> {
                           for(int index2 = 0; index2 < 60; ++index2) {
                              if (world instanceof ServerLevel) {
                                 ServerLevel _level = (ServerLevel)world;
                                 Entity entityToSpawn = ((EntityType)PepoyoModEntities.YANDEBOMB.get()).m_262496_(_level, BlockPos.m_274561_(x + (double)Mth.m_216271_(RandomSource.m_216327_(), -40, 40), y + 5.0D, z + (double)Mth.m_216271_(RandomSource.m_216327_(), -40, 40)), MobSpawnType.MOB_SUMMONED);
                                 if (entityToSpawn != null) {
                                    entityToSpawn.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                                 }
                              }

                              if (entity instanceof YorupobossEntity) {
                                 YorupobossEntity _datEntSetL = (YorupobossEntity)entity;
                                 _datEntSetL.m_20088_().m_135381_(YorupobossEntity.DATA_active, true);
                              }
                           }

                        });
                     });
                  });
               }
            }

            Enchantment var36 = Enchantments.f_44981_;
            ItemStack var32;
            if (sourceentity instanceof LivingEntity) {
               _livEnt = (LivingEntity)sourceentity;
               var32 = _livEnt.m_21205_();
            } else {
               var32 = ItemStack.f_41583_;
            }

            if (EnchantmentHelper.m_44843_(var36, var32) != 0) {
               ItemStack var37;
               if (sourceentity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)sourceentity;
                  var37 = _livEnt.m_21205_();
               } else {
                  var37 = ItemStack.f_41583_;
               }

               Map<Enchantment, Integer> _enchantments = EnchantmentHelper.m_44831_(var37);
               if (_enchantments.containsKey(Enchantments.f_44981_)) {
                  _enchantments.remove(Enchantments.f_44981_);
                  if (sourceentity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)sourceentity;
                     var32 = _livEnt.m_21205_();
                  } else {
                     var32 = ItemStack.f_41583_;
                  }

                  EnchantmentHelper.m_44865_(_enchantments, var32);
               }

               if (sourceentity instanceof ServerPlayer) {
                  ServerPlayer _player = (ServerPlayer)sourceentity;
                  Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("pepoyo:fireban"));
                  AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                  if (!_ap.m_8193_()) {
                     Iterator var23 = _ap.m_8219_().iterator();

                     while(var23.hasNext()) {
                        String criteria = (String)var23.next();
                        _player.m_8960_().m_135988_(_adv, criteria);
                     }
                  }
               }
            }

            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var35 = _livEnt.m_21223_();
            } else {
               var35 = -1.0F;
            }

            if (var35 <= 80.0F) {
               if (entity instanceof YorupobossEntity) {
                  _datEntSetL = (YorupobossEntity)entity;
                  _datEntSetL.m_20088_().m_135381_(YorupobossEntity.DATA_active, false);
               }

               if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "tellraw @a \"<夜步及> 呃！\"");
               }

               if (entity instanceof YorupobossEntity) {
                  _datEntSetL = (YorupobossEntity)entity;
                  _datEntSetL.m_20088_().m_135381_(YorupobossEntity.DATA_lock_blood, true);
               }

               PepoyoMod.queueServerWork(20, () -> {
                  if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "tellraw @a \"<夜步及> 很厉害\"");
                  }

                  PepoyoMod.queueServerWork(40, () -> {
                     if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                        entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "tellraw @a \"<夜步及> 但我还可以打，一直打下去\"");
                     }

                     PepoyoMod.queueServerWork(30, () -> {
                        if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                           entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "tellraw @a \"<夜步及> 我所拥有的力量\"");
                        }

                        PepoyoMod.queueServerWork(50, () -> {
                           if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                              entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "tellraw @a \"<夜步及> 就让我们一直打下去吧\"");
                           }

                           PepoyoMod.queueServerWork(50, () -> {
                              ServerLevel _level;
                              if (world instanceof ServerLevel) {
                                 _level = (ServerLevel)world;
                                 _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "effect give @a[distance=0..100] pepoyo:error 1 1 true");
                              }

                              PepoyoMod.LOGGER.error("<夜步及> 呃，是你");
                              PepoyoMod.LOGGER.error("<1508> 你太弱了，根本无法完成我的任务");
                              PepoyoMod.LOGGER.error("<夜步及> 不，不要这样！我做得到！我一定会打开DOOR");
                              PepoyoMod.LOGGER.error("<1508> 你想把PEPPO带过来，你想让他杀了我");
                              PepoyoMod.LOGGER.error("<夜步及> 不是的，他们不是佩珀，他们是玩家");
                              PepoyoMod.LOGGER.error("<夜步及> 再给我一次机会，我会把他们碾碎");
                              if (!entity.m_9236_().m_5776_()) {
                                 entity.m_146870_();
                              }

                              world.m_7731_(BlockPos.m_274561_(x, y, z), ((Block)PepoyoModBlocks.YORUPOCORPSE.get()).m_49966_(), 3);
                              ItemEntity entityToSpawn;
                              if (world instanceof ServerLevel) {
                                 _level = (ServerLevel)world;
                                 entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)PepoyoModItems.PARADISE.get()));
                                 entityToSpawn.m_32010_(10);
                                 _level.m_7967_(entityToSpawn);
                              }

                              if (world instanceof ServerLevel) {
                                 _level = (ServerLevel)world;
                                 entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)PepoyoModItems.KNIFE.get()));
                                 entityToSpawn.m_32010_(10);
                                 _level.m_7967_(entityToSpawn);
                              }

                              if (world instanceof ServerLevel) {
                                 _level = (ServerLevel)world;
                                 entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.f_42747_));
                                 entityToSpawn.m_32010_(10);
                                 _level.m_7967_(entityToSpawn);
                              }

                              if (world instanceof ServerLevel) {
                                 _level = (ServerLevel)world;
                                 entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.f_42747_));
                                 entityToSpawn.m_32010_(10);
                                 _level.m_7967_(entityToSpawn);
                              }

                              if (world instanceof ServerLevel) {
                                 _level = (ServerLevel)world;
                                 entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Blocks.f_50273_));
                                 entityToSpawn.m_32010_(10);
                                 _level.m_7967_(entityToSpawn);
                              }

                           });
                        });
                     });
                  });
               });
            }
         }

      }
   }
}
