package kz.chesschicken.ojw.block;

import kz.chesschicken.ojw.init.OJWTextureListener;
import net.minecraft.block.material.Material;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.client.model.BlockModelProvider;
import net.modificationstation.stationapi.api.client.model.CustomModel;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

import java.util.Random;

public class BlockSpawnerExtended extends TemplateBlockBase /* implements BlockModelProvider */ {
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

    /*
    @Override
    public CustomModel getCustomWorldModel(Level level, int x, int y, int z, int meta) {
        return OJWTextureListener.spawnerExtended;
    }

    @Override
    public CustomModel getCustomInventoryModel(int meta) {
        return OJWTextureListener.spawnerExtended;
    }

     */
}
