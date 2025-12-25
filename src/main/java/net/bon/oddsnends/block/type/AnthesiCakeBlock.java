package net.bon.oddsnends.block.type;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class AnthesiCakeBlock extends Block {
    public static final int MAX_BITES = 6;
    public static final IntegerProperty BITES = BlockStateProperties.BITES;
    protected static final VoxelShape[] SHAPE_BY_BITE = new VoxelShape[]{
            Block.box(1.0, 0.0, 1.0, 15.0, 8.0, 15.0),
            Block.box(3.0, 0.0, 1.0, 15.0, 8.0, 15.0),
            Block.box(5.0, 0.0, 1.0, 15.0, 8.0, 15.0),
            Block.box(7.0, 0.0, 1.0, 15.0, 8.0, 15.0),
            Block.box(9.0, 0.0, 1.0, 15.0, 8.0, 15.0),
            Block.box(11.0, 0.0, 1.0, 15.0, 8.0, 15.0),
            Block.box(13.0, 0.0, 1.0, 15.0, 8.0, 15.0)};
    public AnthesiCakeBlock(Properties properties) {
        super(properties);
    }
    
    public VoxelShape getShape(BlockState state, BlockGetter view, BlockPos pos, CollisionContext ctx) {
        return SHAPE_BY_BITE[state.getValue(BITES)];
    }

    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if (level.isClientSide) {
            if (eat(level, pos, state, player).consumesAction()) {
                return InteractionResult.SUCCESS;
            } if (player.getItemInHand(hand).isEmpty()) {
                return InteractionResult.CONSUME;
            }
        }
        return eat(level, pos, state, player);
    }

    protected static InteractionResult eat(LevelAccessor level, BlockPos pos, BlockState state, Player player) {
        if (!player.canEat(false)) {
            return InteractionResult.PASS;
        } else {
            player.awardStat(Stats.EAT_CAKE_SLICE);
            player.getFoodData().eat(2, 0.1F);
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 240, 1));
            int $$4 = state.getValue(BITES);
            level.gameEvent(player, GameEvent.EAT, pos);
            if ($$4 < 6) {
                level.setBlock(pos, state.setValue(BITES, $$4 + 1), 3);
            } else {
                level.removeBlock(pos, false);
                level.gameEvent(player, GameEvent.BLOCK_DESTROY, pos);
            }

            return InteractionResult.SUCCESS;
        }
    }

    public BlockState updateShape(BlockState state, Direction direction, BlockState blockState, LevelAccessor level, BlockPos pos, BlockPos blockPos) {
        return direction == Direction.DOWN && !state.canSurvive(level, pos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, direction, blockState, level, pos, blockPos);
    }

    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return level.getBlockState(pos.below()).isSolid();
    }

    public int getAnalogOutputSignal(BlockState state, Level level, BlockPos pos) {
        return getOutputSignal(state.getValue(BITES));
    }

    public static int getOutputSignal(int signal) {
        return (7 - signal) * 2;
    }

    public boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    public boolean isPathfindable(BlockState state, BlockGetter view, BlockPos pos, PathComputationType type) {
        return false;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{BITES});
    }
}