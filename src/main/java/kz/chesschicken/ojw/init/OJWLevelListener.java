package kz.chesschicken.ojw.init;

import kz.chesschicken.ojw.level.biome.overworld.*;
import kz.chesschicken.ojw.level.structure.PlantGroup;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.level.biome.Biome;
import net.modificationstation.stationapi.api.event.level.biome.BiomeRegisterEvent;
import net.modificationstation.stationapi.api.event.level.gen.LevelGenEvent;

/**
 * Biomes, Generation, Dimensions
 */
public class OJWLevelListener {
    public static Biome bBirchForest;
    public static Biome bConiferousForest;
    public static Biome bJungle;
    public static Biome cShrubland;
    public static Biome cSavanna;
    public static Biome cSwampland;

    @SuppressWarnings("unused")
    @EventListener
    public void registerBiome(BiomeRegisterEvent event)
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
    public void registerGeneration(LevelGenEvent.ChunkDecoration chunkDecoration)
    {
        if (chunkDecoration.random.nextInt(8) == 0 && chunkDecoration.biome == OJWLevelListener.bJungle) {
            int ix = chunkDecoration.x + chunkDecoration.random.nextInt(16) + 8;
            int iy = chunkDecoration.random.nextInt(128);
            int iz = chunkDecoration.z + chunkDecoration.random.nextInt(16) + 8;
            (new PlantGroup(OJWContentListener.blockMelon.id, 0)).generate(chunkDecoration.level, chunkDecoration.random, ix, iy, iz);
        }
    }
}
