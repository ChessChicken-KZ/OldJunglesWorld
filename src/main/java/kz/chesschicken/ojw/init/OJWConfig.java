package kz.chesschicken.ojw.init;


import kz.chesschicken.ojw.utils.configapi.ConfigInstance;
import kz.chesschicken.ojw.utils.configapi.instance.Group;
import kz.chesschicken.ojw.utils.configapi.instance.Property;

import static kz.chesschicken.ojw.init.OJWContentListener.modID;

/**
 * Config of OldJunglesWorld
 */
public class OJWConfig extends ConfigInstance {

    public boolean customMainMenu;
    public boolean extendF3;
    public boolean debugItems;

    public OJWConfig() {
        super("ojw");
        OJWLogger.INIT.info("Current version: " + modID.getVersion().getFriendlyString());
    }

    @Override
    public void saveConfig() {
        Group commonCategory = Group.createGroup("common");
        commonCategory.add(Property.createProperty("customMainMenu", false), "Enables custom Main Menu, with some cool stuff.");

        Group debugCategory = Group.createGroup("debug");
        debugCategory.add(Property.createProperty("extendF3", false), "Show some debug info while pressing F3.");
        debugCategory.add(Property.createProperty("debugItems", false), "Load up debug blocks/items.");

        instance.add(commonCategory);
        instance.add(debugCategory);
    }

    @Override
    public void applyConfig() {
        customMainMenu = (boolean) getValue("common","customMainMenu");
        extendF3 = (boolean) getValue("debug","extendF3");
        debugItems = (boolean) getValue("debug","debugItems");
    }
}
