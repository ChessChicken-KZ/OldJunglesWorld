package kz.chesschicken.ojw.utils.extendedblocks;

import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;

public interface IBlockBoneMeal {
    boolean canBoneMealBlock(Level level, PlayerBase playerBase, ItemInstance itemInstance, int x, int y, int z);

    void doGrowing(Level arg, PlayerBase player, ItemInstance item, int x, int y, int z);
}
