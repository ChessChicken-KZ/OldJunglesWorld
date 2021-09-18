package kz.chesschicken.ojw.mixin.metalight;

import kz.chesschicken.ojw.utils.extendedblocks.CustomLightEmittancePerMeta;
import net.minecraft.block.BlockBase;
import net.minecraft.level.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockBase.class)
public abstract class MixinBlockBaseMetaL {
    @Inject(method = "getBrightness", at = @At("HEAD"), cancellable = true)
    private void injectMetaBrightness(BlockView tileView, int x, int y, int z, CallbackInfoReturnable<Float> cir) {
        if(this instanceof CustomLightEmittancePerMeta) {
            cir.setReturnValue(tileView.method_1784(x, y, z, (int)(15.0F * ((CustomLightEmittancePerMeta)this).getLightValue(tileView.getTileMeta(x, y, z)))));
            cir.cancel();
        }
    }
}
