package org.github.chezecakes.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;

public class SajdegahBlock extends Block {
    public SajdegahBlock() {
        super(FabricBlockSettings.of(Material.STONE).strength(1.0f));
    }
}
