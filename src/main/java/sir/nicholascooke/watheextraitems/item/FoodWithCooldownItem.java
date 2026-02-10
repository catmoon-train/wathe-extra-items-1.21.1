package sir.nicholascooke.watheextraitems.item;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class FoodWithCooldownItem extends ToolTip {

    private final int cooldownTicks;

    public FoodWithCooldownItem(Settings settings, int cooldownSeconds, String shortTooltipKey, String detailedTooltipKey) {
        super(settings, shortTooltipKey, detailedTooltipKey);
        this.cooldownTicks = cooldownSeconds * 20;
    }

    public ItemStack finishUsing(ItemStack stack, World world, PlayerEntity user) {
        ItemStack result = super.finishUsing(stack, world, user);
        user.getItemCooldownManager().set(this, cooldownTicks);
        return result;
    }
}
