package kz.chesschicken.ojw.block.hardmaterial;

import kz.chesschicken.ojw.init.OJWContentListener;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.block.BlockHardnessPerMeta;
import net.modificationstation.stationapi.api.block.HasMetaNamedBlockItem;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

import java.util.Random;

@HasMetaNamedBlockItem
public class BlockStoneComplex extends TemplateBlockBase implements BlockHardnessPerMeta {
    public BlockStoneComplex(Identifier identifier) {
        super(identifier, Material.STONE);
        this.setSounds(PISTON_SOUNDS);
    }

    @Override
    public int getDropId(int i, Random rand) {
        return OJWContentListener.blockCobblestoneComplex.id;
    }

    @Override
    public float getHardness(int i) {
        return MetaRock.metadataCollection[i].getHardnessAsStone();
    }

    @Override
    public int getTextureForSide(int side, int i) {
        return MetaRock.metadataCollection[i].getStoneTexture();
    }
}
