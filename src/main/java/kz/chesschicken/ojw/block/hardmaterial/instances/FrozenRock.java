package kz.chesschicken.ojw.block.hardmaterial.instances;

import kz.chesschicken.ojw.block.hardmaterial.MetaRock;
import kz.chesschicken.ojw.init.OJWTextureListener;

public class FrozenRock extends MetaRock {
    public FrozenRock(int i) {
        super(i, "frozen");
    }

    @Override
    public int getStoneTexture() {
        return OJWTextureListener.textureStoneFrozen;
    }

    @Override
    public int getCobblestoneTexture() {
        return OJWTextureListener.textureCobblestoneFrozen;
    }

    @Override
    public int getGravelTexture() {
        return OJWTextureListener.textureGravelFrozen;
    }
}
