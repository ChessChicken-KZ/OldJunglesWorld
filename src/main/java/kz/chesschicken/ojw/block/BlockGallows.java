package kz.chesschicken.ojw.block;

import kz.chesschicken.ojw.init.OJWContainer;
import kz.chesschicken.ojw.utils.extendedblocks.CustomBoundingBoxPerMeta;
import net.minecraft.block.material.Material;
import net.minecraft.level.BlockView;
import net.modificationstation.stationapi.api.block.HasMetaNamedBlockItem;
import net.modificationstation.stationapi.api.client.model.BlockInventoryModelProvider;
import net.modificationstation.stationapi.api.client.model.BlockWorldModelProvider;
import net.modificationstation.stationapi.api.client.model.JsonModel;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

@HasMetaNamedBlockItem
public class BlockGallows extends TemplateBlockBase implements BlockInventoryModelProvider, BlockWorldModelProvider, CustomBoundingBoxPerMeta {
    public BlockGallows(Identifier identifier) {
        super(identifier, Material.WOOD);
        this.disableNotifyOnMetaDataChange();
    }

    @Override
    protected int droppedMeta(int meta) {
        return meta;
    }

    @Override
    public JsonModel getInventoryModel(int meta) {
        return getJson(meta);
    }

    @Override
    public JsonModel getCustomWorldModel(BlockView blockView, int x, int y, int z) {
        return getJson(blockView.getTileMeta(x, y, z));
    }

    private JsonModel getJson(int i)
    {
        switch (i)
        {
            case 0:
                return OJWContainer.gallowsFirst;
            case 1:
                return OJWContainer.gallowsCenter;
            case 2:
                return OJWContainer.gallowsTop;
            case 3:
                return OJWContainer.gallowsEYE;

            default:
                return null;
        }
    }

    @Override
    public boolean isFullOpaque() {
        return false;
    }

    @Override
    public boolean isFullCube() {
        return false;
    }

    @Override
    public float[] getBoundingBoxes(int meta) {
        switch (meta) {

            case 3:
                return new float[] {
                        0.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F
                };

            case 2:
                return new float[] {
                        -1.0F, 0.0F, 0.0F, 2.0F, 1.0F, 1.0F
                };

            default:
                return new float[] {
                        0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F
                };
        }
    }
}
