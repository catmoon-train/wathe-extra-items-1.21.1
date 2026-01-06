package sir.nicholascooke.watheextraitems;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.block.BlockState;
import sir.nicholascooke.watheextraitems.block.ModBlocks;
import sir.nicholascooke.watheextraitems.block.RadioBlock;

import java.util.Objects;

public class WatheExtraItemsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        WorldRenderEvents.BLOCK_OUTLINE.register((worldRenderContext, outlineCtx) -> {
            BlockState state = outlineCtx.blockState();
            if (!state.isOf(ModBlocks.RADIO)) {
                return true;
            }

            MatrixStack matrices = worldRenderContext.matrixStack();
            if (matrices == null) return true;

            BlockPos pos = outlineCtx.blockPos();

            VertexConsumer vc = Objects.requireNonNull(worldRenderContext.consumers()).getBuffer(RenderLayer.getLines());

            double camX = outlineCtx.cameraX();
            double camY = outlineCtx.cameraY();
            double camZ = outlineCtx.cameraZ();

            matrices.push();
            matrices.translate(pos.getX() - camX, pos.getY() - camY, pos.getZ() - camZ);

            Direction facing = state.get(RadioBlock.FACING);

            float yRot;
            switch (facing) {
                case WEST  -> yRot = 90f;
                case NORTH -> yRot = 0f;
                case EAST  -> yRot = 270f;
                default    -> yRot = 180f;
            }


            matrices.translate(0.5, 0.0, 0.5);
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(yRot));
            matrices.translate(-0.5, 0.0, -0.5);


            WorldRenderer.drawBox(
                    matrices, vc,
                    3 / 16.0, 0 / 16.0, 5 / 16.0,
                    13 / 16.0, 6 / 16.0, 11 / 16.0,
                    0f, 0f, 0f, 0.4f
            );

            matrices.push();

            matrices.translate(4 / 16.0, 6 / 16.0, 7 / 16.0);
            matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-45f));
            matrices.translate(-4 / 16.0, -6 / 16.0, -7 / 16.0);

            WorldRenderer.drawBox(
                    matrices, vc,
                    4.5 / 16.0, 6 / 16.0, 7.5 / 16.0,
                    5.5 / 16.0, 11 / 16.0, 8.5 / 16.0,
                    0f, 0f, 0f, 0.4f
            );

            matrices.pop();
            matrices.pop();

            return false;
        });
    }
}
