package sniffer.sniffermod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import sniffer.sniffermod.SnifferMod;
import sniffer.sniffermod.block.ModBlocks;
import sniffer.sniffermod.block.custom.ShellCropBlock;

public class ModItems {
    public static final Item SHELL_SEEDS = registerItem("shell_seeds",
            new AliasedBlockItem(ModBlocks.SHELL_CROP, new FabricItemSettings()));

    public static final Item ICE_SEEDS = registerItem("ice_seeds",
            new AliasedBlockItem(ModBlocks.ICE_CROP, new FabricItemSettings()));

    private static void addItemsToNaturalItemGroup(FabricItemGroupEntries entries) {

    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(SnifferMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        SnifferMod.LOGGER.info("Registering Mod Blocks for " + SnifferMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(ModItems::addItemsToNaturalItemGroup);
    }
}
