package kz.chesschicken.ojw.block.wood.instances;

import kz.chesschicken.ojw.block.wood.MetaWood;
import kz.chesschicken.ojw.init.OJWContainer;

public class SoulWood extends MetaWood {
    public SoulWood(int i) {
        super(i);
    }

    @Override
    public int getPlanksTexture() {
        return OJWContainer.texturePlanksSoul;
    }

    @Override
    public int getLogTopTexture() {
        return OJWContainer.textureLogSoulTop;
    }

    @Override
    public int getLogSideTexture() {
        return OJWContainer.textureLogSoulSide;
    }

    @Override
    public int getLeavesTexture() {
        return OJWContainer.textureLeavesSoul;
    }
}
