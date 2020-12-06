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


}
