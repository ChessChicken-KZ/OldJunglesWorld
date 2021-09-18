package kz.chesschicken.ojw.level.glitch;

import kz.chesschicken.ojw.utils.dimensionapi.GeneratorBase;
import net.minecraft.level.Level;
import net.minecraft.level.chunk.Chunk;
import net.minecraft.level.source.LevelSource;

public class GeneratorGlitch extends GeneratorBase {
    public GeneratorGlitch(Level l, long seed) {
        super(l, seed);
    }

    @Override
    public Chunk getChunk(int chunkX, int chunkZ) {
        return null;
    }

    @Override
    public void decorate(LevelSource levelSource, int chunkX, int chunkZ) {

    }
}
