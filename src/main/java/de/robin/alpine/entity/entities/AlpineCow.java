package de.robin.alpine.entity.entities;

import de.robin.alpine.entity.AlpineEntities;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class AlpineCow  extends Cow {

    public AlpineCow(EntityType<? extends Cow> entityType, Level level) {
        super(entityType, level);
    }

    @Nullable
    public AlpineCow getBreedOffspring(ServerLevel p_148890_, AgeableMob p_148891_) {
        return AlpineEntities.ALPINE_COW.get().create(p_148890_);
    }
}
