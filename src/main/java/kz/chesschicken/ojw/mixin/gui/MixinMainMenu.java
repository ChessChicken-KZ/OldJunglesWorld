package kz.chesschicken.ojw.mixin.gui;

import net.minecraft.client.gui.screen.menu.MainMenu;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.awt.*;

@Mixin(MainMenu.class)
public class MixinMainMenu {
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
}
