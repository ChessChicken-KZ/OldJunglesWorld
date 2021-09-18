package kz.chesschicken.ojw.block;

import kz.chesschicken.ojw.utils.extendedblocks.DifferentStairsBase;
import kz.chesschicken.ojw.utils.itemhelper.ProvideCustomMetaNames;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.block.HasMetaNamedBlockItem;
import net.modificationstation.stationapi.api.registry.Identifier;

@HasMetaNamedBlockItem
@ProvideCustomMetaNames
public class StairsWool extends DifferentStairsBase {

    public StairsWool(Identifier identifier) {
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
