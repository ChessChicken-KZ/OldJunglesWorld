package kz.chesschicken.ojw.utils.client;

public interface ICustomWeatherRender {
    String getRainTexture();

    String getSnowTexture();

    default boolean renderDefaultClouds() {
        return true;
    }
}
