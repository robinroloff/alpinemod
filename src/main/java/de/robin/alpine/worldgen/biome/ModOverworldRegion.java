package de.robin.alpine.worldgen.biome;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.VanillaParameterOverlayBuilder;
import static terrablender.api.ParameterUtils.*;

import java.util.function.Consumer;

public class ModOverworldRegion extends Region {
    public ModOverworldRegion(ResourceLocation name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();
        new ParameterPointListBuilder()
                .temperature(Temperature.COOL)
                .humidity(Humidity.WET)
                .continentalness(Continentalness.FAR_INLAND)
                .erosion(Climate.Parameter.span(-2F, 1F))
                .depth(Depth.SURFACE, Depth.FLOOR)
                .weirdness(Weirdness.FULL_RANGE)
                .build().forEach(point -> builder.add(point, AlpineBiomes.ALPS));

        builder.build().forEach(mapper);
    }
}