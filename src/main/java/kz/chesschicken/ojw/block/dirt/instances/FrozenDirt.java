package kz.chesschicken.ojw.block.dirt.instances;

import kz.chesschicken.ojw.block.dirt.MetaDirt;
import kz.chesschicken.ojw.init.OJWContentListener;

public class FrozenDirt extends MetaDirt {
    public FrozenDirt(int i) {
        super(i);
    }

    @Override
    public int getTextureSide(int side) {
        return OJWContentListener.textureDirtFrozen;
    }

    @Override
    public String getName() {
        return "tile.dirtFrozen.name";
    }
}
