package kz.chesschicken.ojw.level.glitch;

import kz.chesschicken.ojw.utils.dimensionapi.ExtendedDimension;
import net.minecraft.level.dimension.Dimension;
import net.minecraft.level.source.LevelSource;
import net.minecraft.level.source.SkylandsLevelSource;

public class GlitchDimension extends Dimension implements ExtendedDimension {
    @Override
    public int getDimensionID() {
        return 2;
    }

    @Override
    public String getDimensionName() {
        return "DIM_GLITCH";
    }

    @Override
    public LevelSource createLevelSource() {
        return new SkylandsLevelSource(this.level, this.level.getSeed());
    }
}
