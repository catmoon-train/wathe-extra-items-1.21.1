package sir.nicholascooke.watheextraitems.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import sir.nicholascooke.watheextraitems.WatheExtraItems;

public class ModItems {
    public static final Item CIGAR = regItem("cigar",
            new ConsumableCigarItem(new Item.Settings()
                    .food(
                            new FoodComponent.Builder()
                                    .nutrition(0)
                                    .saturationModifier(0f)
                                    .alwaysEdible()
                                    .build()
                    )
            ));


    private static Item regItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(WatheExtraItems.MOD_ID, name), item);
    }


    public static void regModItems() {
        WatheExtraItems.LOGGER.info("Reg Mod Items for " + WatheExtraItems.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
           entries.add(CIGAR);
        });
    }
}