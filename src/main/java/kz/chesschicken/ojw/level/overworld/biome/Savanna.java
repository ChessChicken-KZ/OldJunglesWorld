package kz.chesschicken.ojw.level.overworld.biome;


import kz.chesschicken.biomesystem.common.biomes.ExtendedBiome;
import kz.chesschicken.biomesystem.common.utils.BiomeTemperature;
import kz.chesschicken.ojw.level.overworld.structures.StructureSavanna;
import net.minecraft.level.structure.Structure;

import java.util.Random;

public class Savanna extends ExtendedBiome {
    public Savanna() {
        super(BiomeTemperature.EXTREME_WARM, 42D);
        this.setGrassColour(14278691);
        this.setName("Savanna");
        this.setTreeDensity(1);
    }

    public Structure getTree(Random random) {
        return new StructureSavanna();
    }
}
