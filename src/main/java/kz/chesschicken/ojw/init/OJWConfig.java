package kz.chesschicken.ojw.init;


import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.config.Category;
import net.modificationstation.stationapi.api.config.Configuration;
import net.modificationstation.stationapi.api.config.Property;
import net.modificationstation.stationapi.api.event.mod.InitEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.registry.ModID;
import net.modificationstation.stationapi.api.util.Null;

/**
 * Config of OldJunglesWorld
 */
public class OJWConfig {

    public boolean customMainMenu;

    @Entrypoint.Config
    public static Configuration modCONFIG = Null.get();

    @Entrypoint.ModID
    public static ModID modID = Null.get();

    @SuppressWarnings("unused")
    @EventListener
    public void config(InitEvent event)
    {
        OJWLogger.INSTANCE.INIT.info("Current version: " + modID.getVersion().getFriendlyString());
        modCONFIG.load();
        Category commonCategory = modCONFIG.getCategory("common");

        Property a = commonCategory.getProperty("customMainMenu", false);
        a.setComment("Enables custom Main Menu, with some cool stuff.");
        customMainMenu = a.getBooleanValue();

        modCONFIG.save();
        INSTANCE = this;
    }

    private static OJWConfig INSTANCE;
    public static OJWConfig getInstance()
    {
        return INSTANCE;
    }
}
