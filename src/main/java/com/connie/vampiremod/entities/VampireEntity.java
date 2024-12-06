package com.connie.vampiremod.entities;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;

public class VampireEntity extends Zombie {
    public VampireEntity(EntityType<? extends VampireEntity> type, Level world) {
        super(type, world);
    }


}