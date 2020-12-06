package com.maideniles.maidensmerrymaking.world.gen.feature.tree;


import com.maideniles.maidensmerrymaking.init.ModBlocks;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationBaseReader;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;
import java.util.Set;
import java.util.function.Function;

public class  ChristmasPineTreeLarge extends AbstractTreeFeature<NoFeatureConfig> {
    private static final BlockState TRUNK = Blocks.SPRUCE_LOG.getDefaultState();
    private static final BlockState LEAF = Blocks.SPRUCE_LEAVES.getDefaultState();

    public ChristmasPineTreeLarge(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i51429_1_, boolean p_i51429_2_) {
        super(p_i51429_1_, p_i51429_2_);
        setSapling((net.minecraftforge.common.IPlantable)Blocks.SPRUCE_SAPLING);
    }

    public boolean place(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, Random rand, BlockPos position, MutableBoundingBox p_208519_5_) {

        // this.setBlockState(worldIn, position, ModBlocks.TREE.get().getDefaultState());
        //   this.setBlockState(worldIn, position.up(), ModBlocks.TREE_MIDDLE.get().getDefaultState());
        //   this.setBlockState(worldIn, position.add(0,2,0), ModBlocks.TREE_TOP.get().getDefaultState());

        return true;
    }

    protected static boolean isSoil(IWorldGenerationBaseReader reader, BlockPos pos, net.minecraftforge.common.IPlantable sapling) {
        if (!(reader instanceof net.minecraft.world.IBlockReader) || sapling == null)
            return isDirtOrGrassBlock(reader, pos);
        return reader.hasBlockState(pos, state -> state.canSustainPlant((net.minecraft.world.IBlockReader)reader, pos, Direction.UP, sapling));
    }

    @Deprecated //Forge: moved to isSoilOrFarm
    protected static boolean isDirtOrGrassBlockOrFarmland(IWorldGenerationBaseReader worldIn, BlockPos pos) {
        return worldIn.hasBlockState(pos, (p_214586_0_) -> {
            Block block = p_214586_0_.getBlock();
            return Block.isDirt(block) || block == Blocks.GRASS_BLOCK || block == Blocks.FARMLAND || block == Blocks.PODZOL;
        });
    }

    protected static boolean isSoilOrFarm(IWorldGenerationBaseReader reader, BlockPos pos, net.minecraftforge.common.IPlantable sapling) {
        if (!(reader instanceof net.minecraft.world.IBlockReader) || sapling == null)
            return isDirtOrGrassBlockOrFarmland(reader, pos);
        return reader.hasBlockState(pos, state -> state.canSustainPlant((net.minecraft.world.IBlockReader)reader, pos, Direction.UP, sapling));
    }
}