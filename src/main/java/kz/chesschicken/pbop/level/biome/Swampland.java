package kz.chesschicken.pbop.level.biome;

import kz.chesschicken.pbop.level.gen.StructureSwamp;
import net.minecraft.level.biome.Biome;
import net.minecraft.level.structure.Structure;

import java.util.Random;

public class Swampland extends Biome {
    public Swampland(){
        this.setGrassColour(522674);
        this.setName("Swampland");
        this.setFoliageColour(9154376);
    }
    public Structure getTree(Random random) {
        return new StructureSwamp();
    }
}
