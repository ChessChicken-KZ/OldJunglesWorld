package kz.chesschicken.ojw.level;

import kz.chesschicken.ojw.init.OldJunglesWorldListener;
import net.minecraft.level.biome.Biome;

import java.util.Random;

public class BiomeSystem {
    private static final int AREA_GLOBAL = 4096;
    private static final int AREA_STEP = 1024;
    private static int AREA_TURN = 0;

    public static Biome getBiomeVariations(Biome biome, Random random)
    {
        if(biome == Biome.TUNDRA)
        {
            switch (getBiomeTurn())
            {
                case 0:
                case 2:
                    return OldJunglesWorldListener.vEverTundra;
                case 1:
                case 3:
                    return OldJunglesWorldListener.vSwampTundra;

                default: return Biome.TUNDRA;
            }
        }

        if(AREA_TURN <= AREA_GLOBAL)
            AREA_TURN++;
        return biome;
    }

    private static byte getBiomeTurn()
    {
        return (byte) (AREA_TURN/AREA_STEP);
    }

}
