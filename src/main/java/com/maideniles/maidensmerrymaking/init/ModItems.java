package com.maideniles.maidensmerrymaking.init;

import com.maideniles.maidensmerrymaking.MaidensMerryMaking;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {


    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, MaidensMerryMaking.MODID);

    public static final RegistryObject<Item> CHRISTMAS_TREE = ITEMS.register("christmas_tree",
            () -> new Item(new Item.Properties().group(ModItemGroups.MAIDENS_ITEMS_GROUP).maxStackSize(64)));

    public static final RegistryObject<Item> CHRISTMAS_TREE_LIGHTS_WHITE = ITEMS.register("christmas_tree_white_lights",
            () -> new Item(new Item.Properties().group(ModItemGroups.MAIDENS_ITEMS_GROUP).maxStackSize(64)));

    public static final RegistryObject<Item> CHRISTMAS_TREE_LIGHTS_MULTI = ITEMS.register("christmas_tree_multi_lights",
            () -> new Item(new Item.Properties().group(ModItemGroups.MAIDENS_ITEMS_GROUP).maxStackSize(64)));

    public static final RegistryObject<Item> STOCKING = ITEMS.register( "stocking",
            () -> new Item(new Item.Properties().group(ModItemGroups.MAIDENS_ITEMS_GROUP).maxStackSize(64)));

}
