package com.maideniles.maidensmerrymaking.blocks.lamppost;

import com.maideniles.maidensmerrymaking.blocks.deco.HorizontalDecoBlock;
import com.maideniles.maidensmerrymaking.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class LampPostBottom extends HorizontalDecoBlock {

    protected static final VoxelShape SHAPE = Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D);

    public LampPostBottom(Properties properties) {
        super(properties);
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
                return SHAPE;
  }

    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {


        BlockState above = worldIn.getBlockState(pos.up());
        BlockState up2 = worldIn.getBlockState(pos.up().up());

//IF THE BLOCK ABOVE IS THE LAMP,
        if (above.getBlock() == ModBlocks.LAMP_POST.get()) {

            worldIn.setBlockState(pos.up(),Blocks.AIR.getDefaultState());  //CHANGE LAMP TO AIR

            worldIn.setBlockState(pos, ModBlocks.LAMP_POST.get().getDefaultState().with(DIRECTION, state.get(DIRECTION)));
            //MOVE LAMP DOWN
        }


        if (above.getBlock() == ModBlocks.LAMP_POST_POLE.get() && up2.getBlock() == ModBlocks.LAMP_POST.get()) {

            //PLACE BOTTOM UNDER LAMP
            worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
            //MOVE LAMP DOWN
            worldIn.setBlockState(pos.up(), Blocks.AIR.getDefaultState());
            //CHANGE LAMP TO AIR
            worldIn.setBlockState(pos.up().up(), Blocks.AIR.getDefaultState());
        }
    }

}
