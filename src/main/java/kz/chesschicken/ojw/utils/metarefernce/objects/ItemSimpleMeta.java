package kz.chesschicken.ojw.utils.metarefernce.objects;

import kz.chesschicken.ojw.utils.metarefernce.MetaItem;
import net.minecraft.item.ItemInstance;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.item.TemplateItemBase;

public class ItemSimpleMeta extends TemplateItemBase {
    public final MetaItem[] metadataCollection;

    public ItemSimpleMeta(Identifier identifier, int capacity) {
        super(identifier);
        metadataCollection = new MetaItem[capacity];
        this.setHasSubItems(true);
    }

    public void addMetaItem(MetaItem metaBlock) {
        metaBlock.setObjectID(this.id);
        metadataCollection[metaBlock.metadata] = metaBlock;
    }

    @Override
    public int getMetaData(int i) {
        return i;
    }

    @Override
    public int getTexturePosition(int damage) {
        return metadataCollection[damage].getIcon();
    }

    @Override
    public String getTranslationKey(ItemInstance item) {
        return metadataCollection[item.getDamage()].getName(item);
    }
}
