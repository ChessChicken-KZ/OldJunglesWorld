package kz.chesschicken.ojw.level.overworld.biome;

import kz.chesschicken.biomesystem.common.biomes.ExtendedBiome;
import kz.chesschicken.biomesystem.common.utils.BiomeTemperature;
import kz.chesschicken.ojw.level.overworld.structures.HugeTrees;
import kz.chesschicken.ojw.level.overworld.structures.StructureShrub;
import net.minecraft.level.structure.OakTree;
import net.minecraft.level.structure.Structure;

import java.util.Random;

public class Jungle extends ExtendedBiome {

    public Jungle() {
        super(BiomeTemperature.WARM, +35D);
        this.setGrassColour(588342);
        this.setName("Jungle");
        this.setFoliageColour(2094168);
        this.setTreeDensity(7);
    }

    public Structure getTree(Random random) {
        if (random.nextInt(3) == 0) {
            return new StructureShrub();
        } else {
            return random.nextInt(2) == 0 ? new HugeTrees() : new OakTree();
        }
    }
}
