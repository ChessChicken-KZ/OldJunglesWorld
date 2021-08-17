package kz.chesschicken.ojw.block.grass.instances;

import kz.chesschicken.ojw.block.grass.MetaGrass;
import kz.chesschicken.ojw.init.OJWContentListener;

public class GlitchGrass extends MetaGrass {
    public GlitchGrass(int i) {
        super(i);
    }

    @Override
    public int getTopTexture() {
        return OJWContentListener.textureGrassGlitchTop;
    }

    @Override
    public int getBottomTexture() {
        return OJWContentListener.textureDirtGlitch;
    }

    @Override
    public int getSideTexture() {
        return OJWContentListener.textureGrassGlitchSide;
    }

    @Override
    public String getName() {
        return "tile.grassGlitch.name";
    }
}
