package net.mcreator.pepoyo.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class PepoyoModSounds {
   public static final DeferredRegister<SoundEvent> REGISTRY;
   public static final RegistryObject<SoundEvent> SOUND_YANDE_DEATH;
   public static final RegistryObject<SoundEvent> SOUND_YORUPO_POSONOUS_RAMEN;
   public static final RegistryObject<SoundEvent> SOUND_CASHIER;
   public static final RegistryObject<SoundEvent> SOUND_ERROR;
   public static final RegistryObject<SoundEvent> SOUND_YANDE_ERROR;

   static {
      REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, "pepoyo");
      SOUND_YANDE_DEATH = REGISTRY.register("sound.yande.death", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("pepoyo", "sound.yande.death"));
      });
      SOUND_YORUPO_POSONOUS_RAMEN = REGISTRY.register("sound.yorupo.posonous_ramen", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("pepoyo", "sound.yorupo.posonous_ramen"));
      });
      SOUND_CASHIER = REGISTRY.register("sound.cashier", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("pepoyo", "sound.cashier"));
      });
      SOUND_ERROR = REGISTRY.register("sound.error", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("pepoyo", "sound.error"));
      });
      SOUND_YANDE_ERROR = REGISTRY.register("sound.yande_error", () -> {
         return SoundEvent.m_262824_(new ResourceLocation("pepoyo", "sound.yande_error"));
      });
   }
}
