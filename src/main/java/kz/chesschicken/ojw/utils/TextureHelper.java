package kz.chesschicken.ojw.utils;

import net.modificationstation.stationapi.api.client.texture.atlas.ExpandableAtlas;

public class TextureHelper {

    private TextureHelper() { }

    public int registerBlockTexture(String name)
    {
        return ExpandableAtlas.STATION_TERRAIN.addTexture("/assets/ojw/textures/block/" + name + ".png").index;
    }

    public int registerItemTexture(String name)
    {
        return ExpandableAtlas.STATION_GUI_ITEMS.addTexture("/assets/ojw/textures/item/" + name + ".png").index;
    }


    private final static TextureHelper INSTANCE = new TextureHelper();
    public static TextureHelper getInstance()
    {
        return INSTANCE;
    }
}
