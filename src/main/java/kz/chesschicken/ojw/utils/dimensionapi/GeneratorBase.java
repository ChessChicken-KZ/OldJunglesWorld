package kz.chesschicken.ojw.utils.dimensionapi;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.level.Level;
import net.minecraft.level.chunk.Chunk;
import net.minecraft.level.source.LevelSource;
import net.minecraft.util.ProgressListener;

import java.util.Random;

public abstract class GeneratorBase implements LevelSource {

    protected Random random;
    protected Level level;

    public GeneratorBase(Level l, long seed) {
        this.random = new Random(seed);
        this.level = l;
    }

    @Override
    public Chunk loadChunk(int chunkX, int chunkZ) {
        return this.getChunk(chunkX, chunkZ);
    }

    @Override
    public boolean isChunkLoaded(int chunkX, int chunkZ) {
        return true;
    }

    @Override
    public boolean deleteCacheCauseClientCantHandleThis(boolean iDontKnowWhy, ProgressListener listener) {
        return true;
    }

    @Override
    public boolean method_1801() {
        return false;
    }

    @Override
    public boolean method_1805() {
        return true;
    }

    @Override
    @Environment(EnvType.CLIENT)
    public String toString() {
        return "RandomLevelSource";
    }
}
