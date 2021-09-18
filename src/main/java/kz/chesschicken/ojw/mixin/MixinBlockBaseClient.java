package kz.chesschicken.ojw.mixin;

import kz.chesschicken.ojw.utils.extendedblocks.CustomBoundingBoxPerMeta;
import net.minecraft.block.BlockBase;
import net.minecraft.level.BlockView;
import net.minecraft.level.Level;
import net.minecraft.util.maths.Box;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockBase.class)
public class MixinBlockBaseClient {

    @Inject(method = "isSideRendered", at = @At("HEAD"), cancellable = true)
    private void injectSideRendered(BlockView tileView, int x, int y, int z, int side, CallbackInfoReturnable<Boolean> cir) {
        if(this instanceof CustomBoundingBoxPerMeta) {
            float[] floats = ((CustomBoundingBoxPerMeta) this).getBoundingBoxes(tileView.getTileMeta(x, y, z));
            if (side == 0 && floats[1] > 0.0D)
                cir.setReturnValue(true);
            else if (side == 1 && floats[4] < 1.0D)
                cir.setReturnValue(true);
            else if (side == 2 && floats[2] > 0.0D)
                cir.setReturnValue(true);
            else if (side == 3 && floats[5] < 1.0D)
                cir.setReturnValue(true);
            else if (side == 4 && floats[0] > 0.0D)
                cir.setReturnValue(true);
            else if (side == 5 && floats[3] < 1.0D)
                cir.setReturnValue(true);
            else cir.setReturnValue(!tileView.isFullOpaque(x, y, z));
            cir.cancel();
        }
    }

    @Inject(method = "getOutlineShape", at = @At("HEAD"), cancellable = true)
    private void injectOutlineShape(Level level, int x, int y, int z, CallbackInfoReturnable<Box> cir) {
        if(this instanceof CustomBoundingBoxPerMeta) {
            float[] floats = ((CustomBoundingBoxPerMeta) this).getBoundingBoxes(level.getTileMeta(x, y, z));
            cir.setReturnValue(Box.createButWasteMemory(x + floats[0], y + floats[1], z + floats[2], x + floats[3], y + floats[4], z + floats[5]));
            cir.cancel();
        }
    }

}
