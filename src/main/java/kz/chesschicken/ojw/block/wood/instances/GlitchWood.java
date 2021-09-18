package kz.chesschicken.ojw.block.wood.instances;

import kz.chesschicken.ojw.block.wood.MetaWood;
import kz.chesschicken.ojw.init.OJWContainer;

public class GlitchWood extends MetaWood {
    public GlitchWood(int i) {
        super(i);
    }

    @Override
    public int getPlanksTexture() {
        return OJWContainer.texturePlanksGlitch;
    }

    @Override
    public int getLogTopTexture() {
        return OJWContainer.textureLogGlitchTop;
    }

    @Override
    public int getLogSideTexture() {
        return OJWContainer.textureLogGlitchSide;
    }

    @Override
    public int getLeavesTexture() {
        return OJWContainer.textureLeavesGlitch;
    }
}
