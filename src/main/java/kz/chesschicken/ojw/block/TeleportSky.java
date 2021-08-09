package kz.chesschicken.ojw.block;

import kz.chesschicken.ojw.init.OJWContentListener;
import kz.chesschicken.ojw.utils.portal.IBlockPortal;
import net.minecraft.block.BlockBase;

public class TeleportSky extends net.minecraft.class_467 implements IBlockPortal
{
    @Override
    public int getBlockPortal() {
        return OJWContentListener.blockSkyPortal.id;
    }

    @Override
    public int getBlockFrame() {
        return BlockBase.GLOWSTONE.id;
    }
}
