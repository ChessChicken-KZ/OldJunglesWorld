package kz.chesschicken.ojw.block.grass.instances;

import kz.chesschicken.ojw.block.grass.MetaGrass;
import kz.chesschicken.ojw.init.OJWContentListener;

public class FrozenGrass extends MetaGrass {
    public FrozenGrass(int i) {
        super(i, "frozen");
    }

    @Override
    public int getTopTexture() {
        return OJWContentListener.textureSnowFrozen;
    }

    @Override
    public int getDirtTexture() {
        return OJWContentListener.textureDirtFrozen;
    }

    @Override
    public int getSideTexture() {
        return OJWContentListener.textureGrassFrozenSide;
    }
}
