package com.connie.vampiremod.entities;

import com.connie.vampiremod.VampireMod;
import net.minecraft.world.entity.EntityType;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.world.entity.MobCategory;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(Registries.ENTITY_TYPE, VampireMod.MODID);

    public static final Supplier<EntityType<VampireEntity>> VAMPIRE_ENTITY = ENTITY_TYPES.register(
            "vampire_entity",
            // The entity type, created using a builder.
            () -> EntityType.Builder.of(
                            VampireEntity::new,
                            MobCategory.MONSTER
                    )
                    .sized(1.0f, 1.0f)
                    .spawnDimensionsScale(4.0f)
                    .eyeHeight(0.5f)
                    .noSave()
                    .canSpawnFarFromPlayer()
                    .clientTrackingRange(8)
                    .updateInterval(10)
                    .build(null)
    );
}
