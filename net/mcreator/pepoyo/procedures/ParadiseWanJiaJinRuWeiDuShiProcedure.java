package net.mcreator.pepoyo.procedures;

import net.mcreator.pepoyo.PepoyoMod;
import net.mcreator.pepoyo.init.PepoyoModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraftforge.registries.ForgeRegistries;

public class ParadiseWanJiaJinRuWeiDuShiProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (world instanceof ServerLevel) {
            ServerLevel _serverworld = (ServerLevel)world;
            StructureTemplate template = _serverworld.m_215082_().m_230359_(new ResourceLocation("pepoyo", "theparadise1508"));
            if (template != null) {
               template.m_230328_(_serverworld, BlockPos.m_274561_(x + (double)Mth.m_216271_(RandomSource.m_216327_(), -25, 25), y, z + (double)Mth.m_216271_(RandomSource.m_216327_(), -25, 25)), BlockPos.m_274561_(x + (double)Mth.m_216271_(RandomSource.m_216327_(), -25, 25), y, z + (double)Mth.m_216271_(RandomSource.m_216327_(), -25, 25)), (new StructurePlaceSettings()).m_74379_(Rotation.NONE).m_74377_(Mirror.NONE).m_74392_(false), _serverworld.f_46441_, 3);
            }
         }

         PepoyoMod.queueServerWork(Mth.m_216271_(RandomSource.m_216327_(), 200, 600), () -> {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)PepoyoModMobEffects.DARKSCREENS.get(), 60, 1, false, false));
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ghast.hurt")), SoundSource.NEUTRAL, 1.0F, 1.0F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ghast.hurt")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
               }
            }

            PepoyoMod.LOGGER.error("Unknown entity");
         });
      }
   }
}
