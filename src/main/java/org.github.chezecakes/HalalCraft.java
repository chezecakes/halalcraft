package org.github.chezecakes;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
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

	@Override
	public void onInitialize() {
		LOGGER.info("Registering items..");

		Registry.register(Registries.ITEM, new Identifier("halalcraft", "tasbih"), TASBIH);
		Registry.register(Registries.ITEM, new Identifier("halalcraft", "sajdegah"), SAJDEGAH);
	}
}
