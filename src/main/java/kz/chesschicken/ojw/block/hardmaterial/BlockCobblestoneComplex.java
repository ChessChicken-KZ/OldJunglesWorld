package kz.chesschicken.ojw.block.hardmaterial;

import kz.chesschicken.ojw.utils.metarefernce.objects.BlockSimpleMeta;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.block.HasMetaNamedBlockItem;
import net.modificationstation.stationapi.api.registry.Identifier;

import java.util.Random;

@HasMetaNamedBlockItem
public class BlockCobblestoneComplex extends BlockSimpleMeta {
    public BlockCobblestoneComplex(Identifier identifier) {
        super(identifier, Material.STONE, 4);
        this.setSounds(PISTON_SOUNDS);
    }

    @Override
    public int getTextureForSide(int side, int i) {
        return ((MetaRock)this.metadataCollection[i]).getCobblestoneTexture();
    }

    @Override
    public int getDropId(int i, Random rand) {
        return this.id;
    }

    @Override
    public float getHardness(int i) {
        return ((MetaRock)this.metadataCollection[i]).getHardnessAsCobblestone();
    }
}
