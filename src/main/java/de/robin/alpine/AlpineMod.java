package de.robin.alpine;

import de.robin.alpine.block.AlpineBlocks;
import de.robin.alpine.entity.AlpineEntities;
import de.robin.alpine.entity.model.AlpineChickenModel;
import de.robin.alpine.entity.model.AlpineKillerBunnyModel;
import de.robin.alpine.entity.model.MarmotModel;
import de.robin.alpine.entity.renderer.AlpineChickenRenderer;
import de.robin.alpine.entity.renderer.AlpineCowRenderer;
import de.robin.alpine.entity.renderer.AlpineKillerBunnyRenderer;
import de.robin.alpine.entity.renderer.MarmotRenderer;
import de.robin.alpine.item.AlpineItems;
import de.robin.alpine.worldgen.biome.ModOverworldRegion;
import de.robin.alpine.worldgen.biome.ModSurfaceRuleData;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.VineBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(AlpineMod.MODID)
public class AlpineMod {

    // Define mod id in a common place for everything to reference
    public static final String MODID = "alpinemod";
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public AlpineMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading

        AlpineItems.register(modEventBus);
        AlpineEntities.register(modEventBus);
        AlpineBlocks.register(modEventBus);

        CREATIVE_MODE_TABS.register(modEventBus);

        modEventBus.addListener(this::commonSetup);


        MinecraftForge.EVENT_BUS.register(this);
    }


    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(AlpineBlocks.EDELWEISS.getId(), AlpineBlocks.POTTED_EDELWEISS);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(AlpineBlocks.ENZIAN.getId(), AlpineBlocks.POTTED_ENZIAN);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(AlpineBlocks.MOREL_MUSHROOM.getId(), AlpineBlocks.POTTED_MOREL_MUSHROOM);

            Regions.register(new ModOverworldRegion(new ResourceLocation(MODID, "overworld_1"), 20));
            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MODID, ModSurfaceRuleData.makeRules());

        });
    }


    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEvents {
        @SubscribeEvent
        public static void buildContents(BuildCreativeModeTabContentsEvent event) {
            if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
                event.accept(AlpineBlocks.ENZIAN);
                event.accept(AlpineBlocks.EDELWEISS);
                event.accept(AlpineBlocks.MOREL_MUSHROOM);
                event.accept(AlpineBlocks.RESIN);
                event.accept(AlpineBlocks.SALT_BLOCK);
            } else if (event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
                event.accept(AlpineItems.MARMOT_SPAWN_EGG);
                event.accept(AlpineItems.ALPINE_KILLER_BUNNY_SPAWN_EGG);
                event.accept(AlpineItems.ALPINE_COW_SPAWN_EGG);
                event.accept(AlpineItems.ALPINE_CHICKEN_SPAWN_EGG);
            }
        }
    }


    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
            event.registerLayerDefinition(AlpineChickenModel.LAYER_LOCATION, AlpineChickenModel::createBodyLayer);
            event.registerLayerDefinition(MarmotModel.LAYER_LOCATION, MarmotModel::createBodyLayer);
            event.registerLayerDefinition(AlpineKillerBunnyModel.LAYER_LOCATION, AlpineKillerBunnyModel::createBodyLayer);

        }

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(AlpineEntities.ALPINE_COW.get(), AlpineCowRenderer::new);
            EntityRenderers.register(AlpineEntities.ALPINE_CHICKEN.get(), AlpineChickenRenderer::new);
            EntityRenderers.register(AlpineEntities.MARMOT.get(), MarmotRenderer::new);
            EntityRenderers.register(AlpineEntities.ALPINE_KILLER_BUNNY.get(), AlpineKillerBunnyRenderer::new);
        }
    }
}
