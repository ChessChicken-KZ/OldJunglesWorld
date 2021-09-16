package kz.chesschicken.ojw.utils.customtextures;

public interface ICustomWeatherRender {
    String getRainTexture();

    String getSnowTexture();

    default boolean renderDefaultClouds() {
        return true;
    }
}
