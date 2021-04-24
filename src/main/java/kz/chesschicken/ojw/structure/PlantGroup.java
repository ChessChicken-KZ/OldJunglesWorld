package kz.chesschicken.ojw.structure;

import kz.chesschicken.ojw.init.OldJunglesWorldListener;
import net.minecraft.block.BlockBase;
import net.minecraft.level.Level;
import net.minecraft.level.structure.Structure;

import java.util.Random;

public class PlantGroup extends Structure {
    private final int id;

    public PlantGroup(int i)
    {
        this.id = i;
    }

    public boolean generate(Level level, Random rand, int x, int y, int z) {
        for(int tempVar = 0; tempVar < 32; ++tempVar) {
            int ix = x + rand.nextInt(8) - rand.nextInt(8);
            int iy = y + rand.nextInt(4) - rand.nextInt(4);
            int iz = z + rand.nextInt(8) - rand.nextInt(8);

            if (level.isAir(ix, iy, iz) && level.getTileId(ix, iy - 1, iz) == BlockBase.GRASS.id && OldJunglesWorldListener.blockMelon.canPlaceAt(level, ix, iy, iz))
                level.setTile(ix, iy, iz, id);

        }

        return true;
    }
}
