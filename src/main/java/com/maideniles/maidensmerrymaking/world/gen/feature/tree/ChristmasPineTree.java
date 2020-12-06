package com.maideniles.maidensmerrymaking.world.gen.feature.tree;


import com.maideniles.maidensmerrymaking.init.ModBlocks;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.tags.BlockTags;
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

public class  ChristmasPineTree extends AbstractTreeFeature<NoFeatureConfig> {
    private static final BlockState LOG = ModBlocks.TREE.get().getDefaultState();
    private static final BlockState LEAF = Blocks.SPRUCE_LEAVES.getDefaultState();

    public ChristmasPineTree(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i51429_1_, boolean p_i51429_2_) {
        super(p_i51429_1_, p_i51429_2_);

    }

    public boolean place(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, Random rand, BlockPos position, MutableBoundingBox box) {

        int k = 0;
        int i = 0;
        int j = 0;

        placeLogAt(changedBlocks, worldIn, position.down(i), box);

if( !isWater(worldIn, position.down() ) ) {
    this.setBlockState(worldIn, position.add(i + 0, j + 0, k + 0), ModBlocks.TREE.get().getDefaultState());
    this.setBlockState(worldIn, position.add(i + 0, j + 1, k + 0), ModBlocks.TREE_MIDDLE.get().getDefaultState());
    this.setBlockState(worldIn, position.add(i + 0, j + 2, k + 0), ModBlocks.TREE_TOP.get().getDefaultState());
}
        return true;
    }

    private void placeLogAt(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, BlockPos pos, MutableBoundingBox box) {
        if (!isAirOrLeaves(worldIn, pos) || !isWater(worldIn, pos)) {
            this.placeBlock(worldIn, pos, changedBlocks, box, LOG);
        }
    }

    protected boolean placeBlock(IWorldGenerationReader worldIn, BlockPos pos, Set<BlockPos> changedBlocks, MutableBoundingBox box, BlockState state) {
        if (!isAirOrLeaves(worldIn, pos) && !isTallPlants(worldIn, pos) && !isWater(worldIn, pos)) {
            return false;
        } else {

            changedBlocks.add(pos.toImmutable());
            return true;
        }
    }

    protected static boolean isTallPlants(IWorldGenerationBaseReader p_214576_0_, BlockPos p_214576_1_) {
        return p_214576_0_.hasBlockState(p_214576_1_, (p_214588_0_) -> {
            Material material = p_214588_0_.getMaterial();
            return material == Material.TALL_PLANTS;
        });
    }

    @Deprecated //Forge: moved to setDirtAt
    protected void func_214584_a(IWorldGenerationReader p_214584_1_, BlockPos p_214584_2_) {
        if (!isDirt(p_214584_1_, p_214584_2_)) {
            this.setBlockState(p_214584_1_, p_214584_2_, Blocks.DIRT.getDefaultState());
        }

    }

    protected static boolean isSoil(IWorldGenerationBaseReader reader, BlockPos pos, net.minecraftforge.common.IPlantable sapling) {
        if (!(reader instanceof net.minecraft.world.IBlockReader) || sapling == null)
            return isDirtOrGrassBlock(reader, pos);
        return reader.hasBlockState(pos, state -> state.canSustainPlant((net.minecraft.world.IBlockReader) reader, pos, Direction.UP, sapling));
    }

    @Deprecated //Forge: moved to isSoilOrFarm
    protected static boolean isDirtOrGrassBlockOrFarmland(IWorldGenerationBaseReader worldIn, BlockPos pos) {
        return worldIn.hasBlockState(pos, (p_214586_0_) -> {
            Block block = p_214586_0_.getBlock();

            if ( block !=Blocks.GRASS_BLOCK||block !=Blocks.DIRT||block !=Blocks.COARSE_DIRT||block !=Blocks.PODZOL) {

                return false;
            }
else

            return true;
        });
    }

    protected static boolean isSoilOrFarm(IWorldGenerationBaseReader reader, BlockPos pos, net.minecraftforge.common.IPlantable sapling) {
        if (!(reader instanceof net.minecraft.world.IBlockReader) || sapling == null)
            return isDirtOrGrassBlockOrFarmland(reader, pos);
        return reader.hasBlockState(pos, state -> state.canSustainPlant((net.minecraft.world.IBlockReader) reader, pos, Direction.UP, sapling));
    }



}