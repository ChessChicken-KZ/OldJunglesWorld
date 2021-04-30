package kz.chesschicken.ojw.level.biome.varitations;

import net.minecraft.level.biome.Biome;

public class EverTundra extends Biome {
    public EverTundra()
    {
        this.setGrassColour(5762041);
        this.setName("Tundra: Merzlota");
        this.setSnowy();
        this.setFoliageColour(12899129);
        //this.topTileId = (byte) OldJunglesWorldListener.blockFrozenDirt.id;
    }
}
