package kz.chesschicken.ojw.level.biome.overworld;

import kz.chesschicken.biomesystem.common.biomes.ExtendedBiome;
import kz.chesschicken.ojw.level.gen.overworld.StructureSwamp;
import net.minecraft.level.structure.Structure;

import java.util.Random;

public class Swampland extends ExtendedBiome {

    public Swampland() {
        this.setGrassColour(522674);
        this.setName("Swampland");
        this.setFoliageColour(9154376);

        this.setTemperature(0.82F);
        this.setHumidity(0.92F);
    }

    public Structure getTree(Random random) {
        return new StructureSwamp();
    }
}
