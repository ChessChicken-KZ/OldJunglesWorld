package kz.chesschicken.ojw.mixin.customtextures;

import kz.chesschicken.ojw.utils.client.ICustomWeatherRender;
import net.minecraft.client.Minecraft;
import net.minecraft.sortme.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(GameRenderer.class)
public class MixinGameRenderer {
    @Shadow private Minecraft minecraft;

    @ModifyArg(method = "method_1847", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/texture/TextureManager;getTextureId(Ljava/lang/String;)I"
    ), index = 0)
    private String getNewTextures(String s)
    {
        if(s.endsWith("rain.png") && this.minecraft.level.dimension instanceof ICustomWeatherRender)
            return ((ICustomWeatherRender)this.minecraft.level.dimension).getRainTexture();
        if(s.endsWith("snow.png") && this.minecraft.level.dimension instanceof ICustomWeatherRender)
            return ((ICustomWeatherRender)this.minecraft.level.dimension).getSnowTexture();
        return s;
    }
}
