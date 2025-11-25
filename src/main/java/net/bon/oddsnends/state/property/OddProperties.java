package net.bon.oddsnends.state.property;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class OddProperties {
    public static final BooleanProperty SHEARED = BooleanProperty.create("sheared");
    public static final BooleanProperty SUBMERGED = BooleanProperty.create("submerged");
    public static final BooleanProperty POLLINATED = BooleanProperty.create("pollinated");
    public static final IntegerProperty SLICES = IntegerProperty.create("slices", 1, 4);
    public static final BooleanProperty MELTED = BooleanProperty.create("melted");
}
