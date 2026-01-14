package sir.nicholascooke.watheextraitems.item;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.component.type.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import sir.nicholascooke.watheextraitems.WatheExtraItems;
import net.minecraft.item.BlockItem;
import sir.nicholascooke.watheextraitems.block.ModBlocks;
import dev.doctor4t.wathe.item.CocktailItem;


public class ModItems {
    public static final Item CIGAR = regItem(
            "cigar",
            new ConsumableCigarItem(
                    new Item.Settings()
                            .maxDamage(6)
            )
    );
    public static final Item HIGHBALL = regItem("highball",
            new CocktailItem(new Item.Settings().maxCount(1).food(FoodComponents.HONEY_BOTTLE)));

    public static final Item RADIO = Registry.register(
            Registries.ITEM,
            Identifier.of(WatheExtraItems.MOD_ID, "radio"),
            new BlockItem(ModBlocks.RADIO, new Item.Settings())
    );

    public static final Item TMOTL = regItem("tmotl", new Item(new Item.Settings()
            .maxCount(1)

    ));

    public static final Item TRHM = regItem("trhm", new Item(new Item.Settings()
            .maxCount(1)

    ));


    private static Item regItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(WatheExtraItems.MOD_ID, name), item);
    }

    public static void regModItems() {
        WatheExtraItems.LOGGER.info("Reg Mod Items for " + WatheExtraItems.MOD_ID);

    }
}