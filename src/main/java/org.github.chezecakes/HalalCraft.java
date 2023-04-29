package org.github.chezecakes;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.github.chezecakes.blocks.LimestoneBlock;
import org.github.chezecakes.blocks.MarbleBlock;
import org.github.chezecakes.items.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HalalCraft implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("halalcraft");

    // items
    public static final Item KHAAK = Registry.register(Registries.ITEM, new Identifier("halalcraft", "khaak"), new KhaakItem(new FabricItemSettings()));
    public static final Item TASBIH = Registry.register(Registries.ITEM, new Identifier("halalcraft", "tasbih"), new TasbihItem(new FabricItemSettings()));
    public static final Item SAJDEGAH = Registry.register(Registries.ITEM, new Identifier("halalcraft", "sajdegah"), new SajdegahItem(new FabricItemSettings()));
    public static final Item KHAAK_BEADS = Registry.register(Registries.ITEM, new Identifier("halalcraft", "khaak_beads"), new KhaakBeadsItem(new FabricItemSettings()));

    // blocks
    public static final Block LIMESTONE = Registry.register(Registries.BLOCK, new Identifier("halalcraft", "limestone"), new LimestoneBlock(FabricBlockSettings.of(Material.STONE).strength(2.0f)));
    public static final Block MARBLE = Registry.register(Registries.BLOCK, new Identifier("halalcraft", "marble"), new MarbleBlock(FabricBlockSettings.of(Material.STONE).strength(2.0f)));

    private static final ItemGroup HALALCRAFT_GROUP = FabricItemGroup.builder(new Identifier("halalcraft", "halalcraft"))
            .icon(() -> new ItemStack(TASBIH))
            .build();

    @Override
    public void onInitialize() {
        LOGGER.info("Registering items..");

        Registry.register(Registries.ITEM, new Identifier("halalcraft", "limestone"), new LimestoneItem(LIMESTONE, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier("halalcraft", "marble"), new MarbleItem(MARBLE, new FabricItemSettings()));

        ItemGroupEvents.modifyEntriesEvent(HALALCRAFT_GROUP).register(content -> {
            content.add(KHAAK);
            content.add(TASBIH);
            content.add(SAJDEGAH);
            content.add(KHAAK_BEADS);
            content.add(LIMESTONE);
            content.add(MARBLE);
        });
    }
}
