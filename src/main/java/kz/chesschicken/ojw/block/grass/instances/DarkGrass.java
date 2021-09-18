package kz.chesschicken.ojw.block.grass.instances;

import kz.chesschicken.ojw.block.grass.MetaGrass;
import kz.chesschicken.ojw.init.OJWContainer;

public class DarkGrass extends MetaGrass {
    public DarkGrass(int i) {
        super(i);
    }

    @Override
    public int getGrassTopTexture() {
        return OJWContainer.textureGrassDarkTop;
    }

    @Override
    public int getDirtTexture() {
        return OJWContainer.textureDirtDark;
    }

    @Override
    public int getGrassSideTexture() {
        return OJWContainer.textureGrassDarkSide;
    }
}
