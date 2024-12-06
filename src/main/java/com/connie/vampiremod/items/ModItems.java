package com.connie.vampiremod.items;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import com.connie.vampiremod.entities.ModEntities;
import net.minecraft.world.item.CreativeModeTabs;

public class ModItems {
    private static final String MODID = "vampiremod"; // Your mod ID

    // Create a Deferred Register to hold Items under the "vampiremod" namespace
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);

    // Create a Spawn Egg for the vampire entity with the id "vampiremod:vampire_spawn_egg"
    public static final DeferredItem<SpawnEggItem> VAMPIRE_SPAWN_EGG = ITEMS.registerItem("vampire_spawn_egg",
            properties -> new SpawnEggItem(
                    ModEntities.VAMPIRE_ENTITY.get(),
                    0xff0000,
                    0x00ff00,
                    properties
            ));

    // Create a creative tab for the spawn egg
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EXAMPLE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID)
            .register("example_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.vampiremod")) // The name of the creative tab
                    .withTabsBefore(CreativeModeTabs.COMBAT) // Place the tab before the combat tab
                    .icon(() -> VAMPIRE_SPAWN_EGG.get().getDefaultInstance()) // Use the spawn egg as the tab icon
                    .displayItems((parameters, output) -> {
                        output.accept(VAMPIRE_SPAWN_EGG.get()); // Add the spawn egg to the tab
                    }).build());
}
