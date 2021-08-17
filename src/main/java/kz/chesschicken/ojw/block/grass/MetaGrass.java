package kz.chesschicken.ojw.block.grass;

import kz.chesschicken.ojw.init.OJWContentListener;
import kz.chesschicken.ojw.utils.metarefernce.MetaBlock;

public abstract class MetaGrass extends MetaBlock {
    private final String prefix;

    public MetaGrass(int i, String s) {
        super(i);
        this.prefix = s;
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
            case 2: return getDirtTexture();

            default: return getSideTexture();
        }
    }

    public abstract int getTopTexture();
    public abstract int getDirtTexture();
    public abstract int getSideTexture();

    public float getHardnessAsDirt() {
        return 0.5f;
    }

    public String getName(String s) {
        return "tile." + s + "_" + prefix + ".name";
    }

    public static void registerMeta(MetaGrass object)
    {
        OJWContentListener.blockGrassComplex.addMetaBlock(object);
        OJWContentListener.blockDirtComplex.addMetaBlock(object);
    }
}
