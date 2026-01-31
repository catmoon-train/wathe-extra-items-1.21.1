package sir.nicholascooke.watheextraitems.wathe;


import dev.doctor4t.trainmurdermystery.cca.GameWorldComponent;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.World;
import sir.nicholascooke.watheextraitems.item.ModItems;

import java.util.HashSet;
import java.util.Set;

public final class ExtraItemsGameHooks {

    private static final Set<RegistryKey<World>> GIVEN_THIS_ROUND = new HashSet<>();

    public static void init() {
        ServerTickEvents.END_WORLD_TICK.register(ExtraItemsGameHooks::onWorldTick);
    }

    private static void onWorldTick(ServerWorld world) {
//        GameWorldComponent game = GameWorldComponent.KEY.get(world);
//
//        if (game.getGameStatus() != GameWorldComponent.GameStatus.ACTIVE) {
//            GIVEN_THIS_ROUND.remove(world.getRegistryKey());
//            return;
//        }
//
//        if (GIVEN_THIS_ROUND.contains(world.getRegistryKey())) return;
//
//        GIVEN_THIS_ROUND.add(world.getRegistryKey());
//
//        for (ServerPlayerEntity player : world.getPlayers()) {
//            player.giveItemStack(new ItemStack(ModItems.POCKET_WATCH));
//        }
    }
}
