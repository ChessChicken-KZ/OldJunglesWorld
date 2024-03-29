package kz.chesschicken.ojw.init;

import kz.chesschicken.biomesystem.common.biomes.ExtendedBiome;
import kz.chesschicken.biomesystem.common.event.ExtendedBiomeRegisterEvent;
import kz.chesschicken.ojw.level.glitch.GlitchDimension;
import kz.chesschicken.ojw.level.overworld.biome.*;
import kz.chesschicken.ojw.utils.dimensionapi.event.EventRegisterExtendedDimension;
import kz.chesschicken.ojw.utils.structure.StructurePlants;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.mine_diver.unsafeevents.listener.ListenerPriority;
import net.modificationstation.stationapi.api.event.level.gen.LevelGenEvent;
import net.modificationstation.stationapi.api.registry.Identifier;

import static kz.chesschicken.ojw.init.OJWContentListener.modID;

/**
 * Biomes, Generation, Dimensions
 */
public class OJWLevelListener {
    public static ExtendedBiome birch_forest;
    public static ExtendedBiome coniferous_forest;
    public static ExtendedBiome jungle;
    public static ExtendedBiome shrubland;
    public static ExtendedBiome savanna;
    public static ExtendedBiome swampland;

    @SuppressWarnings("unused")
    @EventListener(priority = ListenerPriority.LOW)
    public void registerBiome(ExtendedBiomeRegisterEvent event)
    {
        event.register(Identifier.of(modID, "birch_forest"), birch_forest = new BirchForest());
        event.register(Identifier.of(modID, "coniferous_forest"), coniferous_forest = new ConiferousForest());
        event.register(Identifier.of(modID, "jungle"), jungle = new Jungle());
        event.replace(modID, Identifier.of("shrubland"), shrubland = new Shrubland());
        event.replace(modID, Identifier.of("savanna"), savanna = new Savanna());
        event.replace(modID, Identifier.of("swampland"), swampland = new Swampland());
    }

    @SuppressWarnings("unused")
    @EventListener
    public void registerDimensions(EventRegisterExtendedDimension event) {
        event.register(Identifier.of(modID, "glitch_world"), new GlitchDimension());
    }

    @SuppressWarnings("unused")
    @EventListener
    public void registerGeneration(LevelGenEvent.ChunkDecoration chunkDecoration)
    {
        if (chunkDecoration.random.nextInt(8) == 0 && chunkDecoration.biome == OJWLevelListener.jungle) {
            int ix = chunkDecoration.x + chunkDecoration.random.nextInt(16) + 8;
            int iy = chunkDecoration.random.nextInt(128);
            int iz = chunkDecoration.z + chunkDecoration.random.nextInt(16) + 8;
            (new StructurePlants(OJWContentListener.blockMelon.id, 0)).generate(chunkDecoration.level, chunkDecoration.random, ix, iy, iz);
        }
    }
}
