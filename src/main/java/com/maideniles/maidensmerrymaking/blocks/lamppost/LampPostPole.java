package com.maideniles.maidensmerrymaking.blocks.lamppost;

import com.maideniles.maidensmerrymaking.blocks.deco.HorizontalDecoBlock;
import com.maideniles.maidensmerrymaking.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class LampPostPole extends HorizontalDecoBlock {

    protected static final VoxelShape SHAPE = Block.makeCuboidShape(7.0D, 0.0D, 7.0D, 9.0D, 16.0D, 9.0D);


    public LampPostPole(Properties properties) {
        super(properties);
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }


    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {



        worldIn.setBlockState(pos.down(), Blocks.AIR.getDefaultState());
       worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
        worldIn.setBlockState(pos.up(), Blocks.AIR.getDefaultState());
        }











}
