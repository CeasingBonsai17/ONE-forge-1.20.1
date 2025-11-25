package net.bon.oddsnends.block.type;

import net.bon.oddsnends.particle.OddParticleTypes;
import net.bon.oddsnends.util.OddTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class RageFireBlock extends BaseFireBlock {
    public RageFireBlock(BlockBehaviour.Properties p_56653_) {
        super(p_56653_, 2.0F);
    }

    public BlockState updateShape(BlockState state, Direction direction, BlockState blockState, LevelAccessor level, BlockPos pos, BlockPos blockPos) {
        return this.canSurvive(state, level, pos) ? this.defaultBlockState() : Blocks.AIR.defaultBlockState();
    }

    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource source) {
        if (source.nextInt(24) == 0) {
            level.playLocalSound((double)pos.getX() + 0.5, (double)pos.getY() + 0.5, (double)pos.getZ() + 0.5, SoundEvents.FIRE_AMBIENT, SoundSource.BLOCKS, 1.0F + source.nextFloat(), source.nextFloat() * 0.7F + 0.3F, false);
        }

        BlockPos blockpos = pos.below();
        BlockState blockstate = level.getBlockState(blockpos);
        int j1;
        double d7;
        double d12;
        double d17;
        {
            for(j1 = 0; j1 < 1; ++j1) {
                d7 = (double)pos.getX() + source.nextDouble();
                d12 = (double)pos.getY() + source.nextDouble() * 0.5 + 0.5;
                d17 = (double)pos.getZ() + source.nextDouble();
                level.addParticle(ParticleTypes.LARGE_SMOKE, d7, d12, d17, 0.0, 0.0, 0.0);
            }
            for(j1 = 0; j1 < 2; ++j1) {
                d7 = (double)pos.getX() + source.nextDouble();
                d12 = (double)pos.getY() + source.nextDouble() * 0.5 + 0.5;
                d17 = (double)pos.getZ() + source.nextDouble();
                level.addParticle(OddParticleTypes.MANA_RUNE.get(), d7, d12, d17, 0.0, 0.0, 0.0);
            }
        }
    }

    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return canSurviveOnBlock(level.getBlockState(pos.below()));
    }

    public static boolean canSurviveOnBlock(BlockState state) {
        return state.is(OddTags.RAGE_FIRE_BASE_BLOCKS);
    }

    protected boolean canBurn(BlockState p_56668_) {
        return true;
    }
}

