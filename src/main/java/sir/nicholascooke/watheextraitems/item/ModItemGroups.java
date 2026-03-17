package sir.nicholascooke.watheextraitems.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import sir.nicholascooke.watheextraitems.WatheExtraItems;

public class ModItemGroups {


    public static final ItemGroup EXTRA_MISC = regItemGroup(
            "extraitems_misc",
            Text.translatable("itemGroup.watheextramisc"),
            ModItems.RADIO,
            ModItems.RADIO,
            ModItems.POCKET_WATCH

    );

    public static final ItemGroup EXTRA_BOOKS = regItemGroup(
            "extraitems_books",
            Text.translatable("itemGroup.watheextrabooks"),
            ModItems.ASIS,
            ModItems.ASIS,
            ModItems.TM,
            ModItems.TMOTL,
            ModItems.TMOTYR,
            ModItems.TMRM,
            ModItems.TRHM
    );

    public static final ItemGroup EXTRA_CONSUMABLES = regItemGroup(
            "extraitems_consumables",
            Text.translatable("itemGroup.watheextraconsumables"),
            ModItems.CHARGE_DUST,
            ModItems.CIGAR,
            ModItems.CIGARETTE,
            ModItems.COAL_COKE,
            ModItems.FLOW_DUST,
            ModItems.CHARGE_DUST
    );


    private static ItemGroup regItemGroup(
            String name,
            Text displayName,
            Item icon,
            Item... items
    ) {
        return Registry.register(
                Registries.ITEM_GROUP,
                Identifier.of(WatheExtraItems.MOD_ID, name),
                FabricItemGroup.builder()
                        .displayName(displayName)
                        .icon(() -> new ItemStack(icon))
                        .entries((context, entries) -> {
                            for (Item item : items) {
                                entries.add(item);
                            }
                        })
                        .build()
        );
    }


    public static void regItemGroups() {
        WatheExtraItems.LOGGER.info("Registering item groups for " + WatheExtraItems.MOD_ID);
    }
}
