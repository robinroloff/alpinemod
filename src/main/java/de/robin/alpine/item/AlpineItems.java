package de.robin.alpine.item;

import de.robin.alpine.AlpineMod;
import de.robin.alpine.entity.AlpineEntities;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AlpineItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, AlpineMod.MODID);

    public static final RegistryObject<Item> ALPINE_COW_SPAWN_EGG = ITEMS.register("alpinecow_spawn_egg",
            () -> new ForgeSpawnEggItem(AlpineEntities.ALPINE_COW, 0xe0d3c6, 0xcc7d40, new Item.Properties()));
    public static final RegistryObject<Item> ALPINE_CHICKEN_SPAWN_EGG = ITEMS.register("alpinechicken_spawn_egg",
            () -> new ForgeSpawnEggItem(AlpineEntities.ALPINE_CHICKEN, 0x237962, 0x622c0c, new Item.Properties()));
    public static final RegistryObject<Item> MARMOT_SPAWN_EGG = ITEMS.register("marmot_spawn_egg",
            () -> new ForgeSpawnEggItem(AlpineEntities.MARMOT, 0x237962, 0x622c0c, new Item.Properties()));
    public static final RegistryObject<Item> ALPINE_KILLER_BUNNY_SPAWN_EGG = ITEMS.register("alpinekillerbunny_spawn_egg",
            () -> new ForgeSpawnEggItem(AlpineEntities.ALPINE_KILLER_BUNNY, 0x237962, 0x622c0c, new Item.Properties()));

    public static final RegistryObject<Item> SALT = ITEMS.register("salt", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PRETZEL = ITEMS.register("pretzel", () -> new Item(new Item.Properties().food(Foods.BREAD)));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
