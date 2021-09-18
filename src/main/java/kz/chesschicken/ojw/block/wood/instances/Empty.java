package kz.chesschicken.ojw.block.wood.instances;

import kz.chesschicken.ojw.block.wood.MetaWood;
import kz.chesschicken.ojw.init.OJWContainer;

public class Empty extends MetaWood {
    public Empty(int i) {
        super(i);
    }

    @Override
    public int getPlanksTexture() {
        return OJWContainer.textureDebug;
    }

    @Override
    public int getLogTopTexture() {
        return OJWContainer.textureDebug;
    }

    @Override
    public int getLogSideTexture() {
        return OJWContainer.textureDebug;
    }

    @Override
    public int getLeavesTexture() {
        return OJWContainer.textureDebug;
    }
}
