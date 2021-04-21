package kz.chesschicken.ojw.block;

import kz.chesschicken.ojw.init.OldJunglesWorldListener;
import net.minecraft.block.BlockBase;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.common.registry.Identifier;
import net.modificationstation.stationapi.template.common.item.Seeds;

public class ItemSeedsMelon extends Seeds {
    public ItemSeedsMelon(Identifier identifier) {
        super(identifier, 1);
        setTexturePosition(OldJunglesWorldListener.texture_MelonTile[6]);
    }

    public boolean useOnTile(ItemInstance item, PlayerBase player, Level level, int x, int y, int z, int facing) {
        if (facing != 1) {
            return false;
        } else {
            int var8 = level.getTileId(x, y, z);
            if (var8 == BlockBase.FARMLAND.id && level.isAir(x, y + 1, z)) {
                level.setTile(x, y + 1, z, OldJunglesWorldListener.blockMelonSeedsTile.id);
                --item.count;
                return true;
            } else {
                return false;
            }
        }
    }
}
