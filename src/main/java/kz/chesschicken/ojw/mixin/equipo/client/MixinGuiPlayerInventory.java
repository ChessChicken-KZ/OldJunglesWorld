package kz.chesschicken.ojw.mixin.equipo.client;

import net.minecraft.client.gui.screen.container.ContainerBase;
import net.minecraft.client.gui.screen.container.PlayerInventory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerInventory.class)
public abstract class MixinGuiPlayerInventory extends ContainerBase {
    public MixinGuiPlayerInventory(net.minecraft.container.ContainerBase container) {
        super(container);
    }

    @Inject(method = "renderContainerBackground", at = @At("TAIL"))
    private void renderJewelryMenu(float f, CallbackInfo ci)
    {
        this.minecraft.textureManager.bindTexture(this.minecraft.textureManager.getTextureId("/assets/ojw/textures/gui/jewelry_menu.png"));
        int width1 = (this.width - this.containerWidth) / 2 - 31;
        int height1 = (this.height - this.containerHeight) / 2 + 4;
        this.blit(width1, height1, 0, 0, 32, this.containerHeight);
    }


}
