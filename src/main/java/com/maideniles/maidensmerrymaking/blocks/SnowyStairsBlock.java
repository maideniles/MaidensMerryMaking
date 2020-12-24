package com.maideniles.maidensmerrymaking.blocks;

import com.maideniles.maidensmerrymaking.init.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.StairsBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class SnowyStairsBlock extends StairsBlock {
    public SnowyStairsBlock(BlockState state, Properties properties) {
        super(state, properties);
    }



    @Override
    public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        ItemStack snow = player.getHeldItem(handIn);
        BlockState blockstate = worldIn.getBlockState(pos);

        if (!worldIn.isRemote()) {

            if (snow.getItem() == Items.SNOWBALL && blockstate.getBlock() == ModBlocks.ROOF_ACACIA_STAIRS.get() ) {
                System.out.println("GO GO SNOWY STAIRS!!");
                worldIn.setBlockState(pos, ModBlocks.SNOWY_ACACIA_STAIRS.get().getDefaultState().with(FACING, state.get(StairsBlock.FACING)));
                snow.shrink(1);
            }

            if (snow.getItem() == Items.SNOWBALL && blockstate.getBlock() == ModBlocks.ROOF_BIRCH_STAIRS.get() ) {
                System.out.println("GO GO SNOWY STAIRS!!");
                worldIn.setBlockState(pos, ModBlocks.SNOWY_BIRCH_STAIRS.get().getDefaultState().with(FACING, state.get(StairsBlock.FACING)));
                snow.shrink(1);
            }

            if (snow.getItem() == Items.SNOWBALL && blockstate.getBlock() == ModBlocks.ROOF_DARK_OAK_STAIRS.get() ) {
                System.out.println("GO GO SNOWY STAIRS!!");
                worldIn.setBlockState(pos, ModBlocks.SNOWY_DARK_OAK_STAIRS.get().getDefaultState().with(FACING, state.get(StairsBlock.FACING)));
                snow.shrink(1);
            }

            if (snow.getItem() == Items.SNOWBALL && blockstate.getBlock() == ModBlocks.ROOF_JUNGLE_STAIRS.get() ) {
                System.out.println("GO GO SNOWY STAIRS!!");
                worldIn.setBlockState(pos, ModBlocks.SNOWY_JUNGLE_STAIRS.get().getDefaultState().with(FACING, state.get(StairsBlock.FACING)));
                snow.shrink(1);
            }

            if (snow.getItem() == Items.SNOWBALL && blockstate.getBlock() == ModBlocks.ROOF_OAK_STAIRS.get() ) {
                System.out.println("GO GO SNOWY STAIRS!!");
                worldIn.setBlockState(pos, ModBlocks.SNOWY_OAK_STAIRS.get().getDefaultState().with(FACING, state.get(StairsBlock.FACING)));
                snow.shrink(1);
            }

            if (snow.getItem() == Items.SNOWBALL && blockstate.getBlock() == ModBlocks.ROOF_SPRUCE_STAIRS.get() ) {
                System.out.println("GO GO SNOWY STAIRS!!");
                worldIn.setBlockState(pos, ModBlocks.SNOWY_SPRUCE_STAIRS.get().getDefaultState().with(FACING, state.get(StairsBlock.FACING)));
                snow.shrink(1);
            }
        }
        return false;
    }

}
