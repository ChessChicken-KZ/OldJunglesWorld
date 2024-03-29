package kz.chesschicken.ojw.utils.structure;

import net.minecraft.block.BlockBase;
import net.minecraft.level.Level;
import net.minecraft.level.chunk.Chunk;

/**
 * Some great and fast alternatives to old methods, use with caution, some methods won't be called.
 */
public class WorldUtils {
    public static final short MAX_ID_VALUE = 255;

    public static void setBlockIfEmpty(Level level, int x, int y, int z, int id)
    {
        if(getID(level, x, y, z) == 0)
            setID(level, x, y, z, id);
    }

    public static int getMeta(Level level, int x, int y, int z)
    {
        Chunk chunk = level.getChunkFromCache(x >> 4, z >> 4);
        int coordinate = (x & 15) << 11 | y << 7 | (z & 15);
        //field_957 - META NIBBLE ARRAY!
        return (coordinate & 1) == 0 ? chunk.field_957.field_2103[coordinate >> 1] & 15 : chunk.field_957.field_2103[coordinate >> 1] >> 4 & 15;
    }

    public static int getID(Level level, int x, int y, int z)
    {
        if(y > 0 && y < 128)
            return level.getChunkFromCache(x >> 4, z >> 4).tiles[(x & 15) << 11 | (z & 15) << 7 | y] & MAX_ID_VALUE;
        return 0;
    }

    public static void setMeta(Level level, int x, int y, int z, int meta)
    {
        Chunk chunk = level.getChunkFromCache(x >> 4, z >> 4);
        x &= 15;
        z &= 15;

        chunk.field_967 = true;
        int coordinate = x << 11 | z << 7 | y;
        int q = coordinate >> 1;
        if ((coordinate & 1) == 0) {
            chunk.field_957.field_2103[q] = (byte)(chunk.field_957.field_2103[q] & 240 | meta & 15);
        } else {
            chunk.field_957.field_2103[q] = (byte)(chunk.field_957.field_2103[q] & 15 | (meta & 15) << 4);
        }
    }

    public static void setID(Level level, int x, int y, int z, int id) {
        setID(level, level.getChunkFromCache(x >> 4, z >> 4), false, x & 15, y, z & 15, id);
    }

    public static void setID(Level level, Chunk chunk, boolean any, int i, int j, int k, int id)
    {
        int prevID = chunk.tiles[i << 11 | k << 7 | j] & MAX_ID_VALUE;
        if (prevID == id) return;

        int ic_x = chunk.x * 16 + i;
        int ic_z = chunk.z * 16 + k;
        chunk.tiles[i << 11 | k << 7 | j] = (byte)((byte)id & MAX_ID_VALUE);
        if (prevID != 0 && any)
            BlockBase.BY_ID[prevID].onBlockRemoved(level, ic_x, j, ic_z);
        setMeta(level, i, j, k, 0);
        if (id != 0 && any)
            BlockBase.BY_ID[id].onBlockPlaced(chunk.level, ic_x, j, ic_z);
        chunk.field_967 = true;
    }

    public static void setIDandMeta(Level level, int x, int y, int z, int id, int meta)
    {
        setID(level, x, y, z, id);
        setMeta(level, x, y, z, meta);
    }

    public static void dangerousSetID(Level level, int x, int y, int z, int id)
    {
        Chunk chunk = level.getChunkFromCache(x >> 4, z >> 4);
        if ((chunk.tiles[x << 11 | z << 7 | y] & MAX_ID_VALUE) == id) return;
        chunk.tiles[x << 11 | z << 7 | y] = (byte)((byte)id & MAX_ID_VALUE);
        setMeta(level, x, y, z, 0);
    }

}
