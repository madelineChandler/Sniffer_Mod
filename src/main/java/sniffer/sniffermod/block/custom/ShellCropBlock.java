package sniffer.sniffermod.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.item.ItemConvertible;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import sniffer.sniffermod.block.ModBlocks;
import sniffer.sniffermod.item.ModItems;

public class ShellCropBlock extends CropBlock {
    public static final MapCodec<ShellCropBlock> CODEC = createCodec(ShellCropBlock::new);
    public static final int field_42775 = 2;
    private static final float field_42777 = 3.0F;
    private static final VoxelShape[] SHAPES = new VoxelShape[]{
            Block.createCuboidShape(5.0, 0.0, 5.0, 11.0, 6.0, 11.0), Block.createCuboidShape(5.0, 0.0, 5.0, 11.0, 10.0, 11.0)
    };
    private static final int field_44479 = 1;

    public static final int MAX_AGE = 4;
    public static final IntProperty AGE = Properties.AGE_4;

    public ShellCropBlock(Settings settings) {
        super(settings);
    }

    @Override
    public MapCodec<ShellCropBlock> getCodec() {
        return CODEC;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPES[this.getAge(state)];
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModBlocks.SHELL_CROP;
    }

    @Override
    public IntProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    public BlockState withAge(int age) {
        return age == 2 ? ModBlocks.SHELL_FLOWER.getDefaultState() : super.withAge(age);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (random.nextInt(3) != 0) {
            super.randomTick(state, world, pos, random);
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    protected int getGrowthAmount(World world) {
        return 1;
    }
}
