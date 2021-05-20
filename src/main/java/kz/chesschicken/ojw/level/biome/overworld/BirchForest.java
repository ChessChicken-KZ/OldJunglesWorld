package kz.chesschicken.ojw.level.biome.overworld;



import net.minecraft.entity.EntityEntry;
import net.minecraft.entity.animal.Wolf;
import net.minecraft.level.biome.Biome;
import net.minecraft.level.structure.BirchTree;
import net.minecraft.level.structure.Structure;

import java.util.Random;

public class BirchForest extends Biome {

    public BirchForest()
    {
        this.creatures.add(new EntityEntry(Wolf.class, 2));
        this.setGrassColour(9022836);
        this.setName("Birch Forest");
        this.setFoliageColour(9022836);
    }


    public Structure getTree(Random random) {
        return new BirchTree();
    }
}
