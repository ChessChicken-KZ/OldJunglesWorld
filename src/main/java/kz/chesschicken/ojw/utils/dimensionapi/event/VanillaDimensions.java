package kz.chesschicken.ojw.utils.dimensionapi.event;

import kz.chesschicken.ojw.utils.dimensionapi.vanilla.VanillaNether;
import kz.chesschicken.ojw.utils.dimensionapi.vanilla.VanillaOverworld;
import kz.chesschicken.ojw.utils.dimensionapi.vanilla.VanillaSkylands;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.registry.Identifier;

public class VanillaDimensions {

    @SuppressWarnings("unused")
    @EventListener
    public void registerVanillaDimensions(EventRegisterExtendedDimension event) {
        event.register(Identifier.of("overworld"), new VanillaOverworld());
        event.register(Identifier.of("nether"), new VanillaNether());
        event.register(Identifier.of("skylands"), new VanillaSkylands());
    }
}
