package kz.chesschicken.ojw.block.hardmaterial;

import kz.chesschicken.ojw.init.OJWContentListener;
import kz.chesschicken.ojw.utils.metarefernce.MetaBlock;
import net.minecraft.entity.EntityBase;

public abstract class MetaRock extends MetaBlock {
    private final String prefix;
    public MetaRock(int i, String s) {
        super(i);
        this.prefix = s;
    }

    public String getName(String s) {
        return "tile." + s + "_" + prefix + ".name";
    }

    @Override
    public float getHardness() {
        return 1.5F;
    }

    @Override
    public float getResistance(EntityBase entityBase) {
        return 10.0F;
    }

    public float getHardnessAsGravel() {
        return 0.6F;
    }

    public float getHardnessAsCobblestone() {
        return 2.0F;
    }

    public abstract int getStoneTexture();
    public abstract int getCobblestoneTexture();
    public abstract int getGravelTexture();

    public static void registerRock(MetaRock object)
    {
        OJWContentListener.blockStoneComplex.addMetaBlock(object);
        OJWContentListener.blockCobblestoneComplex.addMetaBlock(object);
        OJWContentListener.blockGravelComplex.addMetaBlock(object);

    }
}
