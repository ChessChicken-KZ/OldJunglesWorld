package kz.chesschicken.ojw.mixin.gui;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.screen.ScreenBase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Environment(EnvType.CLIENT)
@Mixin(ScreenBase.class)
public class MixinScreenBase extends DrawableHelper
{
    @ModifyArg(method = "renderDirtBackground", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/texture/TextureManager;getTextureId(Ljava/lang/String;)I"
    ), index = 0)
    private String getBackground(String s)
    {
        return "/assets/ojw/textures/block/melonSide.png";
    }

}