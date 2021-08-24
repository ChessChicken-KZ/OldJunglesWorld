package kz.chesschicken.ojw.block.hardmaterial;

import kz.chesschicken.ojw.init.OJWContentListener;
import kz.chesschicken.ojw.utils.metarefernce.objects.BlockSimpleMeta;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.block.HasMetaNamedBlockItem;
import net.modificationstation.stationapi.api.registry.Identifier;

import java.util.Random;

@HasMetaNamedBlockItem
public class BlockStoneComplex extends BlockSimpleMeta {
    public BlockStoneComplex(Identifier identifier) {
        super(identifier, Material.STONE, 4);
        this.setSounds(PISTON_SOUNDS);
    }

    @Override
    public int getDropId(int i, Random rand) {
        return OJWContentListener.blockCobblestoneComplex.id;
    }

    @Override
    public float getHardness(int i) {
        return ((MetaRock)metadataCollection[i]).getHardnessAsStone();
    }

    @Override
    public int getTextureForSide(int side, int i) {
        return ((MetaRock)this.metadataCollection[i]).getStoneTexture();
    }
}
