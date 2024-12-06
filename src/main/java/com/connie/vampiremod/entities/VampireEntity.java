package com.connie.vampiremod.entities;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;

public class VampireEntity extends Zombie {
    // We inherit this constructor without the bound on the generic wildcard.
    // The bound is needed for registration below, so we add it here.
    public VampireEntity(EntityType<? extends VampireEntity> type, Level world) {
        super(type, world);
    }


}