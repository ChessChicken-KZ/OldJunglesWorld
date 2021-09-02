package kz.chesschicken.ojw.utils.texturemap;

import kz.chesschicken.ojw.init.OJWLogger;
import net.modificationstation.stationapi.api.client.texture.atlas.Atlas;
import net.modificationstation.stationapi.api.client.texture.atlas.ExpandableAtlas;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.registry.ModID;

import java.util.HashMap;
import java.util.Map;

/**
 * An easier way to provide and create texture array.
 * If there are lots of textures, this thing can be useful.
 */
public class TextureMap {
    private final ExpandableAtlas currentAtlas;
    private final Map<Identifier, Integer> textureMap;
    private final ModID modID;

    public TextureMap(ModID mod, ExpandableAtlas a)
    {
        this.modID = mod;
        this.currentAtlas = a;
        this.textureMap = new HashMap<>();

        this.add(Identifier.of(this.modID, "debug"), "/assets/" + this.modID + "/textures/block/debug.png");
    }

    /**
     * Checks if any texture with this identifier exists.
     * @param id Identifier of texture.
     * @return Exist.
     */
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

    /**
     * Get the texture id of the specific Identifier.
     * @param id Identifier of texture.
     * @return Texture ID.
     */
    public int get(Identifier id)
    {
        if(!doesExist(id)) {
            return this.textureMap.get(id);
        }
        OJWLogger.INSTANCE.INIT.error("Texture with identifier " + id.toString() + " was not found!");
        return this.getDebugTexture();
    }

    /**
     * Just a debug texture.
     * @return Debug texture id.
     */
    public int getDebugTexture() {
        return this.textureMap.get(Identifier.of(this.modID, "debug"));
    }

    /**
     * Return current atlas of the texture map list.
     * @return Current atlas.
     */
    public Atlas getAtlas()
    {
        return this.currentAtlas;
    }

}
