package net.bon.oddsnends.block.type;

import net.bon.oddsnends.OddConfig;
import net.bon.oddsnends.block.OddBlocks;
import net.bon.oddsnends.item.OddItems;
import net.bon.oddsnends.util.OddTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CiderineCropBlock extends FallingBlock implements BonemealableBlock {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{Block.box(4.0, 9.0, 4.0, 12.0, 13.0, 12.0), Block.box(5.0, 9.0, 5.0, 11.0, 13.0, 11.0), Block.box(4.0, 7.0, 4.0, 12.0, 13.0, 12.0), Block.box(3.0, 5.0, 3.0, 13.0, 13.0, 13.0)};
    public CiderineCropBlock(Properties properties) {
        super(properties);
    }

    public boolean isRandomlyTicking(BlockState state) {
        return true;
    }

    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if(state.getValue(AGE) < 3) {
            level.setBlock(pos, state.setValue(AGE, state.getValue(AGE) + 1), 11);
        }
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state, boolean b) {
        return state.getValue(AGE) < 3;
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        int i = Math.min(3, state.getValue(AGE) + 1);
        level.setBlock(pos, state.setValue(AGE, i), 11);
    }

    public BlockState updateShape(BlockState state, Direction direction, BlockState blockState, LevelAccessor level, BlockPos pos, BlockPos blockPos) {
        return !state.canSurvive(level, pos) && state.getValue(AGE) < 3 ? Blocks.AIR.defaultBlockState() : super.updateShape(state, direction, state, level, pos, blockPos);
    }

    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!player.isSecondaryUseActive() && OddConfig.clickHarvestCiderines && state.getValue(AGE) == 3) {
            level.playSound(player, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.CAVE_VINES_BREAK, SoundSource.BLOCKS, 1.0f, 1.0f);

            level.setBlockAndUpdate(pos, OddBlocks.CIDERINE_BLOSSOM.get().defaultBlockState().setValue(CiderineBlossomBlock.POLLINATED, !OddConfig.ciderineRequirePollinationToGrow));
            level.addFreshEntity(new ItemEntity(level, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, new ItemStack(OddItems.CIDERINE.get(), 1)));
            return InteractionResult.sidedSuccess(level.isClientSide);
        }
        return InteractionResult.PASS;
    }

    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return level.getBlockState(pos.above()).is(OddTags.CIDERINE_LEAVES);
    }

    @Override
    public float getMaxHorizontalOffset() {
        float offset;
        if (OddConfig.ciderineCropXZRandomization) {
            offset = super.getMaxHorizontalOffset();
        } else {
            offset = 0.0f;
        }
        return offset;
    }

    public ItemStack getCloneItemStack(BlockGetter block, BlockPos pos, BlockState state) {
        return new ItemStack(OddItems.CIDERINE.get());
    }

    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!canSurvive(state, level, pos) && state.getValue(AGE) == 3) {
            this.falling(FallingBlockEntity.fall(level, pos, OddBlocks.CIDERINE.get().defaultBlockState().setValue(HangingCiderineBlock.FACING, Direction.DOWN)));
        }
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    public VoxelShape getShape(BlockState state, BlockGetter view, BlockPos pos, CollisionContext context) {
        Vec3 vec3 = state.getOffset(view, pos);
        return SHAPE_BY_AGE[state.getValue(AGE)].move(vec3.x, vec3.y, vec3.z);
    }
 }
