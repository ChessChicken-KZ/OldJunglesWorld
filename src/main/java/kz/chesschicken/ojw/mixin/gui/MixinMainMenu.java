package kz.chesschicken.ojw.mixin.gui;

import kz.chesschicken.ojw.init.OJWContentListener;
import net.minecraft.client.gui.screen.ScreenBase;
import net.minecraft.client.gui.screen.menu.MainMenu;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.awt.*;

@Mixin(MainMenu.class)
public class MixinMainMenu extends ScreenBase {
    @ModifyArg(method = "render", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/gui/screen/menu/MainMenu;drawTextWithShadow(Lnet/minecraft/client/render/TextRenderer;Ljava/lang/String;III)V"
    ), index = 4)
    private int getColor(int i)
    {
        if(i == 5263440)
            return Color.WHITE.getRGB();
        return i;
    }

    @Inject(method = "render", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/gui/screen/ScreenBase;render(IIF)V",
            shift = At.Shift.BEFORE
    ))
    private void renderVersionString(int mouseX, int mouseY, float delta, CallbackInfo ci)
    {
        this.drawTextWithShadow(this.textManager, "OldJunglesWorld " + OJWContentListener.modID.getVersion().getFriendlyString(), 2, this.height - 10, Color.WHITE.getRGB());
    }
}
