package sir.nicholascooke.watheextraitems.item;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import java.util.List;

public class ToolTip extends Item {
    private final String shortTooltip;
    private final String detailedTooltip;

    public ToolTip(Settings settings, String shortTooltip, String detailedTooltip) {
        super(settings);
        this.shortTooltip = shortTooltip;
        this.detailedTooltip = detailedTooltip;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal(shortTooltip).formatted(Formatting.GRAY, Formatting.ITALIC));

        if (Screen.hasShiftDown()) {
            tooltip.add(Text.literal(detailedTooltip).formatted(Formatting.DARK_GRAY, Formatting.ITALIC));
        } else {
            tooltip.add(Text.literal("Hold ")
                    .append(Text.literal("Shift").formatted(Formatting.YELLOW))
                    .append(Text.literal(" for more info."))
                    .formatted(Formatting.DARK_GRAY));
        }
    }
}
