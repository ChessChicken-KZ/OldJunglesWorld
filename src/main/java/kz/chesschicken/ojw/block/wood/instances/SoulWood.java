package kz.chesschicken.ojw.block.wood.instances;

import kz.chesschicken.ojw.block.wood.MetaWood;
import kz.chesschicken.ojw.init.OJWTextureListener;

public class SoulWood extends MetaWood {

    public SoulWood(int i) {
        super(i);
    }

    @Override
    public int getPlanksTexture() {
        return OJWTextureListener.texturePlanksSoul;
    }

    @Override
    public int getLogTopTexture() {
        return OJWTextureListener.textureLogSoulTop;
    }

    @Override
    public int getLogSideTexture() {
        return OJWTextureListener.textureLogSoulSide;
    }

    @Override
    public int getLeavesTexture() {
        return OJWTextureListener.textureLeavesSoul;
    }
}
