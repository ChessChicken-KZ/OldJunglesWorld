package kz.chesschicken.ojw.block;

import kz.chesschicken.ojw.utils.client.IHighGamma;
import kz.chesschicken.ojw.utils.extendedblocks.SimpleStairs;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.block.HasMetaNamedBlockItem;
import net.modificationstation.stationapi.api.registry.Identifier;

@HasMetaNamedBlockItem
public class BlockStairsWool extends SimpleStairs implements IHighGamma {

    public BlockStairsWool(Identifier identifier) {
        super(identifier, Material.WOOL);
    }

    @Override
    protected int droppedMeta(int meta) {
        return meta / 3;
    }

    @Override
    public int getTextureForSide(int side, int meta) {
        return WOOL.getTextureForSide(side, 0);
    }
}
