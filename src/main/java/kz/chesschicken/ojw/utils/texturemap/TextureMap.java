package kz.chesschicken.ojw.utils.texturemap;

import kz.chesschicken.ojw.init.OJWLogger;
import net.modificationstation.stationapi.api.client.texture.atlas.Atlas;
import net.modificationstation.stationapi.api.client.texture.atlas.ExpandableAtlas;
import net.modificationstation.stationapi.api.registry.Identifier;

import java.util.HashMap;
import java.util.Map;

public class TextureMap {
    private final ExpandableAtlas currentAtlas;
    private final Map<Identifier, Integer> textureMap;

    public TextureMap(ExpandableAtlas a)
    {
        this.currentAtlas = a;
        this.textureMap = new HashMap<>();

        this.add(Identifier.of("ojw:debug"), "/assets/ojw/textures/block/debug.png");
    }

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    public boolean doesExist(Identifier id)
    {
        return this.textureMap.containsKey(id);
    }

    public void add(Identifier id, String texture)
    {
        if(!doesExist(id)) {
            this.textureMap.put(id, this.currentAtlas.addTexture(texture).index);
            return;
        }
        OJWLogger.INSTANCE.INIT.error("Texture with same identifier is already present in the map list.");
    }

    public int get(Identifier id)
    {
        if(!doesExist(id)) {
            return this.textureMap.get(id);
        }
        OJWLogger.INSTANCE.INIT.error("Texture with identifier " + id.toString() + " was not found!");
        return this.getDebugTexture();
    }

    public int getDebugTexture() {
        return this.textureMap.get(Identifier.of("ojw:debug"));
    }

    public Atlas getAtlas()
    {
        return this.currentAtlas;
    }

}
