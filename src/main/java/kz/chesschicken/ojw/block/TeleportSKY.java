package kz.chesschicken.ojw.block;

import kz.chesschicken.ojw.init.OJWListener1;
import kz.chesschicken.ojw.utils.portalworks.OJW_class_467;
import net.minecraft.block.BlockBase;

public class TeleportSKY extends net.minecraft.class_467 implements OJW_class_467
{
    @Override
    public int getBLOCKPORTAL() {
        return OJWListener1.blockSkyPortal.id;
    }

    @Override
    public int getBlockOBSIDIAN() {
        return BlockBase.GLOWSTONE.id;
    }
}
