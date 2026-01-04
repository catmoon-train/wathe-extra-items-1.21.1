package sir.nicholascooke.watheextraitems.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import sir.nicholascooke.watheextraitems.WatheExtraItems;

public class ModItems {
    public static final Item CIGAR = regItem(
            "cigar",
            new ConsumableCigarItem(
                    new Item.Settings()
                            .maxDamage(6)
            )
    );

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