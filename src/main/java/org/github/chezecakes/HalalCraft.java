package org.github.chezecakes;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.github.chezecakes.blocks.LimestoneBlock;
import org.github.chezecakes.blocks.MarbleBlock;
import org.github.chezecakes.items.KhaakBeadsItem;
import org.github.chezecakes.items.KhaakItem;
import org.github.chezecakes.items.SajdegahItem;
import org.github.chezecakes.items.TasbihItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HalalCraft implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("halalcraft");

    private static final Item KHAAK, IRON_TASBIH, GOLD_TASBIH, DIAMOND_TASBIH, EMERALD_TASBIH, QUARTZ_TASBIH, AMETHYST_TASBIH, NETHER_STAR_TASBIH, SAJDEGAH, KHAAK_BEADS, LIMESTONE, MARBLE;
    private static final ItemGroup HALALCRAFT_GROUP;

    static {
        KHAAK = Registry.register(Registries.ITEM, new Identifier("halalcraft", "khaak"), new KhaakItem(new FabricItemSettings()));
        IRON_TASBIH = Registry.register(Registries.ITEM, new Identifier("halalcraft", "iron_tasbih"), new TasbihItem());
        GOLD_TASBIH = Registry.register(Registries.ITEM, new Identifier("halalcraft", "gold_tasbih"), new TasbihItem());
        DIAMOND_TASBIH = Registry.register(Registries.ITEM, new Identifier("halalcraft", "diamond_tasbih"), new TasbihItem());
        EMERALD_TASBIH = Registry.register(Registries.ITEM, new Identifier("halalcraft", "emerald_tasbih"), new TasbihItem());
        QUARTZ_TASBIH = Registry.register(Registries.ITEM, new Identifier("halalcraft", "quartz_tasbih"), new TasbihItem());
        AMETHYST_TASBIH = Registry.register(Registries.ITEM, new Identifier("halalcraft", "amethyst_tasbih"), new TasbihItem());
        NETHER_STAR_TASBIH = Registry.register(Registries.ITEM, new Identifier("halalcraft", "nether_star_tasbih"), new TasbihItem());
        SAJDEGAH = Registry.register(Registries.ITEM, new Identifier("halalcraft", "sajdegah"), new SajdegahItem(new FabricItemSettings()));
        KHAAK_BEADS = Registry.register(Registries.ITEM, new Identifier("halalcraft", "khaak_beads"), new KhaakBeadsItem(new FabricItemSettings()));

        // todo: do we need a strong reference to these?
        var limestone_block = new BlockItem(Registry.register(Registries.BLOCK, new Identifier("halalcraft", "limestone"), new LimestoneBlock(FabricBlockSettings.of(Material.STONE).strength(2.0f))), new FabricItemSettings());
        var marble_block = new BlockItem(Registry.register(Registries.BLOCK, new Identifier("halalcraft", "marble"), new MarbleBlock(FabricBlockSettings.of(Material.STONE).strength(2.0f))), new FabricItemSettings());

        var limestone_id = Registries.BLOCK.getId(limestone_block.getBlock());
        var marble_id = Registries.BLOCK.getId(marble_block.getBlock());

        // todo: why necessary? see Items.java, line 1280
        limestone_block.appendBlocks(Item.BLOCK_ITEMS, limestone_block);
        marble_block.appendBlocks(Item.BLOCK_ITEMS, marble_block);

        LIMESTONE = Registry.register(Registries.ITEM, limestone_id, limestone_block);
        MARBLE = Registry.register(Registries.ITEM, marble_id, marble_block);

        HALALCRAFT_GROUP = FabricItemGroup.builder(new Identifier("halalcraft", "halalcraft"))
                .icon(() -> new ItemStack(Items.BOOK))
                .build();
    }

    @Override
    public void onInitialize() {
        LOGGER.info("Registering items..");

        ItemGroupEvents.modifyEntriesEvent(HALALCRAFT_GROUP).register(content -> {
            content.add(KHAAK);
            content.add(IRON_TASBIH);
            content.add(GOLD_TASBIH);
            content.add(DIAMOND_TASBIH);
            content.add(EMERALD_TASBIH);
            content.add(QUARTZ_TASBIH);
            content.add(AMETHYST_TASBIH);
            content.add(NETHER_STAR_TASBIH);
            content.add(SAJDEGAH);
            content.add(KHAAK_BEADS);
            content.add(LIMESTONE);
            content.add(MARBLE);
        });
    }
}
