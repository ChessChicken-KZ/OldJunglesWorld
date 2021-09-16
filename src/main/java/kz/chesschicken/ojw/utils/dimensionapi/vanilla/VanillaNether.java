package kz.chesschicken.ojw.utils.dimensionapi.vanilla;

import kz.chesschicken.ojw.utils.dimensionapi.ExtendedDimension;
import net.minecraft.level.dimension.Nether;

public class VanillaNether extends Nether implements ExtendedDimension {
    @Override
    public int getDimensionID() {
        return -1;
    }

    @Override
    public String getDimensionName() {
        return "DIM-1";
    }
}
