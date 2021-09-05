package kz.chesschicken.ojw.level.overworld.biome;


import kz.chesschicken.biomesystem.common.biomes.ExtendedBiome;
import kz.chesschicken.biomesystem.common.utils.BiomeTemperature;
import kz.chesschicken.ojw.level.overworld.structures.TreeTaiga3;
import kz.chesschicken.ojw.level.overworld.structures.TreeTaiga4;
import net.minecraft.entity.EntityEntry;
import net.minecraft.entity.animal.Wolf;
import net.minecraft.level.structure.SpruceTree;
import net.minecraft.level.structure.Structure;

import java.util.Random;

public class ConiferousForest extends ExtendedBiome {

    public ConiferousForest() {
        super(BiomeTemperature.COLD, 35D);
        this.setGrassColour(7647092);
        this.setName("Coniferous Forest");
        this.creatures.add(new EntityEntry(Wolf.class, 2));
        this.setFoliageColour(7647092);
        this.setTreeDensity(4);
    }

    public Structure getTree(Random random) {
        if (random.nextInt(2) == 0) {
            return new SpruceTree();
        } else {
            return random.nextInt(3) == 0 ? new TreeTaiga3() : new TreeTaiga4();
        }
    }
}
