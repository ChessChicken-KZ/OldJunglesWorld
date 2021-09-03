package kz.chesschicken.ojw.block.hardmaterial;

import kz.chesschicken.ojw.init.OJWContentListener;
import kz.chesschicken.ojw.utils.metarefernce.MetaBlock;
import net.minecraft.entity.EntityBase;

public abstract class MetaRock extends MetaBlock {
    public MetaRock(int i) {
        super(i);
    }

    public float getResistanceAsStone(EntityBase entityBase) {
        return 10.0F;
    }

    public float getResistanceAsCobblestone(EntityBase entityBase) {
        return 10.0F;
    }


    public float getHardnessAsStone() {
        return 1.5F;
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
