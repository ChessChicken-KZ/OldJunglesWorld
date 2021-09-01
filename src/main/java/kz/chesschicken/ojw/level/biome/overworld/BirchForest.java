package kz.chesschicken.ojw.level.biome.overworld;


import kz.chesschicken.biomesystem.common.biomes.ExtendedBiome;
import net.minecraft.entity.EntityEntry;
import net.minecraft.entity.animal.Wolf;
import net.minecraft.level.structure.BirchTree;
import net.minecraft.level.structure.Structure;

import java.util.Random;

public class BirchForest extends ExtendedBiome {

    public BirchForest() {
        this.creatures.add(new EntityEntry(Wolf.class, 2));
        this.setGrassColour(9022836);
        this.setName("Birch Forest");
        this.setFoliageColour(9022836);

        this.setTemperature(0.75F);
        this.setHumidity(0.75F);
    }


    public Structure getTree(Random random) {
        return new BirchTree();
    }
}
