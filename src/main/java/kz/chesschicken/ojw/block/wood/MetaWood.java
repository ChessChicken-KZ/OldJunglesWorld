package kz.chesschicken.ojw.block.wood;

public abstract class MetaWood {
    public int metadata;
    public MetaWood(int i) {
        this.metadata = i;
    }

    public float getHardnessAsLog() {
        return 2.0F;
    }

    public float getHardnessAsPlanks() {
        return 2.0F;
    }

    public float getHardnessAsLeaves() {
        return 0.2F;
    }

    public abstract int getPlanksTexture();
    public abstract int getLogTopTexture();
    public abstract int getLogSideTexture();
    public abstract int getLeavesTexture();

    public static MetaWood[] metadataCollection = new MetaWood[4];
    public static void registerWood(MetaWood metaWood)
    {
        metadataCollection[metaWood.metadata] = metaWood;
    }
}
