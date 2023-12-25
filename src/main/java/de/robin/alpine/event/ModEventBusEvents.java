package de.robin.alpine.event;

import de.robin.alpine.AlpineMod;
import de.robin.alpine.entity.AlpineEntities;
import de.robin.alpine.entity.entities.AlpineChicken;
import de.robin.alpine.entity.entities.AlpineCow;
import de.robin.alpine.entity.entities.AlpineKillerBunny;
import de.robin.alpine.entity.entities.Marmot;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AlpineMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(AlpineEntities.ALPINE_COW.get(), AlpineCow.createAttributes().build());
        event.put(AlpineEntities.ALPINE_CHICKEN.get(), AlpineChicken.createAttributes().build());
        event.put(AlpineEntities.MARMOT.get(), Marmot.createAttributes().build());
        event.put(AlpineEntities.ALPINE_KILLER_BUNNY.get(), AlpineKillerBunny.createAttributes().build());
    }
}
