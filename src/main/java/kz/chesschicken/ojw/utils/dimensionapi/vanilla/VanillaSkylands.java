package kz.chesschicken.ojw.utils.dimensionapi.vanilla;

import kz.chesschicken.ojw.utils.dimensionapi.ExtendedDimension;
import net.minecraft.level.dimension.Skylands;

public class VanillaSkylands extends Skylands implements ExtendedDimension {
    @Override
    public int getDimensionID() {
        return 1;
    }

    @Override
    public String getDimensionName() {
        return "DIM1";
    }
}
