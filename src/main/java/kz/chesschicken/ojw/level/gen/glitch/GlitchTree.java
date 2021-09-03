package kz.chesschicken.ojw.level.gen.glitch;

import kz.chesschicken.ojw.init.OJWContentListener;
import kz.chesschicken.ojw.utils.structure.LevelManipulationUtil;
import net.minecraft.level.Level;
import net.minecraft.level.structure.Structure;

import java.util.Random;

public class GlitchTree extends Structure {
    @Override
    public boolean generate(Level level, Random rand, int x, int y, int z) {
        if(level.canRainAt(x, y + 1, z))
        {
            int s = 8 + rand.nextInt(10);

            for(int i = 0; i < s; i++)
            {
                LevelManipulationUtil.fastPlaceIDuMeta(level, x, y - 1 + i, z, OJWContentListener.blockLogComplex.id, 1);
                if(i > 6)
                    genLeaves(level, rand, x, y - 1 + i, z);
            }

            return true;
        }

        return false;
    }

    private void genLeaves(Level level, Random random, int x, int y, int z)
    {
        int size = random.nextBoolean() ? 5 : random.nextBoolean() ? 3 : 0;
        for(int ix = 0; ix < size; ix++)
            for(int iz = 0; iz < size; iz++)
                LevelManipulationUtil.placeBlockIfEmpty(level, x - (size / 2) + ix, y, z - (size / 2) + iz, OJWContentListener.blockLeavesComplex.id);
    }
}
