package kz.chesschicken.ojw.utils.customtextures;

public interface ICustomSkyRender {
    String getMoonTexture();

    String getSunTexture();

    default boolean renderDefaultStars() {
        return true;
    }
}
