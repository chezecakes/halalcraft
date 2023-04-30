package org.github.chezecakes.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;

// limestone for the kaaba structure
public class LimestoneBlock extends Block {
    public LimestoneBlock() {
        super(FabricBlockSettings.of(Material.STONE).strength(2.0f));
    }
}
