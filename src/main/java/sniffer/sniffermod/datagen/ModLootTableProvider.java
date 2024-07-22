package sniffer.sniffermod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import sniffer.sniffermod.block.ModBlocks;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.SHELL_FLOWER);
        addPottedPlantDrops(ModBlocks.POTTED_SHELL_FLOWER);
        addDrop(ModBlocks.BUSH);
    }
}
