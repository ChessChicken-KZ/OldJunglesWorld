package kz.chesschicken.ojw.block.wood.instances;

import kz.chesschicken.ojw.block.wood.MetaWood;
import kz.chesschicken.ojw.init.OJWTextureListener;

public class Empty extends MetaWood {
    public Empty(int i) {
        super(i);
    }

    @Override
    public int getPlanksTexture() {
        return OJWTextureListener.textureDebug;
    }

    @Override
    public int getLogTopTexture() {
        return OJWTextureListener.textureDebug;
    }

    @Override
    public int getLogSideTexture() {
        return OJWTextureListener.textureDebug;
    }
}
