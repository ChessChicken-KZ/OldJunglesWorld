package kz.chesschicken.ojw.utils.dimensionapi;

import net.minecraft.class_467;
import net.modificationstation.stationapi.api.registry.Identifier;

public interface IPlayerTeleport {
    void teleport(int id, class_467 teleport, boolean nether_travel);

    default void teleport(Identifier identifier, class_467 teleport) {
        this.teleport(DimensionAPI.DIMENSION_MAP.get(identifier).getDimensionID(), teleport, false);
    }

    default void teleport(Identifier identifier, class_467 teleport, boolean nether_travel) {
        this.teleport(DimensionAPI.DIMENSION_MAP.get(identifier).getDimensionID(), teleport, nether_travel);
    }
}
