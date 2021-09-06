package kz.chesschicken.ojw.block.grass;

import kz.chesschicken.ojw.init.OJWContentListener;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.block.BlockHardnessPerMeta;
import net.modificationstation.stationapi.api.block.HasMetaNamedBlockItem;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

import java.util.Random;

@HasMetaNamedBlockItem
public class BlockGrassComplex extends TemplateBlockBase implements BlockHardnessPerMeta {
    public BlockGrassComplex(Identifier identifier) {
        super(identifier, Material.ORGANIC);
        this.setSounds(GRASS_SOUNDS);
    }

    @Override
    protected int droppedMeta(int meta) {
        return meta;
    }

    @Override
    public int getDropId(int meta, Random rand) {
        return OJWContentListener.blockDirtComplex.id;
    }

    @Override
    public float getHardness(int i) {
        return MetaGrass.metadataCollection[i].getHardnessAsGrass();
    }

    @Override
    public int getTextureForSide(int side, int i) {
        if(side == 1)
            return MetaGrass.metadataCollection[i].getGrassTopTexture();
        if(side == 0)
            return MetaGrass.metadataCollection[i].getDirtTexture();

        return MetaGrass.metadataCollection[i].getGrassSideTexture();
    }
}
