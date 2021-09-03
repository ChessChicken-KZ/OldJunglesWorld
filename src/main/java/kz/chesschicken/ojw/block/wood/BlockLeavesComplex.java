package kz.chesschicken.ojw.block.wood;

import kz.chesschicken.ojw.init.OJWContentListener;
import kz.chesschicken.ojw.utils.structure.LevelManipulationUtil;
import net.minecraft.block.material.Material;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.block.HasMetaNamedBlockItem;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

import java.util.Random;

@HasMetaNamedBlockItem
public class BlockLeavesComplex extends TemplateBlockBase {
    public BlockLeavesComplex(Identifier i) {
        super(i, Material.LEAVES);
        this.setTicksRandomly(true);
        this.disableNotifyOnMetaDataChange();
        this.disableStat();
    }

    @Override
    public int getTextureForSide(int side, int meta) {
        return MetaWood.metadataCollection[meta].getLeavesTexture();
    }

    @Override
    public void onScheduledTick(Level level, int x, int y, int z, Random rand) {
        int a = LevelManipulationUtil.fastGetMeta(level, x, y, z);

        if(     !isLeavesAttached(level, a, x + 1, y, z) ||
                !isLeavesAttached(level, a, x - 1, y, z) ||
                !isLeavesAttached(level, a, x, y, z + 1) ||
                !isLeavesAttached(level, a, x, y, z - 1) ||
                !isLeavesAttached(level, a, x, y + 1, z) ||
                !isLeavesAttached(level, a, x, y - 1, z))
        {
            LevelManipulationUtil.fastPlaceID(level, x, y, z, 0);
            this.onBlockRemoved(level, x, y, z);
        }
    }

    public boolean isLeavesAttached(Level level, int curMeta, int x, int y, int z)
    {
        if(LevelManipulationUtil.fastGetID(level, x, y, z) == this.id && LevelManipulationUtil.fastGetMeta(level, x, y, z) == curMeta)
            return ((BlockLeavesComplex)OJWContentListener.blockLeavesComplex).isLeavesAttached(level, curMeta, x, y, z);

        return LevelManipulationUtil.fastGetID(level, x, y, z) == OJWContentListener.blockLogComplex.id && LevelManipulationUtil.fastGetMeta(level, x, y, z) == curMeta;
    }
}
