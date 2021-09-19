package kz.chesschicken.ojw.utils.dimensionapi;

import kz.chesschicken.ojw.utils.dimensionapi.event.EventRegisterExtendedDimension;
import kz.chesschicken.ojw.utils.dimensionapi.vanilla.VanillaNether;
import kz.chesschicken.ojw.utils.dimensionapi.vanilla.VanillaOverworld;
import kz.chesschicken.ojw.utils.dimensionapi.vanilla.VanillaSkylands;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.registry.Identifier;

import java.util.HashMap;

public class DimensionAPI {
    public static HashMap<Identifier, ExtendedDimension> DIMENSION_MAP = new HashMap<>();

    public static ExtendedDimension getDimensionByInt(int i) {
        for(Identifier identifier : DIMENSION_MAP.keySet()) {
            if(DIMENSION_MAP.get(identifier).getDimensionID() == i)
                return DIMENSION_MAP.get(identifier);
        }
        return null;
    }

    @SuppressWarnings("unused")
    @EventListener
    public void registerVanillaDimensions(EventRegisterExtendedDimension event) {
        event.register(Identifier.of("overworld"), new VanillaOverworld());
        event.register(Identifier.of("nether"), new VanillaNether());
        event.register(Identifier.of("skylands"), new VanillaSkylands());
    }


}
