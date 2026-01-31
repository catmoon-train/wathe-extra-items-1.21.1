package sir.nicholascooke.watheextraitems.item;
import dev.doctor4t.trainmurdermystery.item.CocktailItem;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.component.type.FoodComponents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import sir.nicholascooke.watheextraitems.WatheExtraItems;
import net.minecraft.item.BlockItem;
import sir.nicholascooke.watheextraitems.block.ModBlocks;



public class ModItems {
    public static final Item CIGAR = regItem(
            "cigar",
            new ConsumableCigarItem(
                    new Item.Settings().maxDamage(6),
                    "tooltip.watheextraitems.cigar.short",
                    "tooltip.watheextraitems.cigar.detailed"
            )
    );

    public static final Item CIGARETTE = regItem(
            "cigarette",
            new ConsumableCigarItem(
                    new Item.Settings().maxDamage(3),
                    "tooltip.watheextraitems.cigarette.short",
                    "tooltip.watheextraitems.cigarette.detailed"
            )
    );


    public static final Item HIGHBALL = regItem("highball",
            new CocktailItem(new Item.Settings().maxCount(1).food(FoodComponents.HONEY_BOTTLE)));

    public static final Item COAL_COKE = regItem("coal_coke", new ToolTip(
            new Item.Settings().maxCount(1).food(new FoodComponent.Builder()
                    .statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 400, 10, false, false), 1.0f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 400, 10, false, false),1.0f)
                    .alwaysEdible()
                    .build()),
            "tooltip.watheextraitems.coal_coke.short",
            "tooltip.watheextraitems.coal_coke.detailed"
    ));

    public static final Item FLOW_DUST = regItem("flow_dust", new ToolTip(
            new Item.Settings().maxCount(1).food(new FoodComponent.Builder()
                    .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200, 1, false, false), 1.0f)
                    .alwaysEdible()
                    .build()),
            "tooltip.watheextraitems.flow_dust.short",
            "tooltip.watheextraitems.flow_dust.detailed"
    ));


    public static final  Item CHARGE_DUST = regItem("charge_dust", new ToolTip(
            new Item.Settings().maxCount(1).food(new FoodComponent.Builder()
                            .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 400, 1, false, false), 1.0f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 400, 3, false, false), 1.0f)
                            .alwaysEdible()
                    .build()),
            "tooltip.watheextraitems.charge_dust.short",
            "tooltip.watheextraitems.charge_dust.detailed"
    ));
    public static final Item POCKET_WATCH = regItem(
            "pocket_watch",
            new PocketWatchItem(new Item.Settings().maxCount(1))
    );


    public static final Item RADIO = Registry.register(
            Registries.ITEM,
            Identifier.of(WatheExtraItems.MOD_ID, "radio"),
            new BlockItem(ModBlocks.RADIO, new Item.Settings())
    );

    public static final Item TMOTL = regItem("tmotl", new ToolTip(
            new Item.Settings().maxCount(1),
            "tooltip.watheextraitems.tmotl.short",
            "tooltip.watheextraitems.tmotl.detailed"
    ));
    public static final Item TRHM = regItem("trhm", new ToolTip(
            new Item.Settings().maxCount(1),
            "tooltip.watheextraitems.trhm.short",
            "tooltip.watheextraitems.trhm.detailed"
    ));
    public static final Item ASIS = regItem("asis", new ToolTip(
            new Item.Settings().maxCount(1),
            "tooltip.watheextraitems.asis.short",
            "tooltip.watheextraitems.asis.detailed"
    ));
    public static final Item TMRM = regItem("tmrm", new ToolTip(
            new Item.Settings().maxCount(1),
            "tooltip.watheextraitems.tmrm.short",
            "tooltip.watheextraitems.tmrm.detailed"
    ));
    public static final Item TM = regItem("tm", new ToolTip(
            new Item.Settings().maxCount(1),
            "tooltip.watheextraitems.tm.short",
            "tooltip.watheextraitems.tm.detailed"
    ));
    public static final Item TMOTYR = regItem("tmotyr", new ToolTip(
            new Item.Settings().maxCount(1),
            "tooltip.watheextraitems.tmotyr.short",
            "tooltip.watheextraitems.tmotyr.detailed"
    ));

    private static Item regItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(WatheExtraItems.MOD_ID, name), item);
    }

    public static void regModItems() {
        WatheExtraItems.LOGGER.info("Reg Mod Items for " + WatheExtraItems.MOD_ID);

    }
}