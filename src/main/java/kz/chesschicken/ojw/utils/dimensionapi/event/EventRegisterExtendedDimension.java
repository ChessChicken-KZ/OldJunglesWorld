package kz.chesschicken.ojw.utils.dimensionapi.event;

import kz.chesschicken.ojw.utils.dimensionapi.ExtendedDimension;
import net.mine_diver.unsafeevents.Event;
import net.minecraft.level.dimension.Dimension;
import net.modificationstation.stationapi.api.registry.Identifier;

import java.util.HashMap;

public class EventRegisterExtendedDimension extends Event {
    public static HashMap<Identifier, ExtendedDimension> DIMENSION_MAP = new HashMap<>();

    public static ExtendedDimension getDimensionByInt(int i) {
        for(Identifier identifier : DIMENSION_MAP.keySet()) {
            if(DIMENSION_MAP.get(identifier).getDimensionID() == i)
                return DIMENSION_MAP.get(identifier);
        }
        return null;
    }

    public void register(Identifier identifier, ExtendedDimension dimension) {
        if(dimension instanceof Dimension)
            DIMENSION_MAP.put(identifier, dimension);
    }

    @Override
    protected int getEventID() {
        return ID;
    }

    public static final int ID = NEXT_ID.incrementAndGet();
}
