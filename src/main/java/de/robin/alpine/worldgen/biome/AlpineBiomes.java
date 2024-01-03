package de.robin.alpine.worldgen.biome;

import de.robin.alpine.AlpineMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.biome.OverworldBiomes;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;

public class AlpineBiomes {
    public static final ResourceKey<Biome> ALPS = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(AlpineMod.MODID, "alps"));

 public static final ResourceKey<Biome> ALPS_VALLEY = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(AlpineMod.MODID, "alps_valley"));


    public static void boostrap(BootstapContext<Biome> context) {
        context.register(ALPS, alps(context));
        context.register(ALPS_VALLEY, alpsValley(context));
    }

    public static Biome alps(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder mobSpawnInfo = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(mobSpawnInfo);
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(4159204).waterFogColor(329011).skyColor(7972607).foliageColorOverride(10387789).grassColorOverride(-6684928).build();
        BiomeGenerationSettings.Builder biomeGenerationSettings =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);
        BiomeDefaultFeatures.addSurfaceFreezing(biomeGenerationSettings);

        return new Biome.BiomeBuilder().hasPrecipitation(true).temperature(0.5f).downfall(0.5f).specialEffects(effects).mobSpawnSettings(mobSpawnInfo.build()).generationSettings(biomeGenerationSettings.build()).build();

    }
    public static Biome alpsValley(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder mobSpawnInfo = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(mobSpawnInfo);
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(4159204).waterFogColor(329011).skyColor(7972607).foliageColorOverride(10387789).grassColorOverride(-6684928).build();
        BiomeGenerationSettings.Builder biomeGenerationSettings =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        BiomeDefaultFeatures.addPlainGrass(biomeGenerationSettings);
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.TREES_FLOWER_FOREST);
        BiomeDefaultFeatures.addDefaultGrass(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultCarversAndLakes(biomeGenerationSettings);

        BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);
        BiomeDefaultFeatures.addSurfaceFreezing(biomeGenerationSettings);

        return new Biome.BiomeBuilder().hasPrecipitation(true).temperature(0.5f).downfall(0.5f).specialEffects(effects).mobSpawnSettings(mobSpawnInfo.build()).generationSettings(biomeGenerationSettings.build()).build();

    }
}