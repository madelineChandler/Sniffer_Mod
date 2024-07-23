package sniffer.sniffermod.block.custom;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import org.jetbrains.annotations.Nullable;

public class CorpseCropBlock extends Block {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public CorpseCropBlock(Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return super.getPlacementState(ctx);
    }

    
}
