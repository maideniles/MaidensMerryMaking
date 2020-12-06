package com.maideniles.maidensmerrymaking.init;



import com.maideniles.maidensmerrymaking.world.gen.feature.tree.ChristmasPineTree;

import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;


public  class ModFeatures<FC extends IFeatureConfig> extends net.minecraftforge.registries.ForgeRegistryEntry<net.minecraft.world.gen.feature.Feature<?>> {

    public static final Feature<NoFeatureConfig> PINE_TREE = new ChristmasPineTree(NoFeatureConfig::deserialize, false);


    @SubscribeEvent
    public static void registerFeature(RegistryEvent.Register<Feature<?>> event) {

        event.getRegistry().register(new ChristmasPineTree(NoFeatureConfig::deserialize, false).setRegistryName("pine_tree"));

    }

  @SubscribeEvent
  public static void registerFeatures(RegistryEvent.Register<Feature<?>> event) {
    //FlowerVillagePools.init();
    event.getRegistry().registerAll(


    );
  }

}
