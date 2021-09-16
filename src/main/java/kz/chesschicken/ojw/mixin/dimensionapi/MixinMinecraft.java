package kz.chesschicken.ojw.mixin.dimensionapi;

import kz.chesschicken.ojw.utils.dimensionapi.event.EventRegisterExtendedDimension;
import net.minecraft.client.Minecraft;
import net.modificationstation.stationapi.api.StationAPI;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MixinMinecraft {
    @Inject(method = "init", at = @At("TAIL"))
    private void call1(CallbackInfo ci) {
        StationAPI.EVENT_BUS.post(new EventRegisterExtendedDimension());
    }
}
