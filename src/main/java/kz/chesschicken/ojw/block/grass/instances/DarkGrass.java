package kz.chesschicken.ojw.block.grass.instances;

import kz.chesschicken.ojw.block.grass.MetaGrass;
import kz.chesschicken.ojw.init.OJWTextureListener;

public class DarkGrass extends MetaGrass {
    public DarkGrass(int i) {
        super(i, "dark");
    }

    @Override
    public int getGrassTopTexture() {
        return OJWTextureListener.textureGrassDarkTop;
    }

    @Override
    public int getDirtTexture() {
        return OJWTextureListener.textureDirtDark;
    }

    @Override
    public int getGrassSideTexture() {
        return OJWTextureListener.textureGrassDarkSide;
    }
}
