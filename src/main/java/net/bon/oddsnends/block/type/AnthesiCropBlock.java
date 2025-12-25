package net.bon.oddsnends.block.type;

import net.bon.oddsnends.OddConfig;
import net.bon.oddsnends.block.OddBlocks;
import net.bon.oddsnends.item.OddItems;
import net.bon.oddsnends.state.property.OddProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.ForgeHooks;

public class AnthesiCropBlock extends CropBlock {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_7;
    public static final BooleanProperty SHEARED = OddProperties.SHEARED;
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[] {
            Block.box(4, 10, 4, 12, 16, 12),
            Block.box(4, 7, 4, 12, 16, 12),
            Block.box(2, 5, 2, 14, 16, 14),
            Block.box(2, 2, 2, 14, 16, 14),
            Block.box(2, 0, 2, 14, 16, 14),
            Block.box(2, 0, 2, 14, 16, 14),
            Block.box(2, 0, 2, 14, 16, 14),
            Block.box(2, 0, 2, 14, 16, 14)};

    public AnthesiCropBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(this.getAgeProperty(), 0).setValue(SHEARED, false));
    }

    @Override
    public float getMaxHorizontalOffset() {
        float offset;
        if (OddConfig.anthesiCropXZRandomization) {
            offset = super.getMaxHorizontalOffset();
        } else {
            offset = 0.0f;
        }
        return offset;
    }

    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        int i = this.getAge(state);
        float f = getGrowthSpeed(this, level, pos);
        if (!state.getValue(SHEARED) && level.isAreaLoaded(pos, 1) && level.getRawBrightness(pos, 0) >= 9 && i < getMaxAge() && ForgeHooks.onCropsGrowPre(level, pos, state, random.nextInt((int)(25.0F / f) + 1) == 0)) {
            level.setBlock(pos, getStateForAge(i + 1), 2);
            ForgeHooks.onCropsGrowPost(level, pos, state);
        }
    }
    
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos blockpos = pos.above();
        return state.getBlock() == this ? level.getBlockState(blockpos).canSustainPlant(level, blockpos, Direction.DOWN, this) : this.mayPlaceOn(level.getBlockState(blockpos), level, blockpos);
    }

    protected boolean mayPlaceOn(BlockState state, BlockGetter view, BlockPos pos) {
        return state.is(BlockTags.DIRT) || state.is(Blocks.FARMLAND);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!player.isSecondaryUseActive()) {
            ItemStack itemStack = player.getItemInHand(hand);
            if (itemStack.is(Items.SHEARS)) {
                level.setBlockAndUpdate(pos, this.defaultBlockState().setValue(AGE, state.getValue(AGE)).setValue(SHEARED, true));
                level.playSound(player, pos, SoundEvents.GROWING_PLANT_CROP, SoundSource.BLOCKS);
                if (!player.isCreative()) {
                    itemStack.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(hand));
                } if (!level.isClientSide()) {
                    player.awardStat(Stats.ITEM_USED.get(itemStack.getItem()));
                }
                return InteractionResult.sidedSuccess(level.isClientSide);
            } if (OddConfig.clickHarvestAnthesi && state.getValue(AGE) == 7) {
                level.playSound(player, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.CAVE_VINES_BREAK, SoundSource.BLOCKS, 1.0f, 1.0f);
                level.setBlockAndUpdate(pos, this.defaultBlockState().setValue(AGE, 0).setValue(SHEARED, false));
                Block.popResource(level, pos, new ItemStack(OddItems.ANTHESI_FRUIT.get(), 2));
                return InteractionResult.sidedSuccess(level.isClientSide);
            }
        }
        return InteractionResult.PASS;
    }

    protected IntegerProperty getAgeProperty() {
        return AGE;
    }

    public int getMaxAge() {
        return 7;
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return true;
    }

    protected ItemLike getBaseSeedId() {
        return OddItems.ANTHESI_PIT.get();
    }
    
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> state) {
        state.add(new Property[]{AGE, SHEARED});
    }

    public VoxelShape getShape(BlockState state, BlockGetter view, BlockPos pos, CollisionContext context) {
        return SHAPE_BY_AGE[this.getAge(state)];
    }
}