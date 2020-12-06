package com.maideniles.maidensmerrymaking.world.gen.feature;

import com.maideniles.maidensmerrymaking.init.ModFeatures;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;


public class PineTreeGen {

    public static void setupPineTreeGen() {


        for (Biome biome :Biome.BIOMES){
            if (biome.getTempCategory() == Biome.TempCategory.COLD) {
                biome.addFeature(
                        GenerationStage.Decoration.VEGETAL_DECORATION,
                        Biome.createDecoratedFeature(
                                ModFeatures .PINE_TREE,
                                IFeatureConfig.NO_FEATURE_CONFIG,
                                Placement.COUNT_EXTRA_HEIGHTMAP,
                                new AtSurfaceWithExtraConfig(0, 2, 1))
                );
            }
        }
    }
}
