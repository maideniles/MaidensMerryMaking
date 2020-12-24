package com.maideniles.maidensmerrymaking.blocks.lamppost;

import com.maideniles.maidensmerrymaking.blocks.deco.HorizontalDecoBlock;
import com.maideniles.maidensmerrymaking.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
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
    public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        ItemStack item = player.getHeldItem(handIn);
        if (!worldIn.isRemote()) {

            if (item.getItem() == Item.getItemFromBlock(ModBlocks.CHRISTMAS_WREATH.get()) ){
                System.out.println("WREATH");
                worldIn.setBlockState(pos, ModBlocks.LAMP_POST_POLE_WREATH.get().getDefaultState().with(DIRECTION, state.get(DIRECTION)));
               item.shrink(1);
            }

            if (item.getItem() == Item.getItemFromBlock(ModBlocks.CHRISTMAS_WREATH_WHITE_LIGHTS.get()) ){
                System.out.println("WREATH WHITE LIGHTS");
                worldIn.setBlockState(pos, ModBlocks.LAMP_POST_POLE_WREATH_WHITE.get().getDefaultState().with(DIRECTION, state.get(DIRECTION)));
                item.shrink(1);
            }

            if (item.getItem() == Item.getItemFromBlock(ModBlocks.CHRISTMAS_WREATH_MULTI_LIGHTS.get())){
                System.out.println("WREATH MULTI LIGHTS");
                worldIn.setBlockState(pos, ModBlocks.LAMP_POST_POLE_WREATH_MULTI.get().getDefaultState().with(DIRECTION, state.get(DIRECTION)));
                item.shrink(1);
            }

            if (item.getItem() == Item.getItemFromBlock(ModBlocks.BOW_TOPPER.get())){
                System.out.println("BOW");
                worldIn.setBlockState(pos, ModBlocks.LAMP_POST_POLE_BOW.get().getDefaultState().with(DIRECTION, state.get(DIRECTION)));
                item.shrink(1);
            }

        }
        return true;
    }




        @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {



        worldIn.setBlockState(pos.down(), Blocks.AIR.getDefaultState());
       worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
        worldIn.setBlockState(pos.up(), Blocks.AIR.getDefaultState());
        }











}
