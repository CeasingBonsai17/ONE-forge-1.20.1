package net.bon.oddsnends;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;


@Mod.EventBusSubscriber(modid = OddsNEnds.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class OddConfig
{
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    private static final ForgeConfigSpec.BooleanValue ITEM_EFFECT_TOOLTIPS = BUILDER
            .comment("Whether to show the tooltip for effects on some odd items")
            .define("itemEffectTooltips", true);
    private static final ForgeConfigSpec.BooleanValue CIDERINE_REQUIRE_POLLINATION_TO_GROW = BUILDER
            .comment("Whether Ciderine Blossoms need to be pollinated by bees/bats before they can grow")
            .define("ciderineRequirePollinationToGrow", true);
    private static final ForgeConfigSpec.BooleanValue CIDERINE_CROP_XZ_RANDOMIZATION = BUILDER
            .comment("Whether Ciderine Crops have random positioning on the block they're on")
            .define("ciderineCropXZRandomization", true);
    private static final ForgeConfigSpec.BooleanValue CLICK_HARVEST_CIDERINES = BUILDER
            .comment("Whether you can click Ciderines to harvest them")
            .define("clickHarvestCiderines", true);
    private static final ForgeConfigSpec.BooleanValue CLICK_HARVEST_MANDRAKES = BUILDER
            .comment("Whether you can click Mandrakes to harvest them")
            .define("clickHarvestMandrakes", true);

//    private static final ForgeConfigSpec.IntValue MAGIC_NUMBER = BUILDER
//            .comment("A magic number")
//            .defineInRange("magicNumber", 42, 0, Integer.MAX_VALUE);
//
//    public static final ForgeConfigSpec.ConfigValue<String> MAGIC_NUMBER_INTRODUCTION = BUILDER
//            .comment("What you want the introduction message to be for the magic number")
//            .define("magicNumberIntroduction", "The magic number is... ");
//
//    // a list of strings that are treated as resource locations for items
//    private static final ForgeConfigSpec.ConfigValue<List<? extends String>> ITEM_STRINGS = BUILDER
//            .comment("A list of items to log on common setup.")
//            .defineListAllowEmpty("items", List.of("minecraft:iron_ingot"), Config::validateItemName);

    static final ForgeConfigSpec SPEC = BUILDER.build();

    public static boolean itemEffectTooltips;
    public static boolean ciderineRequirePollinationToGrow;
    public static boolean ciderineCropXZRandomization;
    public static boolean clickHarvestCiderines;
    public static boolean clickHarvestMandrakes;
//    public static int magicNumber;
//    public static String magicNumberIntroduction;
//    public static Set<Item> items;
//
//    private static boolean validateItemName(final Object obj)
//    {
//        return obj instanceof final String itemName && ForgeRegistries.ITEMS.containsKey(new ResourceLocation(itemName));
//    }

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        itemEffectTooltips = ITEM_EFFECT_TOOLTIPS.get();
        ciderineRequirePollinationToGrow = CIDERINE_REQUIRE_POLLINATION_TO_GROW.get();
        ciderineCropXZRandomization = CIDERINE_CROP_XZ_RANDOMIZATION.get();
        clickHarvestCiderines = CLICK_HARVEST_CIDERINES.get();
        clickHarvestMandrakes = CLICK_HARVEST_MANDRAKES.get();
//        magicNumber = MAGIC_NUMBER.get();
//        magicNumberIntroduction = MAGIC_NUMBER_INTRODUCTION.get();

        // convert the list of strings into a set of items
//        items = ITEM_STRINGS.get().stream()
//                .map(itemName -> ForgeRegistries.ITEMS.getValue(new ResourceLocation(itemName)))
//                .collect(Collectors.toSet());
    }
}
