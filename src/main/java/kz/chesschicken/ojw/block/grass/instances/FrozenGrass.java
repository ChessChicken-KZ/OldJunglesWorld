package kz.chesschicken.ojw.block.grass.instances;

import kz.chesschicken.ojw.block.grass.MetaGrass;
import kz.chesschicken.ojw.init.OJWTextureListener;

public class FrozenGrass extends MetaGrass {
    public FrozenGrass(int i) {
        super(i, "frozen");
    }

    @Override
    public int getGrassTopTexture() {
        return OJWTextureListener.textureSnowFrozen;
    }

    @Override
    public int getDirtTexture() {
        return OJWTextureListener.textureDirtFrozen;
    }

    @Override
    public int getGrassSideTexture() {
        return OJWTextureListener.textureGrassFrozenSide;
    }
}
