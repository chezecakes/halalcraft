package org.github.chezecakes;

import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.github.chezecakes.blocks.LimestoneBlock;
import org.github.chezecakes.blocks.MarbleBlock;
import org.github.chezecakes.blocks.SajdegahBlock;

public class HalalCraftBlocks {
    public static final Block MARBLE;
    public static final Block SAJDEGAH;
    public static final Block LIMESTONE;

    static {
        MARBLE = register("marble", new MarbleBlock());
        SAJDEGAH = register("sajdegah", new SajdegahBlock());
        LIMESTONE = register("limestone", new LimestoneBlock());
    }

    private static Block register(String path, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier("halalcraft", path), block);
    }
}
