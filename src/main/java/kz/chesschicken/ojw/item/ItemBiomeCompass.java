package kz.chesschicken.ojw.item;

import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.common.registry.Identifier;
import net.modificationstation.stationapi.template.common.item.ItemBase;

public class ItemBiomeCompass extends ItemBase {
    public ItemBiomeCompass(Identifier identifier) {
        super(identifier);
    }

    @Override
    public ItemInstance use(ItemInstance item, Level level, PlayerBase player) {
        level.getBiomeSource().getBiome(player.chunkX, player.chunkZ);
        
        return item;
    }
}
