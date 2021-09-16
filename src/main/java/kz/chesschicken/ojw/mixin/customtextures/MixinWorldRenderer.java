package kz.chesschicken.ojw.mixin.customtextures;

import kz.chesschicken.ojw.utils.customtextures.ICustomSkyRender;
import kz.chesschicken.ojw.utils.customtextures.ICustomWeatherRender;
import net.minecraft.client.Minecraft;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.texture.TextureManager;
import net.minecraft.level.Level;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldRenderer.class)
public class MixinWorldRenderer {

    @Shadow private Minecraft client;

    @Shadow private Level level;

    @Shadow private TextureManager textureManager;

    @ModifyArg(method = "renderSky", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/texture/TextureManager;getTextureId(Ljava/lang/String;)I"
    ), index = 0)
    private String getNewTextures(String s)
    {
        if(s.endsWith("sun.png") && this.client.level.dimension instanceof ICustomSkyRender)
            return ((ICustomSkyRender)this.client.level.dimension).getSunTexture();
        if(s.endsWith("moon.png") && this.client.level.dimension instanceof ICustomSkyRender)
            return ((ICustomSkyRender)this.client.level.dimension).getMoonTexture();
        return s;
    }



    @Inject(method = "renderClouds", at = @At("HEAD"), cancellable = true)
    private void cancelCloudsRendering(float f, CallbackInfo ci)
    {
        if(this.client.level != null && this.client.level.dimension instanceof ICustomWeatherRender)
            if(!((ICustomWeatherRender)this.client.level.dimension).renderDefaultClouds())
                ci.cancel();
    }

    @Inject(method = "renderStars", at = @At("HEAD"), cancellable = true)
    private void cancelStarsRendering(CallbackInfo ci)
    {
        if(this.client.level != null && this.client.level.dimension instanceof ICustomSkyRender)
            if(!((ICustomSkyRender)this.client.level.dimension).renderDefaultStars())
                ci.cancel();
    }

    @Inject(method = "renderSky", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/level/Level;method_286(F)F",
            shift = At.Shift.BEFORE
    ))
    private void renderGalaxies(float f, CallbackInfo ci)
    {
        GL11.glEnable(3553);
        Tessellator tessellator = Tessellator.INSTANCE;
        GL11.glRotatef(0.0F, 0.0F, 0.0F, 1.0F);
        GL11.glRotatef(this.level.method_198(f) * 360.0F, 2.2F, 0.0F, 3.5F);
        float size = 85.0F;
        GL11.glBindTexture(3553, this.textureManager.getTextureId("/assets/ojw/textures/gui/environment/galaxy_NGC-4414.png"));
        tessellator.start();
        tessellator.vertex(-size, -100.0D, size, 1.0D, 1.0D);
        tessellator.vertex(size, -100.0D, size, 0.0D, 1.0D);
        tessellator.vertex(size, -100.0D, -size, 0.0D, 0.0D);
        tessellator.vertex(-size, -100.0D, -size, 1.0D, 0.0D);
        tessellator.draw();

        GL11.glRotatef(0.0F, 0.0F, 0.0F, 1.0F);
        GL11.glRotatef(this.level.method_198(f) * 360.0F, 0.5F, 0.0F, -0.3F);
        size = 72.0F;
        GL11.glBindTexture(3553, this.textureManager.getTextureId("/assets/ojw/textures/gui/environment/galaxy_Antennae-Galaxies.png"));
        tessellator.start();
        tessellator.vertex(-size, -100.0D, size, 1.0D, 1.0D);
        tessellator.vertex(size, -100.0D, size, 0.0D, 1.0D);
        tessellator.vertex(size, -100.0D, -size, 0.0D, 0.0D);
        tessellator.vertex(-size, -100.0D, -size, 1.0D, 0.0D);
        tessellator.draw();

        GL11.glRotatef(0.0F, 0.0F, 0.0F, 1.0F);
        GL11.glRotatef(this.level.method_198(f) * 360.0F, -1.0F, 0.0F, -1.8F);
        size = 32.0F;
        GL11.glBindTexture(3553, this.textureManager.getTextureId("/assets/ojw/textures/gui/environment/galaxy_NGC-1427А.png"));
        tessellator.start();
        tessellator.vertex(-size, -100.0D, size, 1.0D, 1.0D);
        tessellator.vertex(size, -100.0D, size, 0.0D, 1.0D);
        tessellator.vertex(size, -100.0D, -size, 0.0D, 0.0D);
        tessellator.vertex(-size, -100.0D, -size, 1.0D, 0.0D);
        tessellator.draw();

        GL11.glRotatef(0.0F, 0.0F, 0.0F, 1.0F);
        GL11.glRotatef(this.level.method_198(f) * 360.0F, 1.3F, 0.0F, -1.2F);
        size = 48.0F;
        GL11.glBindTexture(3553, this.textureManager.getTextureId("/assets/ojw/textures/gui/environment/galaxy_M60-UCD1.png"));
        tessellator.start();
        tessellator.vertex(-size, -100.0D, size, 1.0D, 1.0D);
        tessellator.vertex(size, -100.0D, size, 0.0D, 1.0D);
        tessellator.vertex(size, -100.0D, -size, 0.0D, 0.0D);
        tessellator.vertex(-size, -100.0D, -size, 1.0D, 0.0D);
        tessellator.draw();
        GL11.glDisable(3553);
    }
}
