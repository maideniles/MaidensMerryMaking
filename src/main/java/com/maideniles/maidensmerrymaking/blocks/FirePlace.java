package com.maideniles.maidensmerrymaking.blocks;


import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class FirePlace  extends Block {

    protected static final AxisAlignedBB MANTEL_AABB_NORTH = new AxisAlignedBB(-0.5D, 0.0D, 0.0D, 1.5D, 1.5D, 0.5D);
    protected static final AxisAlignedBB MANTEL_AABB_SOUTH = new AxisAlignedBB(-0.5D, 0.0D, 0.0D, 1.5D, 1.5D, 0.5D);
    protected static final AxisAlignedBB MANTEL_AABB_EAST = new AxisAlignedBB(-0.5D, 0.0D, 0.0D, 1.5D, 1.5D, 0.5D);
    protected static final AxisAlignedBB MANTEL_AABB_WEST = new AxisAlignedBB(-0.5D, 0.0D, 0.0D, 1.5D, 1.5D, 0.5D);

    public FirePlace(Properties properties) {
        super(properties.hardnessAndResistance(1.0f, 1.0f).sound(SoundType.WOOD));
    }

    @Override
    public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        ItemStack stack = player.getHeldItem(handIn);
        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }
}
