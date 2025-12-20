package net.bon.oddsnends.state.property;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class OddProperties {
    public static final BooleanProperty SHEARED = BooleanProperty.create("sheared");
    public static final BooleanProperty SUBMERGED = BooleanProperty.create("submerged");
    public static final BooleanProperty POLLINATED = BooleanProperty.create("pollinated");
    public static final IntegerProperty SLICES = IntegerProperty.create("slices", 1, 4);
    public static final BooleanProperty GROWING = BooleanProperty.create("growing");
    public static final IntegerProperty ROOT_STAGE = IntegerProperty.create("root_stage", 0, 3);
    public static final BooleanProperty ENTITY = BooleanProperty.create("entity");
    public static final IntegerProperty CLOVERS = IntegerProperty.create("clovers", 1, 3);
}
