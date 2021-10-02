package kz.chesschicken.ojw.utils.client;

import kz.chesschicken.ojw.utils.MinecraftInstance;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class GlobalScreenScaler {
    private static short SCALE = -1;
    private static int SCALE_INT;

    private static int SIZED_WIDTH;
    private static int SIZED_HEIGHT;

    private static int WIDTH;
    private static int HEIGHT;

    public static int getWidth() {
        return SIZED_WIDTH;
    }

    public static int getHeight() {
        return SIZED_HEIGHT;
    }

    public static void updateSizedDimensions() {
        if(MinecraftInstance.get().options.guiScale != SCALE || WIDTH != MinecraftInstance.get().actualWidth || HEIGHT != MinecraftInstance.get().actualHeight) {
            WIDTH = MinecraftInstance.get().actualWidth;
            HEIGHT = MinecraftInstance.get().actualHeight;
            SCALE = (short) MinecraftInstance.get().options.guiScale;
            if(SCALE == 0) SCALE = 1000;

            while(SCALE_INT < SCALE && WIDTH / (SCALE_INT + 1) >= 320 && HEIGHT / (SCALE_INT + 1) >= 240) {
                ++SCALE_INT;
            }

            SIZED_WIDTH = WIDTH / SCALE_INT;
            SIZED_HEIGHT = HEIGHT / SCALE_INT;
        }
    }
}
