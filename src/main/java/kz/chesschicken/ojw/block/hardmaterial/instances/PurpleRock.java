package kz.chesschicken.ojw.block.hardmaterial.instances;

import kz.chesschicken.ojw.block.hardmaterial.MetaRock;
import kz.chesschicken.ojw.init.OJWContainer;

public class PurpleRock extends MetaRock {
    public PurpleRock(int i) {
        super(i);
    }

    @Override
    public int getStoneTexture() {
        return OJWContainer.textureStonePurple;
    }

    @Override
    public int getCobblestoneTexture() {
        return OJWContainer.textureCobblestonePurple;
    }

    @Override
    public int getGravelTexture() {
        return OJWContainer.textureGravelPurple;
    }
}
