package kz.chesschicken.ojw.level.overworld.biome;

import kz.chesschicken.biomesystem.common.biomes.ExtendedBiome;
import kz.chesschicken.biomesystem.common.utils.BiomeTemperature;
import kz.chesschicken.ojw.level.overworld.structures.StructureSwamp;
import net.minecraft.level.structure.Structure;

import java.util.Random;

public class Swampland extends ExtendedBiome {

    public Swampland() {
        super(BiomeTemperature.WARM, +27D);
        this.setGrassColour(522674);
        this.setName("Swampland");
        this.setFoliageColour(9154376);
        this.setTreeDensity(3);
    }

    public Structure getTree(Random random) {
        return new StructureSwamp();
    }
}
