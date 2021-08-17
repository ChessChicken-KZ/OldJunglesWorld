package kz.chesschicken.ojw.block.dirt;

import kz.chesschicken.ojw.utils.metarefernce.MetaBlock;

public class MetaDirt extends MetaBlock {
    public MetaDirt(int i) {
        super(i);
    }

    @Override
    public float getHardness() {
        return 0.5F;
    }
}
