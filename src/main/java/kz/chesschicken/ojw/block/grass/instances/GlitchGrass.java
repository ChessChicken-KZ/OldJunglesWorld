package kz.chesschicken.ojw.block.grass.instances;

import kz.chesschicken.ojw.block.grass.MetaGrass;
import kz.chesschicken.ojw.init.OJWTextureListener;

public class GlitchGrass extends MetaGrass {
    public GlitchGrass(int i) {
        super(i);
    }

    @Override
    public int getGrassTopTexture() {
        return OJWTextureListener.textureGrassGlitchTop;
    }

    @Override
    public int getDirtTexture() {
        return OJWTextureListener.textureDirtGlitch;
    }

    @Override
    public int getGrassSideTexture() {
        return OJWTextureListener.textureGrassGlitchSide;
    }
}
