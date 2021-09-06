package kz.chesschicken.ojw.block.wood;

import kz.chesschicken.ojw.init.OJWContentListener;
import net.minecraft.block.material.Material;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.block.BlockHardnessPerMeta;
import net.modificationstation.stationapi.api.block.HasMetaNamedBlockItem;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

@HasMetaNamedBlockItem
public class BlockLogComplex extends TemplateBlockBase implements BlockHardnessPerMeta {

    public BlockLogComplex(Identifier identifier) {
        super(identifier, Material.WOOD);
        this.setSounds(WOOD_SOUNDS);
        this.disableNotifyOnMetaDataChange();
    }

    @Override
    protected int droppedMeta(int meta) {
        return meta;
    }

    @Override
    public float getHardness(int i) {
        return (MetaWood.metadataCollection[i]).getHardnessAsLog();
    }

    @Override
    public int getTextureForSide(int side, int i) {
        if(side == 0 || side == 1)
            return (MetaWood.metadataCollection[i]).getLogTopTexture();
        return (MetaWood.metadataCollection[i]).getLogSideTexture();
    }

    @Override
    public void onBlockRemoved(Level level, int x, int y, int z) {
        if (level.method_155(x - 2, y - 2, z - 2, x + 2, y + 2, z + 2)) {
            for(int ix = -1; ix <= 1; ++ix) {
                for(int iy = -1; iy <= 1; ++iy) {
                    for(int iz = -1; iz <= 1; ++iz) {
                        if (level.getTileId(x + ix, y + iy, z + iz) == OJWContentListener.blockLeavesComplex.id) {
                            level.method_223(x + ix, y + iy, z + iz, level.getTileMeta(x + ix, y + iy, z + iz) | 8);
                        }
                    }
                }
            }
        }

    }
}
