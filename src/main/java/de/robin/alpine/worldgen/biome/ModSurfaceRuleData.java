package de.robin.alpine.worldgen.biome;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;

public class ModSurfaceRuleData {
    private static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
    private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final SurfaceRules.RuleSource SNOW = makeStateRule(Blocks.SNOW_BLOCK);
    private static final SurfaceRules.RuleSource STONE = makeStateRule(Blocks.STONE);

    private static SurfaceRules.ConditionSource surfaceNoiseAbove(double pValue) {
        return SurfaceRules.noiseCondition(Noises.SURFACE, pValue / 8.25D, Double.MAX_VALUE);
    }

    public static SurfaceRules.RuleSource makeValleyRules() {
        SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);
        SurfaceRules.RuleSource grassSurface = SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.sequence(
                SurfaceRules.ifTrue(isAtOrAboveWaterLevel, GRASS_BLOCK), DIRT));

        return grassSurface;
    }

    public static SurfaceRules.RuleSource makeRules() {
        SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);
        SurfaceRules.RuleSource grassSurface = SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.sequence(
                SurfaceRules.ifTrue(isAtOrAboveWaterLevel, GRASS_BLOCK), DIRT));

        SurfaceRules.RuleSource spawnStone =
                SurfaceRules.sequence(
                        SurfaceRules.ifTrue(surfaceNoiseAbove(1D), STONE),
                        SurfaceRules.ifTrue(SurfaceRules.yStartCheck(VerticalAnchor.absolute(95), 4), STONE)
                );
        SurfaceRules.RuleSource stoneSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, spawnStone), grassSurface);

        SurfaceRules.ConditionSource spawnSnow = surfaceNoiseAbove(0.5D);
        SurfaceRules.RuleSource snowSurface = SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR,
                        SurfaceRules.ifTrue(spawnSnow,
                                SurfaceRules.ifTrue(SurfaceRules.yStartCheck(VerticalAnchor.absolute(120), 4), SNOW))), stoneSurface);

        return SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(AlpineBiomes.ALPS), snowSurface),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(AlpineBiomes.ALPS_VALLEY), makeValleyRules()));
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }
}