package sniffer.sniffermod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import sniffer.sniffermod.SnifferMod;
import net.minecraft.item.Item;
import sniffer.sniffermod.item.ModItems;

public class ModBlocks {
    //public static final Block SHELL_SEEDS = registerBlock("shell_seeds",
            //new CropBlock(FabricBlockSettings.copyOf(Items.WHEAT_SEEDS)));
    public static final Block SHELL_FLOWER = registerBlock("shell_flower",
            new FlowerBlock(StatusEffects.RESISTANCE, 40, FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));
    public static final Block POTTED_SHELL_FLOWER = registerBlock("potted_shell_flower",
            new FlowerPotBlock(SHELL_FLOWER, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));

    public static final Block BUSH = registerBlock("bush",
            new LeavesBlock(FabricBlockSettings.copyOf(Blocks.AZALEA).nonOpaque()));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(SnifferMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(SnifferMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        SnifferMod.LOGGER.info("Registering mod blocks for " + SnifferMod.MOD_ID);

    }
}
