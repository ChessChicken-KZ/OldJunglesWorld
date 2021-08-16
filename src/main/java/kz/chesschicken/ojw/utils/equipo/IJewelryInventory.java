package kz.chesschicken.ojw.utils.equipo;

import net.minecraft.item.ItemInstance;

public interface IJewelryInventory {

    /**
     * Access to the array, where jewelry usually is.
     * @return Array of {@link net.minecraft.item.ItemInstance}
     */
    public ItemInstance[] getJewelryInventory();
}
