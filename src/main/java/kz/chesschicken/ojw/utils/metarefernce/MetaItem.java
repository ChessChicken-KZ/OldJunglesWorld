package kz.chesschicken.ojw.utils.metarefernce;

import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;

public class MetaItem extends MetaObject<ItemBase> {

    public MetaItem(int i) {
        super(i);
    }

    public int getIcon() {
        return ItemBase.byId[this.objectID].getTexturePosition(0);
    }

    public String getName(ItemInstance object) {
        return ItemBase.byId[this.objectID].getTranslatedName();
    }

    public boolean useOnTile(ItemInstance item, PlayerBase player, Level level, int x, int y, int z, int facing) {
        return false;
    }

    public ItemInstance use(ItemInstance item, Level level, PlayerBase player) {
        return item;
    }

    @Override
    public Class<? extends ItemBase> getObjectClass() {
        return ItemBase.class;
    }
}
