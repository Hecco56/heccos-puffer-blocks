package hecco.puffer.blocks.registry;

import hecco.puffer.blocks.PufferBlocks;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final BlockItem PUFFER_BLOCK = new BlockItem(ModBlocks.PUFFER_BLOCK, new FabricItemSettings());


    private static void addToItemGroup(ItemGroup group, Item itembefore, BlockItem item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(content -> {
            content.addAfter(itembefore, item);
        });
    }
    public static void addItemsToItemGroup() {
        addToItemGroup(ItemGroups.BUILDING_BLOCKS, Items.NETHERITE_BLOCK, PUFFER_BLOCK);
        addToItemGroup(ItemGroups.FUNCTIONAL, Items.MAGMA_BLOCK, PUFFER_BLOCK);
    }
    public static void registerItems() {
        Registry.register(Registries.ITEM, new Identifier(PufferBlocks.MOD_ID, "puffer_block"), PUFFER_BLOCK);

        addItemsToItemGroup();

    }

}

