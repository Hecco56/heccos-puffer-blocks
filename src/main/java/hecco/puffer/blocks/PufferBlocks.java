package hecco.puffer.blocks;

import hecco.puffer.blocks.registry.ModBlocks;
import hecco.puffer.blocks.registry.ModItems;
import net.fabricmc.api.ModInitializer;

public class PufferBlocks implements ModInitializer {

    public static final String MOD_ID = "pufferblocks";

    @Override
    public void onInitialize() {
        ModItems.registerItems();
        ModBlocks.registerBlocks();
    }
}
