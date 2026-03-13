package net.mcreator.pepoyo.init;

import net.mcreator.pepoyo.potion.DarkscreensMobEffect;
import net.mcreator.pepoyo.potion.ERRORMobEffect;
import net.mcreator.pepoyo.potion.PayramenMobEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class PepoyoModMobEffects {
   public static final DeferredRegister<MobEffect> REGISTRY;
   public static final RegistryObject<MobEffect> DARKSCREENS;
   public static final RegistryObject<MobEffect> PAYRAMEN;
   public static final RegistryObject<MobEffect> ERROR;

   static {
      REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, "pepoyo");
      DARKSCREENS = REGISTRY.register("darkscreens", () -> {
         return new DarkscreensMobEffect();
      });
      PAYRAMEN = REGISTRY.register("payramen", () -> {
         return new PayramenMobEffect();
      });
      ERROR = REGISTRY.register("error", () -> {
         return new ERRORMobEffect();
      });
   }
}
