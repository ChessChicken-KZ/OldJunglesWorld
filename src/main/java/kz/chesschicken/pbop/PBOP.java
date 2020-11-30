package kz.chesschicken.pbop;

import kz.chesschicken.pbop.level.biome.*;
import net.minecraft.level.biome.Biome;
import net.modificationstation.stationloader.api.common.event.level.biome.BiomeRegister;
import net.modificationstation.stationloader.api.common.mod.StationMod;



public class PBOP implements BiomeRegister, StationMod {

    public static Biome bBirchForest;
    public static Biome bConiferousForest;
    public static Biome bJungle;
    public static Biome cShrubland;
    public static Biome cSavanna;
    public static Biome cSwampland;
    @Override
    public void registerBiomes() {
        bBirchForest = new BirchForest();
        bConiferousForest = new ConiferousForest();
        bJungle = new Jungle();
        cShrubland = new Shrubland();
        cSavanna = new Savanna();
        cSwampland = new Swampland();
    }

    @Override
    public void preInit() {
        BiomeRegister.EVENT.register(this);
    }

}
