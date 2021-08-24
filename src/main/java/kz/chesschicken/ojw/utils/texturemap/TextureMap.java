package kz.chesschicken.ojw.utils.texturemap;

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
        throw new IllegalArgumentException("stupid");
    }

    public int get(Identifier id)
    {
        if(!doesExist(id)) {
            return this.textureMap.get(id);
        }
        throw new IllegalArgumentException("bald");
    }

    public Atlas getAtlas()
    {
        return this.currentAtlas;
    }

}
