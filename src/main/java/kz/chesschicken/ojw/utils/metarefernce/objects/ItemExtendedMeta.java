package kz.chesschicken.ojw.utils.metarefernce.objects;

import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.registry.Identifier;

public class ItemExtendedMeta extends ItemSimpleMeta {

    public ItemExtendedMeta(Identifier identifier, int capacity) {
        super(identifier, capacity);
    }

    @Override
    public boolean useOnTile(ItemInstance item, PlayerBase player, Level level, int x, int y, int z, int facing) {
        return metadataCollection[item.getDamage()].useOnTile(item, player, level, x, y, z, facing);
    }

    @Override
    public ItemInstance use(ItemInstance item, Level level, PlayerBase player) {
        return metadataCollection[item.getDamage()].use(item, level, player);
    }
}
