package sir.nicholascooke.watheextraitems;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sir.nicholascooke.watheextraitems.item.ModItems;

public class WatheExtraItems implements ModInitializer {
	public static final String MOD_ID = "watheextraitems";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.regModItems();
	}
}