package net.bon.oddsnends.block.type;

import net.bon.oddsnends.item.OddItems;
import net.bon.oddsnends.util.OddTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Fallable;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class CiderineBlock extends OddFruitBlock implements Fallable {
    public CiderineBlock(int nutrition, float saturation, Properties properties) {
        super(nutrition, saturation, properties);
    }

    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState blockState, boolean b) {
        level.scheduleTick(pos, this, this.getDelayAfterPlace());
    }

    public BlockState updateShape(BlockState state, Direction direction, BlockState blockState, LevelAccessor level, BlockPos pos, BlockPos blockPos) {
        level.scheduleTick(pos, this, this.getDelayAfterPlace());
        return super.updateShape(state, direction, blockState, level, pos, blockPos);
    }

    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (shouldFall(level, pos) && pos.getY() >= level.getMinBuildHeight()) {
            this.falling(FallingBlockEntity.fall(level, pos, state));
        }
    }

    protected void falling(FallingBlockEntity entity) {
    }

    protected int getDelayAfterPlace() {
        return 2;
    }

    public boolean shouldFall(LevelReader level, BlockPos pos) {
        return !level.getBlockState(pos.above()).is(BlockTags.LEAVES) && isFree(level, pos) ;
    }

    public static boolean isFree(LevelReader level, BlockPos pos) {
        BlockState below = level.getBlockState(pos.below());
        return below.isAir() || below.is(BlockTags.FIRE) || below.liquid() || below.canBeReplaced();
    }
    
    @Override
    public void onProjectileHit(Level level, BlockState state, BlockHitResult result, Projectile projectile) {
        if(!level.isClientSide()) {
            int count = 4;
            switch(state.getValue(SLICES)) {
                case 1 -> count = 1;
                case 2 -> count = 2;
                case 3 -> count = 3;
            }
            level.setBlockAndUpdate(result.getBlockPos(), Blocks.AIR.defaultBlockState());
            level.addFreshEntity(new ItemEntity(level, result.getBlockPos().getX() + 0.5, result.getBlockPos().getY() + 0.5, result.getBlockPos().getZ() + 0.5, new ItemStack(OddItems.CIDERINE.get(), count)));
        }
    }
}