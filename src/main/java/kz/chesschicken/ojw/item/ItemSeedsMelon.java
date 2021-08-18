package kz.chesschicken.ojw.item;

import kz.chesschicken.ojw.init.OJWContentListener;
import kz.chesschicken.ojw.init.OJWTextureListener;
import net.minecraft.block.BlockBase;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.item.TemplateSeeds;

/**
 * Melon seeds.
 */
public class ItemSeedsMelon extends TemplateSeeds {
    public ItemSeedsMelon(Identifier identifier) {
        super(identifier, 1);
        setTexturePosition(OJWTextureListener.textureMelonCrop[6]);
    }

    public boolean useOnTile(ItemInstance item, PlayerBase player, Level level, int x, int y, int z, int facing) {
        if (facing != 1) {
            return false;
        } else {
            int var8 = level.getTileId(x, y, z);
            if (var8 == BlockBase.FARMLAND.id && level.isAir(x, y + 1, z)) {
                level.setTile(x, y + 1, z, OJWContentListener.blockMelonSeedsTile.id);
                --item.count;
                return true;
            } else {
                return false;
            }
        }
    }
}
