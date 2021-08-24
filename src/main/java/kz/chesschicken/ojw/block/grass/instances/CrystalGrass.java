package kz.chesschicken.ojw.block.grass.instances;

import kz.chesschicken.ojw.block.grass.MetaGrass;
import kz.chesschicken.ojw.init.OJWTextureListener;

public class CrystalGrass extends MetaGrass {
    public CrystalGrass(int i) {
        super(i);
    }

    @Override
    public int getGrassTopTexture() {
        return OJWTextureListener.textureGrassCrystalTop;
    }

    @Override
    public int getDirtTexture() {
        return OJWTextureListener.textureDirtCrystal;
    }

    @Override
    public int getGrassSideTexture() {
        return OJWTextureListener.textureGrassCrystalSide;
    }
}
