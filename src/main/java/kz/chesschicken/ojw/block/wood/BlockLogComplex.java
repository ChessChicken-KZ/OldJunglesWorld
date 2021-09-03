package kz.chesschicken.ojw.block.wood;

import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.block.BlockHardnessPerMeta;
import net.modificationstation.stationapi.api.block.HasMetaNamedBlockItem;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

@HasMetaNamedBlockItem
public class BlockLogComplex extends TemplateBlockBase implements BlockHardnessPerMeta {

    public BlockLogComplex(Identifier identifier) {
        super(identifier, Material.WOOD);
        this.setSounds(WOOD_SOUNDS);
        this.disableNotifyOnMetaDataChange();
    }

    @Override
    public float getHardness(int i) {
        return (MetaWood.metadataCollection[i]).getHardnessAsLog();
    }

    @Override
    public int getTextureForSide(int side, int i) {
        if(side == 0 || side == 1)
            return (MetaWood.metadataCollection[i]).getLogTopTexture();
        return (MetaWood.metadataCollection[i]).getLogSideTexture();
    }
}
