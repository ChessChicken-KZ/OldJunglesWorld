package kz.chesschicken.ojw.init;

import net.modificationstation.stationapi.api.common.config.Category;
import net.modificationstation.stationapi.api.common.config.Configuration;
import net.modificationstation.stationapi.api.common.config.Property;
import net.modificationstation.stationapi.api.common.event.EventListener;
import net.modificationstation.stationapi.api.common.event.mod.Init;
import net.modificationstation.stationapi.api.common.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.common.util.Null;

/**
 * Config of OldJunglesWorld
 */
public class OJWConfig {

    public boolean customMainMenu;

    public int imageWidth;
    public int imageHeight;
    public boolean isBlurred;

    @Entrypoint.Config
    public static Configuration modCONFIG = Null.get();

    @SuppressWarnings("unused")
    @EventListener
    public void config(Init event)
    {
        modCONFIG.load();
        Category commonCategory = modCONFIG.getCategory("common");

        Property a = commonCategory.getProperty("customMainMenu", false);
        a.setComment("Enables custom Main Menu, with some cool stuff.");
        customMainMenu = a.getBooleanValue();

        Category mainMenuCategory = modCONFIG.getCategory("mainmenu");
        imageWidth = mainMenuCategory.getProperty("imageWidth", 256).getIntValue();
        imageHeight = mainMenuCategory.getProperty("imageHeight", 256).getIntValue();
        isBlurred = mainMenuCategory.getProperty("isBlurred", true).getBooleanValue();

        modCONFIG.save();
        INSTANCE = this;
    }

    private static OJWConfig INSTANCE;
    public static OJWConfig getInstance()
    {
        return INSTANCE;
    }
}
