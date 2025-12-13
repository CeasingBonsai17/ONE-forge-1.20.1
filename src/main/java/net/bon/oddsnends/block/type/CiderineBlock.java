package net.bon.oddsnends.block.type;

import net.bon.oddsnends.item.OddItems;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class CiderineBlock extends OddFruitBlock{
    public CiderineBlock(int nutrition, float saturation, Properties properties) {
        super(nutrition, saturation, properties);
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