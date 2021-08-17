package kz.chesschicken.ojw.block.grass.instances;

import kz.chesschicken.ojw.block.grass.MetaGrass;
import kz.chesschicken.ojw.init.OJWContentListener;

public class GlitchGrass extends MetaGrass {
    public GlitchGrass(int i) {
        super(i, "glitch");
    }

    @Override
    public int getTopTexture() {
        return OJWContentListener.textureGrassGlitchTop;
    }

    @Override
    public int getDirtTexture() {
        return OJWContentListener.textureDirtGlitch;
    }

    @Override
    public int getSideTexture() {
        return OJWContentListener.textureGrassGlitchSide;
    }
}
