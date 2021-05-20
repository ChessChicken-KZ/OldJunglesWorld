package kz.chesschicken.ojw.init;

import kz.chesschicken.ojw.level.biome.*;
import kz.chesschicken.ojw.structure.PlantGroup;
import net.minecraft.level.biome.Biome;
import net.modificationstation.stationapi.api.common.event.EventListener;
import net.modificationstation.stationapi.api.common.event.level.biome.BiomeRegister;
import net.modificationstation.stationapi.api.common.event.level.gen.ChunkDecoration;

/**
 * Biomes, Generation, Dimensions
 */
public class OJWListener2 {
    public static Biome bBirchForest;
    public static Biome bConiferousForest;
    public static Biome bJungle;
    public static Biome cShrubland;
    public static Biome cSavanna;
    public static Biome cSwampland;

    @SuppressWarnings("unused")
    @EventListener
    public void registerBiome(BiomeRegister event)
    {
        bBirchForest = new BirchForest();
        bConiferousForest = new ConiferousForest();
        bJungle = new Jungle();
        cShrubland = new Shrubland();
        cSavanna = new Savanna();
        cSwampland = new Swampland();

    }

    @SuppressWarnings("unused")
    @EventListener
    public void registerGeneration(ChunkDecoration chunkDecoration)
    {
        if (chunkDecoration.random.nextInt(8) == 0 && chunkDecoration.biome == OJWListener2.bJungle) {
            int ix = chunkDecoration.x + chunkDecoration.random.nextInt(16) + 8;
            int iy = chunkDecoration.random.nextInt(128);
            int iz = chunkDecoration.z + chunkDecoration.random.nextInt(16) + 8;
            (new PlantGroup(OJWListener1.blockMelon.id)).generate(chunkDecoration.level, chunkDecoration.random, ix, iy, iz);
        }
    }
}
