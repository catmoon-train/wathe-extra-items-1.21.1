package sir.nicholascooke.watheextraitems.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import sir.nicholascooke.watheextraitems.WatheExtraItems;

public class ModItemGroups {

    public static final ItemGroup WATHE_EXTRA_ITEMS = Registry.register(
            Registries.ITEM_GROUP,
            Identifier.of(WatheExtraItems.MOD_ID, "watheextraitems"),
            FabricItemGroup.builder()
                    .displayName(Text.translatable("itemGroup.watheextraitems"))
                    .icon(() -> new ItemStack(ModItems.CIGAR)) // tab icon
                    .entries((context, entries) -> {
                        entries.add(ModItems.CIGAR);
                        entries.add(ModItems.RADIO);
                    })
                    .build()
    );

    public static final ItemGroup EXTRA_BOOKS = Registry.register(
            Registries.ITEM_GROUP,
            Identifier.of(WatheExtraItems.MOD_ID, "extra_books"),
            FabricItemGroup.builder()
                    .displayName(Text.translatable("itemGroup.watheextrabooks"))
                    .icon(() -> new ItemStack(ModItems.TMOTL))
                    .entries((context, entries) -> {
                        entries.add(ModItems.TMOTL);
                        entries.add(ModItems.TRHM);
                    })
                    .build()
    );

    public static final ItemGroup EXTRA_CONSUMABLES = Registry.register(
            Registries.ITEM_GROUP,
            Identifier.of(WatheExtraItems.MOD_ID, "extra_consumables"),
            FabricItemGroup.builder()
                    .displayName(Text.translatable("itemGroup.watheextraconsumables"))
                    .icon(() -> new ItemStack(ModItems.HIGHBALL))
                    .entries((context, entries) -> {
                        entries.add(ModItems.HIGHBALL);
                    })
                    .build()

    );




    public static void registerItemGroups() {
        WatheExtraItems.LOGGER.info("Registering item groups for " + WatheExtraItems.MOD_ID);
    }
}
