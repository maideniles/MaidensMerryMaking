package com.maideniles.maidensmerrymaking.world.gen.feature;


import com.maideniles.maidensmerrymaking.init.ModBlocks;
import com.maideniles.maidensmerrymaking.util.MaidensPines;
import com.maideniles.maidensmerrymaking.world.gen.feature.tree.ChristmasPineTree;
import com.maideniles.maidensmerrymaking.world.gen.feature.tree.ChristmasPineTreeLarge;
import com.maideniles.maidensmerrymaking.world.gen.feature.tree.ChristmasPineTreeMedium;
import net.minecraft.block.Blocks;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.TallTaigaTreeFeature;

import javax.annotation.Nullable;
import java.util.Random;

public class PineTreeFeatures extends Tree {
    private MaidensPines pines;

    public PineTreeFeatures(MaidensPines pinesIn) {
        pines = pinesIn;

    }


    @Nullable
    protected AbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {

        switch (pines) {


            case SMALL:  return  new ChristmasPineTree(NoFeatureConfig::deserialize, false);

            case MEDIUM:  return  new ChristmasPineTreeMedium(NoFeatureConfig::deserialize, false);

            case LARGE:  return  new ChristmasPineTreeLarge(NoFeatureConfig::deserialize, false);

        }

        return getTreeFeature(random);
    }
}



