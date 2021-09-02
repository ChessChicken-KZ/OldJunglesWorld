package kz.chesschicken.ojw.utils.structure;

import net.minecraft.level.Level;

public interface ISpecificGenRequest {

    /**
     * Interface method, allowing you to specify the generation condition.
     * @see StructurePlants
     *
     * @param level Level Instance.
     * @param x x coordinate of the block.
     * @param y y coordinate of the block.
     * @param z z coordinate of the block.
     * @return Can be planted in these coordinates.
     */
    boolean canBePlantedHere(Level level, int x, int y, int z);
}
