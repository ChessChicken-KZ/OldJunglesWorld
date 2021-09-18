package kz.chesschicken.ojw.utils;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.Minecraft;

/**
 * Returns Minecraft Client's instance.
 * Use this if you're working with client side.
 */
@Environment(EnvType.CLIENT)
public class MinecraftInstance {
    @SuppressWarnings("deprecation")
    public static Minecraft get() {
        return (Minecraft) FabricLoader.getInstance().getGameInstance();
    }
}
