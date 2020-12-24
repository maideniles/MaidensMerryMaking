package com.maideniles.maidensmerrymaking.blocks.fireplace.mantel.single;

import com.maideniles.maidensmerrymaking.blocks.deco.HorizontalDecoBlock;
import com.maideniles.maidensmerrymaking.blocks.fireplace.mantel.stocking.MantelTopCenterJungleWithStocking;
import com.maideniles.maidensmerrymaking.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class MantelLegRightJungle extends HorizontalDecoBlock {

    public static final DirectionProperty DIRECTION = BlockStateProperties.HORIZONTAL_FACING;

    private static final VoxelShape WEST_AABB = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 8.0D, 16.0D, 9.0D);
    private static final VoxelShape EAST_AABB = Block.makeCuboidShape(7.0D, 0.0D, 8.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape NORTH_AABB = Block.makeCuboidShape(7.0D, 0.0D, 0.0D, 15.0D, 16.0D, 8.0D);
    private static final VoxelShape SOUTH_AABB = Block.makeCuboidShape(1.0D, 0.0D, 8.0D, 9.0D, 16.0D, 16.0D);


    public MantelLegRightJungle(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch(state.get(DIRECTION)) {

            default:
            case NORTH:
                return NORTH_AABB;
            case SOUTH:
                return SOUTH_AABB;
            case WEST:
                return WEST_AABB;
            case EAST:

                return EAST_AABB;
        }
    }

    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {

        BlockState blockstate = worldIn.getBlockState(pos);
        if (blockstate.getBlock() != this) return;
        BlockState blockstate1 = worldIn.getBlockState(pos.up().north());
        BlockState blockstate2 = worldIn.getBlockState(pos.up().south());
        BlockState blockstate3 = worldIn.getBlockState(pos.up().east());
        BlockState blockstate4 = worldIn.getBlockState(pos.up().west());

        if (blockstate1.getBlock() == ModBlocks.MANTEL_JUNGLE_TOP_MIDDLE.get())
            ((MantelTopCenterJungle)blockstate1.getBlock()).onBlockHarvested(worldIn, pos.north().up(), blockstate1, player);

        else if (blockstate1.getBlock() == ModBlocks.MANTEL_JUNGLE_TOP_MIDDLE_STOCKING.get())
            ((MantelTopCenterJungleWithStocking)blockstate1.getBlock()).onBlockHarvested(worldIn, pos.north().up(), blockstate1, player);



        else if (blockstate2.getBlock() == ModBlocks.MANTEL_JUNGLE_TOP_MIDDLE.get())
            ((MantelTopCenterJungle)blockstate2.getBlock()).onBlockHarvested(worldIn, pos.south().up(), blockstate2, player);

        else if(blockstate2.getBlock() == ModBlocks.MANTEL_JUNGLE_TOP_MIDDLE_STOCKING.get())
            ((MantelTopCenterJungleWithStocking)blockstate2.getBlock()).onBlockHarvested(worldIn, pos.south().up(), blockstate2, player);




        else if (blockstate3.getBlock() == ModBlocks.MANTEL_JUNGLE_TOP_MIDDLE.get())
            ((MantelTopCenterJungle)blockstate3.getBlock()).onBlockHarvested(worldIn, pos.east().up(), blockstate3, player);

        else if(blockstate3.getBlock() == ModBlocks.MANTEL_JUNGLE_TOP_MIDDLE_STOCKING.get())
            ((MantelTopCenterJungleWithStocking)blockstate3.getBlock()).onBlockHarvested(worldIn, pos.east().up(), blockstate3, player);



        else if (blockstate4.getBlock() == ModBlocks.MANTEL_JUNGLE_TOP_MIDDLE.get())
            ((MantelTopCenterJungle)blockstate4.getBlock()).onBlockHarvested(worldIn, pos.west().up(), blockstate4, player);


        else if (blockstate4.getBlock() == ModBlocks.MANTEL_JUNGLE_TOP_MIDDLE_STOCKING.get())
            ((MantelTopCenterJungleWithStocking)blockstate4.getBlock()).onBlockHarvested(worldIn, pos.west().up(), blockstate4, player);
    }



}
