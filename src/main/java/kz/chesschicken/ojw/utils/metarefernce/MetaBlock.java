package kz.chesschicken.ojw.utils.metarefernce;

import net.minecraft.block.BlockBase;
import net.minecraft.entity.EntityBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.minecraft.level.TileView;
import net.minecraft.util.maths.Vec3f;
import net.modificationstation.stationapi.api.common.item.tool.ToolLevel;

import java.util.List;
import java.util.Random;

public class MetaBlock extends MetaObject<BlockBase> {
    protected int objectID;

    public void setObjectID(int i) {
        this.objectID = i;
    }

    public MetaBlock(int i) {
        super(i);
    }

    @Override
    public String getName() {
        return BlockBase.BY_ID[objectID].getTranslatedName();
    }

    @Override
    public Class<BlockBase> getObjectClass() {
        return BlockBase.class;
    }

    public int getDropMetadata() {
        return this.metadata;
    }

    public int getDropID(Random random) {
        return BlockBase.BY_ID[objectID].getDropId(this.metadata, random);
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

    public float getToolEffectivness(ItemInstance itemInstance)
    {
        return 0;
    }

    public int getBlockMiningLevel(ItemInstance itemInstance)
    {
        return 0;
    }

    public List<Class<? extends ToolLevel>> getToolTypes(ItemInstance itemInstance)
    {
        return null;
    }

    public int getColorMultiplier(TileView tileView, int x, int y, int z) {
        return BlockBase.BY_ID[objectID].getColourMultiplier(tileView, x, y, z);
    }

    public float getBrightness(TileView tileView, int x, int y, int z) {
        return BlockBase.BY_ID[objectID].getBrightness(tileView, x, y, z);
    }

    public void onCollideWithEntity(Level level, int x, int y, int z, EntityBase entityBase, Vec3f vec3f) {
        BlockBase.BY_ID[objectID].onCollideWithEntity(level, x, y, z, entityBase, vec3f);
    }

    public void onEntityCollision(Level level, int x, int y, int z, EntityBase entityBase) {
        BlockBase.BY_ID[objectID].onEntityCollision(level, x, y, z, entityBase);
    }
}
