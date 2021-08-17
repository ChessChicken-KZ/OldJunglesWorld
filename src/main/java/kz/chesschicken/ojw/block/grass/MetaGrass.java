package kz.chesschicken.ojw.block.grass;

import kz.chesschicken.ojw.utils.metarefernce.MetaBlock;
import net.minecraft.block.material.Material;

public abstract class MetaGrass extends MetaBlock {
    public MetaGrass(int i) {
        super(i);
    }

    @Override
    public float getHardness() {
        return 0.6F;
    }

    @Override
    public int getTextureSide(int side) {
        switch (side)
        {
            case 1: return getTopTexture();
            case 2: return getBottomTexture();

            default: return getSideTexture();
        }
    }

    public abstract int getTopTexture();
    public abstract int getBottomTexture();
    public abstract int getSideTexture();

}
