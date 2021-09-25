package kz.chesschicken.ojw.item;

import kz.chesschicken.ojw.init.OJWContentListener;
import net.modificationstation.stationapi.api.template.item.TemplateBlock;

public class ItemLightFlower extends TemplateBlock {
    public ItemLightFlower(int i) {
        super(i);
        this.setHasSubItems(true);
    }

    @Override
    public int getMetaData(int i) {
        return i;
    }

    @Override
    public int getTexturePosition(int damage) {
        return OJWContentListener.flower_light.getTextureForSide(0, damage);
    }
}
