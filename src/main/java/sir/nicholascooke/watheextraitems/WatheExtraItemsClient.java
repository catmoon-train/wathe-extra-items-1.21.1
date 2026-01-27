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

            VertexConsumer vc = Objects
                    .requireNonNull(ctx.consumers())
                    .getBuffer(RenderLayer.getLines());

            BlockPos pos = outline.blockPos();

            matrices.push();
            matrices.translate(
                    pos.getX() - outline.cameraX(),
                    pos.getY() - outline.cameraY(),
                    pos.getZ() - outline.cameraZ()
            );

            Direction facing = state.get(RadioBlock.FACING);
            float yRot = switch (facing) {
                case NORTH -> 0f;
                case EAST  -> 270f;
                case SOUTH -> 180f;
                case WEST  -> 90f;
                default    -> 0f;
            };

            matrices.translate(0.5, 0, 0.5);
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(yRot));
            matrices.translate(-0.5, 0, -0.5);

            // ==== RADIO BASE ====
            drawBox(matrices, vc,
                    0.5, 0.5, 2.5,
                    15.5, 8.0, 12.5
            );

            // ==== TOP PLATE ====
            drawBox(matrices, vc,
                    1.0, 8.0, 3.0,
                    15.0, 8.5, 12.0
            );

            // ==== KNOBS ====
            drawBox(matrices, vc,
                    7.5, 1.5, 2.0,
                    9.0, 3.0, 3.0
            );

            drawBox(matrices, vc,
                    2.0, 1.5, 2.0,
                    3.5, 3.0, 3.0
            );

            // ==== ANTENNA STACK ====
            drawBox(matrices, vc,
                    11.0, 8.0, 7.5,
                    13.0, 9.0, 8.5
            );
            drawBox(matrices, vc,
                    10.0, 9.0, 7.5,
                    12.0, 10.0, 8.5
            );
            drawBox(matrices, vc,
                    9.5, 10.0, 7.5,
                    11.0, 11.0, 8.5
            );
            drawBox(matrices, vc,
                    8.0, 11.0, 7.5,
                    10.0, 12.0, 8.5
            );
            drawBox(matrices, vc,
                    7.0, 12.0, 7.5,
                    9.0, 13.0, 8.5
            );

            matrices.pop();
            return false;
        });
    }

    private static void drawBox(
            MatrixStack matrices,
            VertexConsumer vc,
            double x1, double y1, double z1,
            double x2, double y2, double z2
    ) {
        WorldRenderer.drawBox(
                matrices,
                vc,
                x1 / 16.0, y1 / 16.0, z1 / 16.0,
                x2 / 16.0, y2 / 16.0, z2 / 16.0,
                0f, 0f, 0f, 0.4f
        );
    }
}
