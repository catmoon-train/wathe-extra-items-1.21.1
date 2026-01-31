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
                    "A slow burn, meant to be savoured.",
                    "Chachi Grayland"
            )
    );

    public static final Item CIGARETTE = regItem(
            "cigarette",
            new ConsumableCigarItem(
                    new Item.Settings().maxDamage(3),
                    "Cheap but effective nicotine.",
                    "This stuff tastes bad."
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
            "It's Literally Just Coal Coke.",
            "Slime? Why are you eating this?"
    ));

    public static final Item FLOW_DUST = regItem("flow_dust", new ToolTip(
            new Item.Settings().maxCount(1).food(new FoodComponent.Builder()
                    .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200, 1, false, false), 1.0f)
                    .alwaysEdible()
                    .build()),
            "Suspicious Dust.",
            "Hmm Seems Addictive."
    ));


    public static final  Item CHARGE_DUST = regItem("charge_dust", new ToolTip(
            new Item.Settings().maxCount(1).food(new FoodComponent.Builder()
                            .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 400, 1, false, false), 1.0f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 400, 3, false, false), 1.0f)
                            .alwaysEdible()
                    .build()),
            "Strange Stuff.",
            "Tastes Spicy."
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
            "How is this here?",
            "Written By Agatha Christie in APRIL 1923"
    ));
    public static final Item TRHM = regItem("trhm", new ToolTip(
            new Item.Settings().maxCount(1),
            "Is This An Omen?",
            "Written By Alan Alexander Milne"
    ));
    public static final Item ASIS = regItem("asis", new ToolTip(
            new Item.Settings().maxCount(1),
            "A Detective En Route",
            "Written by Sir Arthur Conan Doyle"
    ));
    public static final Item TMRM = regItem("tmrm", new ToolTip(
            new Item.Settings().maxCount(1),
            "Brutal but Brief",
            "Written By Edgar Allan Poe"
    ));
    public static final Item TM = regItem("tm", new ToolTip(
            new Item.Settings().maxCount(1),
            "A Tale of Redemption",
            "Written By Wilkie Collins"
    ));
    public static final Item TMOTYR = regItem("tmotyr", new ToolTip(
            new Item.Settings().maxCount(1),
            "A Perfect Crime in Plain Sight.",
            "Written By Gaston Leroux"
    ));

    private static Item regItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(WatheExtraItems.MOD_ID, name), item);
    }

    public static void regModItems() {
        WatheExtraItems.LOGGER.info("Reg Mod Items for " + WatheExtraItems.MOD_ID);

    }
}