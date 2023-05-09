package hecco.puffer.blocks.registry;

        import hecco.puffer.blocks.PufferBlocks;
        import hecco.puffer.blocks.custom.PufferBlock;
        import hecco.puffer.blocks.sound.ModSounds;
        import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
        import net.minecraft.block.*;
        import net.minecraft.registry.Registries;
        import net.minecraft.registry.Registry;
        import net.minecraft.util.Identifier;

public class ModBlocks {


    public static final Block PUFFER_BLOCK = new PufferBlock(FabricBlockSettings.of(Material.GLASS, MapColor.YELLOW).strength(0.25F, 2F).sounds(ModSounds.PUFFER_BLOCK).nonOpaque());

    public static void registerBlocks() {
        Registry.register(Registries.BLOCK, new Identifier(PufferBlocks.MOD_ID, "puffer_block"), PUFFER_BLOCK);
    }



}
