package com.maideniles.maidensmerrymaking.init;

import com.maideniles.maidensmerrymaking.MaidensMerryMaking;
import com.maideniles.maidensmerrymaking.blocks.crop.ChristmasTreeCropBlockBottom;
import com.maideniles.maidensmerrymaking.blocks.crop.ChristmasTreeCropBlockMiddle;
import com.maideniles.maidensmerrymaking.blocks.crop.ChristmasTreeCropBlockTop;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS,
            MaidensMerryMaking.MODID);

  //  public static List<Item> gatheredOres = new ArrayList<>();
  //  public static List<String> oresIWant = new ArrayList<>();
  //  public static List<Block> validBlocks = new ArrayList<>();


    public static final List<Block> GRASS = new ArrayList<Block>();

    private static <B extends Block> RegistryObject<B> createBlockWithItem(String name, Supplier<? extends B> supplier, Supplier<BlockItem> item) {
        ModItems.ITEMS.register(name, item);
        return ModBlocks.BLOCKS.register(name, supplier);
    }

    private static <B extends Block> RegistryObject<B> createBlock(String name, Supplier<? extends B> supplier, @Nullable ItemGroup group) {
        RegistryObject<B> block = ModBlocks.BLOCKS.register(name, supplier);
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().group(group)));
        return block;
    }

    //blocks that make up the christmas pine feature//
    public static final RegistryObject<Block>   TREE = createBlock("christmas_pine_bottom",
            () -> new ChristmasTreeCropBlockBottom(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F)) , null);

    public static final RegistryObject<Block>   TREE_MIDDLE = createBlock("christmas_pine_middle",
            () -> new ChristmasTreeCropBlockMiddle(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F)) , null);

    public static final RegistryObject<Block>   TREE_TOP = createBlock("christmas_pine_top",
            () -> new ChristmasTreeCropBlockTop(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F)) , null);


}