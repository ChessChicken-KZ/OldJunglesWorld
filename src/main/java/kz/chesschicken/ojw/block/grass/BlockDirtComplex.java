package kz.chesschicken.ojw.block.grass;

import kz.chesschicken.ojw.utils.metarefernce.objects.SimpleBlockWithMeta;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.common.block.HasMetaNamedBlockItem;
import net.modificationstation.stationapi.api.common.registry.Identifier;

@HasMetaNamedBlockItem
public class BlockDirtComplex extends SimpleBlockWithMeta {
    public BlockDirtComplex(Identifier identifier) {
        super(identifier, Material.DIRT, 9);
        this.setSounds(GRAVEL_SOUNDS);
    }

    @Override
    public float getHardness(int i) {
        return ((MetaGrass)metadataCollection[i]).getHardnessAsDirt();
    }

    @Override
    public int getTextureForSide(int side, int i) {
        return ((MetaGrass)metadataCollection[i]).getDirtTexture();
    }
}