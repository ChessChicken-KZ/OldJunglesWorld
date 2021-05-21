package kz.chesschicken.ojw.init;

import net.modificationstation.stationapi.api.common.config.Category;
import net.modificationstation.stationapi.api.common.config.Configuration;
import net.modificationstation.stationapi.api.common.config.Property;
import net.modificationstation.stationapi.api.common.event.EventListener;
import net.modificationstation.stationapi.api.common.event.mod.Init;
import net.modificationstation.stationapi.api.common.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.common.registry.ModID;
import net.modificationstation.stationapi.api.common.util.Null;

/**
 * Config of OldJunglesWorld
 */
public class OJWConfig {

    @Entrypoint.ModID
    public static ModID modID = Null.get();

    @Entrypoint.Config
    public static Configuration modCONFIG = Null.get();

    @SuppressWarnings("unused")
    @EventListener
    public void config(Init event)
    {
        modCONFIG.load();
        Category commonCategory = modCONFIG.getCategory("common");
        Property property = commonCategory.getProperty("");
        property.setComment("");

        modCONFIG.save();
    }
}
