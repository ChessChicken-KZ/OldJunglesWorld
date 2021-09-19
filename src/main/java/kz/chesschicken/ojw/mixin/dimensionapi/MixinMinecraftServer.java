package kz.chesschicken.ojw.mixin.dimensionapi;

import kz.chesschicken.ojw.utils.dimensionapi.event.EventRegisterExtendedDimension;
import net.minecraft.server.MinecraftServer;
import net.modificationstation.stationapi.api.StationAPI;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MinecraftServer.class)
public class MixinMinecraftServer {
    @Inject(method = "start", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/server/ServerProperties;getInteger(Ljava/lang/String;I)I",
            shift = At.Shift.AFTER
    ))
    private void postEventRegisterDimensions(CallbackInfoReturnable<Boolean> cir) {
        StationAPI.EVENT_BUS.post(new EventRegisterExtendedDimension());
    }
}
