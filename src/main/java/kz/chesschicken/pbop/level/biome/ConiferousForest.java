package kz.chesschicken.pbop.level.biome;



import kz.chesschicken.pbop.level.gen.TreeTaiga3;
import kz.chesschicken.pbop.level.gen.TreeTaiga4;
import net.minecraft.entity.EntityEntry;
import net.minecraft.entity.animal.Wolf;
import net.minecraft.level.biome.Biome;
import net.minecraft.level.structure.SpruceTree;
import net.minecraft.level.structure.Structure;

import java.util.Random;

public class ConiferousForest extends Biome {

    public ConiferousForest() {
        this.setGrassColour(7647092);
        this.setName("Coniferous Forest");
        this.creatures.add(new EntityEntry(Wolf.class, 2));
        this.setFoliageColour(7647092);
    }

    public Structure getTree(Random random) {
        if (random.nextInt(2) == 0) {
            return new SpruceTree();
        } else {
            return (Structure)(random.nextInt(3) == 0 ? new TreeTaiga3() : new TreeTaiga4());
        }
    }
}
