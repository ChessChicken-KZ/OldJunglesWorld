package kz.chesschicken.ojw.block.hardmaterial.instances;

import kz.chesschicken.ojw.block.hardmaterial.MetaRock;
import kz.chesschicken.ojw.init.OJWTextureListener;

public class Empty extends MetaRock {
    public Empty(int i) {
        super(i);
    }

    public int getStoneTexture() {
        return OJWTextureListener.textureDebug;
    }
    public int getCobblestoneTexture() {
        return OJWTextureListener.textureDebug;
    }
    public int getGravelTexture() {
        return OJWTextureListener.textureDebug;
    }

}
