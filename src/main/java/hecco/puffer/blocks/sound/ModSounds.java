package hecco.puffer.blocks.sound;

import hecco.puffer.blocks.PufferBlocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static SoundEvent PUFFER_BLOCK_BREAK = registerSoundEvent("puffer_block_break");
    public static SoundEvent PUFFER_BLOCK_WALK = registerSoundEvent("puffer_block_walk");
    public static SoundEvent PUFFER_BLOCK_PLACE = registerSoundEvent("puffer_block_place");
    public static SoundEvent PUFFER_BLOCK_HIT = registerSoundEvent("puffer_block_hit");
    public static SoundEvent PUFFER_BLOCK_BURP = registerSoundEvent("puffer_block_burp");

    public static final BlockSoundGroup PUFFER_BLOCK = new BlockSoundGroup(1f, 1f,
            ModSounds.PUFFER_BLOCK_BREAK, ModSounds.PUFFER_BLOCK_WALK, ModSounds.PUFFER_BLOCK_PLACE,
            ModSounds.PUFFER_BLOCK_HIT, ModSounds.PUFFER_BLOCK_WALK);

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(PufferBlocks.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }
}
