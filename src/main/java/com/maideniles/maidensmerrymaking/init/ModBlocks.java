package com.maideniles.maidensmerrymaking.init;

import com.maideniles.maidensmerrymaking.MaidensMerryMaking;
import com.maideniles.maidensmerrymaking.blocks.CustomDoorBlock;
import com.maideniles.maidensmerrymaking.blocks.deco.GarlandBlock;
import com.maideniles.maidensmerrymaking.blocks.deco.MantelDecoBlock;
import com.maideniles.maidensmerrymaking.blocks.fireplace.logs.Fireplace;
import com.maideniles.maidensmerrymaking.blocks.deco.WreathBlock;
import com.maideniles.maidensmerrymaking.blocks.fireplace.logs.FireplaceBurned;
import com.maideniles.maidensmerrymaking.blocks.fireplace.logs.FireplaceBurning;
import com.maideniles.maidensmerrymaking.blocks.fireplace.mantel.FireplaceMantel;
import com.maideniles.maidensmerrymaking.blocks.fireplace.mantel.single.*;
import com.maideniles.maidensmerrymaking.blocks.fireplace.mantel.stocking.MantelTopCenterWithStocking;
import com.maideniles.maidensmerrymaking.blocks.fireplace.mantel.stocking.MantelTopLeftWithStocking;
import com.maideniles.maidensmerrymaking.blocks.fireplace.mantel.stocking.MantelTopRightWithStocking;
import com.maideniles.maidensmerrymaking.blocks.fireplace.mantel.wide.FireplaceMantelDouble;
import com.maideniles.maidensmerrymaking.blocks.lamppost.LampPost;
import com.maideniles.maidensmerrymaking.blocks.lamppost.LampPostBottom;
import com.maideniles.maidensmerrymaking.blocks.lamppost.LampPostPole;
import com.maideniles.maidensmerrymaking.blocks.tree.ChristmasTreeTopBlock;
import com.maideniles.maidensmerrymaking.blocks.tree.ChristmasTreeMiddleBlock;
import com.maideniles.maidensmerrymaking.blocks.tree.ChristmasTreeBottomBlock;
import com.maideniles.maidensmerrymaking.blocks.TreeStandBlock;
import com.maideniles.maidensmerrymaking.blocks.tree.*;

import com.maideniles.maidensmerrymaking.blocks.tree.white_lights.*;
import com.maideniles.maidensmerrymaking.blocks.tree.multi_lights.ChristmasTreeMultiLightsBottomBlock;
import com.maideniles.maidensmerrymaking.blocks.tree.multi_lights.ChristmasTreeMultiLightsTopBlock;
import com.maideniles.maidensmerrymaking.blocks.tree.multi_lights.ChristmasTreeMultiLightsMiddleBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
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

    public static List<Block> validBlocks = new ArrayList<>();

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
            () -> new PineTreeBottomBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F).harvestLevel(1)) , null);

    public static final RegistryObject<Block>   TREE_MIDDLE = createBlock("christmas_pine_middle",
            () -> new PineTreeMiddleBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F).harvestLevel(1)) , null);

    public static final RegistryObject<Block>   TREE_TOP = createBlock("christmas_pine_top",
            () -> new PineTreeTopBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F).harvestLevel(1)) , null);

    //CHRISTMAS TREE//

    public static final RegistryObject<Block>   CHRISTMAS_TREE_STAND = createBlock("christmas_tree_stand",
            () -> new TreeStandBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5F, 2.0F)) , null);


    public static final RegistryObject<Block>   CHRISTMAS_TREE_BOTTOM = createBlock("christmas_tree_bottom",
            () -> new ChristmasTreeBottomBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F).harvestLevel(1)) , null);

    public static final RegistryObject<Block>   CHRISTMAS_TREE_MIDDLE = createBlock("christmas_tree_middle",
            () -> new ChristmasTreeMiddleBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F).harvestLevel(1)) , null);

    public static final RegistryObject<Block>   CHRISTMAS_TREE_TOP = createBlock("christmas_tree_top",
            () -> new ChristmasTreeTopBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F).harvestLevel(1)) , null);

    //CHRISTMAS TREE WHITE LIGHTS//

    public static final RegistryObject<Block>   CHRISTMAS_TREE_WHITE_LIGHTS_BOTTOM = createBlock("christmas_tree_white_lights_bottom",
            () -> new ChristmasTreeWhiteLightsBottomBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F).harvestLevel(1).lightValue(10)) , null);

    public static final RegistryObject<Block>   CHRISTMAS_TREE_WHITE_LIGHTS_MIDDLE = createBlock("christmas_tree_white_lights_middle",
            () -> new ChristmasTreeWhiteLightsMiddleBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F).harvestLevel(1).lightValue(10)) , null);

    public static final RegistryObject<Block>   CHRISTMAS_TREE_WHITE_LIGHTS_TOP = createBlock("christmas_tree_white_lights_top",
            () -> new ChristmasTreeWhiteLightsTopBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F).harvestLevel(1).lightValue(10)) , null);

