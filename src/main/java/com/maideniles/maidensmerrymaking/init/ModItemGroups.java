package com.maideniles.maidensmerrymaking.init;

import com.maideniles.maidensmerrymaking.MaidensMerryMaking;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

import java.util.function.Supplier;

public class ModItemGroups {

    public static class ModItemGroup extends ItemGroup {

        private final Supplier<ItemStack> iconSupplier;

        public ModItemGroup(final String name, final Supplier<ItemStack> iconSupplier) {
            super(name);
            this.iconSupplier = iconSupplier;
        }

        @Override
        public ItemStack createIcon() {
            return iconSupplier.get();
        }

    }

    public static final ItemGroup MAIDENS_BLOCKS_GROUP = new ModItemGroup("maidens_blocks", () -> new ItemStack(Blocks.GOLD_BLOCK));
    public static final ItemGroup MAIDENS_ITEMS_GROUP = new ModItemGroup("maidens_items", () -> new ItemStack(Items.ENCHANTED_GOLDEN_APPLE));
}
