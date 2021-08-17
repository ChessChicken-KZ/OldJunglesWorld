package kz.chesschicken.ojw.utils.metarefernce.objects;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityBase;
import net.minecraft.level.Level;
import net.minecraft.level.TileView;
import net.minecraft.util.maths.Vec3f;
import net.modificationstation.stationapi.api.common.block.*;
import net.modificationstation.stationapi.api.common.registry.Identifier;

@HasMetaNamedBlockItem
public class BlockWithMeta extends SimpleBlockWithMeta
{

    @SuppressWarnings("unused")
    public BlockWithMeta(Identifier identifier, Material material, int capacity) {
        super(identifier, material, capacity);
    }

    @Override
    public int getColourMultiplier(TileView tileView, int x, int y, int z) {
        int meta = tileView.getTileMeta(x, y, z);
        return metadataCollection[meta].getColorMultiplier(tileView, x, y, z);
    }

    @Override
    public float getBrightness(TileView tileView, int x, int y, int z) {
        int meta = tileView.getTileMeta(x, y, z);
        return metadataCollection[meta].getBrightness(tileView, x, y, z);
    }

    @Override
    public void onCollideWithEntity(Level level, int x, int y, int z, EntityBase entityBase, Vec3f vec3f) {
        int meta = level.getTileMeta(x, y, z);
        metadataCollection[meta].onCollideWithEntity(level, x, y, z, entityBase, vec3f);
    }

    @Override
    public void onEntityCollision(Level level, int x, int y, int z, EntityBase entityBase) {
        int meta = level.getTileMeta(x, y, z);
        metadataCollection[meta].onEntityCollision(level, x, y, z, entityBase);
    }
}
