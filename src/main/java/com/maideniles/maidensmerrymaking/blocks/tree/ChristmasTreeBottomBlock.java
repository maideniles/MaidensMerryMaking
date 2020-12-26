package com.maideniles.maidensmerrymaking.blocks.tree;

import com.maideniles.maidensmerrymaking.init.ModBlocks;
import com.maideniles.maidensmerrymaking.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class ChristmasTreeBottomBlock extends Block {

    protected static final VoxelShape SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);



    public ChristmasTreeBottomBlock(Properties properties) {
        super(properties);
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {

        BlockState blockstate = worldIn.getBlockState(pos);

        if (blockstate.getBlock() == this ) {

            worldIn.setBlockState(pos, ModBlocks.CHRISTMAS_TREE_STAND.get().getDefaultState(), 35);
        }

    }

    @Override
    public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        ItemStack tree = player.getHeldItem(handIn);

        if (!worldIn.isRemote()) {



            if (tree.getItem() == ModItems.MINI_LIGHTS_WHITE.get()){

                System.out.println("O CHRISTMAS TREE, O CHRISTMAS TREE!");
                worldIn.setBlockState(pos, ModBlocks.CHRISTMAS_TREE_WHITE_LIGHTS_BOTTOM.get().getDefaultState());
            //      worldIn.setBlockState(pos.add(0,1,0), ModBlocks.CHRISTMAS_TREE_WHITE_LIGHTS_MIDDLE.get().getDefaultState());
           //       worldIn.setBlockState(pos.add(0,2,0), ModBlocks.CHRISTMAS_TREE_WHITE_LIGHTS_TOP.get().getDefaultState());

                tree.shrink(1);
            }

        }

        if (!worldIn.isRemote()) {



            if (tree.getItem() == ModItems.MINI_LIGHTS_MULTI.get()){

                System.out.println("O CHRISTMAS TREE, O CHRISTMAS TREE!");
                worldIn.setBlockState(pos, ModBlocks.CHRISTMAS_TREE_MULTI_LIGHTS_BOTTOM.get().getDefaultState());
                //      worldIn.setBlockState(pos.add(0,1,0), ModBlocks.CHRISTMAS_TREE_WHITE_LIGHTS_MIDDLE.get().getDefaultState());
                //       worldIn.setBlockState(pos.add(0,2,0), ModBlocks.CHRISTMAS_TREE_WHITE_LIGHTS_TOP.get().getDefaultState());

                tree.shrink(1);
            }

        }

        return true;
    }

    @Override
    public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return false;
    }

    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT;
    }

}
