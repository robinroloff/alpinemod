package de.robin.alpine.worldgen.biome;

import de.robin.alpine.AlpineMod;
import net.minecraft.resources.ResourceLocation;
import terrablender.api.Regions;

public class ModTerraBlender {

    public static void registerBiomes() {
        Regions.register(new ModOverworldRegion(new ResourceLocation(AlpineMod.MODID, "overworld"), 5));
    }
}
