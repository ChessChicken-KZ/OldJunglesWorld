package kz.chesschicken.ojw.utils.metarefernce;

public abstract class MetaObject<K> {
    public final int metadata;
    protected int objectID;

    public MetaObject(int i) {
        this.metadata = i;
    }

    public void setObjectID(int i) {
        this.objectID = i;
    }

    public int getObjectID() {
        return this.objectID;
    }

    public abstract Class<? extends K> getObjectClass();
}
