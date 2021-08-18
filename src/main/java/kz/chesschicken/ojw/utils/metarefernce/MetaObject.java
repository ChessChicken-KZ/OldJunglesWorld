package kz.chesschicken.ojw.utils.metarefernce;

public abstract class MetaObject<K> {
    public final int metadata;

    public MetaObject(int i)
    {
        this.metadata = i;
    }

    public abstract Class<? extends K> getObjectClass();
}
