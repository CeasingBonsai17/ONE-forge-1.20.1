package net.bon.oddsnends.sound;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;

public class OddSoundType {
    public static final SoundType QUARTZ_SAND = new SoundType(1f, 1f,
            OddSoundEvents.QUARTZ_SAND_BREAK.get(), OddSoundEvents.QUARTZ_SAND_STEP.get(), SoundEvents.SUSPICIOUS_SAND_PLACE,
            SoundEvents.SAND_HIT, SoundEvents.SAND_FALL);
    public static final SoundType SUSPICIOUS_QUARTZ_SAND = new SoundType(1f, 1f,
            SoundEvents.SUSPICIOUS_SAND_BREAK, OddSoundEvents.QUARTZ_SAND_STEP.get(), SoundEvents.SUSPICIOUS_SAND_PLACE,
            SoundEvents.SAND_HIT, SoundEvents.SAND_FALL);
}
