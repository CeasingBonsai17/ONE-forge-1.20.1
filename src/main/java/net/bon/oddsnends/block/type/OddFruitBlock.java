package net.bon.oddsnends.block.type;

import net.bon.oddsnends.state.property.OddProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class OddFruitBlock extends Block {
    private static final VoxelShape[] NORTH = new VoxelShape[] {
            Block.box(0, 0, 8, 8, 16, 16),
            Block.box(0, 0, 8, 16, 16, 16),
                    Shapes.join(Block.box(8, 0, 0, 16, 16, 16),
                    Block.box(0, 0, 8, 8, 16, 16), BooleanOp.OR)};
    private static final VoxelShape[] EAST = new VoxelShape[] {
            Block.box(0, 0, 0, 8, 16, 8),
            Block.box(0, 0, 0, 8, 16, 16),
                    Shapes.join(Block.box(0, 0, 8, 16, 16, 16),
                    Block.box(0, 0, 0, 8, 16, 8), BooleanOp.OR)};
    private static final VoxelShape[] SOUTH = new VoxelShape[] {
            Block.box(8, 0, 0, 16, 16, 8),
            Block.box(0, 0, 0, 16, 16, 8),
            Shapes.join(Block.box(0, 0, 0, 8, 16, 16),
                    Block.box(8, 0, 0, 16, 16, 8), BooleanOp.OR)};
    private static final VoxelShape[] WEST = new VoxelShape[] {
            Block.box(8, 0, 8, 16, 16, 16),
            Block.box(8, 0, 0, 16, 16, 16),
            Shapes.join(Block.box(0, 0, 0, 16, 16, 8),
                    Block.box(8, 0, 8, 16, 16, 16), BooleanOp.OR)};

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final IntegerProperty SLICES = OddProperties.SLICES;
    public final int nutrition;
    public final float saturation;
    public OddFruitBlock(int nutrition, float saturation, Properties properties) {
        super(properties);
        this.nutrition = nutrition;
        this.saturation = saturation;
        this.registerDefaultState(this.defaultBlockState().setValue(SLICES, 4));
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (player.getItemInHand(hand).isEmpty() && player.canEat(false)) {
            switch (state.getValue(SLICES)) {
                case 2, 3, 4 -> level.setBlockAndUpdate(pos,state.setValue(SLICES, state.getValue(SLICES) - 1));
                case 1 -> level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
            }
            player.getFoodData().eat(nutrition, saturation);
            level.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.GENERIC_EAT, SoundSource.BLOCKS, 1.0f, 1.0f);
            return InteractionResult.sidedSuccess(level.isClientSide);
        }
        return InteractionResult.PASS;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter block, BlockPos pos, CollisionContext ctx) {
        if (state.getValue(SLICES) != 4) {
            switch(state.getValue(FACING)) {
                case NORTH: return NORTH[state.getValue(SLICES) - 1];
                case EAST: return EAST[state.getValue(SLICES) - 1];
                case SOUTH: return SOUTH[state.getValue(SLICES) - 1];
                case WEST: return WEST[state.getValue(SLICES) - 1];
            }
        }
        return super.getShape(state, block, pos, ctx);
    }

    @Override
    public void onProjectileHit(Level level, BlockState state, BlockHitResult result, Projectile projectile) {
        if(!level.isClientSide()) {
            int count = 9;
            switch(state.getValue(SLICES)) {
                case 1 -> count = 1;
                case 2 -> count = 2;
                case 3 -> count = 4;
            }
            level.setBlockAndUpdate(result.getBlockPos(), Blocks.AIR.defaultBlockState());
            level.addFreshEntity(new ItemEntity(level, result.getBlockPos().getX() + 0.5, result.getBlockPos().getY() + 0.5, result.getBlockPos().getZ() + 0.5, new ItemStack(Items.APPLE, count)));
        }
    }

    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return this.defaultBlockState().setValue(FACING, ctx.getHorizontalDirection().getOpposite());
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> state) {
        state.add(new Property[]{FACING, SLICES});
    }
}
