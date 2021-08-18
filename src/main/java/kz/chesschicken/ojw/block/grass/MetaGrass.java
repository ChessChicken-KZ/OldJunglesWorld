package kz.chesschicken.ojw.block.grass;

import kz.chesschicken.ojw.init.OJWContentListener;
import kz.chesschicken.ojw.utils.metarefernce.MetaBlock;

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
            case 1: return getGrassTopTexture();
            case 2: return getDirtTexture();

            default: return getGrassSideTexture();
        }
    }

    public abstract int getGrassTopTexture();
    public abstract int getDirtTexture();
    public abstract int getGrassSideTexture();

    public float getHardnessAsDirt() {
        return 0.5f;
    }

    public static void registerMeta(MetaGrass object)
    {
        OJWContentListener.blockGrassComplex.addMetaBlock(object);
        OJWContentListener.blockDirtComplex.addMetaBlock(object);
    }
}
