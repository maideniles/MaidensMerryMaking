package com.maideniles.maidensmerrymaking.blocks.lamppost;

import com.maideniles.maidensmerrymaking.blocks.deco.HorizontalDecoBlock;
import com.maideniles.maidensmerrymaking.init.ModBlocks;
import com.maideniles.maidensmerrymaking.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class LampPost extends HorizontalDecoBlock {

    protected static final VoxelShape SHAPE = Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 16.0D, 13.0D);


    public LampPost(Properties properties) {
        super(properties);
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {


        BlockState blockstate = worldIn.getBlockState(pos.down());
        BlockState blockstate1 = worldIn.getBlockState(pos.down().down());


        if (blockstate.getBlock() == this) {

            worldIn.setBlockState(pos.down(), ModBlocks.LAMP_POST_BOTTOM.get().getDefaultState().with(DIRECTION, state.get(DIRECTION)));
            worldIn.setBlockState(pos, ModBlocks.LAMP_POST.get().getDefaultState().with(DIRECTION, state.get(DIRECTION)));
//THIS ONE WORKS//
        }

        if(blockstate.getBlock() == this && blockstate1.getBlock() == ModBlocks.LAMP_POST_BOTTOM.get()){

            worldIn.setBlockState(pos.down().down(),ModBlocks.LAMP_POST_BOTTOM.get().getDefaultState().with(DIRECTION, state.get(DIRECTION)));
            worldIn.setBlockState(pos.down(), ModBlocks.LAMP_POST_POLE.get().getDefaultState().with(DIRECTION, state.get(DIRECTION)));
            worldIn.setBlockState(pos, ModBlocks.LAMP_POST.get().getDefaultState().with(DIRECTION, state.get(DIRECTION)));


        }
    }

    @Override
    public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        ItemStack stocking = player.getHeldItem(handIn);

        if (!worldIn.isRemote()) {



            if (stocking.getItem() == Items.TORCH){

                System.out.println("YOU LIGHT UP MY LIFE!");
                worldIn.setBlockState(pos, ModBlocks.LAMP_POST_ON.get().getDefaultState().with(DIRECTION, state.get(DIRECTION)));


                stocking.shrink(1);
            }



        }

        return true;
    }

    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {

        BlockState blockstate = worldIn.getBlockState(pos);
        BlockState blockstate1 = worldIn.getBlockState(pos.down());


        if (blockstate.getBlock() == this && blockstate1.getBlock() == ModBlocks.LAMP_POST_POLE.get()) {

            worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
            worldIn.setBlockState(pos.down(), ModBlocks.LAMP_POST.get().getDefaultState().with(DIRECTION, state.get(DIRECTION)));

        }

        if (blockstate.getBlock() == this && blockstate1.getBlock() == ModBlocks.LAMP_POST_BOTTOM.get()) {

         //   worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
            worldIn.setBlockState(pos.down(), ModBlocks.LAMP_POST.get().getDefaultState().with(DIRECTION, state.get(DIRECTION)));

        }





    }
}
