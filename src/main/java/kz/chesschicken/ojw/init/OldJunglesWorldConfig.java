package kz.chesschicken.ojw.init;

import net.fabricmc.loader.api.FabricLoader;
import net.modificationstation.stationapi.api.common.event.EventListener;
import net.modificationstation.stationapi.api.common.event.mod.PostInit;
import net.modificationstation.stationapi.api.common.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.common.registry.ModID;
import net.modificationstation.stationapi.api.common.util.Null;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class OldJunglesWorldConfig {

    private final File fileConfig = new File(FabricLoader.getInstance().getGameDirectory(), "ojw.conf");

    @Entrypoint.ModID public static ModID modID = Null.get();
    @EventListener
    public void config(PostInit event)
    {
        saveConfig();
        loadConfig();
    }

    private void loadConfig()
    {

    }

    private void saveConfig()
    {
        try (OutputStream output = new FileOutputStream(fileConfig)) {

            Properties prop = new Properties();

            //prop.setProperty("example", String.valueOf(example));


            prop.store(output, null);



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
