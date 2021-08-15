package kz.chesschicken.ojw.mixin.equipo.client;

import net.minecraft.client.render.entity.PlayerRenderer;
import net.minecraft.entity.player.PlayerBase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerRenderer.class)
public class MixinPlayerRenderer {
    @Inject(method = "render(Lnet/minecraft/entity/player/PlayerBase;DDDFF)V", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/render/entity/LivingEntityRenderer;render(Lnet/minecraft/entity/Living;DDDFF)V",
            shift = At.Shift.AFTER
    ))
    private void renderJewelry(PlayerBase arg, double d, double d1, double d2, float f, float f1, CallbackInfo ci)
    {
        //TODO: Wait till StAPI releases custom item model rendering.
    }

}
