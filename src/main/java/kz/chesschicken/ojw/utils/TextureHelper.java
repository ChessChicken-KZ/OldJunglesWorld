package kz.chesschicken.ojw.utils;

import net.modificationstation.stationapi.api.client.texture.TextureFactory;
import net.modificationstation.stationapi.api.client.texture.TextureRegistry;

public class TextureHelper {

    private TextureHelper() { }

    public int registerBlockTexture(String name)
    {
        return TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/ojw/textures/block/" + name + ".png");
    }

    public int registerItemTexture(String name)
    {
        return TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/ojw/textures/item/" + name + ".png");
    }


    private final static TextureHelper INSTANCE = new TextureHelper();
    public static TextureHelper getInstance()
    {
        return INSTANCE;
    }
}
