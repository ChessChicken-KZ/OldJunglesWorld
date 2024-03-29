package kz.chesschicken.ojw.block.grass;


public abstract class MetaGrass {
    public int metadata;
    public MetaGrass(int i) {
        this.metadata = i;
    }

    public abstract int getGrassTopTexture();
    public abstract int getDirtTexture();
    public abstract int getGrassSideTexture();

    public float getHardnessAsDirt() {
        return 0.5F;
    }
    public float getHardnessAsGrass() {
        return 0.6F;
    }

    public static MetaGrass[] metadataCollection;
    public static void setMetadataCollection(MetaGrass... object)
    {
        metadataCollection = object;
    }
}
