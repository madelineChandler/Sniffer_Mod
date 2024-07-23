package sniffer.sniffermod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropBlock;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.state.property.Properties;
import sniffer.sniffermod.block.ModBlocks;
import sniffer.sniffermod.block.custom.ShellCropBlock;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.TintType noTint = BlockStateModelGenerator.TintType.NOT_TINTED;

        // flowers
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.SHELL_FLOWER, ModBlocks.POTTED_SHELL_FLOWER, noTint);
        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.SHELL_CROP, noTint, Properties.AGE_1, 0, 1);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.ICE_FLOWER, ModBlocks.POTTED_ICE_FLOWER, noTint);
        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.ICE_CROP, noTint, Properties.AGE_1, 0, 1);

        // 3d models

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }
}
