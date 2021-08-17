package kz.chesschicken.ojw.block.grass.instances;

import kz.chesschicken.ojw.block.grass.MetaGrass;
import kz.chesschicken.ojw.init.OJWContentListener;

public class DarkGrass extends MetaGrass {
    public DarkGrass(int i) {
        super(i, "dark");
    }

    @Override
    public int getGrassTopTexture() {
        return OJWContentListener.textureGrassDarkTop;
    }

    @Override
    public int getDirtTexture() {
        return OJWContentListener.textureDirtDark;
    }

    @Override
    public int getGrassSideTexture() {
        return OJWContentListener.textureGrassDarkSide;
    }
}
