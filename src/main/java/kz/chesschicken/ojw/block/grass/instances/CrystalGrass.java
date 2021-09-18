package kz.chesschicken.ojw.block.grass.instances;

import kz.chesschicken.ojw.block.grass.MetaGrass;
import kz.chesschicken.ojw.init.OJWContainer;

public class CrystalGrass extends MetaGrass {
    public CrystalGrass(int i) {
        super(i);
    }

    @Override
    public int getGrassTopTexture() {
        return OJWContainer.textureGrassCrystalTop;
    }

    @Override
    public int getDirtTexture() {
        return OJWContainer.textureDirtCrystal;
    }

    @Override
    public int getGrassSideTexture() {
        return OJWContainer.textureGrassCrystalSide;
    }
}
