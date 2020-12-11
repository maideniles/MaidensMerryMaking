package com.maideniles.maidensmerrymaking.blocks.fireplace.mantel.single;

import com.maideniles.maidensmerrymaking.blocks.deco.HorizontalDecoBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class MantelTopRight extends HorizontalDecoBlock {
    protected static final VoxelShape WEST_AABB = Block.makeCuboidShape(0.0D, 0.0D, 8.0D, 9.0D, 8.0D, 16.0D);
    protected static final VoxelShape EAST_AABB = Block.makeCuboidShape(7.0D, 0.0D, 0.0D, 16.0D, 8.0D, 8.0D);
    private static final VoxelShape NORTH_AABB = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 8.0D, 8.0D, 9.0D);
    protected static final VoxelShape SOUTH_AABB = Block.makeCuboidShape(8.0D, 0.0D, 7.0D, 16.0D, 8.0D, 16.0D);

    public MantelTopRight(Properties properties) {
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
}
