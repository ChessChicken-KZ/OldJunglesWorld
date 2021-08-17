package kz.chesschicken.ojw.block.hardmaterial.instances;

import kz.chesschicken.ojw.block.hardmaterial.MetaRock;

public class FrozenRock extends MetaRock {
    public FrozenRock(int i) {
        super(i, "frozen");
    }

    @Override
    public int getStoneTexture() {
        return 0;
    }

    @Override
    public int getCobblestoneTexture() {
        return 0;
    }

    @Override
    public int getGravelTexture() {
        return 0;
    }
}
