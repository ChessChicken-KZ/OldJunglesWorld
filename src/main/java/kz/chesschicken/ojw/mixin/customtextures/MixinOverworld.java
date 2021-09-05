package kz.chesschicken.ojw.mixin.customtextures;

import kz.chesschicken.ojw.utils.customtextures.ICustomSkyTexture;
import kz.chesschicken.ojw.utils.customtextures.ICustomWeatherTexture;
import net.minecraft.level.dimension.Overworld;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Overworld.class)
public class MixinOverworld implements ICustomSkyTexture, ICustomWeatherTexture {
    @Override
    public String getMoonTexture() {
        return "/terrain/moon.png";
    }

    @Override
    public String getSunTexture() {
        return "/terrain/sun.png";
    }

    @Override
    public String getRainTexture() {
        return "/environment/rain.png";
    }

    @Override
    public String getSnowTexture() {
        return "/environment/snow.png";
    }
}
