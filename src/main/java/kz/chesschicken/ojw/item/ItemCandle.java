package kz.chesschicken.ojw.item;

import kz.chesschicken.ojw.init.OJWContainer;
import net.minecraft.item.Block;

public class ItemCandle extends Block {
    public ItemCandle(int q) {
        super(q);
        this.setHasSubItems(false);
    }

    @Override
    public int getTexturePosition(int damage) {
        return OJWContainer.textureCandleItem;
    }
}
