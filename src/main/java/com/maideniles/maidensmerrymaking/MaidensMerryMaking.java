package com.maideniles.maidensmerrymaking;

import com.maideniles.maidensmerrymaking.init.BiomeInit;
import com.maideniles.maidensmerrymaking.init.ModBlocks;
import com.maideniles.maidensmerrymaking.init.ModFeatures;
import com.maideniles.maidensmerrymaking.init.ModItems;
import com.maideniles.maidensmerrymaking.world.gen.feature.PineTreeGen;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(MaidensMerryMaking.MODID)
@Mod.EventBusSubscriber(modid = MaidensMerryMaking.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class MaidensMerryMaking {

    public static MaidensMerryMaking instance;

    public static final String MODID = "maidensmerrymaking";

    public static final Logger LOGGER = LogManager.getLogger(MODID);


    public MaidensMerryMaking() {

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::FMLLoadCompleteEvent);

        LOGGER.debug("Hello from Maiden's MerryMaking!");




        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);


      


        instance = this;
        MinecraftForge.EVENT_BUS.register(this);


    }



@SubscribeEvent
    public void setup(final FMLCommonSetupEvent event) {// K9#8016


        /*
         * DeferredWorkQueue.runLater(() -> { for (Biome biome : ForgeRegistries.BIOMES)
         * { if (biome instanceof ExampleBiome) {
         * biome.getSpawns(EntityClassification.MONSTER) .add(new
         * Biome.SpawnListEntry(EntityType.ZOMBIE, 1000, 1, 4)); } } });
         */

    }

    public void FMLLoadCompleteEvent(FMLLoadCompleteEvent event) {
        for (Biome biome : ForgeRegistries.BIOMES) {

        }
    }
}