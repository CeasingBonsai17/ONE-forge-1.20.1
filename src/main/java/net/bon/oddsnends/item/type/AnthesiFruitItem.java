package net.bon.oddsnends.item.type;

import net.bon.oddsnends.item.OddItems;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class AnthesiFruitItem extends Item {

    public AnthesiFruitItem(Item.Properties properties) {
        super(properties);
    }

    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        super.finishUsingItem(stack, level, entity);
        if (entity instanceof ServerPlayer serverPlayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, stack);
            serverPlayer.awardStat(Stats.ITEM_USED.get(this));
        } if (stack.isEmpty()) {
            return new ItemStack(OddItems.ANTHESI_PIT.get());
        } else {
            Player player = (Player)entity;
            if (entity instanceof Player && !(player).getAbilities().instabuild) {
                ItemStack pit = new ItemStack(OddItems.ANTHESI_PIT.get());
                if (!player.getInventory().add(pit)) {
                    player.drop(pit, false);
                }
            }
            return stack;
        }
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        return ItemUtils.startUsingInstantly(level, player, hand);
    }

    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack stack) {
        return new ItemStack(OddItems.ANTHESI_PIT.get());
    }
}
