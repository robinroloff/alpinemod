package de.robin.alpine.entity.entities;

import de.robin.alpine.entity.AlpineEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class Marmot extends Animal {

    private Marmot.COLORS color;

    public Marmot(EntityType<? extends Animal> p_27557_, Level p_27558_) {
        super(p_27557_, p_27558_);
        Random rdm = new Random();
        if (this.color == null) {
            this.color = Marmot.COLORS.values()[rdm.nextInt(0, COLORS.values().length - 1)];
            System.out.println("set color to " + this.color);
        }
    }

    public enum COLORS {
        BLACK, BROWN, GOLD, DEFAULT, SALT, TOAST, WHITE, WHITE_SPLOTCHED;
    }


    @Override
    public void addAdditionalSaveData(CompoundTag data) {
        data.putInt("marmotColor", this.color.ordinal());
        System.out.println("added marmot color " + this.color);
        super.addAdditionalSaveData(data);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag data) {
        if (data.contains("marmotColor")) {
            this.color = Marmot.COLORS.values()[data.getInt("marmotColor")];
            System.out.println("read marmot color " + this.color);
        }

        super.readAdditionalSaveData(data);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 4.0D).add(Attributes.MOVEMENT_SPEED, 0.25D);
    }


    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_) {
        return AlpineEntities.MARMOT.get().create(p_146743_);
    }

    public COLORS getColor() {
        return color;
    }
}
