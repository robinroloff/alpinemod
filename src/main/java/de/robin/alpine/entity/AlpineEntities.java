package de.robin.alpine.entity;

import de.robin.alpine.AlpineMod;
import de.robin.alpine.entity.entities.AlpineChicken;
import de.robin.alpine.entity.entities.AlpineCow;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AlpineEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, AlpineMod.MODID);

    public static final RegistryObject<EntityType<AlpineCow>> ALPINE_COW =
            ENTITY_TYPES.register("alpinecow", () -> EntityType.Builder.of(AlpineCow::new, MobCategory.CREATURE)
                    .sized(0.9F, 1.4F).clientTrackingRange(10).build("alpinecow"));
    public static final RegistryObject<EntityType<AlpineChicken>> ALPINE_CHICKEN =
            ENTITY_TYPES.register("alpinechicken", () -> EntityType.Builder.of(AlpineChicken::new, MobCategory.CREATURE)
                    .sized(0.4F, 0.7F).clientTrackingRange(10).build("alpinechicken"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
