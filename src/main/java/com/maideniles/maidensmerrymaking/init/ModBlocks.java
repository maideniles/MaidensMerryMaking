package com.maideniles.maidensmerrymaking.init;

import com.maideniles.maidensmerrymaking.MaidensMerryMaking;
import com.maideniles.maidensmerrymaking.blocks.*;
import com.maideniles.maidensmerrymaking.blocks.crop.GingerRoot;
import com.maideniles.maidensmerrymaking.blocks.crop.MintPlant;
import com.maideniles.maidensmerrymaking.blocks.deco.MantelDecoBlock;
import com.maideniles.maidensmerrymaking.blocks.deco.TopperBlock;
import com.maideniles.maidensmerrymaking.blocks.fireplace.logs.Fireplace;
import com.maideniles.maidensmerrymaking.blocks.deco.WreathBlock;
import com.maideniles.maidensmerrymaking.blocks.fireplace.logs.FireplaceBurned;
import com.maideniles.maidensmerrymaking.blocks.fireplace.logs.FireplaceBurning;
import com.maideniles.maidensmerrymaking.blocks.fireplace.mantel.single.*;
import com.maideniles.maidensmerrymaking.blocks.fireplace.mantel.stocking.*;

import com.maideniles.maidensmerrymaking.blocks.lamppost.LampPost;
import com.maideniles.maidensmerrymaking.blocks.lamppost.LampPostBottom;
import com.maideniles.maidensmerrymaking.blocks.lamppost.LampPostOn;
import com.maideniles.maidensmerrymaking.blocks.lamppost.LampPostPole;
import com.maideniles.maidensmerrymaking.blocks.tree.ChristmasTreeTopBlock;
import com.maideniles.maidensmerrymaking.blocks.tree.ChristmasTreeMiddleBlock;
import com.maideniles.maidensmerrymaking.blocks.tree.ChristmasTreeBottomBlock;
import com.maideniles.maidensmerrymaking.blocks.tree.*;

import com.maideniles.maidensmerrymaking.blocks.tree.white_lights.*;
import com.maideniles.maidensmerrymaking.blocks.tree.multi_lights.ChristmasTreeMultiLightsBottomBlock;
import com.maideniles.maidensmerrymaking.blocks.tree.multi_lights.ChristmasTreeMultiLightsTopBlock;
import com.maideniles.maidensmerrymaking.blocks.tree.multi_lights.ChristmasTreeMultiLightsMiddleBlock;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
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


public static final RegistryObject<Block> MINT_PLANT = createBlock("mint_plant",
        () -> new MintPlant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0).sound(SoundType.CROP)), null);

    public static final RegistryObject<Block> GINGER_PLANT = createBlock("ginger_plant",
            () -> new GingerRoot(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0).sound(SoundType.CROP)), null);

    //blocks that make up the christmas pine feature//
    public static final RegistryObject<Block>   TREE = createBlock("christmas_pine_bottom",
            () -> new PineTreeBottomBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F).harvestLevel(1)) , null);

    public static final RegistryObject<Block>   TREE_MIDDLE = createBlock("christmas_pine_middle",
            () -> new PineTreeMiddleBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F).harvestLevel(1)) , null);

    public static final RegistryObject<Block>   TREE_TOP = createBlock("christmas_pine_top",
            () -> new PineTreeTopBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F).harvestLevel(1)) , null);

    //CHRISTMAS TREE//

    public static final RegistryObject<Block>   CHRISTMAS_TREE_STAND = createBlock("christmas_tree_stand",
            () -> new TreeStandBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5F, 2.0F)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);


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
            () -> new WreathBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F).harvestLevel(1).sound(SoundType.PLANT)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block>   CHRISTMAS_WREATH_WHITE_LIGHTS = createBlock("christmas_wreath_white_lights",
            () -> new WreathBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F).harvestLevel(1).lightValue(10).sound(SoundType.PLANT).lightValue(10)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block>   CHRISTMAS_WREATH_MULTI_LIGHTS = createBlock("christmas_wreath_multi_lights",
            () -> new WreathBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F).harvestLevel(1).lightValue(10).sound(SoundType.PLANT).lightValue(10)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);


    //BOW BLOCK//
    public static final RegistryObject<Block>   BOW_TOPPER = createBlock("bow_topper",
            () -> new TopperBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F).harvestLevel(1).sound(SoundType.PLANT)) , null);
//STAR BLOCK//
    public static final RegistryObject<Block>   STAR_TOPPER = createBlock("star_topper",
            () -> new TopperBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F).harvestLevel(1)) , null);




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

