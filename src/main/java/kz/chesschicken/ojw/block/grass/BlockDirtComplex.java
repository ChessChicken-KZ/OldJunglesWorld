package kz.chesschicken.ojw.block.grass;

import kz.chesschicken.ojw.utils.metarefernce.objects.BlockSimpleMeta;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.block.HasMetaNamedBlockItem;
import net.modificationstation.stationapi.api.registry.Identifier;

@HasMetaNamedBlockItem
public class BlockDirtComplex extends BlockSimpleMeta {
    public BlockDirtComplex(Identifier identifier) {
        super(identifier, Material.DIRT, 3);
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
