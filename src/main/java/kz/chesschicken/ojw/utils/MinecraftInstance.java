package kz.chesschicken.ojw.utils;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.Minecraft;

@Environment(EnvType.CLIENT)
public class MinecraftInstance {
    public static Minecraft INSTANCE;

    static {
        INSTANCE = (Minecraft) FabricLoader.getInstance().getGameInstance();
    }
}
