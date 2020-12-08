package com.maideniles.maidensmerrymaking.blocks;

import com.maideniles.maidensmerrymaking.init.ModBlocks;
import com.maideniles.maidensmerrymaking.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class TreeStandBlock extends Block {

    protected static final VoxelShape SHAPE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 8.0D, 14.0D);



    public TreeStandBlock(Properties properties) {
        super(properties);
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    @Override
    public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return false;
    }

    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }

    @Override
    public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        ItemStack tree = player.getHeldItem(handIn);

        if (!worldIn.isRemote()) {



            if (tree.getItem() == ModItems.CHRISTMAS_TREE.get()){

                System.out.println("O CHRISTMAS TREE, O CHRISTMAS TREE!");
                worldIn.setBlockState(pos, ModBlocks.CHRISTMAS_TREE_BOTTOM.get().getDefaultState());
                worldIn.setBlockState(pos.add(0,1,0), ModBlocks.CHRISTMAS_TREE_MIDDLE.get().getDefaultState());
                worldIn.setBlockState(pos.add(0,2,0), ModBlocks.CHRISTMAS_TREE_TOP.get().getDefaultState());

                tree.shrink(1);
            }



        }




        return true;
    }

}
