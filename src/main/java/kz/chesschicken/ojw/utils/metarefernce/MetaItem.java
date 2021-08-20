package kz.chesschicken.ojw.utils.metarefernce;

import net.minecraft.item.ItemBase;
import net.minecraft.item.ItemInstance;

public class MetaItem extends MetaObject<ItemBase> {
    protected int objectID;

    public void setObjectID(int i) {
        this.objectID = i;
    }

    public MetaItem(int i) {
        super(i);
    }

    public int getIcon() {
        return ItemBase.byId[this.objectID].getTexturePosition(0);
    }

    public String getName(ItemInstance object) {
        return ItemBase.byId[this.objectID].getTranslatedName();
    }


    @Override
    public Class<? extends ItemBase> getObjectClass() {
        return ItemBase.class;
    }
}
