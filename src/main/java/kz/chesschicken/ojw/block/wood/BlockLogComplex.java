package kz.chesschicken.ojw.block.wood;

import kz.chesschicken.ojw.utils.metarefernce.objects.BlockSimpleMeta;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.block.HasMetaNamedBlockItem;
import net.modificationstation.stationapi.api.registry.Identifier;

@HasMetaNamedBlockItem
public class BlockLogComplex extends BlockSimpleMeta {

    public BlockLogComplex(Identifier identifier) {
        super(identifier, Material.WOOD, 4);
        this.setSounds(WOOD_SOUNDS);
        this.disableNotifyOnMetaDataChange();
    }

    @Override
    public float getHardness(int i) {
        return ((MetaWood)this.metadataCollection[i]).getHardnessAsLog();
    }

    @Override
    public int getTextureForSide(int side, int i) {
        if(side == 0 || side == 1)
            return ((MetaWood)this.metadataCollection[i]).getLogTopTexture();
        return ((MetaWood)this.metadataCollection[i]).getLogSideTexture();
    }
}
