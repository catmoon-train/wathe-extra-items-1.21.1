package sir.nicholascooke.watheextraitems.item;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import java.util.List;

public class ToolTip extends Item {
    private final String shortTooltipKey;
    private final String detailedTooltipKey;

    public ToolTip(Settings settings, String shortTooltipKey, String detailedTooltipKey) {
        super(settings);
        this.shortTooltipKey = shortTooltipKey;
        this.detailedTooltipKey = detailedTooltipKey;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable(shortTooltipKey).formatted(Formatting.GRAY, Formatting.ITALIC));

        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable(detailedTooltipKey).formatted(Formatting.DARK_GRAY, Formatting.ITALIC));
        } else {
            tooltip.add(Text.translatable("tooltip.watheextraitems.hold_shift_for_more")
                    .formatted(Formatting.DARK_GRAY));
        }
    }
}
