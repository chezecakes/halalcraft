package org.github.chezecakes;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
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

/*
todo:
- add a way to templock all tasbih variants when a user uses one tasbih

*/
public class HalalCraft implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("halalcraft");

    private static final Item KHAAK, GOLD_TASBIH, DIAMOND_TASBIH, EMERALD_TASBIH, IRON_TASBIH, QUARTZ_TASBIH, AMETHYST_TASBIH, NETHER_STAR_TASBIH, SAJDEGAH, KHAAK_BEADS, LIMESTONE, MARBLE;
    private static final ItemGroup HALALCRAFT_GROUP;

    static {
        KHAAK = Registry.register(Registries.ITEM, new Identifier("halalcraft", "khaak"), new KhaakItem(new FabricItemSettings()));
        IRON_TASBIH = Registry.register(Registries.ITEM, new Identifier("halalcraft", "iron_tasbih"), new IronTasbihItem(new FabricItemSettings()));
        GOLD_TASBIH = Registry.register(Registries.ITEM, new Identifier("halalcraft", "gold_tasbih"), new GoldTasbihItem(new FabricItemSettings()));
        DIAMOND_TASBIH = Registry.register(Registries.ITEM, new Identifier("halalcraft", "diamond_tasbih"), new DiamondTasbihItem(new FabricItemSettings()));
        EMERALD_TASBIH = Registry.register(Registries.ITEM, new Identifier("halalcraft", "emerald_tasbih"), new EmeraldTasbihItem(new FabricItemSettings()));
        QUARTZ_TASBIH = Registry.register(Registries.ITEM, new Identifier("halalcraft", "quartz_tasbih"), new QuartzTasbihItem(new FabricItemSettings()));
        AMETHYST_TASBIH = Registry.register(Registries.ITEM, new Identifier("halalcraft", "amethyst_tasbih"), new AmethystTasbihItem(new FabricItemSettings()));
        NETHER_STAR_TASBIH = Registry.register(Registries.ITEM, new Identifier("halalcraft", "nether_star_tasbih"), new NetherStarTasbihItem(new FabricItemSettings()));
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
                .icon(() -> new ItemStack(GOLD_TASBIH))
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
