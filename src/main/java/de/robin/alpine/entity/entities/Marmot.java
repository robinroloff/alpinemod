package de.robin.alpine.entity.entities;

import de.robin.alpine.entity.AlpineEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.Rabbit;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class Marmot extends Animal {

    private static final EntityDataAccessor<Integer> DATA_TYPE_ID = SynchedEntityData.defineId(Marmot.class, EntityDataSerializers.INT);
    private EatBlockGoal eatBlockGoal;

    public Marmot(EntityType<? extends Animal> p_27557_, Level p_27558_) {
        super(p_27557_, p_27558_);

    }

    public enum COLORS {
        BLACK, BROWN, GOLD, DEFAULT, SALT, TOAST, WHITE, WHITE_SPLOTCHED;
    }

    protected void registerGoals() {
        this.eatBlockGoal = new EatBlockGoal(this);
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 2.0D));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.25D, Ingredient.of(Items.WHEAT), false));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
        this.goalSelector.addGoal(5, this.eatBlockGoal);
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
    }


    @Override
    public void addAdditionalSaveData(CompoundTag data) {
        data.putInt("marmotColor", this.getColor().ordinal());
        System.out.println("added marmot color " + this.getColor());
        super.addAdditionalSaveData(data);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_TYPE_ID, COLORS.DEFAULT.ordinal());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag data) {
        if (data.contains("marmotColor")) {
            setColor(Marmot.COLORS.values()[data.getInt("marmotColor")]);

            System.out.println("read marmot color " + this.getColor());
        }

        super.readAdditionalSaveData(data);
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_146746_, DifficultyInstance p_146747_, MobSpawnType p_146748_, @Nullable SpawnGroupData p_146749_, @Nullable CompoundTag p_146750_) {
        Random rdm = new Random();
        setColor(Marmot.COLORS.values()[rdm.nextInt(0, COLORS.values().length - 1)]);
        System.out.println("set color to " + this.getColor());

        return super.finalizeSpawn(p_146746_, p_146747_, p_146748_, p_146749_, p_146750_);
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
        return Marmot.COLORS.values()[this.entityData.get(DATA_TYPE_ID)];
    }

    public void setColor(COLORS color) {
        this.entityData.set(DATA_TYPE_ID, color.ordinal());
    }
}
