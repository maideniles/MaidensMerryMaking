package com.maideniles.maidensmerrymaking.blocks.deco;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.minecraft.block.*;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Map;
public abstract class HorizontalDecoBlock extends Block
{

    protected static final VoxelShape WEST_AABB = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 8.0D, 8.0D, 16.0D);
    protected static final VoxelShape EAST_AABB = Block.makeCuboidShape(8.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);
    protected static final VoxelShape NORTH_AABB = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 8.0D);
    protected static final VoxelShape SOUTH_AABB = Block.makeCuboidShape(0.0D, 0.0D, 8.0D, 16.0D, 8.0D, 16.0D);

    public static final DirectionProperty DIRECTION = BlockStateProperties.HORIZONTAL_FACING;

    public HorizontalDecoBlock(Properties properties)
    {
        super(properties);
    }


    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {


        switch(state.get(DIRECTION)) {
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
    public BlockState getStateForPlacement(BlockItemUseContext context)
    {
        return super.getStateForPlacement(context).with(DIRECTION, context.getPlacementHorizontalFacing());
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation)
    {
        return state.with(DIRECTION, rotation.rotate(state.get(DIRECTION)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror)
    {
        return state.rotate(mirror.toRotation(state.get(DIRECTION)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
    {
        super.fillStateContainer(builder);
        builder.add(DIRECTION);
    }

    @Override
    public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return false;
    }

    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }

    public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
        return true;
    }



}