package kz.chesschicken.ojw.mixin;

import kz.chesschicken.ojw.utils.BlockLightRequest;
import kz.chesschicken.ojw.utils.IHighGamma;
import net.minecraft.block.BlockBase;
import net.minecraft.client.render.block.BlockRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockRenderer.class)
public class MixinBlockRenderer {
    /*
     Doing some tricks, as NFC had, might be.
     */
    @Inject(method = "render", at = @At("HEAD"))
    private void injectRenderGammaStart(BlockBase block, int blockX, int blockY, int blockZ, CallbackInfoReturnable<Boolean> cir) {
        if(block instanceof IHighGamma) {
            BlockLightRequest.isGammaCurrent = true;
        }
    }

    @Inject(method = "render", at = @At("TAIL"))
    private void injectRenderGammaEnd(BlockBase block, int blockX, int blockY, int blockZ, CallbackInfoReturnable<Boolean> cir) {
        if(block instanceof IHighGamma) {
            BlockLightRequest.isGammaCurrent = false;
        }
    }
}
