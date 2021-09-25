package kz.chesschicken.ojw.block;

import kz.chesschicken.ojw.item.ItemLightFlower;
import kz.chesschicken.ojw.utils.IHighGamma;
import net.minecraft.block.BlockBase;
import net.minecraft.block.material.Material;
import net.minecraft.level.Level;
import net.minecraft.util.maths.Box;
import net.modificationstation.stationapi.api.block.HasCustomBlockItemFactory;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

import java.util.Random;

@HasCustomBlockItemFactory(ItemLightFlower.class)
public class BlockLightFlower extends TemplateBlockBase implements IHighGamma {
    public BlockLightFlower(Identifier identifier) {
        super(identifier, Material.PLANT);
        this.setTicksRandomly(true);
        this.setBoundingBox(0.3F, 0.0F, 0.3F, 0.7F, 0.6F, 0.7F);
    }

    @Override
    public boolean canPlaceAt(Level level, int x, int y, int z) {
        return super.canPlaceAt(level, x, y, z) && (level.getTileId(x, y - 1, z) == BlockBase.GRASS.id || level.getTileId(x, y - 1, z) == BlockBase.DIRT.id || level.getTileId(x, y - 1, z) == BlockBase.FARMLAND.id);
    }

    @Override
    public void onAdjacentBlockUpdate(Level level, int x, int y, int z, int id) {
        super.onAdjacentBlockUpdate(level, x, y, z, id);
        this.breakIfIncorrect(level, x, y, z);
    }

    @Override
    public void onScheduledTick(Level level, int x, int y, int z, Random rand) {
        this.breakIfIncorrect(level, x, y, z);
    }

    protected final void breakIfIncorrect(Level arg, int x, int y, int z) {
        if (!this.canGrow(arg, x, y, z)) {
            this.drop(arg, x, y, z, arg.getTileMeta(x, y, z));
            arg.setTile(x, y, z, 0);
        }
    }

    @Override
    public Box getCollisionShape(Level level, int x, int y, int z) {
        return null;
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
