package kz.chesschicken.ojw.init;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.Minecraft;

public class MinecraftInstance {
    public static Minecraft INSTANCE;

    static {
        INSTANCE = (Minecraft) FabricLoader.getInstance().getGameInstance();
    }
}
