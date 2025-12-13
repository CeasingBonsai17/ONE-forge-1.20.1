package net.bon.oddsnends.block.type;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class HangingCiderineBlock extends FallingBlock {
    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    protected final VoxelShape northShape;
    protected final VoxelShape southShape;
    protected final VoxelShape eastShape;
    protected final VoxelShape westShape;
    protected final VoxelShape upShape;
    protected final VoxelShape downShape;
    public HangingCiderineBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(FACING, Direction.UP));
        this.upShape = Block.box(3, 0.0, 3, 13, 8, 13);
        this.downShape = Block.box(3, 5, 3, 13, 13, 13);
        this.northShape = Block.box(3, 3, 6, 13, 11, 16);
        this.southShape = Block.box(3, 3, 0, 13, 11, 10);
        this.eastShape = Block.box(0, 3, 3, 10, 11, 13);
        this.westShape = Block.box(6, 3, 3, 16, 11, 13);
    }

    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        Direction facing = state.getValue(FACING);
        BlockPos relativePos = pos.relative(facing.getOpposite());
        return level.getBlockState(relativePos).isFaceSturdy(level, relativePos, facing) || level.getBlockState(relativePos).is(BlockTags.LEAVES);
    }

    @Override
    public void animateTick(BlockState p_221129_, Level p_221130_, BlockPos p_221131_, RandomSource p_221132_) {
    }

    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!canSurvive(state, level, pos)) {
            this.falling(FallingBlockEntity.fall(level, pos, state));
        }
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return this.defaultBlockState().setValue(FACING, ctx.getClickedFace());
    }

    public VoxelShape getShape(BlockState state, BlockGetter block, BlockPos pos, CollisionContext ctx) {
        switch (state.getValue(FACING)) {
            case NORTH:
                return this.northShape;
            case SOUTH:
                return this.southShape;
            case EAST:
                return this.eastShape;
            case WEST:
                return this.westShape;
            case DOWN:
                return this.downShape;
            case UP:
            default:
                return this.upShape;
        }
    }

    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> state) {
        state.add(new Property[]{FACING});
    }
}
