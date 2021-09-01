package kz.chesschicken.ojw.init;

import kz.chesschicken.biomesystem.common.biomes.ExtendedBiome;
import kz.chesschicken.biomesystem.common.event.ExtendedBiomeRegisterEvent;
import kz.chesschicken.ojw.level.biome.overworld.*;
import kz.chesschicken.ojw.level.structure.PlantGroup;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.level.biome.Biome;
import net.modificationstation.stationapi.api.event.level.biome.BiomeRegisterEvent;
import net.modificationstation.stationapi.api.event.level.gen.LevelGenEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.registry.ModID;
import net.modificationstation.stationapi.api.util.Null;

/**
 * Biomes, Generation, Dimensions
 */
public class OJWLevelListener {
    public static ExtendedBiome bBirchForest;
    public static ExtendedBiome bConiferousForest;
    public static ExtendedBiome bJungle;
    public static ExtendedBiome cShrubland;
    public static ExtendedBiome cSavanna;
    public static ExtendedBiome cSwampland;

    @Entrypoint.ModID
    public static ModID modID = Null.get();

    @SuppressWarnings("unused")
    @EventListener
    public void registerBiome(ExtendedBiomeRegisterEvent event)
    {
        event.register(Identifier.of(modID, "birch_forest"), bBirchForest = new BirchForest());
        event.register(Identifier.of(modID, "coniferous_forest"), bConiferousForest = new ConiferousForest());
        event.register(Identifier.of(modID, "jungle"), bJungle = new Jungle());
        event.register(Identifier.of(modID, "shrubland"), cShrubland = new Shrubland());
        event.register(Identifier.of(modID, "savanna"), cSavanna = new Savanna());
        event.register(Identifier.of(modID, "swampland"), cSwampland = new Swampland());

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
