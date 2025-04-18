package net.bon.oddsnends.block.type;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;

public class AnthesiCropBlock extends BushBlock implements BonemealableBlock {
    public AnthesiCropBlock(Properties properties) {
        super(properties);
    }

    public boolean isValidBonemealTarget(LevelReader levelReader, BlockPos pos, BlockState state, boolean bl) {
        return true;
    }

    public boolean isBonemealSuccess(Level level, RandomSource randomSource, BlockPos pos, BlockState state) {
        return true;
    }

    public void performBonemeal(ServerLevel level, RandomSource randomSource, BlockPos pos, BlockState state) {
        popResource(level, pos, new ItemStack(this));
    }
}