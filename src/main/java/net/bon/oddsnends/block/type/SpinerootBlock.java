package net.bon.oddsnends.block.type;

import net.bon.oddsnends.state.property.OddProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SpinerootBlock extends BushBlock {
    public static final IntegerProperty STAGE = OddProperties.ROOT_STAGE;

    public SpinerootBlock(Properties properties) {
        super(properties);
        registerDefaultState(this.defaultBlockState().setValue(STAGE, 1));
    }

    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (!level.isClientSide) {
             if (state.getValue(STAGE) == 0) {
                 setStageAndScheduleTick(state, level, pos, 1);
            } if (state.getValue(STAGE) == 1 && !entity.isSteppingCarefully()) {
                setStageAndScheduleTick(state, level, pos, 2);
            }
            if (state.getValue(STAGE) == 3) {
                if(entity instanceof LivingEntity) {
                    entity.hurt(entity.damageSources().cactus(), 1.5f);
                }
                setStageAndScheduleTick(state, level, pos, 3);
            }
        }
    }

    public VoxelShape getShape(BlockState state, BlockGetter view, BlockPos pos, CollisionContext context) {
        return Block.box(1, 0, 1, 15, 4, 15);
    }

    private void setStageAndScheduleTick(BlockState state, Level level, BlockPos pos, int stage) {
        level.setBlock(pos, state.setValue(STAGE, stage), 2);
        level.scheduleTick(pos, this, 10);
        level.gameEvent(null, GameEvent.BLOCK_CHANGE, pos);
    }


    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource source) {
        if (state.getValue(STAGE) == 2) {
            setStageAndScheduleTick(state, level, pos, 3);
        } else if (state.getValue(STAGE) == 3) {
            setStageAndScheduleTick(state, level, pos, 0);
            level.playSound(null, pos, SoundEvents.CAVE_VINES_FALL, SoundSource.BLOCKS);
        }
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> state) {
        state.add(new Property[]{STAGE});
    }
}