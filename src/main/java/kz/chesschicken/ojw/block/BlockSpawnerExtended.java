package kz.chesschicken.ojw.block;

import kz.chesschicken.ojw.init.OJWTextureListener;
import net.minecraft.block.material.Material;
import net.minecraft.level.BlockView;
import net.modificationstation.stationapi.api.client.model.BlockInventoryModelProvider;
import net.modificationstation.stationapi.api.client.model.BlockWorldModelProvider;
import net.modificationstation.stationapi.api.client.model.JsonModel;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

import java.util.Random;

public class BlockSpawnerExtended extends TemplateBlockBase implements BlockInventoryModelProvider, BlockWorldModelProvider {
    public BlockSpawnerExtended(Identifier identifier) {
        super(identifier, Material.STONE);
        this.setHardness(5.0F);
        this.setSounds(METAL_SOUNDS);
        this.disableStat();
    }

    public int getDropId(int meta, Random rand) {
        return 0;
    }

    public int getDropCount(Random rand) {
        return 0;
    }

    public boolean isFullOpaque() {
        return false;
    }


    @Override
    public JsonModel getCustomWorldModel(BlockView level, int x, int y, int z) {
        return OJWTextureListener.spawnerExtended;
    }

    @Override
    public JsonModel getInventoryModel(int meta) {
        return OJWTextureListener.spawnerExtended;
    }


}
