package kz.chesschicken.ojw.level.biome.glitch;

import kz.chesschicken.ojw.init.OJWContentListener;
import kz.chesschicken.ojw.level.BiomeTemplate;
import kz.chesschicken.ojw.level.gen.glitch.GlitchTree;
import net.minecraft.level.structure.Structure;

import java.util.Random;


public class GlitchForest extends BiomeTemplate {

    public GlitchForest() {
        super();
        this.topTileId = (byte) OJWContentListener.blockGrassComplex.id;
        this.underTileId = (byte) OJWContentListener.blockDirtComplex.id;
    }

    @Override
    public Structure getTree(Random rand) {
        return new GlitchTree();
    }
}
