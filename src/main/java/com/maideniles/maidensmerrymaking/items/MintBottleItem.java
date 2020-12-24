package com.maideniles.maidensmerrymaking.items;

import com.maideniles.maidensmerrymaking.init.ModItems;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import java.util.List;

public class MintBottleItem extends Item {


    public MintBottleItem(Properties properties) {
        super(properties);
    }


    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        List<AreaEffectCloudEntity> list = worldIn.getEntitiesWithinAABB(AreaEffectCloudEntity.class, playerIn.getBoundingBox().grow(2.0D), (p_210311_0_) -> {
            return p_210311_0_ != null && p_210311_0_.isAlive() && p_210311_0_.getOwner() instanceof EnderDragonEntity;
        });
        ItemStack itemstack = playerIn.getHeldItem(handIn);

            RayTraceResult raytraceresult = rayTrace(worldIn, playerIn, RayTraceContext.FluidMode.SOURCE_ONLY);
            if (raytraceresult.getType() == RayTraceResult.Type.MISS) {
                return new ActionResult<>(ActionResultType.PASS, itemstack);
            } else {
                if (raytraceresult.getType() == RayTraceResult.Type.BLOCK) {
                    BlockPos blockpos = ((BlockRayTraceResult)raytraceresult).getPos();
                    if (!worldIn.isBlockModifiable(playerIn, blockpos)) {
                        return new ActionResult<>(ActionResultType.PASS, itemstack);
                    }

                    if (worldIn.getFluidState(blockpos).isTagged(FluidTags.WATER)) {
                        worldIn.playSound(playerIn, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.NEUTRAL, 1.0F, 1.0F);
                        return new ActionResult<>(ActionResultType.SUCCESS, this.turnBottleIntoItem(itemstack, playerIn, (new ItemStack(ModItems.PEPPERMINT_EXTRACT.get()))));
                    }
                }

                return new ActionResult<>(ActionResultType.PASS, itemstack);
            }
        }


    protected ItemStack turnBottleIntoItem(ItemStack p_185061_1_, PlayerEntity player, ItemStack stack) {
        p_185061_1_.shrink(1);
        player.addStat(Stats.ITEM_USED.get(this));
        if (p_185061_1_.isEmpty()) {
            return stack;
        } else {
            if (!player.inventory.addItemStackToInventory(stack)) {
                player.dropItem(stack, false);
            }

            return p_185061_1_;
        }
    }

}
