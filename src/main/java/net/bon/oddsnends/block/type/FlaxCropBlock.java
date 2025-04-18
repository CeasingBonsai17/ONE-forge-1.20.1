package net.bon.oddsnends.block.type;

import net.bon.oddsnends.item.OddItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.swing.text.html.BlockView;

public class FlaxCropBlock extends CropBlock {
    private static final VoxelShape[] AGE_TO_SHAPE;
    public FlaxCropBlock(Properties properties) {
        super(properties);
    }

    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return AGE_TO_SHAPE[this.getAge(state)];
    }

    protected ItemLike getBaseSeedId() {
        return OddItems.FLAX_SEEDS.get();
    }

    static {
        AGE_TO_SHAPE = new VoxelShape[]{
                Block.box(4.0, 0.0, 4.0, 12.0, 2.0, 12.0),
                Block.box(4.0, 0.0, 4.0, 12.0, 4.0, 12.0),
                Block.box(3.0, 0.0, 3.0, 13.0, 8.0, 13.0),
                Block.box(3.0, 0.0, 3.0, 13.0, 11.0, 13.0),
                Block.box(2.0, 0.0, 2.0, 14.0, 16.0, 14.0),
                Block.box(2.0, 0.0, 2.0, 14.0, 16.0, 14.0),
                Block.box(2.0, 0.0, 2.0, 14.0, 16.0, 14.0),
                Block.box(2.0, 0.0, 2.0, 14.0, 16.0, 14.0)
        };
    }
}
