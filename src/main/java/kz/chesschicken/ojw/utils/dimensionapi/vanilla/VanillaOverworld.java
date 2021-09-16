package kz.chesschicken.ojw.utils.dimensionapi.vanilla;

import kz.chesschicken.ojw.utils.dimensionapi.ExtendedDimension;
import net.minecraft.level.dimension.Overworld;

public class VanillaOverworld extends Overworld implements ExtendedDimension {
    @Override
    public int getDimensionID() {
        return 0;
    }

    @Override
    public String getDimensionName() {
        return "DIM0";
    }
}
