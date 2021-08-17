package kz.chesschicken.ojw.block.hardmaterial;

import kz.chesschicken.ojw.utils.metarefernce.objects.SimpleBlockWithMeta;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.common.block.HasMetaNamedBlockItem;
import net.modificationstation.stationapi.api.common.registry.Identifier;

@HasMetaNamedBlockItem
public class BlockCobblestoneComplex extends SimpleBlockWithMeta {
    public BlockCobblestoneComplex(Identifier identifier) {
        super(identifier, Material.STONE, 9);
        this.setSounds(PISTON_SOUNDS);
    }

    @Override
    public int getTextureForSide(int side, int i) {
        return ((MetaRock)this.metadataCollection[i]).getCobblestoneTexture();
    }

    @Override
    public float getHardness(int i) {
        return ((MetaRock)this.metadataCollection[i]).getHardnessAsCobblestone();
    }
}
