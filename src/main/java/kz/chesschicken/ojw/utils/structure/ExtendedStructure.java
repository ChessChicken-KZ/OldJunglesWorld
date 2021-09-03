package kz.chesschicken.ojw.utils.structure;

import net.minecraft.block.BlockBase;
import net.minecraft.level.Level;
import net.minecraft.level.chunk.Chunk;
import net.minecraft.level.structure.Structure;

/**
 * Some great and fast alternatives to old methods, use with caution. Especially when your block needs {@link BlockBase#onBlockPlaced(Level, int, int, int)} method.
 */
public abstract class ExtendedStructure extends Structure {

    public void placeBlockIfEmpty(Level level, int x, int y, int z, int id)
    {
        if(fastGetID(level, x, y, z) == 0)
            fastPlaceID(level, x, y, z, id);
    }

    public int fastGetMeta(Level level, int x, int y, int z)
    {
        Chunk chunk = level.getChunkFromCache(x >> 4, z >> 4);
        x &= 15;
        z &= 15;
        int coordinate = x << 11 | y << 7 | z;
        //field_957 - META NIBBLE ARRAY!
        return (coordinate & 1) == 0 ? chunk.field_957.field_2103[coordinate >> 1] & 15 : chunk.field_957.field_2103[coordinate >> 1] >> 4 & 15;
    }

    public int fastGetID(Level level, int x, int y, int z)
    {
        if(y > 0 && y < 128)
            return level.getChunkFromCache(x >> 4, z >> 4).tiles[x << 11 | z << 7 | y] & 255;
        return 0;
    }

    public void fastPlaceMeta(Level level, int x, int y, int z, int meta)
    {
        Chunk chunk = level.getChunkFromCache(x >> 4, z >> 4);
        x &= 15;
        z &= 15;

        chunk.field_967 = true;
        int coordinate = x << 11 | y << 7 | z;
        int lookup = coordinate >> 1;

        //omg, someone pls pull request to BIN-Mappings with normal array names.
        chunk.field_957.field_2103[lookup] = (coordinate & 1) == 0 ?
                (byte)(chunk.field_957.field_2103[lookup] & 240 | meta & 15) :
                (byte)(chunk.field_957.field_2103[lookup] & 15 | (meta & 15) << 4);
    }

    public void fastPlaceID(Level level, int x, int y, int z, int id) {
        fastPlaceID(level, level.getChunkFromCache(x >> 4, z >> 4), false, x & 15, y, z & 15, id);
    }

    public void fastPlaceID(Level level, Chunk chunk, boolean any, int i, int j, int k, int id)
    {
        int prevID = chunk.tiles[i << 11 | k << 7 | j] & 255;
        if (prevID == id)
            return;

        int ic_x = chunk.x * 16 + i;
        int ic_z = chunk.z * 16 + k;
        chunk.tiles[i << 11 | k << 7 | j] = (byte)((byte)id & 255);
        if (prevID != 0 && any) {
            BlockBase.BY_ID[prevID].onBlockRemoved(level, ic_x, j, ic_z);
        }

        chunk.field_957.method_1704(i, j, k, 0);

        if (id != 0 && any) {
            BlockBase.BY_ID[id].onBlockPlaced(chunk.level, ic_x, j, ic_z);
        }

        chunk.field_967 = true;
    }

    public void fastPlaceIDuMeta(Level level, int x, int y, int z, int id, int meta)
    {
        fastPlaceID(level, x, y, z, id);
        fastPlaceMeta(level, x, y, z, meta);
    }


}
