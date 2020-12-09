package com.maideniles.maidensmerrymaking.blocks.fireplace.mantel;

import com.maideniles.maidensmerrymaking.blocks.deco.HorizontalDecoBlock;
import com.maideniles.maidensmerrymaking.init.ModBlocks;
import com.maideniles.maidensmerrymaking.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class FireplaceMantel extends HorizontalDecoBlock {

    protected static final VoxelShape WEST_AABB = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 1.0D, 16.0D, 16.0D);
    protected static final VoxelShape EAST_AABB = Block.makeCuboidShape(15.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    protected static final VoxelShape NORTH_AABB = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 1.0D);
    protected static final VoxelShape SOUTH_AABB = Block.makeCuboidShape(0.0D, 0.0D, 15.0D, 16.0D, 16.0D, 16.0D);



    public FireplaceMantel(Properties properties) {
        super(properties);
    }


    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {

        switch((Direction)state.get(DIRECTION)) {
            case SOUTH:
                return SOUTH_AABB;
            case NORTH:
            default:
                return NORTH_AABB;
            case WEST:
                return WEST_AABB;
            case EAST:
                return EAST_AABB;
        }
    }


    @Override
    public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        ItemStack tree = player.getHeldItem(handIn);

        if (!worldIn.isRemote()) {



            if (tree.getItem() == ModItems.STOCKING.get()){

                System.out.println("O CHRISTMAS TREE, O CHRISTMAS TREE!");
                worldIn.setBlockState(pos, ModBlocks.CHRISTMAS_TREE_WHITE_LIGHTS_BOTTOM.get().getDefaultState());
                //      worldIn.setBlockState(pos.add(0,1,0), ModBlocks.CHRISTMAS_TREE_WHITE_LIGHTS_MIDDLE.get().getDefaultState());
                //       worldIn.setBlockState(pos.add(0,2,0), ModBlocks.CHRISTMAS_TREE_WHITE_LIGHTS_TOP.get().getDefaultState());

                tree.shrink(1);
            }

        }

        if (!worldIn.isRemote()) {



            if (tree.getItem() == ModItems.CHRISTMAS_TREE_LIGHTS_MULTI.get()){

                System.out.println("O CHRISTMAS TREE, O CHRISTMAS TREE!");
                worldIn.setBlockState(pos, ModBlocks.CHRISTMAS_TREE_MULTI_LIGHTS_BOTTOM.get().getDefaultState());
                //      worldIn.setBlockState(pos.add(0,1,0), ModBlocks.CHRISTMAS_TREE_WHITE_LIGHTS_MIDDLE.get().getDefaultState());
                //       worldIn.setBlockState(pos.add(0,2,0), ModBlocks.CHRISTMAS_TREE_WHITE_LIGHTS_TOP.get().getDefaultState());

                tree.shrink(1);
            }

        }

        return true;
    }

}
