package kz.chesschicken.ojw.item;

import net.modificationstation.stationapi.api.common.registry.Identifier;
import net.modificationstation.stationapi.template.common.item.food.FoodBase;

/**
 * Melon as Item
 */
public class ItemMelon extends FoodBase {
    public ItemMelon(Identifier identifier) {
        super(identifier, 2, false);
        setMaxStackSize(8);

    }
}
