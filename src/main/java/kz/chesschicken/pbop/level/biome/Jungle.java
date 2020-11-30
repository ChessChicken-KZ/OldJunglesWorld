package kz.chesschicken.pbop.level.biome;

import kz.chesschicken.pbop.level.gen.HugeTrees;
import kz.chesschicken.pbop.level.gen.StructureShrub;
import net.minecraft.level.biome.Biome;
import net.minecraft.level.structure.OakTree;
import net.minecraft.level.structure.Structure;

import java.util.Random;

public class Jungle extends Biome {

    public Jungle(){
        this.setGrassColour(588342);
        this.setName("Jungle");
        this.setFoliageColour(2094168);
    }

    public Structure getTree(Random random) {
        if (random.nextInt(3) == 0) {
            return new StructureShrub();
        } else {
            return (Structure)(random.nextInt(2) == 0 ? new HugeTrees() : new OakTree());
        }
    }
}
