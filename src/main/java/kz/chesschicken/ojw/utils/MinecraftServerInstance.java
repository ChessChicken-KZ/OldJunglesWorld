package kz.chesschicken.ojw.utils;


import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.server.MinecraftServer;

/**
 * Returns Minecraft Server's instance.
 * Use this if you're working with server side.
 */
@Environment(EnvType.SERVER)
public class MinecraftServerInstance {
    @SuppressWarnings("deprecation")
    public static MinecraftServer get() {
        return (MinecraftServer) FabricLoader.getInstance().getGameInstance();
    }
}
