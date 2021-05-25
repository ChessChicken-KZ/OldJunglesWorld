package kz.chesschicken.ojw.mixin.dimapi;

import kz.chesschicken.ojw.utils.dimension.DimensionEvent;
import net.minecraft.level.dimension.Dimension;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Dimension.class)
public class MixinDimension {

    @Inject(method = "getByID", at = @At("HEAD"), cancellable = true)
    private static void changeHisOrHerLife(int id, CallbackInfoReturnable<Dimension> cir)
    {
        cir.setReturnValue(DimensionEvent.INSTANCE.getDimension(id));
        cir.cancel();
    }

}
