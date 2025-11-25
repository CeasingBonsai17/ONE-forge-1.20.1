package net.bon.oddsnends.mixin;

import net.bon.oddsnends.block.OddBlocks;
import net.bon.oddsnends.block.type.RageFireBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(BaseFireBlock.class)
public abstract class BaseFireBlockMixin {

    @Inject(
            method = "getState",
            at = @At(value = "HEAD"),
            cancellable = true
    )
    private static void oddsnends$getState(BlockGetter world, BlockPos pos, CallbackInfoReturnable<BlockState> cir) {
        if (RageFireBlock.canSurviveOnBlock(world.getBlockState(pos.below()))) {
            //cir.setReturnValue(OddBlocks.RAGE_FIRE.get().defaultBlockState());
            cir.cancel();
        }
    }
}