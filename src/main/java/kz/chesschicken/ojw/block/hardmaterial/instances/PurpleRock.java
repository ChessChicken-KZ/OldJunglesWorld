package kz.chesschicken.ojw.block.hardmaterial.instances;

import kz.chesschicken.ojw.block.hardmaterial.MetaRock;
import kz.chesschicken.ojw.init.OJWTextureListener;

public class PurpleRock extends MetaRock {
    public PurpleRock(int i) {
        super(i);
    }

    @Override
    public int getStoneTexture() {
        return OJWTextureListener.textureStonePurple;
    }

    @Override
    public int getCobblestoneTexture() {
        return OJWTextureListener.textureCobblestonePurple;
    }

    @Override
    public int getGravelTexture() {
        return OJWTextureListener.textureGravelPurple;
    }
}
