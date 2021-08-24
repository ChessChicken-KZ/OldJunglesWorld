package kz.chesschicken.ojw.utils.metarefernce;

import net.minecraft.block.BlockBase;
import net.minecraft.entity.EntityBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.BlockView;
import net.minecraft.level.Level;
import net.minecraft.util.maths.Vec3f;
import net.modificationstation.stationapi.api.item.tool.ToolLevel;

import java.util.List;
import java.util.Random;

public class MetaBlock extends MetaObject<BlockBase> {

    public MetaBlock(int i) {
        super(i);
    }

    @Override
    public Class<BlockBase> getObjectClass() {
        return BlockBase.class;
    }

    public int getDropMetadata() {
        return this.metadata;
    }

    public int getDropID(Random random) {
        return this.objectID;
    }

    public int getDropCount(Random random) {
        return BlockBase.BY_ID[objectID].getDropCount(random);
    }

    public float getHardness() {
        return BlockBase.BY_ID[objectID].getHardness();
    }

    public float getResistance(EntityBase entityBase) {
        return BlockBase.BY_ID[objectID].getBlastResistance(entityBase);
    }

    public int getTextureSide(int side) {
        return BlockBase.BY_ID[objectID].getTextureForSide(side);
    }

    public float getToolEffectiveness(ItemInstance itemInstance) {
        return 0;
    }

    public int getBlockMiningLevel(ItemInstance itemInstance) {
        return 0;
    }

    public List<Class<? extends ToolLevel>> getToolTypes(ItemInstance itemInstance) {
        return null;
    }

    public int getColorMultiplier(BlockView tileView, int x, int y, int z) {
        return 16777215;
    }

    public float getBrightness(BlockView tileView, int x, int y, int z) {
        return tileView.method_1784(x, y, z, BlockBase.EMITTANCE[this.objectID]);
    }

    public void onCollideWithEntity(Level level, int x, int y, int z, EntityBase entityBase, Vec3f vec3f) {
    }

    public void onEntityCollision(Level level, int x, int y, int z, EntityBase entityBase) {
    }

    public void onBlockPlaced(Level level, int x, int y, int z, int facing) {
    }
}
