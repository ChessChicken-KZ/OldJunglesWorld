package kz.chesschicken.ojw.block.grass;

import kz.chesschicken.ojw.utils.metarefernce.objects.BlockSimpleMeta;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.block.HasMetaNamedBlockItem;
import net.modificationstation.stationapi.api.registry.Identifier;

@HasMetaNamedBlockItem
public class BlockGrassComplex extends BlockSimpleMeta {
    public BlockGrassComplex(Identifier identifier) {
        super(identifier, Material.ORGANIC, 4);
        this.setSounds(GRASS_SOUNDS);
    }

    @Override
    public float getHardness(int i) {
        return ((MetaGrass)metadataCollection[i]).getHardnessAsGrass();
    }

    @Override
    public int getTextureForSide(int side, int i) {
        if(side == 1)
            return ((MetaGrass)metadataCollection[i]).getGrassTopTexture();
        if(side == 0)
            return ((MetaGrass)metadataCollection[i]).getDirtTexture();

        return ((MetaGrass)metadataCollection[i]).getGrassSideTexture();
    }
}
