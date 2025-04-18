package net.bon.oddsnends.block.type;


import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.function.Supplier;

public class FlaxFlowerBlock extends FlowerBlock implements BonemealableBlock {
    protected static final float field_31094 = 3.0F;
    protected static final VoxelShape SHAPE = Block.box(2.0, 0.0, 2.0, 14.0, 16.0, 14.0);

    public FlaxFlowerBlock(MobEffect effectSupplier, int i, Properties properties) {
        super(effectSupplier, i, properties);
    }

    public VoxelShape getShape(BlockState p_53517_, BlockGetter p_53518_, BlockPos p_53519_, CollisionContext p_53520_) {
        Vec3 vec3 = p_53517_.getOffset(p_53518_, p_53519_);
        return SHAPE.move(vec3.x, vec3.y, vec3.z);
    }

    public boolean isValidBonemealTarget(LevelReader levelReader, BlockPos pos, BlockState state, boolean bl) {
        return true;
    }

    public boolean isBonemealSuccess(Level level, RandomSource randomSource, BlockPos pos, BlockState state) {
        return true;
    }

    public void performBonemeal(ServerLevel level, RandomSource randomSource, BlockPos pos, BlockState state) {
        popResource(level, pos, new ItemStack(this));
    }
}
