package kz.chesschicken.ojw.level.biome.overworld;


import kz.chesschicken.biomesystem.common.biomes.ExtendedBiome;
import kz.chesschicken.ojw.level.gen.overworld.StructureSavanna;
import net.minecraft.level.structure.Structure;

import java.util.Random;

public class Savanna extends ExtendedBiome {
    public Savanna() {
        this.setGrassColour(14278691);
        this.setName("Savanna");

        this.setTemperature(1.7F);
        this.setHumidity(0.1F);
    }

    public Structure getTree(Random random) {
        return new StructureSavanna();
    }
}
