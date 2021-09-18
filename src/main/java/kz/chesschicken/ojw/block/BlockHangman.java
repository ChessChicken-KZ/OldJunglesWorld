package kz.chesschicken.ojw.block;

import kz.chesschicken.ojw.init.OJWTextureListener;
import net.minecraft.block.material.Material;
import net.minecraft.level.BlockView;
import net.modificationstation.stationapi.api.block.HasMetaNamedBlockItem;
import net.modificationstation.stationapi.api.client.model.BlockInventoryModelProvider;
import net.modificationstation.stationapi.api.client.model.BlockWorldModelProvider;
import net.modificationstation.stationapi.api.client.model.JsonModel;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

@HasMetaNamedBlockItem
public class BlockHangman extends TemplateBlockBase implements BlockInventoryModelProvider, BlockWorldModelProvider {
    public BlockHangman(Identifier identifier) {
        super(identifier, Material.WOOD);

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
                return OJWTextureListener.hangmanFirst;
            case 1:
                return OJWTextureListener.hangmanCenter;
            case 2:
                return OJWTextureListener.hangmanTop;
            case 3:
                return OJWTextureListener.hangmanEYE;

            default:
                return null;
        }
    }

    @Override
    public boolean isFullOpaque() {
        return false;
    }
}
