package kz.chesschicken.ojw.block.dirt.instances;

import kz.chesschicken.ojw.block.dirt.MetaDirt;
import kz.chesschicken.ojw.init.OJWContentListener;

public class GlitchDirt extends MetaDirt {
    public GlitchDirt(int i) {
        super(i);
    }

    @Override
    public int getTextureSide(int side) {
        return OJWContentListener.textureDirtGlitch;
    }

    @Override
    public String getName() {
        return "tile.dirtGlitch.name";
    }
}
