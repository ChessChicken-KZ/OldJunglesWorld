package kz.chesschicken.ojw.level.biome.overworld;


import kz.chesschicken.biomesystem.common.biomes.ExtendedBiome;
import kz.chesschicken.ojw.level.gen.overworld.TreeTaiga3;
import kz.chesschicken.ojw.level.gen.overworld.TreeTaiga4;
import net.minecraft.entity.EntityEntry;
import net.minecraft.entity.animal.Wolf;
import net.minecraft.level.structure.SpruceTree;
import net.minecraft.level.structure.Structure;

import java.util.Random;

public class ConiferousForest extends ExtendedBiome {

    public ConiferousForest() {
        this.setGrassColour(7647092);
        this.setName("Coniferous Forest");
        this.creatures.add(new EntityEntry(Wolf.class, 2));
        this.setFoliageColour(7647092);

        this.setTemperature(0.0F);
        this.setHumidity(0.5F);
    }

    public Structure getTree(Random random) {
        if (random.nextInt(2) == 0) {
            return new SpruceTree();
        } else {
            return random.nextInt(3) == 0 ? new TreeTaiga3() : new TreeTaiga4();
        }
    }
}
