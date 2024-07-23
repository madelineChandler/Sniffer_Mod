package sniffer.sniffermod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.predicate.StatePredicate;
import sniffer.sniffermod.block.ModBlocks;
import sniffer.sniffermod.block.custom.ShellCropBlock;
import sniffer.sniffermod.item.ModItemGroups;
import sniffer.sniffermod.item.ModItems;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        // flowers
        addDrop(ModBlocks.SHELL_CROP, ModItems.SHELL_SEEDS);
        addDrop(ModBlocks.SHELL_FLOWER);
        addPottedPlantDrops(ModBlocks.POTTED_SHELL_FLOWER);

        addDrop(ModBlocks.ICE_CROP, ModItems.ICE_SEEDS);
        addDrop(ModBlocks.ICE_FLOWER);
        addPottedPlantDrops(ModBlocks.POTTED_ICE_FLOWER);
    }
}
