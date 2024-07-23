package sniffer.sniffermod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import sniffer.sniffermod.SnifferMod;
import sniffer.sniffermod.block.custom.IceCropBlock;
import sniffer.sniffermod.block.custom.ShellCropBlock;
import sniffer.sniffermod.block.ModBlocks;
import net.minecraft.item.Item;

public class ModBlocks {
    // shell flower
    public static final Block SHELL_CROP = Registry.register(Registries.BLOCK, new Identifier(SnifferMod.MOD_ID, "shell_crop"),
            new ShellCropBlock(FabricBlockSettings.copyOf(Blocks.TORCHFLOWER_CROP)));
    public static final Block SHELL_FLOWER = registerBlock("shell_flower",
            new FlowerBlock(StatusEffects.RESISTANCE, 200, FabricBlockSettings.copyOf(Blocks.TORCHFLOWER).nonOpaque().noCollision().luminance(5)));
    public static final Block POTTED_SHELL_FLOWER = registerBlock("potted_shell_flower",
            new FlowerPotBlock(SHELL_FLOWER, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque().luminance(4)));

    // ice flower
    public static final Block ICE_CROP = Registry.register(Registries.BLOCK, new Identifier(SnifferMod.MOD_ID, "ice_crop"),
            new IceCropBlock(FabricBlockSettings.copyOf(Blocks.TORCHFLOWER_CROP).luminance(3)));
    public static final Block ICE_FLOWER = registerBlock("ice_flower",
            new FlowerBlock(StatusEffects.WATER_BREATHING, 100, FabricBlockSettings.copyOf(Blocks.TORCHFLOWER).nonOpaque().noCollision().luminance(7)));
    public static final Block POTTED_ICE_FLOWER = registerBlock("potted_ice_flower",
            new FlowerPotBlock(ICE_FLOWER, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque().luminance(6)));


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
