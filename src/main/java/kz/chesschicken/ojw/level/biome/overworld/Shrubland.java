package kz.chesschicken.ojw.level.biome.overworld;


import kz.chesschicken.biomesystem.common.biomes.ExtendedBiome;
import kz.chesschicken.ojw.level.gen.overworld.StructureShrub;
import net.minecraft.level.structure.Structure;

import java.util.Random;

public class Shrubland extends ExtendedBiome {

    public Shrubland() {
        this.setGrassColour(10595616);
        this.setName("Shrubland");

        this.setTemperature(1.0F);
        this.setHumidity(0.78F);
    }

    public Structure getTree(Random random) {
        return new StructureShrub();
    }
}
