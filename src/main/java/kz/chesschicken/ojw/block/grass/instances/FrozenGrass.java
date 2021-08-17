package kz.chesschicken.ojw.block.grass.instances;

import kz.chesschicken.ojw.block.grass.MetaGrass;
import kz.chesschicken.ojw.init.OJWContentListener;

public class FrozenGrass extends MetaGrass {
    public FrozenGrass(int i) {
        super(i);
    }

    @Override
    public int getTopTexture() {
        return OJWContentListener.textureSnowFrozen;
    }

    @Override
    public int getBottomTexture() {
        return OJWContentListener.textureDirtFrozen;
    }

    @Override
    public int getSideTexture() {
        return OJWContentListener.textureGrassFrozenSide;
    }

    @Override
    public String getName() {
        return "tile.grassFrozen.name";
    }
}
