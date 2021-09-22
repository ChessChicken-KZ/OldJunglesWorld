package kz.chesschicken.ojw.block.wood;

import kz.chesschicken.ojw.init.OJWContainer;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.block.BlockHardnessPerMeta;
import net.modificationstation.stationapi.api.block.HasMetaNamedBlockItem;
import net.modificationstation.stationapi.api.client.texture.atlas.Atlas;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

@HasMetaNamedBlockItem
public class BlockPlanksComplex extends TemplateBlockBase implements BlockHardnessPerMeta {
    public BlockPlanksComplex(Identifier identifier) {
        super(identifier, Material.WOOD);
        this.setSounds(WOOD_SOUNDS);
        this.disableNotifyOnMetaDataChange();
    }

    @Override
    protected int droppedMeta(int meta) {
        return meta;
    }

    @Override
    public float getHardness(int i) {
        return MetaWood.metadataCollection[i].getHardnessAsPlanks();
    }

    @Override
    public int getTextureForSide(int side, int i) {
        return MetaWood.metadataCollection[i].getPlanksTexture();
    }

    @Override
    public Atlas getAtlas() {
        return OJWContainer.ATLAS_TERRAIN;
    }
}
