package org.github.chezecakes;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HalalCraft implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("halalcraft");

    @Override
    public void onInitialize() {
        LOGGER.info("Registering items..");

        HalalCraftItems.initializeTabGroup();
    }
}
