package kz.chesschicken.ojw.init;


import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.config.Category;
import net.modificationstation.stationapi.api.config.Configuration;
import net.modificationstation.stationapi.api.config.Property;
import net.modificationstation.stationapi.api.event.mod.InitEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.util.Null;

import static kz.chesschicken.ojw.init.OJWContentListener.modID;

/**
 * Config of OldJunglesWorld
 */
public class OJWConfig {

    public boolean customMainMenu;
    public boolean extendF3;
    public boolean debugItems;

    @Entrypoint.Config
    public static Configuration modCONFIG = Null.get();


    @SuppressWarnings("unused")
    @EventListener
    public void config(InitEvent event)
    {
        OJWLogger.INIT.info("Current version: " + modID.getVersion().getFriendlyString());
        modCONFIG.load();
        Category commonCategory = modCONFIG.getCategory("common");

        Property a = commonCategory.getProperty("customMainMenu", false);
        a.setComment("Enables custom Main Menu, with some cool stuff.");
        customMainMenu = a.getBooleanValue();

        Category debugCategory = modCONFIG.getCategory("debug");

        Property b = debugCategory.getProperty("extendF3", false);
        b.setComment("Show some debug info while pressing F3.");
        extendF3 = b.getBooleanValue();

        b = debugCategory.getProperty("debugItems", false);
        b.setComment("Load up debug blocks/items.");
        debugItems = b.getBooleanValue();

        modCONFIG.save();
        INSTANCE = this;
    }

    private static OJWConfig INSTANCE;
    public static OJWConfig getInstance()
    {
        return INSTANCE;
    }
}
