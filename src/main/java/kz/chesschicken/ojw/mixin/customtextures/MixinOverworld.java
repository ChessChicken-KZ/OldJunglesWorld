package kz.chesschicken.ojw.mixin.customtextures;

import kz.chesschicken.ojw.utils.customtextures.ICustomSkyRender;
import kz.chesschicken.ojw.utils.customtextures.ICustomWeatherRender;
import net.minecraft.level.dimension.Overworld;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Overworld.class)
public class MixinOverworld implements ICustomSkyRender, ICustomWeatherRender {
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

    @Override
    public boolean renderDefaultStars() {
        return false;
    }
}
