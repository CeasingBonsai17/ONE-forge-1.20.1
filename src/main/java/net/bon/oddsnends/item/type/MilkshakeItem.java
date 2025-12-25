package net.bon.oddsnends.item.type;

import net.bon.oddsnends.sound.OddSoundEvents;
import net.bon.oddsnends.util.CompatUtil;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BowlFoodItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class MilkshakeItem extends BowlFoodItem {
    public MilkshakeItem(Properties properties) {
        super(properties);
    }

    public int getUseDuration(ItemStack p_41454_) {
        return 40;
    }

    public UseAnim getUseAnimation(ItemStack p_41452_) {
        return UseAnim.DRINK;
    }

    public SoundEvent getDrinkingSound() {
        return SoundEvents.HONEY_DRINK;
    }

    public SoundEvent getEatingSound() {
        return SoundEvents.HONEY_DRINK;
    }

    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return true;
    }

    public ItemStack getCraftingRemainingItem(ItemStack itemStack) {
        return new ItemStack(Items.GLASS_BOTTLE);
    }

    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        super.finishUsingItem(stack, level, entity);
        if (entity instanceof ServerPlayer serverPlayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, stack);
            serverPlayer.awardStat(Stats.ITEM_USED.get(this));
        } if (stack.isEmpty()) {
            return new ItemStack(Items.GLASS_BOTTLE);
        } else {
            Player player = (Player)entity;
            if (entity instanceof Player && !(player).getAbilities().instabuild) {
                ItemStack bottle = new ItemStack(Items.GLASS_BOTTLE);
                if (!player.getInventory().add(bottle)) {
                    player.drop(bottle, false);
                }
            }
            return stack;
        }
    }
}
