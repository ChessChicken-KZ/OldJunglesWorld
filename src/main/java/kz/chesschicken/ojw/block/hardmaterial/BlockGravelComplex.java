package kz.chesschicken.ojw.block.hardmaterial;

import kz.chesschicken.ojw.utils.metarefernce.objects.BlockSimpleMeta;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityBase;
import net.modificationstation.stationapi.api.block.HasMetaNamedBlockItem;
import net.modificationstation.stationapi.api.registry.Identifier;

import java.util.Random;

@HasMetaNamedBlockItem
public class BlockGravelComplex extends BlockSimpleMeta {
    public BlockGravelComplex(Identifier identifier) {
        super(identifier, Material.SAND, 4);
        this.setSounds(GRAVEL_SOUNDS);
    }

    @Override
    public int getTextureForSide(int side, int i) {
        return ((MetaRock)this.metadataCollection[i]).getGravelTexture();
    }

    @Override
    public int getDropId(int i, Random rand) {
        return this.id;
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
