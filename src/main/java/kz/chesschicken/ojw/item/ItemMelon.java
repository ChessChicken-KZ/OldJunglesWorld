package kz.chesschicken.ojw.item;

import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.item.food.TemplateFoodBase;

/**
 * Melon as Item
 */
public class ItemMelon extends TemplateFoodBase {
    public ItemMelon(Identifier identifier) {
        super(identifier, 2, false);
        setMaxStackSize(8);

    }
}
