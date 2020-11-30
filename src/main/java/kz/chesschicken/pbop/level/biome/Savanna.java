package kz.chesschicken.pbop.level.biome;


import kz.chesschicken.pbop.level.gen.StructureSavanna;
import net.minecraft.level.biome.Biome;
import net.minecraft.level.structure.Structure;

import java.util.Random;

public class Savanna extends Biome {
    public Savanna(){
        this.setGrassColour(14278691);
        this.setName("Savanna");
    }
    public Structure getTree(Random random) {
        return new StructureSavanna();
    }
}
