package com.maideniles.maidensmerrymaking.blocks.fireplace.logs;

import com.maideniles.maidensmerrymaking.blocks.deco.HorizontalDecoBlock;
import com.maideniles.maidensmerrymaking.init.ModBlocks;
import com.maideniles.maidensmerrymaking.init.ModItems;
import javafx.geometry.Side;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.particles.ParticleTypes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

public class FireplaceBurning extends HorizontalDecoBlock {
    Random random = new Random();

    protected static final VoxelShape WEST_AABB = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D);
    protected static final VoxelShape EAST_AABB = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D);
    protected static final VoxelShape NORTH_AABB = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D);
    protected static final VoxelShape SOUTH_AABB = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D);

    public FireplaceBurning(Properties properties) {
        super(properties.hardnessAndResistance(1.0f, 1.0f).sound(SoundType.WOOD));
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state,  LivingEntity placer, ItemStack stack) {

        if (random.nextDouble() < 0.1D)
        {
            worldIn.playSound((double)((float)pos.getX() + 0.5F), (double)((float)pos.getY() + 0.5F), (double)((float)pos.getZ() + 0.5F),
            SoundEvents.BLOCK_FIRE_AMBIENT, SoundCategory.BLOCKS, 1.0F + random.nextFloat(), random.nextFloat() * 0.7F + 0.3F, false);
        }

    }

    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        if (rand.nextInt(18) == 0) {
            worldIn.playSound((double)((float)pos.getX() + 0.5F), (double)((float)pos.getY() + 0.5F), (double)((float)pos.getZ() + 0.5F),
      SoundEvents.BLOCK_FIRE_AMBIENT, SoundCategory.BLOCKS, 1.0F + rand.nextFloat(), rand.nextFloat() * 0.7F + 0.3F, false);
        }


        if (random.nextInt(10) == 0) {
                    double d3 = (double)pos.getX() + rand.nextDouble() * (double)0.1F;
                    double d8 = (double)pos.getY() + rand.nextDouble();
                    double d13 = (double)pos.getZ() + rand.nextDouble();
                    worldIn.addParticle(ParticleTypes.LARGE_SMOKE, d3, d8, d13, 0.0D, 0.0D, 0.0D);
                }

        if (random.nextInt(15) == 0) {
            double d4 = (double)(pos.getX() + 1) - rand.nextDouble() * (double)0.1F;
            double d9 = (double)pos.getY() + rand.nextDouble();
            double d14 = (double)pos.getZ() + rand.nextDouble();
            worldIn.addParticle(ParticleTypes.SMOKE, d4, d9, d14, 0.0D, 0.0D, 0.0D);
        }

        if (random.nextInt(50) == 0) {
            double d5 = (double)pos.getX() + rand.nextDouble();
            double d10 = (double)pos.getY() + rand.nextDouble();
            double d15 = (double)pos.getZ() + rand.nextDouble() * (double)0.1F;
            worldIn.addParticle(ParticleTypes.LAVA, d5, d10, d15, 0.0D, 0.0D, 0.0D);
        }

        if (random.nextInt(15) == 0) {
            double d6 = (double)pos.getX() + rand.nextDouble();
            double d11 = (double)pos.getY() + rand.nextDouble();
            double d16 = (double)(pos.getZ() + 1) - rand.nextDouble() * (double)0.1F;
            worldIn.addParticle(ParticleTypes.SMOKE, d6, d11, d16, 0.0D, 0.0D, 0.0D);
        }
            }







    @Override
    public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        ItemStack stack = player.getHeldItem(handIn);


        //defaultSmoke
        double d0 = (double)pos.getX() + worldIn.rand.nextDouble();
        double d1 = (double)pos.getY() + worldIn.rand.nextDouble() * 0.5D + 0.5D;
        double d2 = (double)pos.getZ() + worldIn.rand.nextDouble();


        if (stack.getItem() == Items.WATER_BUCKET) {

            System.out.println("WHOOSH!");
            worldIn.playSound((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, SoundEvents.ITEM_BUCKET_EMPTY_LAVA,
                    SoundCategory.BLOCKS, 1.0F, worldIn.rand.nextFloat() * 0.4F + 0.8F, false);
            worldIn.playSound((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, SoundEvents.BLOCK_LAVA_EXTINGUISH,
                    SoundCategory.BLOCKS, 1.0F, worldIn.rand.nextFloat() * 0.4F + 0.8F, false);

            worldIn.addParticle(ParticleTypes.LARGE_SMOKE, (double)pos.getX() + 0.25D + random.nextDouble() / 2.0D * (double)(random.nextBoolean()
                    ? 1 : -1), (double)pos.getY() + 0.4D, (double)pos.getZ() + 0.25D + random.nextDouble() / 2.0D *
                    (double)(random.nextBoolean() ? 1 : -1), 0.0D, 0.005D, 0.0D);


            worldIn.setBlockState(pos, ModBlocks.FIREPLACE_LOGS_BURNED.get().getDefaultState().with(DIRECTION, state.get(DIRECTION)));
            player.setHeldItem(handIn.MAIN_HAND, new ItemStack(Items.BUCKET));

        }

            Item water_bottle = PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), Potions.WATER).getItem();

            if (stack.getItem() == water_bottle) {

                System.out.println("GLUB GLUB!");
                worldIn.setBlockState(pos, ModBlocks.FIREPLACE_LOGS_BURNED.get().getDefaultState().with(DIRECTION, state.get(DIRECTION)));
                player.setHeldItem(handIn.MAIN_HAND, new ItemStack(Items.GLASS_BOTTLE));

                worldIn.playSound((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, SoundEvents.ITEM_BOTTLE_EMPTY,
                        SoundCategory.PLAYERS, 1.0F, worldIn.rand.nextFloat() * 0.4F + 0.8F, false);
                worldIn.playSound((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, SoundEvents.BLOCK_LAVA_EXTINGUISH,
                        SoundCategory.BLOCKS, 1.0F, worldIn.rand.nextFloat() * 0.4F + 0.8F, false);

                worldIn.addParticle(ParticleTypes.LARGE_SMOKE, (double)pos.getX() + 0.25D + random.nextDouble() / 2.0D * (double)(random.nextBoolean()
                        ? 1 : -1), (double)pos.getY() + 0.4D, (double)pos.getZ() + 0.25D + random.nextDouble() / 2.0D *
                        (double)(random.nextBoolean() ? 1 : -1), 0.0D, 0.005D, 0.0D);


            }


        return true;
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
