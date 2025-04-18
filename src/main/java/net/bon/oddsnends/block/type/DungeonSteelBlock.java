package net.bon.oddsnends.block.type;

import net.bon.oddsnends.state.property.OddProperties;
import net.bon.oddsnends.util.OddBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.Random;

public class DungeonSteelBlock extends Block {
    public static final BooleanProperty SUBMERGED;

    public DungeonSteelBlock(Properties properties) {
        super(properties);
        this.registerDefaultState((BlockState) this.defaultBlockState().setValue(SUBMERGED, false));
    }

    public BlockState updateShape(BlockState state, Direction direction, BlockState blockState, LevelAccessor level, BlockPos pos, BlockPos blockPos) {
        return direction == Direction.UP ? (BlockState) state.setValue(SUBMERGED, this.isWater(blockState)) : super.updateShape(state, direction, blockState, level, pos, blockPos);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        LevelAccessor levelaccessor = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        return (BlockState) ((BlockState) this.defaultBlockState().setValue(SUBMERGED, this.isWater(levelaccessor.getBlockState(blockpos.above()))));
    }

    private boolean isWater(BlockState state) {
        return state.is(Blocks.WATER);
    }

    public void animateTick(BlockState state, Level world, BlockPos pos, RandomSource random) {
        if (state.getValue(SUBMERGED)) {
            for (int i = 0; i < random.nextInt(1) + 0; ++i) {
                world.addParticle(ParticleTypes.BUBBLE, (double) pos.getX() + 0.6, (double) pos.getY() + 1.0, (double) pos.getZ() + 0.5, (double) (random.nextFloat() / 0.5F), 2.5, (double) (random.nextFloat() / 0.5F));
            }
            for (int i = 0; i < random.nextInt(2) + 1; ++i) {
                world.addParticle(ParticleTypes.BUBBLE, (double) pos.getX() + 0.4, (double) pos.getY() + 1.0, (double) pos.getZ() + 0.6, (double) (random.nextFloat() / 0.5F), 2.5, (double) (random.nextFloat() / 0.5F));
            }
            for (int i = 0; i < random.nextInt(1) + 3; ++i) {
                world.addParticle(ParticleTypes.BUBBLE, (double) pos.getX() + 0.5, (double) pos.getY() + 1.0, (double) pos.getZ() + 0.4, (double) (random.nextFloat() / 0.5F), 2.5, (double) (random.nextFloat() /0.5F));
            }
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(SUBMERGED);
    }

    static {
        SUBMERGED = OddProperties.SUBMERGED;
    }
}
