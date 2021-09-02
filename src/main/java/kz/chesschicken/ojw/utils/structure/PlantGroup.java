package kz.chesschicken.ojw.utils.structure;

import net.minecraft.block.BlockBase;
import net.minecraft.level.Level;
import net.minecraft.level.structure.Structure;

import java.util.Random;

public class PlantGroup extends Structure {
    private final int id;
    private final int meta;

    /**
     * The flower generator. Supports block metadata.
     * @param a Block ID.
     * @param b Metadata.
     */
    public PlantGroup(int a, int b) {
        this.id = a;
        this.meta = b;
    }

    /**
     * The flower generator. For per meta generation use construction {@link PlantGroup#PlantGroup(int, int)}
     * @param i Block ID.
     */
    public PlantGroup(int i) {
        this(i, 0);
    }

    public boolean generate(Level level, Random rand, int x, int y, int z) {
        for(int i = 0; i < 32; ++i) {

            int ix = x + rand.nextInt(8) - rand.nextInt(8);
            int iy = y + rand.nextInt(4) - rand.nextInt(4);
            int iz = z + rand.nextInt(8) - rand.nextInt(8);

            if(BlockBase.BY_ID[this.id] instanceof ISpecificGenRequest && ((ISpecificGenRequest)BlockBase.BY_ID[this.id]).canBePlantedHere(level, x, y, z))
                level.setTileWithMetadata(ix, iy, iz, id, meta);
            else if (level.isAir(ix, iy, iz) && level.getTileId(ix, iy - 1, iz) == BlockBase.GRASS.id && BlockBase.BY_ID[this.id].canPlaceAt(level, ix, iy, iz))
                level.setTileWithMetadata(ix, iy, iz, id, meta);

        }

        return true;
    }

}
