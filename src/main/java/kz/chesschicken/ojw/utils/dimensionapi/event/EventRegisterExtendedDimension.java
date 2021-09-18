package kz.chesschicken.ojw.utils.dimensionapi.event;

import kz.chesschicken.ojw.utils.dimensionapi.DimensionAPI;
import kz.chesschicken.ojw.utils.dimensionapi.ExtendedDimension;
import net.mine_diver.unsafeevents.Event;
import net.minecraft.level.dimension.Dimension;
import net.modificationstation.stationapi.api.registry.Identifier;

public class EventRegisterExtendedDimension extends Event {

    public void register(Identifier identifier, ExtendedDimension dimension) {
        if(dimension instanceof Dimension)
            DimensionAPI.DIMENSION_MAP.put(identifier, dimension);

    }

    @Override
    protected int getEventID() {
        return ID;
    }

    public static final int ID = NEXT_ID.incrementAndGet();
}
