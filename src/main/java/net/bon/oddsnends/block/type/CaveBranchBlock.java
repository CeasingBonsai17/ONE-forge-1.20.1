package net.bon.oddsnends.block.type;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.VineBlock;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CaveBranchBlock extends VineBlock {
    private static final VoxelShape UP_SHAPE;
    public CaveBranchBlock(Properties properties) {
        super(properties);
    }

    static {
        UP_SHAPE = Block.box(3.0, 0.0, 3.0, 13.0, 16.0, 13.0);
    }
}