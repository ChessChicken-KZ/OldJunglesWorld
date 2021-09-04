package kz.chesschicken.ojw.level.overworld.biome;


import kz.chesschicken.biomesystem.common.biomes.ExtendedBiome;
import kz.chesschicken.biomesystem.common.utils.BiomeTemperature;
import net.minecraft.entity.EntityEntry;
import net.minecraft.entity.animal.Wolf;
import net.minecraft.level.structure.BirchTree;
import net.minecraft.level.structure.Structure;

import java.util.Random;

public class BirchForest extends ExtendedBiome {

    public BirchForest() {
        super(BiomeTemperature.WARM, 15D);
        this.creatures.add(new EntityEntry(Wolf.class, 2));
        this.setGrassColour(9022836);
        this.setName("Birch Forest");
        this.setFoliageColour(9022836);
        this.setTreeDensity(5);
    }


    public Structure getTree(Random random) {
        return new BirchTree();
    }
}
