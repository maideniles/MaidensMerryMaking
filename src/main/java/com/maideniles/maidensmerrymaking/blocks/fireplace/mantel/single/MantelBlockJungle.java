package com.maideniles.maidensmerrymaking.blocks.fireplace.mantel.single;

import com.maideniles.maidensmerrymaking.blocks.deco.HorizontalDecoBlock;
import com.maideniles.maidensmerrymaking.init.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class MantelBlockJungle extends HorizontalDecoBlock {
    public MantelBlockJungle(Properties properties) {
        super(properties);
    }


    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state,  LivingEntity placer, ItemStack stack) {


        BlockState direction = worldIn.getBlockState(pos).with(DIRECTION, state.get(DIRECTION));

        if (direction == worldIn.getBlockState(pos).with(DIRECTION, Direction.NORTH)) {

            worldIn.setBlockState(pos.up(), ModBlocks.MANTEL_JUNGLE_TOP_MIDDLE.get().getDefaultState().with(DIRECTION, Direction.NORTH));
            worldIn.setBlockState(pos.add(-1, 1, 0), ModBlocks.MANTEL_JUNGLE_TOP_LEFT.get().getDefaultState().with(DIRECTION, Direction.NORTH));
            worldIn.setBlockState(pos.add(1, 1, 0), ModBlocks.MANTEL_JUNGLE_TOP_RIGHT.get().getDefaultState().with(DIRECTION, Direction.NORTH));
            worldIn.setBlockState(pos.add(-1, 0, 0), ModBlocks.MANTEL_JUNGLE_LEG_LEFT.get().getDefaultState().with(DIRECTION, Direction.NORTH));
            worldIn.setBlockState(pos.add(1, 0, 0), ModBlocks.MANTEL_JUNGLE_LEG_RIGHT.get().getDefaultState().with(DIRECTION, Direction.NORTH));
            //  worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());

        }

        if (direction == worldIn.getBlockState(pos).with(DIRECTION, Direction.SOUTH)) {

            worldIn.setBlockState(pos.up(), ModBlocks.MANTEL_JUNGLE_TOP_MIDDLE.get().getDefaultState().with(DIRECTION, Direction.SOUTH));
            worldIn.setBlockState(pos.add(1, 1, 0), ModBlocks.MANTEL_JUNGLE_TOP_LEFT.get().getDefaultState().with(DIRECTION, Direction.SOUTH));
            worldIn.setBlockState(pos.add(-1, 1, 0), ModBlocks.MANTEL_JUNGLE_TOP_RIGHT.get().getDefaultState().with(DIRECTION, Direction.SOUTH));
            worldIn.setBlockState(pos.add(1, 0, 0), ModBlocks.MANTEL_JUNGLE_LEG_LEFT.get().getDefaultState().with(DIRECTION, Direction.SOUTH));
            worldIn.setBlockState(pos.add(-1, 0, 0), ModBlocks.MANTEL_JUNGLE_LEG_RIGHT.get().getDefaultState().with(DIRECTION, Direction.SOUTH));
            //  worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());

        }


        if (direction == worldIn.getBlockState(pos).with(DIRECTION, Direction.WEST)) {

            worldIn.setBlockState(pos.up(), ModBlocks.MANTEL_JUNGLE_TOP_MIDDLE.get().getDefaultState().with(DIRECTION, Direction.WEST));
            worldIn.setBlockState(pos.add(0, 1, -1), ModBlocks.MANTEL_JUNGLE_TOP_RIGHT.get().getDefaultState().with(DIRECTION, Direction.WEST));
            worldIn.setBlockState(pos.add(0, 1, 1), ModBlocks.MANTEL_JUNGLE_TOP_LEFT.get().getDefaultState().with(DIRECTION, Direction.WEST));
            worldIn.setBlockState(pos.add(0, 0, -1), ModBlocks.MANTEL_JUNGLE_LEG_RIGHT.get().getDefaultState().with(DIRECTION, Direction.WEST));
            worldIn.setBlockState(pos.add(0, 0, 1), ModBlocks.MANTEL_JUNGLE_LEG_LEFT.get().getDefaultState().with(DIRECTION, Direction.WEST));
            //worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());

        }
        if (direction == worldIn.getBlockState(pos).with(DIRECTION, Direction.EAST)) {

            worldIn.setBlockState(pos.up(), ModBlocks.MANTEL_JUNGLE_TOP_MIDDLE.get().getDefaultState().with(DIRECTION, Direction.EAST));
            worldIn.setBlockState(pos.add(0, 1, -1), ModBlocks.MANTEL_JUNGLE_TOP_LEFT.get().getDefaultState().with(DIRECTION, Direction.EAST));
            worldIn.setBlockState(pos.add(0, 1, 1), ModBlocks.MANTEL_JUNGLE_TOP_RIGHT.get().getDefaultState().with(DIRECTION, Direction.EAST));
            worldIn.setBlockState(pos.add(0, 0, -1), ModBlocks.MANTEL_JUNGLE_LEG_LEFT.get().getDefaultState().with(DIRECTION, Direction.EAST));
            worldIn.setBlockState(pos.add(0, 0, 1), ModBlocks.MANTEL_JUNGLE_LEG_RIGHT.get().getDefaultState().with(DIRECTION, Direction.EAST));
            //worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());

        }
        worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
    }


}
