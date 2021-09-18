package kz.chesschicken.ojw.block.grass.instances;

import kz.chesschicken.ojw.block.grass.MetaGrass;
import kz.chesschicken.ojw.init.OJWContainer;

public class FrozenGrass extends MetaGrass {
    public FrozenGrass(int i) {
        super(i);
    }

    @Override
    public int getGrassTopTexture() {
        return OJWContainer.textureSnowFrozen;
    }

    @Override
    public int getDirtTexture() {
        return OJWContainer.textureDirtFrozen;
    }

    @Override
    public int getGrassSideTexture() {
        return OJWContainer.textureGrassFrozenSide;
    }
}
