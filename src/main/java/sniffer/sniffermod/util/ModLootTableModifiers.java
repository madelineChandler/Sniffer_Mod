package sniffer.sniffermod.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import sniffer.sniffermod.block.ModBlocks;
import sniffer.sniffermod.item.ModItems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModLootTableModifiers {
    private static final Identifier SNIFFER_DIGGING_ID =
            new Identifier("minecraft", "gameplay/sniffer_digging");

    public static void modifyLootTables() {
        LootTableEvents.REPLACE.register((resourceManager, lootManager, id, original, source) -> {
            if (SNIFFER_DIGGING_ID.equals(id)) {
                List<LootPoolEntry> entries = new ArrayList<>();

                // replace sniffer loot table
                entries.add(ItemEntry.builder(Items.PITCHER_POD).build());
                entries.add(ItemEntry.builder(Items.TORCHFLOWER_SEEDS).build());
                entries.add(ItemEntry.builder(ModItems.SHELL_SEEDS).build());
                entries.add(ItemEntry.builder(ModItems.ICE_SEEDS).build());

                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(entries)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                LootPool.Builder pool = LootPool.builder().with(entries);
                return LootTable.builder().pool(pool).build();
            }

           return null;
        });
    }
}
