package kz.chesschicken.ojw.utils.client;

public interface ICustomSkyRender {
    String getMoonTexture();

    String getSunTexture();

    default boolean renderDefaultStars() {
        return true;
    }
}
