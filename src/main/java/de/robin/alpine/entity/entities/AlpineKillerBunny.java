package de.robin.alpine.entity.entities;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.animal.Rabbit;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;

public class AlpineKillerBunny extends Rabbit {
    public AlpineKillerBunny(EntityType<? extends Rabbit> p_29656_, Level p_29657_) {
        super(p_29656_, p_29657_);
    }

    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_29678_, DifficultyInstance p_29679_, MobSpawnType p_29680_, @Nullable SpawnGroupData p_29681_, @Nullable CompoundTag p_29682_) {
        SpawnGroupData spawnGroupData = super.finalizeSpawn(p_29678_, p_29679_, p_29680_, p_29681_, p_29682_);
        this.setVariant(Variant.EVIL);
        return spawnGroupData;
    }

    @Override
    public void setVariant(Variant p_262578_) {
        super.setVariant(p_262578_);
        setCustomName(null);
        setCustomNameVisible(false);
    }
}

