package kz.chesschicken.ojw.block;

import net.modificationstation.stationapi.api.common.registry.Identifier;
import net.modificationstation.stationapi.template.common.item.food.FoodBase;

public class ItemMelon extends FoodBase {
    public ItemMelon(Identifier identifier) {
        super(identifier, 2, false);
        setMaxStackSize(8);

    }
}
