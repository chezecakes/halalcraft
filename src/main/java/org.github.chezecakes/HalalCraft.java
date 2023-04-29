package org.github.chezecakes;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.github.chezecakes.items.SajdegahItem;
import org.github.chezecakes.items.TasbihItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HalalCraft implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("halalcraft");

	public static final Item TASBIH = new TasbihItem(new FabricItemSettings());
	public static final Item SAJDEGAH = new SajdegahItem(new FabricItemSettings());

	private static final ItemGroup HALALCRAFT_GROUP = FabricItemGroup.builder(new Identifier("halalcraft", "Halalcraft"))
			.icon(() -> new ItemStack(TASBIH))
			.build();
	@Override
	public void onInitialize() {
		LOGGER.info("Registering items..");

		Registry.register(Registries.ITEM, new Identifier("halalcraft", "tasbih"), TASBIH);
		Registry.register(Registries.ITEM, new Identifier("halalcraft", "sajdegah"), SAJDEGAH);
	}
}