//FIREPLACE MANTEL ACACIA//

    public static final RegistryObject<Block>   MANTEL_ACACIA_NORMAL = createBlock("mantel_normal_acacia",
            () -> new MantelBlockAcacia(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);


//ACTUAL MANTEL_ACACIA BLOCKS//
public static final RegistryObject<Block>   MANTEL_ACACIA_TOP_LEFT = createBlock("mantel_acacia_top_left",
        () -> new MantelTopLeftAcacia(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 2.0F)
                .harvestLevel(1).sound(SoundType.WOOD)) , null);

    public static final RegistryObject<Block>   MANTEL_ACACIA_TOP_RIGHT = createBlock("mantel_acacia_top_right",
            () -> new MantelTopRightAcacia(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , null);

    public static final RegistryObject<Block>   MANTEL_ACACIA_TOP_MIDDLE = createBlock("mantel_acacia_top_middle",
            () -> new MantelTopCenterAcacia(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , null);

    public static final RegistryObject<Block>   MANTEL_ACACIA_LEG_RIGHT = createBlock("mantel_acacia_leg_right",
            () -> new MantelLegRightAcacia(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , null);

    public static final RegistryObject<Block>   MANTEL_ACACIA_LEG_LEFT = createBlock("mantel_acacia_leg_left",
            () -> new MantelLegLeftAcacia(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , null);

    //MANTEL_ACACIA WITH STOCKING BLOCKS//
    public static final RegistryObject<Block>   MANTEL_ACACIA_TOP_LEFT_STOCKING = createBlock("mantel_acacia_top_left_stocking",
            () -> new MantelTopLeftAcaciaWithStocking(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , null);

    public static final RegistryObject<Block>   MANTEL_ACACIA_TOP_RIGHT_STOCKING = createBlock("mantel_acacia_top_right_stocking",
            () -> new MantelTopRightAcaciaWithStocking(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , null);

    public static final RegistryObject<Block>   MANTEL_ACACIA_TOP_MIDDLE_STOCKING = createBlock("mantel_acacia_top_middle_stocking",
            () -> new MantelTopCenterAcaciaWithStocking(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 2.0F) .harvestLevel(1).sound(SoundType.WOOD)) , null);

//FIREPLACE MANTEL BIRCH//

    public static final RegistryObject<Block>   MANTEL_BIRCH_NORMAL = createBlock("mantel_normal_birch",
            () -> new MantelBlockBirch(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);


    //ACTUAL MANTEL_BIRCH BLOCKS//
    public static final RegistryObject<Block>   MANTEL_BIRCH_TOP_LEFT = createBlock("mantel_birch_top_left",
            () -> new MantelTopLeftBirch(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , null);

    public static final RegistryObject<Block>   MANTEL_BIRCH_TOP_RIGHT = createBlock("mantel_birch_top_right",
            () -> new MantelTopRightBirch(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , null);

    public static final RegistryObject<Block>   MANTEL_BIRCH_TOP_MIDDLE = createBlock("mantel_birch_top_middle",
            () -> new MantelTopCenterBirch(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , null);

    public static final RegistryObject<Block>   MANTEL_BIRCH_LEG_RIGHT = createBlock("mantel_birch_leg_right",
            () -> new MantelLegRightBirch(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , null);

    public static final RegistryObject<Block>   MANTEL_BIRCH_LEG_LEFT = createBlock("mantel_birch_leg_left",
            () -> new MantelLegLeftBirch(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , null);

    //MANTEL_BIRCH WITH STOCKING BLOCKS//
    public static final RegistryObject<Block>   MANTEL_BIRCH_TOP_LEFT_STOCKING = createBlock("mantel_birch_top_left_stocking",
            () -> new MantelTopLeftBirchWithStocking(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , null);

    public static final RegistryObject<Block>   MANTEL_BIRCH_TOP_RIGHT_STOCKING = createBlock("mantel_birch_top_right_stocking",
            () -> new MantelTopRightBirchWithStocking(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , null);

    public static final RegistryObject<Block>   MANTEL_BIRCH_TOP_MIDDLE_STOCKING = createBlock("mantel_birch_top_middle_stocking",
            () -> new MantelTopCenterBirchWithStocking(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 2.0F) .harvestLevel(1).sound(SoundType.WOOD)) , null);


//FIREPLACE MANTEL DARK_OAK//

    public static final RegistryObject<Block>   MANTEL_DARK_OAK_NORMAL = createBlock("mantel_normal_dark_oak",
            () -> new MantelBlockDarkOak(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);


    //ACTUAL MANTEL_DARK_OAK BLOCKS//
    public static final RegistryObject<Block>   MANTEL_DARK_OAK_TOP_LEFT = createBlock("mantel_dark_oak_top_left",
            () -> new MantelTopLeftDarkOak(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , null);

    public static final RegistryObject<Block>   MANTEL_DARK_OAK_TOP_RIGHT = createBlock("mantel_dark_oak_top_right",
            () -> new MantelTopRightDarkOak(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , null);

    public static final RegistryObject<Block>   MANTEL_DARK_OAK_TOP_MIDDLE = createBlock("mantel_dark_oak_top_middle",
            () -> new MantelTopCenterDarkOak(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , null);

    public static final RegistryObject<Block>   MANTEL_DARK_OAK_LEG_RIGHT = createBlock("mantel_dark_oak_leg_right",
            () -> new MantelLegRightDarkOak(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , null);

    public static final RegistryObject<Block>   MANTEL_DARK_OAK_LEG_LEFT = createBlock("mantel_dark_oak_leg_left",
            () -> new MantelLegLeftDarkOak(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , null);

    //MANTEL_DARK_OAK WITH STOCKING BLOCKS//
    public static final RegistryObject<Block>   MANTEL_DARK_OAK_TOP_LEFT_STOCKING = createBlock("mantel_dark_oak_top_left_stocking",
            () -> new MantelTopLeftDarkOakWithStocking(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , null);

    public static final RegistryObject<Block>   MANTEL_DARK_OAK_TOP_RIGHT_STOCKING = createBlock("mantel_dark_oak_top_right_stocking",
            () -> new MantelTopRightDarkOakWithStocking(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , null);

    public static final RegistryObject<Block>   MANTEL_DARK_OAK_TOP_MIDDLE_STOCKING = createBlock("mantel_dark_oak_top_middle_stocking",
            () -> new MantelTopCenterDarkOakWithStocking(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 2.0F) .harvestLevel(1).sound(SoundType.WOOD)) , null);

//FIREPLACE MANTEL JUNGLE//

    public static final RegistryObject<Block>   MANTEL_JUNGLE_NORMAL = createBlock("mantel_normal_jungle",
            () -> new MantelBlockJungle(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);


    //ACTUAL MANTEL_JUNGLE BLOCKS//
    public static final RegistryObject<Block>   MANTEL_JUNGLE_TOP_LEFT = createBlock("mantel_jungle_top_left",
            () -> new MantelTopLeftJungle(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , null);

    public static final RegistryObject<Block>   MANTEL_JUNGLE_TOP_RIGHT = createBlock("mantel_jungle_top_right",
            () -> new MantelTopRightJungle(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , null);

    public static final RegistryObject<Block>   MANTEL_JUNGLE_TOP_MIDDLE = createBlock("mantel_jungle_top_middle",
            () -> new MantelTopCenterJungle(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , null);

    public static final RegistryObject<Block>   MANTEL_JUNGLE_LEG_RIGHT = createBlock("mantel_jungle_leg_right",
            () -> new MantelLegRightJungle(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , null);

    public static final RegistryObject<Block>   MANTEL_JUNGLE_LEG_LEFT = createBlock("mantel_jungle_leg_left",
            () -> new MantelLegLeftJungle(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , null);

    //MANTEL_JUNGLE WITH STOCKING BLOCKS//
    public static final RegistryObject<Block>   MANTEL_JUNGLE_TOP_LEFT_STOCKING = createBlock("mantel_jungle_top_left_stocking",
            () -> new MantelTopLeftJungleWithStocking(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , null);

    public static final RegistryObject<Block>   MANTEL_JUNGLE_TOP_RIGHT_STOCKING = createBlock("mantel_jungle_top_right_stocking",
            () -> new MantelTopRightJungleWithStocking(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , null);

    public static final RegistryObject<Block>   MANTEL_JUNGLE_TOP_MIDDLE_STOCKING = createBlock("mantel_jungle_top_middle_stocking",
            () -> new MantelTopCenterJungleWithStocking(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 2.0F) .harvestLevel(1).sound(SoundType.WOOD)) , null);

//FIREPLACE MANTEL OAK//

    public static final RegistryObject<Block>   MANTEL_OAK_NORMAL = createBlock("mantel_normal_oak",
            () -> new MantelBlockOak(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);


    //ACTUAL MANTEL_OAK BLOCKS//
    public static final RegistryObject<Block>   MANTEL_OAK_TOP_LEFT = createBlock("mantel_oak_top_left",
            () -> new MantelTopLeftOak(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , null);

    public static final RegistryObject<Block>   MANTEL_OAK_TOP_RIGHT = createBlock("mantel_oak_top_right",
            () -> new MantelTopRightOak(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , null);

    public static final RegistryObject<Block>   MANTEL_OAK_TOP_MIDDLE = createBlock("mantel_oak_top_middle",
            () -> new MantelTopCenterOak(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , null);

    public static final RegistryObject<Block>   MANTEL_OAK_LEG_RIGHT = createBlock("mantel_oak_leg_right",
            () -> new MantelLegRightOak(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , null);

    public static final RegistryObject<Block>   MANTEL_OAK_LEG_LEFT = createBlock("mantel_oak_leg_left",
            () -> new MantelLegLeftOak(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , null);

    //MANTEL_OAK WITH STOCKING BLOCKS//
    public static final RegistryObject<Block>   MANTEL_OAK_TOP_LEFT_STOCKING = createBlock("mantel_oak_top_left_stocking",
            () -> new MantelTopLeftOakWithStocking(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , null);

    public static final RegistryObject<Block>   MANTEL_OAK_TOP_RIGHT_STOCKING = createBlock("mantel_oak_top_right_stocking",
            () -> new MantelTopRightOakWithStocking(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , null);

    public static final RegistryObject<Block>   MANTEL_OAK_TOP_MIDDLE_STOCKING = createBlock("mantel_oak_top_middle_stocking",
            () -> new MantelTopCenterOakWithStocking(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 2.0F) .harvestLevel(1).sound(SoundType.WOOD)) , null);

//FIREPLACE MANTEL SPRUCE//

    public static final RegistryObject<Block>   MANTEL_SPRUCE_NORMAL = createBlock("mantel_normal_spruce",
            () -> new MantelBlockSpruce(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);


    //ACTUAL MANTEL_SPRUCE BLOCKS//
    public static final RegistryObject<Block>   MANTEL_SPRUCE_TOP_LEFT = createBlock("mantel_spruce_top_left",
            () -> new MantelTopLeftSpruce(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , null);

    public static final RegistryObject<Block>   MANTEL_SPRUCE_TOP_RIGHT = createBlock("mantel_spruce_top_right",
            () -> new MantelTopRightSpruce(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , null);

    public static final RegistryObject<Block>   MANTEL_SPRUCE_TOP_MIDDLE = createBlock("mantel_spruce_top_middle",
            () -> new MantelTopCenterSpruce(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , null);

    public static final RegistryObject<Block>   MANTEL_SPRUCE_LEG_RIGHT = createBlock("mantel_spruce_leg_right",
            () -> new MantelLegRightSpruce(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , null);

    public static final RegistryObject<Block>   MANTEL_SPRUCE_LEG_LEFT = createBlock("mantel_spruce_leg_left",
            () -> new MantelLegLeftSpruce(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , null);

    //MANTEL_SPRUCE WITH STOCKING BLOCKS//
    public static final RegistryObject<Block>   MANTEL_SPRUCE_TOP_LEFT_STOCKING = createBlock("mantel_spruce_top_left_stocking",
            () -> new MantelTopLeftSpruceWithStocking(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , null);

    public static final RegistryObject<Block>   MANTEL_SPRUCE_TOP_RIGHT_STOCKING = createBlock("mantel_spruce_top_right_stocking",
            () -> new MantelTopRightSpruceWithStocking(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.WOOD)) , null);

    public static final RegistryObject<Block>   MANTEL_SPRUCE_TOP_MIDDLE_STOCKING = createBlock("mantel_spruce_top_middle_stocking",
            () -> new MantelTopCenterSpruceWithStocking(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 2.0F) .harvestLevel(1).sound(SoundType.WOOD)) , null);































    //LAMP POSTS//
    public static final RegistryObject<Block>   LAMP_POST = createBlock("lamp_post",
            () -> new LampPost(Block.Properties.create(Material.IRON).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.LANTERN)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block>   LAMP_POST_ON = createBlock("lamp_post_on",
            () -> new LampPostOn(Block.Properties.create(Material.IRON).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.LANTERN).lightValue(10)) , null);

    public static final RegistryObject<Block>   LAMP_POST_POLE = createBlock("lamp_post_pole",
            () -> new LampPostPole(Block.Properties.create(Material.IRON).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.LANTERN)) , null);

    public static final RegistryObject<Block>   LAMP_POST_BOTTOM = createBlock("lamp_post_bottom",
            () -> new LampPostBottom(Block.Properties.create(Material.IRON).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.LANTERN)) , null);


    //LAMP POSTS WITH DECO//
    public static final RegistryObject<Block>   LAMP_POST_POLE_BOW = createBlock("lamp_post_pole_bow",
            () -> new LampPostPole(Block.Properties.create(Material.IRON).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.CLOTH)) , null);

    public static final RegistryObject<Block>   LAMP_POST_POLE_WREATH = createBlock("lamp_post_pole_wreath",
            () -> new LampPostPole(Block.Properties.create(Material.IRON).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.PLANT)) , null);

    public static final RegistryObject<Block>   LAMP_POST_POLE_WREATH_WHITE = createBlock("lamp_post_pole_wreath_white",
            () -> new LampPostPole(Block.Properties.create(Material.IRON).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.PLANT).lightValue(10)) , null);

    public static final RegistryObject<Block>   LAMP_POST_POLE_WREATH_MULTI = createBlock("lamp_post_pole_wreath_multi",
            () -> new LampPostPole(Block.Properties.create(Material.IRON).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.PLANT).lightValue(10)) , null);


    public static final RegistryObject<Block>   GARLAND_DIAGONAL_LEFT = createBlock("garland_diagonal_left",
            () -> new GarlandBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.PLANT)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block>   GARLAND_DIAGONAL_RIGHT = createBlock("garland_diagonal_right",
            () -> new GarlandBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.PLANT)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);

//GARLAND BLOCKS--DIAGONAL//
    public static final RegistryObject<Block>   GARLAND_LIGHTS_DIAGONAL_LEFT = createBlock("garland_lights_diagonal_left",
            () -> new GarlandBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.PLANT).lightValue(10)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block>   GARLAND_LIGHTS_DIAGONAL_RIGHT = createBlock("garland_lights_diagonal_right",
            () -> new GarlandBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.PLANT).lightValue(10)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block>   GARLAND_MULTI_DIAGONAL_LEFT = createBlock("garland_multi_diagonal_left",
            () -> new GarlandBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.PLANT).lightValue(10)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block>   GARLAND_MULTI_DIAGONAL_RIGHT = createBlock("garland_multi_diagonal_right",
            () -> new GarlandBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.PLANT).lightValue(10)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);


    //GARLAND BLOCKS--HORIZONTAL//
    public static final RegistryObject<Block>   GARLAND_HORIZONTAL = createBlock("garland_horizontal",
            () -> new GarlandBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.PLANT)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block>   GARLAND_HORIZONTAL_LIGHTS_WHITE = createBlock("garland_horizontal_lights",
            () -> new GarlandBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F)
                    .harvestLevel(1).sound(SoundType.PLANT)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block>   GARLAND_HORIZONTAL_LIGHTS_MULTI = createBlock("garland_horizontal_multi",
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


    //ROOF STAIRS//
    public static final RegistryObject<Block> ROOF_ACACIA_STAIRS = createBlock( "roof_acacia_stairs",
            () -> new SnowyStairsBlock( Blocks.ACACIA_PLANKS.getDefaultState(), Block.Properties.create(Material.ROCK, MaterialColor.SNOW)
                    .hardnessAndResistance(1.5F)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> ROOF_BIRCH_STAIRS = createBlock( "roof_birch_stairs",
            () -> new SnowyStairsBlock( Blocks.BIRCH_PLANKS.getDefaultState(), Block.Properties.create(Material.ROCK, MaterialColor.SNOW)
                    .hardnessAndResistance(1.5F)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> ROOF_DARK_OAK_STAIRS = createBlock( "roof_dark_oak_stairs",
            () -> new SnowyStairsBlock( Blocks.DARK_OAK_PLANKS.getDefaultState(), Block.Properties.create(Material.ROCK, MaterialColor.SNOW)
                    .hardnessAndResistance(1.5F)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> ROOF_JUNGLE_STAIRS = createBlock( "roof_jungle_stairs",
            () -> new SnowyStairsBlock( Blocks.JUNGLE_PLANKS.getDefaultState(), Block.Properties.create(Material.ROCK, MaterialColor.SNOW)
                    .hardnessAndResistance(1.5F)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> ROOF_OAK_STAIRS= createBlock( "roof_oak_stairs",
            () -> new SnowyStairsBlock( Blocks.OAK_PLANKS.getDefaultState(), Block.Properties.create(Material.ROCK, MaterialColor.SNOW)
                    .hardnessAndResistance(1.5F)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> ROOF_SPRUCE_STAIRS = createBlock( "roof_spruce_stairs",
            () -> new SnowyStairsBlock( Blocks.SPRUCE_PLANKS.getDefaultState(), Block.Properties.create(Material.ROCK, MaterialColor.SNOW)
                    .hardnessAndResistance(1.5F)), ModItemGroups.MAIDENS_BLOCKS_GROUP);


    //TESTING SNOW ON STAIRS//
    public static final RegistryObject<Block> SNOWY_ACACIA_STAIRS = createBlock( "snowy_acacia_stairs",
            () -> new StairsBlock(() -> Blocks.ACACIA_PLANKS.getDefaultState(), Block.Properties.create(Material.ROCK, MaterialColor.SNOW)
                    .hardnessAndResistance(1.5F)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> SNOWY_BIRCH_STAIRS = createBlock( "snowy_birch_stairs",
            () -> new StairsBlock(() -> Blocks.BIRCH_PLANKS.getDefaultState(), Block.Properties.create(Material.ROCK, MaterialColor.SNOW)
                    .hardnessAndResistance(1.5F)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> SNOWY_DARK_OAK_STAIRS = createBlock( "snowy_dark_oak_stairs",
            () -> new StairsBlock(() -> Blocks.DARK_OAK_PLANKS.getDefaultState(), Block.Properties.create(Material.ROCK, MaterialColor.SNOW)
                    .hardnessAndResistance(1.5F)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> SNOWY_JUNGLE_STAIRS = createBlock( "snowy_jungle_stairs",
            () -> new StairsBlock(() -> Blocks.JUNGLE_PLANKS.getDefaultState(), Block.Properties.create(Material.ROCK, MaterialColor.SNOW)
                    .hardnessAndResistance(1.5F)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> SNOWY_OAK_STAIRS= createBlock( "snowy_oak_stairs",
            () -> new StairsBlock(() -> Blocks.OAK_PLANKS.getDefaultState(), Block.Properties.create(Material.ROCK, MaterialColor.SNOW)
                    .hardnessAndResistance(1.5F)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> SNOWY_SPRUCE_STAIRS = createBlock( "snowy_spruce_stairs",
            () -> new StairsBlock(() -> Blocks.SPRUCE_PLANKS.getDefaultState(), Block.Properties.create(Material.ROCK, MaterialColor.SNOW)
                    .hardnessAndResistance(1.5F)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    //PICKET FENCES//
    public static final RegistryObject<Block> ACACIA_PICKET_FENCE = createBlock("acacia_picket_fence",
            () -> new ChristmasFence(Block.Properties.create(Material.WOOD, MaterialColor.GOLD).hardnessAndResistance(1.5F)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> BIRCH_PICKET_FENCE = createBlock("birch_picket_fence",
            () -> new ChristmasFence(Block.Properties.create(Material.WOOD, MaterialColor.GOLD).hardnessAndResistance(1.5F)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> DARK_OAK_PICKET_FENCE = createBlock("dark_oak_picket_fence",
            () -> new ChristmasFence(Block.Properties.create(Material.WOOD, MaterialColor.GOLD).hardnessAndResistance(1.5F)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> JUNGLE_PICKET_FENCE = createBlock("jungle_picket_fence",
            () -> new ChristmasFence(Block.Properties.create(Material.WOOD, MaterialColor.GOLD).hardnessAndResistance(1.5F)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> OAK_PICKET_FENCE = createBlock("oak_picket_fence",
            () -> new ChristmasFence(Block.Properties.create(Material.WOOD, MaterialColor.GOLD).hardnessAndResistance(1.5F)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> SPRUCE_PICKET_FENCE = createBlock("spruce_picket_fence",
            () -> new ChristmasFence(Block.Properties.create(Material.WOOD, MaterialColor.GOLD).hardnessAndResistance(1.5F)), ModItemGroups.MAIDENS_BLOCKS_GROUP);


    //DECORATED FENCES//
    public static final RegistryObject<Block> ACACIA_WREATH_FENCE = createBlock("acacia_wreath_fence",
            () -> new ChristmasFence(Block.Properties.create(Material.WOOD, MaterialColor.GOLD).hardnessAndResistance(1.5F)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> BIRCH_WREATH_FENCE = createBlock("birch_wreath_fence",
            () -> new ChristmasFence(Block.Properties.create(Material.WOOD, MaterialColor.GOLD).hardnessAndResistance(1.5F)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> DARK_OAK_WREATH_FENCE = createBlock("dark_oak_wreath_fence",
            () -> new ChristmasFence(Block.Properties.create(Material.WOOD, MaterialColor.GOLD).hardnessAndResistance(1.5F)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> JUNGLE_WREATH_FENCE = createBlock("jungle_wreath_fence",
            () -> new ChristmasFence(Block.Properties.create(Material.WOOD, MaterialColor.GOLD).hardnessAndResistance(1.5F)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> OAK_WREATH_FENCE = createBlock("oak_wreath_fence",
            () -> new ChristmasFence(Block.Properties.create(Material.WOOD, MaterialColor.GOLD).hardnessAndResistance(1.5F)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> SPRUCE_WREATH_FENCE = createBlock("spruce_wreath_fence",
            () -> new ChristmasFence(Block.Properties.create(Material.WOOD, MaterialColor.GOLD).hardnessAndResistance(1.5F)), ModItemGroups.MAIDENS_BLOCKS_GROUP);


    //DECORATED FENCES LIT//
    public static final RegistryObject<Block> ACACIA_WREATH_LIGHTS_FENCE = createBlock("acacia_wreath_lights_fence",
            () -> new ChristmasFence(Block.Properties.create(Material.WOOD, MaterialColor.GOLD).hardnessAndResistance(1.5F).lightValue(10)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> BIRCH_WREATH_LIGHTS_FENCE = createBlock("birch_wreath_lights_fence",
            () -> new ChristmasFence(Block.Properties.create(Material.WOOD, MaterialColor.GOLD).hardnessAndResistance(1.5F).lightValue(10)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> DARK_OAK_WREATH_LIGHTS_FENCE = createBlock("dark_oak_wreath_lights_fence",
            () -> new ChristmasFence(Block.Properties.create(Material.WOOD, MaterialColor.GOLD).hardnessAndResistance(1.5F).lightValue(10)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> JUNGLE_WREATH_LIGHTS_FENCE = createBlock("jungle_wreath_lights_fence",
            () -> new ChristmasFence(Block.Properties.create(Material.WOOD, MaterialColor.GOLD).hardnessAndResistance(1.5F).lightValue(10)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> OAK_WREATH_LIGHTS_FENCE = createBlock("oak_wreath_lights_fence",
            () -> new ChristmasFence(Block.Properties.create(Material.WOOD, MaterialColor.GOLD).hardnessAndResistance(1.5F).lightValue(10)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> SPRUCE_WREATH_LIGHTS_FENCE = createBlock("spruce_wreath_lights_fence",
            () -> new ChristmasFence(Block.Properties.create(Material.WOOD, MaterialColor.GOLD).hardnessAndResistance(1.5F).lightValue(10)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    //DECORATED FENCES//
    public static final RegistryObject<Block> ACACIA_WREATH_MULTI_FENCE = createBlock("acacia_wreath_multi_fence",
            () -> new ChristmasFence(Block.Properties.create(Material.WOOD, MaterialColor.GOLD).hardnessAndResistance(1.5F).lightValue(10)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> BIRCH_WREATH_MULTI_FENCE = createBlock("birch_wreath_multi_fence",
            () -> new ChristmasFence(Block.Properties.create(Material.WOOD, MaterialColor.GOLD).hardnessAndResistance(1.5F).lightValue(10)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> DARK_OAK_WREATH_MULTI_FENCE = createBlock("dark_oak_wreath_multi_fence",
            () -> new ChristmasFence(Block.Properties.create(Material.WOOD, MaterialColor.GOLD).hardnessAndResistance(1.5F).lightValue(10)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> JUNGLE_WREATH_MULTI_FENCE = createBlock("jungle_wreath_multi_fence",
            () -> new ChristmasFence(Block.Properties.create(Material.WOOD, MaterialColor.GOLD).hardnessAndResistance(1.5F).lightValue(10)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> OAK_WREATH_MULTI_FENCE = createBlock("oak_wreath_multi_fence",
            () -> new ChristmasFence(Block.Properties.create(Material.WOOD, MaterialColor.GOLD).hardnessAndResistance(1.5F).lightValue(10)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> SPRUCE_WREATH_MULTI_FENCE = createBlock("spruce_wreath_multi_fence",
            () -> new ChristmasFence(Block.Properties.create(Material.WOOD, MaterialColor.GOLD).hardnessAndResistance(1.5F).lightValue(10)), ModItemGroups.MAIDENS_BLOCKS_GROUP);


    //PICKET FENCE GATE//
    public static final RegistryObject<Block> ACACIA_PICKET_FENCE_GATE = createBlock(  "acacia_picket_fence_gate",
            () -> new ChristmasFenceGate(Block.Properties.create(Material.WOOD, MaterialColor.GOLD).hardnessAndResistance(1.5F)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> BIRCH_PICKET_FENCE_GATE = createBlock(  "birch_picket_fence_gate",
            () -> new ChristmasFenceGate(Block.Properties.create(Material.WOOD, MaterialColor.GOLD).hardnessAndResistance(1.5F)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> DARK_OAK_PICKET_FENCE_GATE = createBlock(  "dark_oak_picket_fence_gate",
            () -> new ChristmasFenceGate(Block.Properties.create(Material.WOOD, MaterialColor.GOLD).hardnessAndResistance(1.5F)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> JUNGLE_PICKET_FENCE_GATE = createBlock(  "jungle_picket_fence_gate",
            () -> new ChristmasFenceGate(Block.Properties.create(Material.WOOD, MaterialColor.GOLD).hardnessAndResistance(1.5F)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> OAK_PICKET_FENCE_GATE = createBlock(  "oak_picket_fence_gate",
            () -> new ChristmasFenceGate(Block.Properties.create(Material.WOOD, MaterialColor.GOLD).hardnessAndResistance(1.5F)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> SPRUCE_PICKET_FENCE_GATE = createBlock(  "spruce_picket_fence_gate",
            () -> new ChristmasFenceGate(Block.Properties.create(Material.WOOD, MaterialColor.GOLD).hardnessAndResistance(1.5F)), ModItemGroups.MAIDENS_BLOCKS_GROUP);


    //DECORATED FENCE GATE//
    public static final RegistryObject<Block> ACACIA_WREATH_FENCE_GATE = createBlock(  "acacia_wreath_fence_gate",
            () -> new ChristmasFenceGate(Block.Properties.create(Material.WOOD, MaterialColor.GOLD).hardnessAndResistance(1.5F)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> BIRCH_WREATH_FENCE_GATE = createBlock(  "birch_wreath_fence_gate",
            () -> new ChristmasFenceGate(Block.Properties.create(Material.WOOD, MaterialColor.GOLD).hardnessAndResistance(1.5F)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> DARK_OAK_WREATH_FENCE_GATE = createBlock(  "dark_oak_wreath_fence_gate",
            () -> new ChristmasFenceGate(Block.Properties.create(Material.WOOD, MaterialColor.GOLD).hardnessAndResistance(1.5F)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> JUNGLE_WREATH_FENCE_GATE = createBlock(  "jungle_wreath_fence_gate",
            () -> new ChristmasFenceGate(Block.Properties.create(Material.WOOD, MaterialColor.GOLD).hardnessAndResistance(1.5F)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> OAK_WREATH_FENCE_GATE = createBlock(  "oak_wreath_fence_gate",
            () -> new ChristmasFenceGate(Block.Properties.create(Material.WOOD, MaterialColor.GOLD).hardnessAndResistance(1.5F)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> SPRUCE_WREATH_FENCE_GATE = createBlock(  "spruce_wreath_fence_gate",
            () -> new ChristmasFenceGate(Block.Properties.create(Material.WOOD, MaterialColor.GOLD).hardnessAndResistance(1.5F)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    //DECORATED LIT FENCE GATE//
    public static final RegistryObject<Block> ACACIA_WREATH_LIGHTS_FENCE_GATE = createBlock(  "acacia_wreath_lights_fence_gate",
            () -> new ChristmasFenceGate(Block.Properties.create(Material.WOOD, MaterialColor.GOLD).hardnessAndResistance(1.5F).lightValue(10)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> BIRCH_WREATH_LIGHTS_FENCE_GATE = createBlock(  "birch_wreath_lights_fence_gate",
            () -> new ChristmasFenceGate(Block.Properties.create(Material.WOOD, MaterialColor.GOLD).hardnessAndResistance(1.5F).lightValue(10)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> DARK_OAK_WREATH_LIGHTS_FENCE_GATE = createBlock(  "dark_oak_wreath_lights_fence_gate",
            () -> new ChristmasFenceGate(Block.Properties.create(Material.WOOD, MaterialColor.GOLD).hardnessAndResistance(1.5F).lightValue(10)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> JUNGLE_WREATH_LIGHTS_FENCE_GATE = createBlock(  "jungle_wreath_lights_fence_gate",
            () -> new ChristmasFenceGate(Block.Properties.create(Material.WOOD, MaterialColor.GOLD).hardnessAndResistance(1.5F).lightValue(10)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> OAK_WREATH_LIGHTS_FENCE_GATE = createBlock(  "oak_wreath_lights_fence_gate",
            () -> new ChristmasFenceGate(Block.Properties.create(Material.WOOD, MaterialColor.GOLD).hardnessAndResistance(1.5F).lightValue(10)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> SPRUCE_WREATH_LIGHTS_FENCE_GATE = createBlock(  "spruce_wreath_lights_fence_gate",
            () -> new ChristmasFenceGate(Block.Properties.create(Material.WOOD, MaterialColor.GOLD).hardnessAndResistance(1.5F).lightValue(10)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    //DECORATED LIT MULTI FENCE GATE//
    public static final RegistryObject<Block> ACACIA_WREATH_MULTI_FENCE_GATE = createBlock(  "acacia_wreath_multi_fence_gate",
            () -> new ChristmasFenceGate(Block.Properties.create(Material.WOOD, MaterialColor.GOLD).hardnessAndResistance(1.5F).lightValue(10)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> BIRCH_WREATH_MULTI_FENCE_GATE = createBlock(  "birch_wreath_multi_fence_gate",
            () -> new ChristmasFenceGate(Block.Properties.create(Material.WOOD, MaterialColor.GOLD).hardnessAndResistance(1.5F).lightValue(10)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> DARK_OAK_WREATH_MULTI_FENCE_GATE = createBlock(  "dark_oak_wreath_multi_fence_gate",
            () -> new ChristmasFenceGate(Block.Properties.create(Material.WOOD, MaterialColor.GOLD).hardnessAndResistance(1.5F).lightValue(10)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> JUNGLE_WREATH_MULTI_FENCE_GATE = createBlock(  "jungle_wreath_multi_fence_gate",
            () -> new ChristmasFenceGate(Block.Properties.create(Material.WOOD, MaterialColor.GOLD).hardnessAndResistance(1.5F).lightValue(10)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> OAK_WREATH_MULTI_FENCE_GATE = createBlock(  "oak_wreath_multi_fence_gate",
            () -> new ChristmasFenceGate(Block.Properties.create(Material.WOOD, MaterialColor.GOLD).hardnessAndResistance(1.5F).lightValue(10)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> SPRUCE_WREATH_MULTI_FENCE_GATE = createBlock(  "spruce_wreath_multi_fence_gate",
            () -> new ChristmasFenceGate(Block.Properties.create(Material.WOOD, MaterialColor.GOLD).hardnessAndResistance(1.5F).lightValue(10)), ModItemGroups.MAIDENS_BLOCKS_GROUP);



    //CLASSIC LIGHTS//

    public static final RegistryObject<Block>   CLASSIC_LIGHTS = createBlock("classic_lights_horizontal",
            () -> new LightsBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F).harvestLevel(1).lightValue(10).sound(SoundType.PLANT)
                    .lightValue(14)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block>   CLASSIC_LIGHTS_DIAGONAL_LEFT = createBlock("classic_lights_diagonal_left",
            () -> new LightsBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F).harvestLevel(1).lightValue(10).sound(SoundType.PLANT)
                    .lightValue(14)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block>   CLASSIC_LIGHTS_DIAGONAL_RIGHT = createBlock("classic_lights_diagonal_right",
            () -> new LightsBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F).harvestLevel(1).lightValue(10).sound(SoundType.PLANT)
                    .lightValue(14)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block>   CLASSIC_LIGHTS_CAP = createBlock("classic_lights_cap",
            () -> new LightsBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F).harvestLevel(1).lightValue(10).sound(SoundType.PLANT)
                    .lightValue(14)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);

    //CLASSIC MULTI COLORED//
    public static final RegistryObject<Block>   CLASSIC_MULTI = createBlock("classic_multi_horizontal",
            () -> new LightsBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F).harvestLevel(1).lightValue(10).sound(SoundType.PLANT)
                    .lightValue(14)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block>   CLASSIC_MULTI_DIAGONAL_LEFT = createBlock("classic_multi_diagonal_left",
            () -> new LightsBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F).harvestLevel(1).lightValue(10).sound(SoundType.PLANT)
                    .lightValue(14)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block>   CLASSIC_MULTI_DIAGONAL_RIGHT = createBlock("classic_multi_diagonal_right",
            () -> new LightsBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F).harvestLevel(1).lightValue(10).sound(SoundType.PLANT)
                    .lightValue(14)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block>   CLASSIC_MULTI_CAP = createBlock("classic_multi_cap",
            () -> new LightsBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F).harvestLevel(1).lightValue(10).sound(SoundType.PLANT)
                    .lightValue(14)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);


    //ICICLE LIGHTS//
    public static final RegistryObject<Block>   ICICLE_LIGHTS = createBlock("icicle_lights_horizontal",
            () -> new LightsBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F).harvestLevel(1).lightValue(10).sound(SoundType.PLANT)
                    .lightValue(14)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block>   ICICLE_LIGHTS_DIAGONAL_LEFT = createBlock("icicle_lights_diagonal_left",
            () -> new LightsBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F).harvestLevel(1).lightValue(10).sound(SoundType.PLANT)
                    .lightValue(14)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block>   ICICLE_LIGHTS_DIAGONAL_RIGHT = createBlock("icicle_lights_diagonal_right",
            () -> new LightsBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F).harvestLevel(1).lightValue(10).sound(SoundType.PLANT)
                    .lightValue(14)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block>   ICICLE_LIGHTS_CAP = createBlock("icicle_lights_cap",
            () -> new LightsBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F).harvestLevel(1).lightValue(10).sound(SoundType.PLANT)
                    .lightValue(14)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);

    //ICICLE MULTI COLORED//
    public static final RegistryObject<Block>   ICICLE_MULTI = createBlock("icicle_multi_horizontal",
            () -> new LightsBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F).harvestLevel(1).lightValue(10).sound(SoundType.PLANT)
                    .lightValue(14)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block>   ICICLE_MULTI_DIAGONAL_LEFT = createBlock("icicle_multi_diagonal_left",
            () -> new LightsBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F).harvestLevel(1).lightValue(10).sound(SoundType.PLANT)
                    .lightValue(14)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block>   ICICLE_MULTI_DIAGONAL_RIGHT = createBlock("icicle_multi_diagonal_right",
            () -> new LightsBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F).harvestLevel(1).lightValue(10).sound(SoundType.PLANT)
                    .lightValue(14)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block>   ICICLE_MULTI_CAP = createBlock("icicle_multi_cap",
            () -> new LightsBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F).harvestLevel(1).lightValue(10).sound(SoundType.PLANT)
                    .lightValue(14)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);

    //TWINKLING_ICICLE LIGHTS//
    public static final RegistryObject<Block>   TWINKLING_ICICLE_LIGHTS = createBlock("twinkling_icicle_lights_horizontal",
            () -> new LightsBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F).harvestLevel(1).lightValue(10).sound(SoundType.PLANT)
                    .lightValue(14)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block>   TWINKLING_ICICLE_LIGHTS_DIAGONAL_LEFT = createBlock("twinkling_icicle_lights_diagonal_left",
            () -> new LightsBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F).harvestLevel(1).lightValue(10).sound(SoundType.PLANT)
                    .lightValue(14)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block>   TWINKLING_ICICLE_LIGHTS_DIAGONAL_RIGHT = createBlock("twinkling_icicle_lights_diagonal_right",
            () -> new LightsBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F).harvestLevel(1).lightValue(10).sound(SoundType.PLANT)
                    .lightValue(14)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block>   TWINKLING_ICICLE_LIGHTS_CAP = createBlock("twinkling_icicle_lights_cap",
            () -> new LightsBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F).harvestLevel(1).lightValue(10).sound(SoundType.PLANT)
                    .lightValue(14)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);

    //TWINKLING_ICICLE MULTI COLORED//
    public static final RegistryObject<Block>   TWINKLING_ICICLE_MULTI = createBlock("twinkling_icicle_multi_horizontal",
            () -> new LightsBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F).harvestLevel(1).lightValue(10).sound(SoundType.PLANT)
                    .lightValue(14)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block>   TWINKLING_ICICLE_MULTI_DIAGONAL_LEFT = createBlock("twinkling_icicle_multi_diagonal_left",
            () -> new LightsBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F).harvestLevel(1).lightValue(10).sound(SoundType.PLANT)
                    .lightValue(14)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block>   TWINKLING_ICICLE_MULTI_DIAGONAL_RIGHT = createBlock("twinkling_icicle_multi_diagonal_right",
            () -> new LightsBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F).harvestLevel(1).lightValue(10).sound(SoundType.PLANT)
                    .lightValue(14)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block>   TWINKLING_ICICLE_MULTI_CAP = createBlock("twinkling_icicle_multi_cap",
            () -> new LightsBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F).harvestLevel(1).lightValue(10).sound(SoundType.PLANT)
                    .lightValue(14)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);

//MINI LIGHTS//
    public static final RegistryObject<Block>   MINI_LIGHTS = createBlock("mini_lights_horizontal",
            () -> new LightsBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F).harvestLevel(1).lightValue(10).sound(SoundType.PLANT)
                    .lightValue(14)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block>   MINI_LIGHTS_DIAGONAL_LEFT = createBlock("mini_lights_diagonal_left",
            () -> new LightsBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F).harvestLevel(1).lightValue(10).sound(SoundType.PLANT)
                    .lightValue(14)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block>   MINI_LIGHTS_DIAGONAL_RIGHT = createBlock("mini_lights_diagonal_right",
            () -> new LightsBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F).harvestLevel(1).lightValue(10).sound(SoundType.PLANT)
                    .lightValue(14)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block>   MINI_LIGHTS_CAP = createBlock("mini_lights_cap",
            () -> new LightsBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F).harvestLevel(1).lightValue(10).sound(SoundType.PLANT)
                    .lightValue(14)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);


    //MINI MULTI COLORED//
    public static final RegistryObject<Block>   MINI_MULTI = createBlock("mini_multi_horizontal",
            () -> new LightsBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F).harvestLevel(1).lightValue(10).sound(SoundType.PLANT)
                    .lightValue(14)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block>   MINI_MULTI_DIAGONAL_LEFT = createBlock("mini_multi_diagonal_left",
            () -> new LightsBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F).harvestLevel(1).lightValue(10).sound(SoundType.PLANT)
                    .lightValue(14)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block>   MINI_MULTI_DIAGONAL_RIGHT = createBlock("mini_multi_diagonal_right",
            () -> new LightsBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F).harvestLevel(1).lightValue(10).sound(SoundType.PLANT)
                    .lightValue(14)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block>   MINI_MULTI_CAP = createBlock("mini_multi_cap",
            () -> new LightsBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 2.0F).harvestLevel(1).lightValue(10).sound(SoundType.PLANT)
                    .lightValue(14)) , ModItemGroups.MAIDENS_BLOCKS_GROUP);

//GARLAND DECORATED WALLS

    public static final RegistryObject<Block> COBBLESTONE_GARLAND_WALL = createBlock("cobblestone_garland_wall",
            () -> new GarlandWallBlock(Block.Properties.from(Blocks.BRICK_WALL)), ModItemGroups.MAIDENS_BLOCKS_GROUP);



}