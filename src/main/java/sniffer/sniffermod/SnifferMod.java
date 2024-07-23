package sniffer.sniffermod;

import net.fabricmc.api.ModInitializer;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sniffer.sniffermod.block.ModBlocks;
import sniffer.sniffermod.item.ModItemGroups;
import sniffer.sniffermod.item.ModItems;
import sniffer.sniffermod.potion.ModPotions;
import sniffer.sniffermod.util.ModLootTableModifiers;

public class SnifferMod implements ModInitializer {
	public static final String MOD_ID = "sniffermod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModLootTableModifiers.modifyLootTables();

		ModPotions.registerPotions();
		// torchflower light level change
		// Blocks.TORCHFLOWER.
	}
}