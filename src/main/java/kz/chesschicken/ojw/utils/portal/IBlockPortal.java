package kz.chesschicken.ojw.utils.portal;

import net.minecraft.block.BlockBase;

public interface IBlockPortal {

    public default int getBlockFrame()
    {
        return BlockBase.OBSIDIAN.id;
    }

    public default int getBlockPortal()
    {
        return BlockBase.PORTAL.id;
    }

}
