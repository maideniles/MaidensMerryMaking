package com.maideniles.maidensmerrymaking.blocks.fireplace.mantel.single;

import com.maideniles.maidensmerrymaking.blocks.deco.HorizontalDecoBlock;
import com.maideniles.maidensmerrymaking.init.ModBlocks;
import com.maideniles.maidensmerrymaking.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class MantelTopRightJungle extends HorizontalDecoBlock {
    protected static final VoxelShape WEST_AABB = Block.makeCuboidShape(0.0D, 8.0D, 0.0D, 9.0D, 16.0D, 16.0D);
    protected static final VoxelShape EAST_AABB = Block.makeCuboidShape(7.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    protected static final VoxelShape NORTH_AABB = Block.makeCuboidShape(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 9.0D);
    protected static final VoxelShape SOUTH_AABB = Block.makeCuboidShape(0.0D, 8.0D, 7.0D, 16.0D, 16.0D, 16.0D);

    private static final VoxelShape LEG_WEST_AABB = Block.makeCuboidShape(0.0D, 0.0D, 2.0D, 8.0D, 8.0D, 8.0D);
    private static final VoxelShape LEG_EAST_AABB = Block.makeCuboidShape(8.0D, 0.0D, 8.0D, 16.0D, 8.0D, 14.0D);
    private static final VoxelShape LEG_NORTH_AABB = Block.makeCuboidShape(8.5D, 0.0D, 0.0D, 14.5D, 8.0D, 8.0D);
    private static final VoxelShape LEG_SOUTH_AABB = Block.makeCuboidShape(2.0D, 0.0D, 8.0D, 8.0D, 8.0D, 16.0D);

    public static VoxelShape WITH_LEG_WEST;
    public static VoxelShape WITH_LEG_EAST;
    public static VoxelShape WITH_LEG_NORTH;
    public static VoxelShape WITH_LEG_SOUTH;

    public MantelTopRightJungle(Properties properties) {
        super(properties);

        WITH_LEG_WEST = VoxelShapes.combine( WEST_AABB, LEG_WEST_AABB, IBooleanFunction.OR);
        WITH_LEG_EAST = VoxelShapes.combine( EAST_AABB, LEG_EAST_AABB, IBooleanFunction.OR);
        WITH_LEG_NORTH = VoxelShapes.combine( NORTH_AABB, LEG_NORTH_AABB, IBooleanFunction.OR);
        WITH_LEG_SOUTH = VoxelShapes.combine( SOUTH_AABB, LEG_SOUTH_AABB, IBooleanFunction.OR);
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {

        switch((Direction)state.get(DIRECTION)) {
            case SOUTH:
                return WITH_LEG_SOUTH;
            case NORTH:
            default:
                return WITH_LEG_NORTH;
            case WEST:
                return WITH_LEG_WEST;
            case EAST:
                return WITH_LEG_EAST;
        }
    }

    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {

        BlockState blockstate = worldIn.getBlockState(pos);
        if (blockstate.getBlock() != this) return;
        BlockState blockstate1 = worldIn.getBlockState(pos.north());
        BlockState blockstate2 = worldIn.getBlockState(pos.south());
        BlockState blockstate3 = worldIn.getBlockState(pos.east());
        BlockState blockstate4 = worldIn.getBlockState(pos.west());

        if (blockstate1.getBlock() == ModBlocks.MANTEL_JUNGLE_TOP_MIDDLE.get())
            ((MantelTopCenterJungle)blockstate1.getBlock()).onBlockHarvested(worldIn, pos.north(), blockstate1, player);

        else if (blockstate2.getBlock() == ModBlocks.MANTEL_JUNGLE_TOP_MIDDLE.get())
            ((MantelTopCenterJungle)blockstate2.getBlock()).onBlockHarvested(worldIn, pos.south(), blockstate2, player);


        else if (blockstate3.getBlock() == ModBlocks.MANTEL_JUNGLE_TOP_MIDDLE.get())
            ((MantelTopCenterJungle)blockstate3.getBlock()).onBlockHarvested(worldIn, pos.east(), blockstate3, player);


        else if (blockstate4.getBlock() == ModBlocks.MANTEL_JUNGLE_TOP_MIDDLE.get())
            ((MantelTopCenterJungle)blockstate4.getBlock()).onBlockHarvested(worldIn, pos.west(), blockstate4, player);


    }

    @Override
    public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        ItemStack stocking = player.getHeldItem(handIn);

        if (!worldIn.isRemote()) {


            if (stocking.getItem() == ModItems.STOCKING.get()) {

                System.out.println("THE STOCKINGS WERE HUNG");
                worldIn.setBlockState(pos, ModBlocks.MANTEL_JUNGLE_TOP_RIGHT_STOCKING.get().getDefaultState().with(DIRECTION, state.get(DIRECTION)));


                stocking.shrink(1);
            }


        }
        return true;
    }
}
