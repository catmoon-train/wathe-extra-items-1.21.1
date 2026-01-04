package sir.nicholascooke.watheextraitems.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ConsumableCigarItem extends Item {

    private static final int COOLDOWN_TICKS = 75;

    public ConsumableCigarItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        if (user.getItemCooldownManager().isCoolingDown(this)) {
            return TypedActionResult.fail(itemStack);
        }

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
                    4,
                    0.08,
                    0.08,
                    0.08,
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
}
