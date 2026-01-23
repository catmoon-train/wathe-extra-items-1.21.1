package sir.nicholascooke.watheextraitems;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationAxis;
import sir.nicholascooke.watheextraitems.block.ModBlocks;
import sir.nicholascooke.watheextraitems.block.RadioBlock;

import java.util.Objects;

public class WatheExtraItemsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        WorldRenderEvents.BLOCK_OUTLINE.register((ctx, outline) -> {
            BlockState state = outline.blockState();
            if (!state.isOf(ModBlocks.RADIO)) return true;

            MatrixStack matrices = ctx.matrixStack();
            if (matrices == null) return true;

            BlockPos pos = outline.blockPos();
            VertexConsumer vc = Objects.requireNonNull(ctx.consumers())
                    .getBuffer(RenderLayer.getLines());

            matrices.push();
            matrices.translate(
                    pos.getX() - outline.cameraX(),
                    pos.getY() - outline.cameraY(),
                    pos.getZ() - outline.cameraZ()
            );

            // rotate to match block facing
            Direction facing = state.get(RadioBlock.FACING);
            float yRot = switch (facing) {
                case WEST -> 90f;
                case NORTH -> 0f;
                case EAST -> 270f;
                default -> 180f;
            };

            matrices.translate(0.5, 0.0, 0.5);
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(yRot));
            matrices.translate(-0.5, 0.0, -0.5);

            // ======================
            // RADIO BASE (from model)
            // from [0.5, 0.5, 2.5] to [15.5, 8, 13.5]
            // ======================
            WorldRenderer.drawBox(
                    matrices, vc,
                    0.5 / 16.0, 0.0 / 16.0, 2.5 / 16.0,
                    15.5 / 16.0, 8.0 / 16.0, 13.5 / 16.0,
                    0f, 0f, 0f, 0.4f
            );

            // ======================
            // ANTENNA STACK (exact model steps)
            // ======================

            draw(matrices, vc, 11, 8, 7.5, 13, 9, 8.5);
            draw(matrices, vc, 10, 9, 7.5, 12, 10, 8.5);
            draw(matrices, vc, 9.5, 10, 7.5, 11, 11, 8.5);
            draw(matrices, vc, 8, 11, 7.5, 10, 12, 8.5);
            draw(matrices, vc, 7, 12, 7.5, 9, 13, 8.5);

            matrices.pop();
            return false;
        });
    }

    private static void draw(
            MatrixStack matrices,
            VertexConsumer vc,
            double x1, double y1, double z1,
            double x2, double y2, double z2
    ) {
        WorldRenderer.drawBox(
                matrices, vc,
                x1 / 16.0, y1 / 16.0, z1 / 16.0,
                x2 / 16.0, y2 / 16.0, z2 / 16.0,
                0f, 0f, 0f, 0.4f
        );
    }
}
