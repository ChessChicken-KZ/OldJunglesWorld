package kz.chesschicken.ojw.level.biome.overworld;

import kz.chesschicken.ojw.level.gen.overworld.StructureSwamp;
import net.minecraft.level.biome.Biome;
import net.minecraft.level.structure.Structure;

import java.util.Random;

public class Swampland extends Biome {

    public Swampland() {
        this.setGrassColour(522674);
        this.setName("Swampland");
        this.setFoliageColour(9154376);
    }

    public Structure getTree(Random random) {
        return new StructureSwamp();
    }
}
