package net.bon.oddsnends.block.type;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class RageLanternBlock extends LanternBlock {
    public static final BooleanProperty HANGING;
    protected static final VoxelShape STANDING_SHAPE;
    protected static final VoxelShape HANGING_SHAPE;
    public RageLanternBlock(Properties properties) {
        super(properties);
    }

    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return (Boolean)state.getValue(HANGING) ? HANGING_SHAPE : STANDING_SHAPE;
    }

    static {
        HANGING = BlockStateProperties.HANGING;
        STANDING_SHAPE = Shapes.or(Block.box(4.0, 0.0, 4.0, 12.0, 8.0, 12.0), Block.box(6.0, 8.0, 6.0, 10.0, 10.0, 10.0));
        HANGING_SHAPE = Shapes.or(Block.box(4.0, 1.0, 4.0, 12.0, 9.0, 12.0), Block.box(6.0, 9.0, 6.0, 10.0, 11.0, 10.0));
    }
}
