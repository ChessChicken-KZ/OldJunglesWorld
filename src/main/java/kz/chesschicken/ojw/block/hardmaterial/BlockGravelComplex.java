package kz.chesschicken.ojw.block.hardmaterial;

import kz.chesschicken.ojw.utils.metarefernce.objects.SimpleBlockWithMeta;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityBase;
import net.modificationstation.stationapi.api.common.block.HasMetaNamedBlockItem;
import net.modificationstation.stationapi.api.common.registry.Identifier;

@HasMetaNamedBlockItem
public class BlockGravelComplex extends SimpleBlockWithMeta {
    public BlockGravelComplex(Identifier identifier) {
        super(identifier, Material.SAND, 9);
    }

    @Override
    public int getTextureForSide(int side, int i) {
        return ((MetaRock)this.metadataCollection[i]).getGravelTexture();
    }

    @Override
    public float getHardness(int i) {
        return ((MetaRock)this.metadataCollection[i]).getHardnessAsGravel();
    }

    @Override
    public float getBlastResistance(EntityBase entityBase) {
        return this.resistance / 5.0F;
    }
}
