package kz.chesschicken.ojw.utils;

import net.modificationstation.stationapi.api.client.texture.atlas.Atlases;

public class TextureHelper {

    private TextureHelper() { }

    public int registerBlockTexture(String name)
    {
        return Atlases.getStationTerrain().addTexture("/assets/ojw/textures/block/" + name + ".png").index;
    }

    public int registerItemTexture(String name)
    {
        return Atlases.getStationTerrain().addTexture("/assets/ojw/textures/item/" + name + ".png").index;
    }

    private static TextureHelper INSTANCE;
    public static TextureHelper getInstance() {
        if(INSTANCE == null)
            INSTANCE = new TextureHelper();
        return INSTANCE;
    }
}
