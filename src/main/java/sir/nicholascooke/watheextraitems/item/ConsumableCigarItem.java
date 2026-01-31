package sir.nicholascooke.watheextraitems.item;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class ConsumableCigarItem extends Item {

    private static final int COOLDOWN_TICKS = 75;

    private final String shortTooltipKey;
    private final String detailedTooltipKey;

    public ConsumableCigarItem(Settings settings, String shortTooltipKey, String detailedTooltipKey) {
        super(settings);
        this.shortTooltipKey = shortTooltipKey;
        this.detailedTooltipKey = detailedTooltipKey;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (user.getItemCooldownManager().isCoolingDown(this)) {
            return TypedActionResult.fail(user.getStackInHand(hand));
        }

        ItemStack itemStack = user.getStackInHand(hand);

        if (!world.isClient && world instanceof ServerWorld serverWorld) {

            serverWorld.playSound(
                    null,
                    user.getBlockPos(),
                    SoundEvents.BLOCK_FIRE_AMBIENT,
                    SoundCategory.PLAYERS,
                    0.6f,
                    1.0f
            );

            Vec3d look = user.getRotationVec(1.0F);

            double smokeX = user.getX() + look.x * 0.4;
            double smokeY = user.getY() + user.getStandingEyeHeight() - 0.15;
            double smokeZ = user.getZ() + look.z * 0.4;

            serverWorld.spawnParticles(
                    ParticleTypes.CAMPFIRE_COSY_SMOKE,
                    smokeX,
                    smokeY,
                    smokeZ,
                    5,
                    0.002,
                    0.1,
                    0.002,
                    0.002
            );

            int newDamage = itemStack.getDamage() + 1;

            if (newDamage >= itemStack.getMaxDamage()) {
                user.setStackInHand(hand, ItemStack.EMPTY);
            } else {
                itemStack.setDamage(newDamage);
                user.getItemCooldownManager().set(this, COOLDOWN_TICKS);
            }
        }

        return TypedActionResult.success(itemStack, world.isClient());
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable(shortTooltipKey)
                .formatted(Formatting.GRAY, Formatting.ITALIC));

        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable(detailedTooltipKey)
                    .formatted(Formatting.DARK_GRAY, Formatting.ITALIC));
        } else {
            tooltip.add(Text.translatable("tooltip.watheextraitems.hold_shift_for_more")
                    .formatted(Formatting.DARK_GRAY));
        }
    }
}



