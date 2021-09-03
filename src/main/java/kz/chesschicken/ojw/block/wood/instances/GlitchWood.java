package kz.chesschicken.ojw.block.wood.instances;

import kz.chesschicken.ojw.block.wood.MetaWood;
import kz.chesschicken.ojw.init.OJWTextureListener;

public class GlitchWood extends MetaWood {
    public GlitchWood(int i) {
        super(i);
    }

    @Override
    public int getPlanksTexture() {
        return OJWTextureListener.texturePlanksGlitch;
    }

    @Override
    public int getLogTopTexture() {
        return OJWTextureListener.textureLogGlitchTop;
    }

    @Override
    public int getLogSideTexture() {
        return OJWTextureListener.textureLogGlitchSide;
    }

    @Override
    public int getLeavesTexture() {
        return 0;
    }
}
