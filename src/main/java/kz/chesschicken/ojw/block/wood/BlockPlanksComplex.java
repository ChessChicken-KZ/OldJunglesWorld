package kz.chesschicken.ojw.block.wood;

import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.block.BlockHardnessPerMeta;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

public class BlockPlanksComplex extends TemplateBlockBase implements BlockHardnessPerMeta {
    public BlockPlanksComplex(Identifier identifier) {
        super(identifier, Material.WOOD);
        this.setSounds(WOOD_SOUNDS);
        this.disableNotifyOnMetaDataChange();
    }

    @Override
    public float getHardness(int i) {
        return MetaWood.metadataCollection[i].getHardnessAsPlanks();
    }

    @Override
    public int getTextureForSide(int side, int i) {
        return MetaWood.metadataCollection[i].getPlanksTexture();
    }
}
