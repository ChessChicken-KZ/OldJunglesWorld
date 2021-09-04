package kz.chesschicken.ojw.level;

import kz.chesschicken.biomesystem.common.biomes.ExtendedBiome;
import kz.chesschicken.biomesystem.common.utils.BiomeTemperature;
import kz.chesschicken.ojw.mixin.AccessorBiome;
import net.minecraft.block.BlockBase;
import net.minecraft.entity.EntityEntry;

import java.util.ArrayList;

public class BiomeTemplate extends ExtendedBiome {
    public BiomeTemplate(BiomeTemperature biomeTemperature, double temp)
    {
        super(biomeTemperature, temp);
        this.topTileId = (byte) BlockBase.GRASS.id;
        this.underTileId = (byte)BlockBase.DIRT.id;
        this.foliageColour = 5169201;
        this.monsters = new ArrayList<EntityEntry>();
        this.creatures = new ArrayList<EntityEntry>();
        this.waterCreatures = new ArrayList<EntityEntry>();
        ((AccessorBiome)this).invokePrecipitates(true);
    }
}
