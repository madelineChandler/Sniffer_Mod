package sniffer.sniffermod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import sniffer.sniffermod.SnifferMod;
import sniffer.sniffermod.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup SNIFFER_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(SnifferMod.MOD_ID, "sniffer"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.sniffer"))
                    .icon(() -> new ItemStack(ModBlocks.SHELL_FLOWER)).entries((displayContext, entries) -> {
                        entries.add(ModBlocks.SHELL_FLOWER);
                        entries.add(ModBlocks.BUSH);
                    }).build());

    public static void registerItemGroups() {
        SnifferMod.LOGGER.info("Registering Item Groups for " + SnifferMod.MOD_ID);
    }
}
