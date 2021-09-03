package kz.chesschicken.ojw.block.hardmaterial;

import net.minecraft.entity.EntityBase;

public abstract class MetaRock {
    public int metadata;
    public MetaRock(int i) {
        this.metadata = i;
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

    public static MetaRock[] metadataCollection = new MetaRock[4];
    public static void registerRock(MetaRock object)
    {
        metadataCollection[object.metadata] = object;
    }
}
