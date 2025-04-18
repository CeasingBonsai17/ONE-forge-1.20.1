package net.bon.oddsnends.block.type;

import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.bon.oddsnends.particle.OddParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.Map;

public class WallRageSconceBlock extends RageSconceBlock {
    public static final DirectionProperty FACING;
    protected static final float AABB_OFFSET = 2.5F;
    private static final Map<Direction, VoxelShape> AABBS;

    public WallRageSconceBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState((BlockState)((BlockState)this.stateDefinition.any()).setValue(FACING, Direction.NORTH));
    }

    public String getDescriptionId() {
        return this.asItem().getDescriptionId();
    }

    public VoxelShape getShape(BlockState state, BlockGetter view, BlockPos pos, CollisionContext context) {
        return getShape(state);
    }

    public static VoxelShape getShape(BlockState state) {
        return (VoxelShape)AABBS.get(state.getValue(FACING));
    }

    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        Direction $$3 = (Direction)state.getValue(FACING);
        BlockPos $$4 = pos.relative($$3.getOpposite());
        BlockState $$5 = level.getBlockState($$4);
        return $$5.isFaceSturdy(level, $$4, $$3);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState $$1 = this.defaultBlockState();
        LevelReader $$2 = context.getLevel();
        BlockPos $$3 = context.getClickedPos();
        Direction[] $$4 = context.getNearestLookingDirections();
        Direction[] var6 = $$4;
        int var7 = $$4.length;

        for(int var8 = 0; var8 < var7; ++var8) {
            Direction $$5 = var6[var8];
            if ($$5.getAxis().isHorizontal()) {
                Direction $$6 = $$5.getOpposite();
                $$1 = (BlockState)$$1.setValue(FACING, $$6);
                if ($$1.canSurvive($$2, $$3)) {
                    return $$1;
                }
            }
        }

        return null;
    }

    public BlockState updateShape(BlockState state, Direction direction, BlockState blockState, LevelAccessor level, BlockPos pos, BlockPos blockPos) {
        return direction.getOpposite() == state.getValue(FACING) && !state.canSurvive(level, pos) ? Blocks.AIR.defaultBlockState() : state;
    }

    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource source) {
        Direction $$4 = (Direction)state.getValue(FACING);
        double $$5 = (double)pos.getX() + 0.5;
        double $$6 = (double)pos.getY() + 0.7;
        double $$7 = (double)pos.getZ() + 0.5;
        double $$8 = 0.22;
        double $$9 = 0.27;
        Direction $$10 = $$4.getOpposite();
        level.addParticle(ParticleTypes.SMOKE, $$5 + 0.27 * (double)$$10.getStepX(), $$6 + 0.22, $$7 + 0.27 * (double)$$10.getStepZ(), 0.0, 0.0, 0.0);
        level.addParticle(OddParticleTypes.RAGE_FIRE_FLAME.get(), $$5 + 0.27 * (double)$$10.getStepX(), $$6 + 0.22, $$7 + 0.27 * (double)$$10.getStepZ(), 0.0, 0.0, 0.0);
    }

    public BlockState rotate(BlockState state, Rotation rotation) {
        return (BlockState)state.setValue(FACING, rotation.rotate((Direction)state.getValue(FACING)));
    }

    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation((Direction)state.getValue(FACING)));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> state) {
        state.add(new Property[]{FACING});
    }

    static {
        FACING = HorizontalDirectionalBlock.FACING;
        AABBS = Maps.newEnumMap(ImmutableMap.of(Direction.NORTH, Block.box(5.5, 3.0, 11.0, 10.5, 13.0, 16.0), Direction.SOUTH, Block.box(5.5, 3.0, 0.0, 10.5, 13.0, 5.0), Direction.WEST, Block.box(11.0, 3.0, 5.5, 16.0, 13.0, 10.5), Direction.EAST, Block.box(0.0, 3.0, 5.5, 5.0, 13.0, 10.5)));
    }
}
