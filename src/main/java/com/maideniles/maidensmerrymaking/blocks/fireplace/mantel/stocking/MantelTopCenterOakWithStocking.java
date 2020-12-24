package com.maideniles.maidensmerrymaking.blocks.fireplace.mantel.stocking;

import com.maideniles.maidensmerrymaking.blocks.deco.HorizontalDecoBlock;
import com.maideniles.maidensmerrymaking.init.ModBlocks;
import com.maideniles.maidensmerrymaking.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class MantelTopCenterOakWithStocking extends HorizontalDecoBlock {
    protected static final VoxelShape WEST_AABB = Block.makeCuboidShape(0.0D, 8.0D, 0.0D, 9.0D, 16.0D, 16.0D);
    protected static final VoxelShape EAST_AABB = Block.makeCuboidShape(7.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    protected static final VoxelShape NORTH_AABB = Block.makeCuboidShape(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 9.0D);
    protected static final VoxelShape SOUTH_AABB = Block.makeCuboidShape(0.0D, 8.0D, 7.0D, 16.0D, 16.0D, 16.0D);

    public MantelTopCenterOakWithStocking(Properties properties) {
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
    public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {

        BlockState blockstate = worldIn.getBlockState(pos);
        BlockState blockstate1 = worldIn.getBlockState(pos.north());
        BlockState blockstate2 = worldIn.getBlockState(pos.south());
        BlockState blockstate3 = worldIn.getBlockState(pos.east());
        BlockState blockstate4 = worldIn.getBlockState(pos.west());

        if (blockstate.getBlock() == this && blockstate1.getBlock() == ModBlocks.MANTEL_OAK_TOP_RIGHT.get()
                || blockstate1.getBlock() == ModBlocks.MANTEL_OAK_TOP_RIGHT_STOCKING.get()
                || blockstate.getBlock() == this && blockstate2.getBlock() == ModBlocks.MANTEL_OAK_TOP_RIGHT.get()
                || blockstate2.getBlock() == ModBlocks.MANTEL_OAK_TOP_RIGHT_STOCKING.get() ){

            worldIn.setBlockState(pos.north(), Blocks.AIR.getDefaultState(), 35);
            worldIn.setBlockState(pos.south(), Blocks.AIR.getDefaultState(), 35);
            worldIn.setBlockState(pos.north().down(), Blocks.AIR.getDefaultState(), 35);
            worldIn.setBlockState(pos.south().down(), Blocks.AIR.getDefaultState(), 35);
            worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 35);
        }
        //IF FACING NORTH/SOUTH//
        if (blockstate.getBlock() == this && blockstate3.getBlock() == ModBlocks.MANTEL_OAK_TOP_RIGHT.get()

                || blockstate3.getBlock() == ModBlocks.MANTEL_OAK_TOP_RIGHT_STOCKING.get()
                || blockstate.getBlock() == this && blockstate4.getBlock() == ModBlocks.MANTEL_OAK_TOP_RIGHT.get()

                || blockstate4.getBlock() == ModBlocks.MANTEL_OAK_TOP_RIGHT_STOCKING.get()){

            worldIn.setBlockState(pos.east(), Blocks.AIR.getDefaultState(), 35);
            worldIn.setBlockState(pos.west(), Blocks.AIR.getDefaultState(), 35);
            worldIn.setBlockState(pos.east().down(), Blocks.AIR.getDefaultState(), 35);
            worldIn.setBlockState(pos.west().down(), Blocks.AIR.getDefaultState(), 35);
            worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 35);

        }

        ItemEntity mantel = new ItemEntity(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModBlocks.MANTEL_OAK_NORMAL.get(), 1));
        if (!worldIn.isRemote() && !player.isCreative()) {
            worldIn.addEntity(mantel); //SPAWN THE BLOSSOMS//
            mantel.setPickupDelay(0);
        }

    }
}
