package kz.chesschicken.ojw.block.wood.instances;

import kz.chesschicken.ojw.block.wood.MetaWood;

public class GlitchWood extends MetaWood {
    public GlitchWood(int i) {
        super(i);
    }

    @Override
    public int getPlanksTexture() {
        return 0;
    }

    @Override
    public int getLogTopTexture() {
        return 0;
    }

    @Override
    public int getLogSideTexture() {
        return 0;
    }
}
