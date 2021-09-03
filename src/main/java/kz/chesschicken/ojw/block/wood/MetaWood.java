package kz.chesschicken.ojw.block.wood;

import kz.chesschicken.ojw.init.OJWContentListener;
import kz.chesschicken.ojw.utils.metarefernce.MetaBlock;

public abstract class MetaWood extends MetaBlock {
    public MetaWood(int i) {
        super(i);
    }

    public float getHardnessAsLog() {
        return 2.0F;
    }

    public float getHardnessAsPlanks() {
        return 2.0F;
    }

    public abstract int getPlanksTexture();
    public abstract int getLogTopTexture();
    public abstract int getLogSideTexture();

    public static void registerWood(MetaWood metaWood)
    {
        OJWContentListener.blockLogComplex.addMetaBlock(metaWood);
        OJWContentListener.blockPlanksComplex.addMetaBlock(metaWood);
    }
}
