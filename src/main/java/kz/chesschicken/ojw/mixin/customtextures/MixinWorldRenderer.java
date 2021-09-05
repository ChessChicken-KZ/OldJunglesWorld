package kz.chesschicken.ojw.mixin.customtextures;

import kz.chesschicken.ojw.utils.customtextures.ICustomSkyTexture;
import net.minecraft.client.Minecraft;
import net.minecraft.client.render.WorldRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(WorldRenderer.class)
public class MixinWorldRenderer {
    @Shadow private Minecraft client;

    @ModifyArg(method = "renderSky", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/texture/TextureManager;getTextureId(Ljava/lang/String;)I"
    ), index = 0)
    private String getNewTextures(String s)
    {
        if(s.endsWith("sun.png") && this.client.level.dimension instanceof ICustomSkyTexture)
            return ((ICustomSkyTexture)this.client.level.dimension).getSunTexture();
        if(s.endsWith("moon.png") && this.client.level.dimension instanceof ICustomSkyTexture)
            return ((ICustomSkyTexture)this.client.level.dimension).getMoonTexture();
        return s;
    }
}
