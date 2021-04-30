package kz.chesschicken.ojw.level.biome.varitations;

import net.minecraft.block.BlockBase;
import net.minecraft.level.Level;
import net.minecraft.level.biome.Biome;
import net.minecraft.level.structure.Structure;

import java.util.Random;

public class SwampTundra extends Biome {
    static class SwampHole extends Structure
    {

        @Override
        public boolean generate(Level level, Random rand, int x, int y, int z) {
            if(!level.isAir(x, y, z))
            {
                int r = rand.nextInt(4) + 2;
                for(int i = 0; i < r; i++)
                {
                    level.setTile(x, y - i, z, BlockBase.ICE.id);
                }
                return true;
            }
            return false;
        }
    }

    public SwampTundra()
    {
        this.setGrassColour(5762041);
        this.setName("Swamp Tundra");
        this.setSnowy();
        this.setFoliageColour(12899129);
    }

    @Override
    public Structure getTree(Random rand) {
        return new SwampHole();
    }
}
