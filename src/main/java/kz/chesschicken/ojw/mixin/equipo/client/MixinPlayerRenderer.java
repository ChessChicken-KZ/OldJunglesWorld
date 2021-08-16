package kz.chesschicken.ojw.mixin.equipo.client;

import kz.chesschicken.ojw.utils.equipo.IJewelry;
import kz.chesschicken.ojw.utils.equipo.IJewelryInventory;
import net.minecraft.client.render.entity.PlayerRenderer;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemInstance;
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
        ItemInstance[] jewelry = ((IJewelryInventory)arg.inventory).getJewelryInventory();
        for(ItemInstance item : jewelry)
        {
            if(item != null && item.getType() != null && item.getType() instanceof IJewelry)
            {
                ((IJewelry)item.getType()).renderJewelry(arg, d, d1, d2, f, f1);
            }
        }
    }

}
