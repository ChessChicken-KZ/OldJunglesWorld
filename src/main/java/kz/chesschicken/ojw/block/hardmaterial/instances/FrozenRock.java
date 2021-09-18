package kz.chesschicken.ojw.block.hardmaterial.instances;

import kz.chesschicken.ojw.block.hardmaterial.MetaRock;
import kz.chesschicken.ojw.init.OJWContainer;

public class FrozenRock extends MetaRock {
    public FrozenRock(int i) {
        super(i);
    }

    @Override
    public int getStoneTexture() {
        return OJWContainer.textureStoneFrozen;
    }

    @Override
    public int getCobblestoneTexture() {
        return OJWContainer.textureCobblestoneFrozen;
    }

    @Override
    public int getGravelTexture() {
        return OJWContainer.textureGravelFrozen;
    }
}
