package kz.chesschicken.ojw.level.overworld.structures;

import kz.chesschicken.ojw.init.OJWContentListener;
import net.minecraft.level.Level;
import net.minecraft.level.structure.Structure;

import java.util.Random;

public class HangmanStructure extends Structure {
    @Override
    public boolean generate(Level level, Random rand, int x, int y, int z) {
        level.setTileWithMetadata(x, y, z, OJWContentListener.hangmanBlock.id, 0);
        level.setTileWithMetadata(x, y + 1, z, OJWContentListener.hangmanBlock.id, 1);
        level.setTileWithMetadata(x, y + 2, z, OJWContentListener.hangmanBlock.id, 1);
        level.setTileWithMetadata(x - 1, y + 2, z, OJWContentListener.hangmanBlock.id, 3);
        level.setTileWithMetadata(x, y + 3, z, OJWContentListener.hangmanBlock.id, 2);
        return true;
    }
}
