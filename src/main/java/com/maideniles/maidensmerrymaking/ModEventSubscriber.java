package com.maideniles.maidensmerrymaking;


import com.maideniles.maidensmerrymaking.world.gen.PineTreeGen;
import net.minecraft.potion.Potion;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

@Mod.EventBusSubscriber(modid = MaidensMerryMaking.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class ModEventSubscriber {

    private static final Logger LOGGER = LogManager.getLogger(MaidensMerryMaking.MODID + " Mod Event Subscriber");

    private static final Random rand = new Random();




    @SubscribeEvent
    public static void onCommonSetup(final FMLCommonSetupEvent event)
    {

            PineTreeGen.setupPineTreeGen();

        LOGGER.debug("Common setup done");
    } // end onCommonSetup





}
