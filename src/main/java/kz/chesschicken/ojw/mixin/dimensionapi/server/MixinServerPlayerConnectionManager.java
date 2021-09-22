package kz.chesschicken.ojw.mixin.dimensionapi.server;

import kz.chesschicken.ojw.utils.dimensionapi.DimensionAPI;
import kz.chesschicken.ojw.utils.dimensionapi.ExtendedDimension;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.ServerPlayerConnectionManager;
import net.minecraft.server.ServerPlayerView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.HashMap;
import java.util.Map;

@Mixin(ServerPlayerConnectionManager.class)
public class MixinServerPlayerConnectionManager {

    @Unique
    private Map<Integer, ServerPlayerView> EYES;

    @Inject(method = "<init>", at = @At("TAIL"))
    private void injectLoadNewPlayerViewList(MinecraftServer server, CallbackInfo ci) {
        EYES = new HashMap<>(DimensionAPI.DIMENSION_MAP.size());

        int distance = server.serverProperties.getInteger("view-distance", 10);

        for(ExtendedDimension dim : DimensionAPI.DIMENSION_MAP.values()) {
            EYES.put(dim.getDimensionID(), new ServerPlayerView(server, dim.getDimensionID(), distance));
        }

    }

    @Inject(method = "getViewRadiusInTiles", at = @At("HEAD"), cancellable = true)
    private void injectSendRadius(CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(EYES.get(0).getViewRadiusInTiles());
        cir.cancel();
    }

    @Inject(method = "getPlayerView", at = @At("HEAD"), cancellable = true)
    private void injectSendEye(int dimension, CallbackInfoReturnable<ServerPlayerView> cir) {
        cir.setReturnValue(EYES.get(dimension));
        cir.cancel();
    }

    @Inject(method = "method_565", at = @At("HEAD"), cancellable = true)
    private void injectAllEyes(CallbackInfo ci) {
        for (ServerPlayerView eye : EYES.values())
            eye.method_1747();
        ci.cancel();
    }
}
