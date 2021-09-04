package kz.chesschicken.ojw.level.glitch.biome;

import kz.chesschicken.biomesystem.common.utils.BiomeTemperature;
import kz.chesschicken.ojw.init.OJWContentListener;
import kz.chesschicken.ojw.level.BiomeTemplate;
import kz.chesschicken.ojw.level.glitch.structures.GlitchTree;
import net.minecraft.level.structure.Structure;

import java.util.Random;


public class GlitchForest extends BiomeTemplate {

    public GlitchForest() {
        super(BiomeTemperature.COLD, 0D);
        this.topTileId = (byte) OJWContentListener.blockGrassComplex.id;
        this.underTileId = (byte) OJWContentListener.blockDirtComplex.id;
    }

    @Override
    public Structure getTree(Random rand) {
        return new GlitchTree();
    }
}
