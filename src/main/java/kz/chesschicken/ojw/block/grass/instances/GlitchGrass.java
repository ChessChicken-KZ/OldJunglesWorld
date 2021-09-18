package kz.chesschicken.ojw.block.grass.instances;

import kz.chesschicken.ojw.block.grass.MetaGrass;
import kz.chesschicken.ojw.init.OJWContainer;

public class GlitchGrass extends MetaGrass {
    public GlitchGrass(int i) {
        super(i);
    }

    @Override
    public int getGrassTopTexture() {
        return OJWContainer.textureGrassGlitchTop;
    }

    @Override
    public int getDirtTexture() {
        return OJWContainer.textureDirtGlitch;
    }

    @Override
    public int getGrassSideTexture() {
        return OJWContainer.textureGrassGlitchSide;
    }
}
