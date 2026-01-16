package sir.nicholascooke.watheextraitems.block;

import net.minecraft.block.Block;
import net.minecraft.block.AbstractBlock;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import sir.nicholascooke.watheextraitems.WatheExtraItems;



public class ModBlocks {

    public static final Block RADIO = Registry.register(
            Registries.BLOCK,
            Identifier.of(WatheExtraItems.MOD_ID, "radio"),
            new RadioBlock(
                    AbstractBlock.Settings.create()
                            .strength(1.0f)
                            .nonOpaque()
            )
    );

    public static void regModBlocks() {
        WatheExtraItems.LOGGER.info("Registered blocks");
    }
}
