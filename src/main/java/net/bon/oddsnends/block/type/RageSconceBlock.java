package net.bon.oddsnends.block.type;

import com.google.common.base.Supplier;
import net.bon.oddsnends.particle.OddParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class RageSconceBlock extends Block {
    protected static final int AABB_STANDING_OFFSET = 2;
    protected static final VoxelShape AABB = Block.box(6.0, 0.0, 6.0, 10.0, 10.0, 10.0);

    public RageSconceBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    public VoxelShape getShape(BlockState state, BlockGetter view, BlockPos pos, CollisionContext context) {
        return AABB;
    }

    public BlockState updateShape(BlockState state, Direction direction, BlockState blockState, LevelAccessor level, BlockPos pos, BlockPos blockPos) {
        return direction == Direction.DOWN && !this.canSurvive(state, level, pos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, direction, blockState, level, pos, blockPos);
    }

    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return canSupportCenter(level, pos.below(), Direction.UP);
    }

    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource source) {
        double $$4 = (double)pos.getX() + 0.5;
        double $$5 = (double)pos.getY() + 0.7;
        double $$6 = (double)pos.getZ() + 0.5;
        level.addParticle(ParticleTypes.SMOKE, $$4, $$5, $$6, 0.0, 0.0, 0.0);
        level.addParticle(OddParticleTypes.RAGE_FIRE_FLAME.get(), $$4, $$5, $$6, 0.0, 0.0, 0.0);
    }
}