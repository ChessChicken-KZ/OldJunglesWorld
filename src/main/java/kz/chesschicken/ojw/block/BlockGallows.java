package kz.chesschicken.ojw.block;

import kz.chesschicken.ojw.init.OJWContainer;
import net.minecraft.block.material.Material;
import net.minecraft.level.BlockView;
import net.modificationstation.stationapi.api.block.HasMetaNamedBlockItem;
import net.modificationstation.stationapi.api.client.model.block.BlockInventoryModelProvider;
import net.modificationstation.stationapi.api.client.model.block.BlockWorldModelProvider;
import net.modificationstation.stationapi.api.client.model.json.JsonModel;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

@HasMetaNamedBlockItem
public class BlockGallows extends TemplateBlockBase implements BlockInventoryModelProvider, BlockWorldModelProvider {
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

}
