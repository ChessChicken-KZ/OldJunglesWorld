package kz.chesschicken.ojw.block;

import kz.chesschicken.ojw.init.OJWContainer;
import kz.chesschicken.ojw.item.ItemCandle;
import kz.chesschicken.ojw.utils.extendedblocks.CustomBoundingBoxPerMeta;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.material.Material;
import net.minecraft.level.BlockView;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.block.HasCustomBlockItemFactory;
import net.modificationstation.stationapi.api.client.model.BlockWorldModelProvider;
import net.modificationstation.stationapi.api.client.model.JsonModel;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

import java.util.Random;

@HasCustomBlockItemFactory(ItemCandle.class)
public class BlockCandle extends TemplateBlockBase implements BlockWorldModelProvider, CustomBoundingBoxPerMeta {
    public BlockCandle(Identifier identifier) {
        super(identifier, Material.WOOL);
        this.setHardness(0.0F);
        this.setLightEmittance(0.9375F);
        this.setSounds(WOOD_SOUNDS);
        this.disableNotifyOnMetaDataChange();
    }

    @Override
    public float[] getBoundingBoxes(int meta) {
        return new float[] {
                0.41F, 0.0F, 0.41F, 0.59F, 0.65F, 0.59F
        };
    }

    @Override
    public JsonModel getCustomWorldModel(BlockView blockView, int x, int y, int z) {
        switch (blockView.getTileMeta(x, y, z)) {
            case 0:
                return OJWContainer.candleSINGLE;

            default:
                return null;
        }
    }



    @Environment(EnvType.CLIENT)
    public void randomDisplayTick(Level level, int x, int y, int z, Random rand) {
        double rX = (float)x + 0.5F;
        double rY = (float)y + 0.9F;
        double rZ = (float)z + 0.5F;
        level.addParticle("smoke", rX, rY, rZ, 0.0D, 0.0D, 0.0D);
        level.addParticle("flame", rX, rY, rZ, 0.0D, 0.0D, 0.0D);
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
