package org.github.chezecakes.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;

// marble for the kaaba structure
public class MarbleBlock extends Block {
    public MarbleBlock() {
        super(FabricBlockSettings.of(Material.STONE).strength(2.0f));
    }
}
