package kz.chesschicken.ojw.block.wood;

import kz.chesschicken.ojw.utils.metarefernce.objects.BlockSimpleMeta;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.registry.Identifier;

public class BlockPlanksComplex extends BlockSimpleMeta {
    public BlockPlanksComplex(Identifier identifier) {
        super(identifier, Material.WOOD, 4);
        this.setSounds(WOOD_SOUNDS);
        this.disableNotifyOnMetaDataChange();
    }

    @Override
    public float getHardness(int i) {
        return ((MetaWood)this.metadataCollection[i]).getHardnessAsPlanks();
    }

    @Override
    public int getTextureForSide(int side, int i) {
        return ((MetaWood)this.metadataCollection[i]).getPlanksTexture();
    }
}
