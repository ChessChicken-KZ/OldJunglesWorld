package kz.chesschicken.ojw.block.grass;

import kz.chesschicken.ojw.init.OJWContentListener;
import kz.chesschicken.ojw.utils.metarefernce.MetaBlock;
import net.minecraft.item.ItemInstance;

public abstract class MetaGrass extends MetaBlock {

    public MetaGrass(int i) {
        super(i);
    }

    public abstract int getGrassTopTexture();
    public abstract int getDirtTexture();
    public abstract int getGrassSideTexture();

    public float getHardnessAsDirt() {
        return 0.5f;
    }
    public float getHardnessAsGrass() {
        return 0.6F;
    }

    public static void registerMeta(MetaGrass object)
    {
        OJWContentListener.blockGrassComplex.addMetaBlock(object);
        OJWContentListener.blockDirtComplex.addMetaBlock(object);
    }

    @Override
    public int getBlockMiningLevel(ItemInstance itemInstance) {
        return 0;
    }
}
