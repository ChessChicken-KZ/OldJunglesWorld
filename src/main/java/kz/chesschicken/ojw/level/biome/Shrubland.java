package kz.chesschicken.ojw.level.biome;


import kz.chesschicken.ojw.level.gen.StructureShrub;
import net.minecraft.level.biome.Biome;
import net.minecraft.level.structure.Structure;

import java.util.Random;

public class Shrubland extends Biome {

    public Shrubland(){
        this.setGrassColour(10595616);
        this.setName("Shrubland");
    }

    public Structure getTree(Random random) {
        return new StructureShrub();
    }
}
