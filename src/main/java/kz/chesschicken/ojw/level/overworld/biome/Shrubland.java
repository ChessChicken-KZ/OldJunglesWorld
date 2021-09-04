package kz.chesschicken.ojw.level.overworld.biome;


import kz.chesschicken.biomesystem.common.biomes.ExtendedBiome;
import kz.chesschicken.biomesystem.common.utils.BiomeTemperature;
import kz.chesschicken.ojw.level.overworld.structures.StructureShrub;
import net.minecraft.level.structure.Structure;

import java.util.Random;

public class Shrubland extends ExtendedBiome {

    public Shrubland() {
        super(BiomeTemperature.WARM, +30D);
        this.setGrassColour(10595616);
        this.setName("Shrubland");
        this.setTreeDensity(1);
    }

    public Structure getTree(Random random) {
        return new StructureShrub();
    }
}
