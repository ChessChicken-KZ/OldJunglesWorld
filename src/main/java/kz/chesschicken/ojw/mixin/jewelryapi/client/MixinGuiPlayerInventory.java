package kz.chesschicken.ojw.mixin.jewelryapi.client;

import net.minecraft.client.gui.screen.container.ContainerBase;
import net.minecraft.client.gui.screen.container.PlayerInventory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(PlayerInventory.class)
public abstract class MixinGuiPlayerInventory extends ContainerBase {
    public MixinGuiPlayerInventory(net.minecraft.container.ContainerBase container) {
        super(container);
    }

    @ModifyVariable(method = "renderContainerBackground", at = @At("STORE"), ordinal = 0)
    private int getNewTexture1(int i)
    {
        return this.minecraft.textureManager.getTextureId("/assets/ojw/textures/gui/inventory_new.png");
    }

    @ModifyArg(method = "renderForeground", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/render/TextRenderer;drawText(Ljava/lang/String;III)V"
    ), index = 0)
    private String cleanText1(String s)
    {
        return "";
    }


}
