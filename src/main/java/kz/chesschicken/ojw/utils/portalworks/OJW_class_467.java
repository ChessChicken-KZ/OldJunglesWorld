package kz.chesschicken.ojw.utils.portalworks;

import net.minecraft.block.BlockBase;

public interface OJW_class_467 {

    public default int getBlockOBSIDIAN()
    {
        return BlockBase.OBSIDIAN.id;
    }

    public default int getBLOCKPORTAL()
    {
        return BlockBase.PORTAL.id;
    }

}
