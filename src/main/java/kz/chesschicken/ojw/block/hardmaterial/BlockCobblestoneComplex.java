package kz.chesschicken.ojw.block.hardmaterial;

import kz.chesschicken.ojw.init.OJWContainer;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.block.BlockHardnessPerMeta;
import net.modificationstation.stationapi.api.block.HasMetaNamedBlockItem;
import net.modificationstation.stationapi.api.client.texture.atlas.Atlas;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

import java.util.Random;

@HasMetaNamedBlockItem
public class BlockCobblestoneComplex extends TemplateBlockBase implements BlockHardnessPerMeta {
    public BlockCobblestoneComplex(Identifier identifier) {
        super(identifier, Material.STONE);
        this.setSounds(PISTON_SOUNDS);
    }

    @Override
    protected int droppedMeta(int meta) {
        return meta;
    }

    @Override
    public int getTextureForSide(int side, int i) {
        return MetaRock.metadataCollection[i].getCobblestoneTexture();
    }

    @Override
    public int getDropId(int i, Random rand) {
        return this.id;
    }

    @Override
    public float getHardness(int i) {
        return MetaRock.metadataCollection[i].getHardnessAsCobblestone();
    }

    @Override
    public Atlas getAtlas() {
        return OJWContainer.ATLAS_TERRAIN;
    }
}