//CHRISTMAS TREE MULTI LIGHTS//

    public static final RegistryObject<Block>   CHRISTMAS_TREE_MULTI_LIGHTS_BOTTOM = createBlock("christmas_tree_multi_lights_bottom",
            () -> new ChristmasTreeMultiLightsBottomBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F).harvestLevel(1).lightValue(10)) , null);

    public static final RegistryObject<Block>   CHRISTMAS_TREE_MULTI_LIGHTS_MIDDLE = createBlock("christmas_tree_multi_lights_middle",
            () -> new ChristmasTreeMultiLightsMiddleBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F).harvestLevel(1).lightValue(10)) , null);

    public static final RegistryObject<Block>   CHRISTMAS_TREE_MULTI_LIGHTS_TOP = createBlock("christmas_tree_multi_lights_top",
            () -> new ChristmasTreeMultiLightsTopBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F).harvestLevel(1).lightValue(10)) , null);

//WREATH BLOCKS//

    public static final RegistryObject<Block>   CHRISTMAS_WREATH = createBlock("christmas_wreath",
            () -> new WreathBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F).harvestLevel(1).lightValue(10).sound(SoundType.PLANT)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block>   CHRISTMAS_WREATH_WHITE_LIGHTS = createBlock("christmas_wreath_white_lights",
            () -> new WreathBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F).harvestLevel(1).lightValue(10).sound(SoundType.PLANT).lightValue(10)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block>   CHRISTMAS_WREATH_MULTI_LIGHTS = createBlock("christmas_wreath_multi_lights",
            () -> new WreathBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F).harvestLevel(1).lightValue(10).sound(SoundType.PLANT).lightValue(10)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);


