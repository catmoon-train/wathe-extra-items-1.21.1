package sir.nicholascooke.watheextraitems.item;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class PocketWatchItem extends Item {

    private static final DateTimeFormatter FORMAT =
            DateTimeFormatter.ofPattern("HH:mm");

    public PocketWatchItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        // CLIENT ONLY
        if (world.isClient) {
            LocalTime now = LocalTime.now();
            String time = now.format(FORMAT);

            Text message = Text.translatable(
                    "item.watheextraitems.pocket_watch.local_time",
                    time
            );

            MinecraftClient.getInstance().player.sendMessage(message, true);
        }

        return TypedActionResult.success(user.getStackInHand(hand), world.isClient);
    }
}
