package org.github.chezecakes;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.github.chezecakes.items.KhaakBeadsItem;
import org.github.chezecakes.items.KhaakItem;
import org.github.chezecakes.items.TasbihItem;

public class HalalCraftItems {
    private static final Item KHAAK;
    private static final Item KHAAK_BEADS;
    private static final Item GOLD_TASBIH;
    private static final Item IRON_TASBIH;
    private static final Item QUARTZ_TASBIH;
    private static final Item DIAMOND_TASBIH;
    private static final Item EMERALD_TASBIH;
    private static final Item AMETHYST_TASBIH;
    private static final Item NETHER_STAR_TASBIH;

    // BLOCKS
    private static final Item MARBLE;
    private static final Item SAJDEGAH;
    private static final Item LIMESTONE;

    private static final ItemGroup HALALCRAFT_GROUP;

    static {
        KHAAK = register("khaak", new KhaakItem());
        KHAAK_BEADS = register("khaak_beads", new KhaakBeadsItem());
        GOLD_TASBIH = register("gold_tasbih", new TasbihItem());
        IRON_TASBIH = register("iron_tasbih", new TasbihItem());
        QUARTZ_TASBIH = register("quartz_tasbih", new TasbihItem());
        DIAMOND_TASBIH = register("diamond_tasbih", new TasbihItem());
        EMERALD_TASBIH = register("emerald_tasbih", new TasbihItem());
        AMETHYST_TASBIH = register("amethyst_tasbih", new TasbihItem());
        NETHER_STAR_TASBIH = register("nether_star_tasbih", new TasbihItem());

        MARBLE = registerBlock(HalalCraftBlocks.MARBLE);
        SAJDEGAH = registerBlock(HalalCraftBlocks.SAJDEGAH);
        LIMESTONE = registerBlock(HalalCraftBlocks.LIMESTONE);

        HALALCRAFT_GROUP = FabricItemGroup.builder(new Identifier("halalcraft", "halalcraft"))
                .icon(() -> new ItemStack(Items.BOOK))
                .build();
    }

    private static Item register(String path, Item item) {
        return Registry.register(Registries.ITEM, new Identifier("halalcraft", path), item);
    }

    private static Item registerBlock(Block block) {
        var block_item = new BlockItem(block, new FabricItemSettings());
        var id = Registries.BLOCK.getId(block);

        block_item.appendBlocks(Item.BLOCK_ITEMS, block_item);

        return Registry.register(Registries.ITEM, id, block_item);
    }

    public static void initializeTabGroup() {
        ItemGroupEvents.modifyEntriesEvent(HALALCRAFT_GROUP).register(content -> {
            content.add(KHAAK);
            content.add(IRON_TASBIH);
            content.add(GOLD_TASBIH);
            content.add(DIAMOND_TASBIH);
            content.add(EMERALD_TASBIH);
            content.add(QUARTZ_TASBIH);
            content.add(AMETHYST_TASBIH);
            content.add(NETHER_STAR_TASBIH);
            content.add(KHAAK_BEADS);
            content.add(SAJDEGAH);
            content.add(LIMESTONE);
            content.add(MARBLE);
        });
    }
}
