package com.connie.vampiremod;

import com.connie.vampiremod.entities.ModEntities;
import com.connie.vampiremod.items.ModItems;
import org.slf4j.Logger;
import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@Mod(VampireMod.MODID)
public class VampireMod
{
    public static final String MODID = "vampiremod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public VampireMod(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        // Register entity types and items
        ModEntities.ENTITY_TYPES.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);

        modEventBus.addListener(this::addCreative);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    public void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Common setup for Vampire Mod completed");
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        // Add the spawn egg to a creative tab
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModItems.VAMPIRE_SPAWN_EGG);
        }
    }

}