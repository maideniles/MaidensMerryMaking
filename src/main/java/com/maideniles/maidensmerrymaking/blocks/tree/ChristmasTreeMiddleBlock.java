package com.maideniles.maidensmerrymaking.blocks.tree;


import com.maideniles.maidensmerrymaking.init.ModBlocks;
import com.maideniles.maidensmerrymaking.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.BushBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class ChristmasTreeMiddleBlock extends BushBlock {

    protected static final VoxelShape SHAPE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);

    public ChristmasTreeMiddleBlock(Block.Properties properties) {
        super(properties);

    }

   // public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
   //     return SHAPE;
   // }

    @Override
    public boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        Block block = state.getBlock();
        return block == ModBlocks.CHRISTMAS_TREE_BOTTOM.get()
                || block == ModBlocks.CHRISTMAS_TREE_WHITE_LIGHTS_BOTTOM.get()
                || block == ModBlocks.CHRISTMAS_TREE_MULTI_LIGHTS_BOTTOM.get();
    }

    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        BlockPos blockpos = pos.down();
        if (state.getBlock() == this) //Forge: This function is called during world gen and placement, before this block is set, so if we are not 'here' then assume it's the pre-check.
            return worldIn.getBlockState(blockpos).canSustainPlant(worldIn, blockpos, Direction.UP, this);
        return this.isValidGround(worldIn.getBlockState(blockpos), worldIn, blockpos);
    }

    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {

        BlockState blockstate = worldIn.getBlockState(pos);
        BlockState blockstate2 = worldIn.getBlockState(pos.down());
        if (blockstate.getBlock() == this && blockstate2.getBlock() == ModBlocks.CHRISTMAS_TREE_BOTTOM.get()
        || blockstate2.getBlock() == ModBlocks.CHRISTMAS_TREE_WHITE_LIGHTS_BOTTOM.get()
        || blockstate2.getBlock() == ModBlocks.CHRISTMAS_TREE_MULTI_LIGHTS_BOTTOM.get()) {
            worldIn.setBlockState(pos.down(), Blocks.AIR.getDefaultState(), 35);
            worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 35);
        }

    }

    @Override
    public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        ItemStack tree = player.getHeldItem(handIn);

        if (!worldIn.isRemote()) {



            if (tree.getItem() == ModItems.CHRISTMAS_TREE_LIGHTS_WHITE.get()){

                System.out.println("O CHRISTMAS TREE, O CHRISTMAS TREE!");
                worldIn.setBlockState(pos, ModBlocks.CHRISTMAS_TREE_WHITE_LIGHTS_MIDDLE.get().getDefaultState());
               //   worldIn.setBlockState(pos.add(0,-1,0), ModBlocks.CHRISTMAS_TREE_WHITE_LIGHTS_BOTTOM.get().getDefaultState());
             //     worldIn.setBlockState(pos.add(0,1,0), ModBlocks.CHRISTMAS_TREE_WHITE_LIGHTS_TOP.get().getDefaultState());

                tree.shrink(1);
            }

        }

        if (!worldIn.isRemote()) {



            if (tree.getItem() == ModItems.CHRISTMAS_TREE_LIGHTS_MULTI.get()){

                System.out.println("O CHRISTMAS TREE, O CHRISTMAS TREE!");
                worldIn.setBlockState(pos, ModBlocks.CHRISTMAS_TREE_MULTI_LIGHTS_MIDDLE.get().getDefaultState());
                //   worldIn.setBlockState(pos.add(0,-1,0), ModBlocks.CHRISTMAS_TREE_WHITE_LIGHTS_BOTTOM.get().getDefaultState());
                //     worldIn.setBlockState(pos.add(0,1,0), ModBlocks.CHRISTMAS_TREE_WHITE_LIGHTS_TOP.get().getDefaultState());

                tree.shrink(1);
            }

        }

        return true;
    }



    /**
     * Gets the render layer this block will render on. SOLID for solid blocks, CUTOUT or CUTOUT_MIPPED for on-off
     * transparency (glass, reeds), TRANSLUCENT for fully blended transparency (stained glass)
     */
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT;
    }

}
