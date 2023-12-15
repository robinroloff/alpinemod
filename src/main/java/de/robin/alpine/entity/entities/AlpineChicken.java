package de.robin.alpine.entity.entities;

import de.robin.alpine.entity.AlpineEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

import javax.annotation.Nullable;

public class AlpineChicken extends Chicken {

    public AlpineChicken(EntityType<? extends Chicken> entityType, Level level) {
        super(entityType, level);
    }

    @Nullable
    public AlpineChicken getBreedOffspring(ServerLevel p_148890_, AgeableMob p_148891_) {
        return AlpineEntities.ALPINE_CHICKEN.get().create(p_148890_);
    }

    public static boolean canSpawn(EntityType<AlpineChicken> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos position, RandomSource random) {
        return Animal.checkAnimalSpawnRules(entityType, level, spawnType, position, random);
    }
}
