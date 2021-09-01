package kz.chesschicken.ojw.level.biome.overworld;

import kz.chesschicken.biomesystem.common.biomes.ExtendedBiome;
import kz.chesschicken.ojw.level.gen.overworld.HugeTrees;
import kz.chesschicken.ojw.level.gen.overworld.StructureShrub;
import net.minecraft.level.structure.OakTree;
import net.minecraft.level.structure.Structure;

import java.util.Random;

public class Jungle extends ExtendedBiome {

    public Jungle() {
        this.setGrassColour(588342);
        this.setName("Jungle");
        this.setFoliageColour(2094168);

        this.setTemperature(1.2F);
        this.setHumidity(0.9F);
    }

    public Structure getTree(Random random) {
        if (random.nextInt(3) == 0) {
            return new StructureShrub();
        } else {
            return random.nextInt(2) == 0 ? new HugeTrees() : new OakTree();
        }
    }
}
