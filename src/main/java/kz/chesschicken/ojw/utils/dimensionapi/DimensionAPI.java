package kz.chesschicken.ojw.utils.dimensionapi;

import kz.chesschicken.ojw.utils.MinecraftInstance;
import kz.chesschicken.ojw.utils.dimensionapi.event.EventRegisterExtendedDimension;
import kz.chesschicken.ojw.utils.dimensionapi.vanilla.VanillaNether;
import kz.chesschicken.ojw.utils.dimensionapi.vanilla.VanillaOverworld;
import kz.chesschicken.ojw.utils.dimensionapi.vanilla.VanillaSkylands;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.class_467;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.level.Level;
import net.minecraft.level.dimension.Dimension;
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

    public static void teleportPlayer(Level level, PlayerBase player, class_467 teleport, Identifier w) {
        teleportPlayer(level, player, teleport, DIMENSION_MAP.get(w).getDimensionID());
    }

    public static void teleportPlayer(Level level, PlayerBase player, class_467 teleport, int i) {
        player.dimensionId = player.dimensionId == i ? 0 : i;

        level.removeEntity(player);
        player.removed = false;

        Level var7;
        player.setPositionAndAngles(player.x, player.y, player.z, player.yaw, player.pitch);
        if (player.isAlive()) {
            level.method_193(player, false);
        }

        if (player.dimensionId == i) {
            var7 = new Level(level, Dimension.getByID(i));
            MinecraftInstance.get().showLevelProgress(var7, "Entering the Nether", player);
        } else {
            var7 = new Level(level, Dimension.getByID(0));
            MinecraftInstance.get().showLevelProgress(var7, "Leaving the Nether", player);
        }

        player.level = level;
        if (player.isAlive()) {
            player.setPositionAndAngles(player.x, player.y, player.z, player.yaw, player.pitch);
            level.method_193(player, false);
            teleport.method_1530(level, player);
        }

    }

    @SuppressWarnings("unused")
    @EventListener
    public void registerVanillaDimensions(EventRegisterExtendedDimension event) {
        event.register(Identifier.of("overworld"), new VanillaOverworld());
        event.register(Identifier.of("nether"), new VanillaNether());
        event.register(Identifier.of("skylands"), new VanillaSkylands());
    }


}
