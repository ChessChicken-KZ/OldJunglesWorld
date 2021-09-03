package kz.chesschicken.ojw.block.grass;

import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.block.BlockHardnessPerMeta;
import net.modificationstation.stationapi.api.block.HasMetaNamedBlockItem;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

@HasMetaNamedBlockItem
public class BlockDirtComplex extends TemplateBlockBase implements BlockHardnessPerMeta {
    public BlockDirtComplex(Identifier identifier) {
        super(identifier, Material.DIRT);
        this.setSounds(GRAVEL_SOUNDS);
    }

    @Override
    public float getHardness(int i) {
        return MetaGrass.metadataCollection[i].getHardnessAsDirt();
    }

    @Override
    public int getTextureForSide(int side, int i) {
        return MetaGrass.metadataCollection[i].getDirtTexture();
    }
}
