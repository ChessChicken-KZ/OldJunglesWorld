package kz.chesschicken.ojw.utils;

import net.modificationstation.stationapi.api.client.texture.atlas.Atlases;

public class TextureHelper {

    private TextureHelper() { }

    public int registerBlockTexture(String name)
    {
        return Atlases.getStationTerrain().addTexture("/assets/ojw/textures/block/" + name + ".png").index;
    }


    private final static TextureHelper INSTANCE = new TextureHelper();
    public static TextureHelper getInstance()
    {
        return INSTANCE;
    }
}
