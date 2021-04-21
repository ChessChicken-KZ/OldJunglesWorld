package kz.chesschicken.ojw.init;

import kz.chesschicken.ojw.level.biome.*;
import net.minecraft.level.biome.Biome;
import net.modificationstation.stationapi.api.common.event.EventListener;
import net.modificationstation.stationapi.api.common.event.level.biome.BiomeRegister;

public class OldJunglesWorldListener {
    public static Biome bBirchForest;
    public static Biome bConiferousForest;
    public static Biome bJungle;
    public static Biome cShrubland;
    public static Biome cSavanna;
    public static Biome cSwampland;


    public int texture_MelonSIDE;


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
}
