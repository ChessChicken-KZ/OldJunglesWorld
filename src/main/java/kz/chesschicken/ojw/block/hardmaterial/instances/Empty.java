package kz.chesschicken.ojw.block.hardmaterial.instances;

import kz.chesschicken.ojw.block.hardmaterial.MetaRock;
import kz.chesschicken.ojw.init.OJWContainer;

public class Empty extends MetaRock {
    public Empty(int i) {
        super(i);
    }

    public int getStoneTexture() {
        return OJWContainer.textureDebug;
    }
    public int getCobblestoneTexture() {
        return OJWContainer.textureDebug;
    }
    public int getGravelTexture() {
        return OJWContainer.textureDebug;
    }

}
