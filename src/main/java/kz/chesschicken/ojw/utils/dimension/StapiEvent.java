package kz.chesschicken.ojw.utils.dimension;

import net.minecraft.level.dimension.Nether;
import net.minecraft.level.dimension.Overworld;
import net.minecraft.level.dimension.Skylands;
import net.modificationstation.stationapi.api.common.event.EventListener;
import net.modificationstation.stationapi.api.common.event.mod.Init;

public class StapiEvent {
    @SuppressWarnings("unused")
    @EventListener
    public void registerBaseDimensions(Init init)
    {
        DimensionEvent.INSTANCE.register(-1, new Nether());
        DimensionEvent.INSTANCE.register(0, new Overworld());
        DimensionEvent.INSTANCE.register(1, new Skylands());
    }
}
