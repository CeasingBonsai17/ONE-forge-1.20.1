package net.bon.oddsnends.block.type;

import net.bon.oddsnends.item.OddItems;
import net.bon.oddsnends.state.property.OddProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.AmethystClusterBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;

public class GiantPadmaBlock extends AmethystClusterBlock implements BonemealableBlock {
        public static final BooleanProperty SHEARED;

        public GiantPadmaBlock(int height, int xzOffset, Properties properties) {
                super (height, xzOffset, properties);
                        this.registerDefaultState((BlockState) this.defaultBlockState().setValue(SHEARED, false));
        }

        public boolean isValidBonemealTarget(LevelReader levelReader, BlockPos pos, BlockState state, boolean bl) {
                return state.getValue(SHEARED).booleanValue();
        }

        public void performBonemeal(ServerLevel level, RandomSource randomSource, BlockPos pos, BlockState state) {
                level.setBlockAndUpdate(pos, state.setValue(SHEARED, false));
        }

        public boolean isBonemealSuccess(Level level, RandomSource randomSource, BlockPos pos, BlockState state) {
                return true;
        }

        @Override
        public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
                ItemStack itemStack = player.getItemInHand(hand);
                boolean s = state.getValue(SHEARED);
                boolean bl = false;
                if (!s) {
                        if (itemStack.is(Items.SHEARS)) {
                                level.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.SHEEP_SHEAR, SoundSource.BLOCKS, 1.0f, 1.0f);
                                level.setBlockAndUpdate(pos,state.cycle(SHEARED));
                                GiantPadmaBlock.dropGiantPadmaPetals(level, pos);
                                if (!player.isCreative()) {
                                        itemStack.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(hand));
                                }
                                bl = true;
                        }
                        if (!level.isClientSide() && bl) {
                                player.awardStat(Stats.ITEM_USED.get(itemStack.getItem()));
                        }
                }
                if (bl) {
                        return InteractionResult.sidedSuccess(level.isClientSide);
                }
                return InteractionResult.PASS;
        }
        public static void dropGiantPadmaPetals(Level level, BlockPos pos) {
                GiantPadmaBlock.popResource(level, pos, new ItemStack(OddItems.GIANT_PADMA_PETAL.get(), 4));
        }
        @Override
        protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
                builder.add(FACING);
                builder.add(WATERLOGGED);
                builder.add(SHEARED);
        }

        static {
                SHEARED = OddProperties.SHEARED;
        }
}