//WREATH DOOR BLOCKS//

    public static final RegistryObject<Block> AcaciaWreathDoor = createBlock("acacia_wreath_door",
            () -> new CustomDoorBlock(Block.Properties.from(Blocks.OAK_DOOR)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> JungleWreathDoor = createBlock("jungle_wreath_door",
            () -> new CustomDoorBlock(Block.Properties.from(Blocks.OAK_DOOR)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> OakWreathDoor = createBlock("oak_wreath_door",
            () -> new CustomDoorBlock(Block.Properties.from(Blocks.OAK_DOOR)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> DarkOakWreathDoor = createBlock("dark_oak_wreath_door",
            () -> new CustomDoorBlock(Block.Properties.from(Blocks.OAK_DOOR)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> SpruceWreathDoor = createBlock("spruce_wreath_door",
            () -> new CustomDoorBlock(Block.Properties.from(Blocks.OAK_DOOR)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> BirchWreathDoor = createBlock("birch_wreath_door",
            () -> new CustomDoorBlock(Block.Properties.from(Blocks.OAK_DOOR)), ModItemGroups.MAIDENS_BLOCKS_GROUP);


    //WREATH WHITE LIGHTS DOOR//
    public static final RegistryObject<Block> AcaciaWreathLightsWhiteDoor = createBlock("acacia_wreath_lights_white_door",
            () -> new CustomDoorBlock(Block.Properties.from(Blocks.OAK_DOOR).lightValue(10)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> JungleWreathLightsWhiteDoor = createBlock("jungle_wreath_lights_white_door",
            () -> new CustomDoorBlock(Block.Properties.from(Blocks.OAK_DOOR).lightValue(10)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> OakWreathLightsWhiteDoor = createBlock("oak_wreath_lights_white_door",
            () -> new CustomDoorBlock(Block.Properties.from(Blocks.OAK_DOOR).lightValue(10)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> DarkOakWreathLightsWhiteDoor = createBlock("dark_oak_wreath_lights_white_door",
            () -> new CustomDoorBlock(Block.Properties.from(Blocks.OAK_DOOR).lightValue(10)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> SpruceWreathLightsWhiteDoor = createBlock("spruce_wreath_lights_white_door",
            () -> new CustomDoorBlock(Block.Properties.from(Blocks.OAK_DOOR).lightValue(10)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> BirchWreathLightsWhiteDoor = createBlock("birch_wreath_lights_white_door",
            () -> new CustomDoorBlock(Block.Properties.from(Blocks.OAK_DOOR).lightValue(10)), ModItemGroups.MAIDENS_BLOCKS_GROUP);


    //WREATH MULTI LIGHTS DOOR//
    public static final RegistryObject<Block> AcaciaWreathLightsMultiDoor = createBlock("acacia_wreath_lights_multi_door",
            () -> new CustomDoorBlock(Block.Properties.from(Blocks.OAK_DOOR).lightValue(10)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> JungleWreathLightsMultiDoor = createBlock("jungle_wreath_lights_multi_door",
            () -> new CustomDoorBlock(Block.Properties.from(Blocks.OAK_DOOR).lightValue(10)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> OakWreathLightsMultiDoor = createBlock("oak_wreath_lights_multi_door",
            () -> new CustomDoorBlock(Block.Properties.from(Blocks.OAK_DOOR).lightValue(10)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> DarkOakWreathLightsMultiDoor = createBlock("dark_oak_wreath_lights_multi_door",
            () -> new CustomDoorBlock(Block.Properties.from(Blocks.OAK_DOOR).lightValue(10)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> SpruceWreathLightsMultiDoor = createBlock("spruce_wreath_lights_multi_door",
            () -> new CustomDoorBlock(Block.Properties.from(Blocks.OAK_DOOR).lightValue(10)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> BirchWreathLightsMultiDoor = createBlock("birch_wreath_lights_multi_door",
            () -> new CustomDoorBlock(Block.Properties.from(Blocks.OAK_DOOR).lightValue(10)), ModItemGroups.MAIDENS_BLOCKS_GROUP);


    //FIREPLACE LOGS//
    public static final RegistryObject<Block> FIREPLACE_LOGS = createBlock("fireplace_logs",
            () -> new Fireplace(Block.Properties.from(Blocks.CAMPFIRE).lightValue(0)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> FIREPLACE_LOGS_BURNING = createBlock("fireplace_logs_on",
            () -> new FireplaceBurning(Block.Properties.from(Blocks.CAMPFIRE).lightValue(10)), null);

    public static final RegistryObject<Block> FIREPLACE_LOGS_BURNED = createBlock("fireplace_logs_burned",
            () -> new FireplaceBurned(Block.Properties.from(Blocks.CAMPFIRE).lightValue(0)), null);

//FIREPLACE MANTEL//

    public static final RegistryObject<Block>   MANTEL_NORMAL = createBlock("mantel_normal",
            () -> new MantelBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);
/*
    public static final RegistryObject<Block>   MANTEL_DOUBLE = createBlock("mantel_double",
            () -> new FireplaceMantelDouble(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);
*/
    //ACTUAL MANTEL BLOCKS//

    public static final RegistryObject<Block>   MANTEL_TOP_LEFT = createBlock("mantel_top_left",
            () -> new MantelTopLeft(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , null);

    public static final RegistryObject<Block>   MANTEL_TOP_RIGHT = createBlock("mantel_top_right",
            () -> new MantelTopRight(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , null);

    public static final RegistryObject<Block>   MANTEL_TOP_MIDDLE = createBlock("mantel_top_middle",
            () -> new MantelTopCenter(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , null);

    public static final RegistryObject<Block>   MANTEL_LEG_RIGHT = createBlock("mantel_leg_right",
            () -> new MantelLegRight(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , null);

    public static final RegistryObject<Block>   MANTEL_LEG_LEFT = createBlock("mantel_leg_left",
            () -> new MantelLegLeft(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , null);

    //MANTEL WITH STOCKING BLOCKS//
    public static final RegistryObject<Block>   MANTEL_TOP_LEFT_STOCKING = createBlock("mantel_top_left_stocking",
            () -> new MantelTopLeftWithStocking(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , null);

    public static final RegistryObject<Block>   MANTEL_TOP_RIGHT_STOCKING = createBlock("mantel_top_right_stocking",
            () -> new MantelTopRightWithStocking(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , null);

    public static final RegistryObject<Block>   MANTEL_TOP_MIDDLE_STOCKING = createBlock("mantel_top_middle_stocking",
            () -> new MantelTopCenterWithStocking(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , null);


    //LAMP POSTS//

    public static final RegistryObject<Block>   LAMP_POST = createBlock("lamp_post",
            () -> new LampPost(Block.Properties.create(Material.IRON).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.LANTERN).lightValue(10)) , null);

    public static final RegistryObject<Block>   LAMP_POST_ON = createBlock("lamp_post_on",
            () -> new LampPost(Block.Properties.create(Material.IRON).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.LANTERN)) , null);

    public static final RegistryObject<Block>   LAMP_POST_POLE = createBlock("lamp_post_pole",
            () -> new LampPostPole(Block.Properties.create(Material.IRON).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.LANTERN)) , null);

    public static final RegistryObject<Block>   LAMP_POST_BOTTOM = createBlock("lamp_post_bottom",
            () -> new LampPostBottom(Block.Properties.create(Material.IRON).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.LANTERN)) , null);

    //GARLAND BLOCKS//

    public static final RegistryObject<Block>   GARLAND_HORIZONTAL = createBlock("garland_horizontal",
            () -> new GarlandBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.PLANT)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block>   GARLAND_HORIZONTAL_LIGHTS_WHITE = createBlock("garland_horizontal_lights_white",
            () -> new GarlandBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.PLANT)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block>   GARLAND_HORIZONTAL_LIGHTS_MULTI = createBlock("garland_horizontal_lights_multi",
            () -> new GarlandBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.PLANT)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);


    //MANTEL DECO//

    public static final RegistryObject<Block>   MANTEL_DECO = createBlock("mantel_deco",
            () -> new MantelDecoBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block>   MANTEL_DECO_1 = createBlock("mantel_deco_1",
            () -> new MantelDecoBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block>   MANTEL_DECO_2 = createBlock("mantel_deco_2",
            () -> new MantelDecoBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block>   MANTEL_DECO_3 = createBlock("mantel_deco_3",
            () -> new MantelDecoBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block>   MANTEL_DECO_4 = createBlock("mantel_deco_4",
            () -> new MantelDecoBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block>   MANTEL_DECO_5 = createBlock("mantel_deco_5",
            () -> new MantelDecoBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);
}