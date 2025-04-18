package net.bon.oddsnends.block.type;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import javax.swing.text.html.BlockView;

public class DriedFlaxFlowerBlock extends FlaxFlowerBlock{
    public DriedFlaxFlowerBlock(MobEffect effectSupplier, int i, Properties properties) {
        super(effectSupplier, i, properties);
    }

    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockState $$3 = level.getBlockState(pos.below());
        return Block.isFaceFull($$3.getCollisionShape(level, pos.below()), Direction.UP);
    }
}