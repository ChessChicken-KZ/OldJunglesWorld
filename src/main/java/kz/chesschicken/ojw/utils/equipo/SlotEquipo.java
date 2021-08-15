package kz.chesschicken.ojw.utils.equipo;

import net.minecraft.container.slot.Slot;
import net.minecraft.inventory.InventoryBase;
import net.minecraft.item.ItemInstance;

public class SlotEquipo extends Slot {
    private final IJewelry.JewelryType jewelryType;
    public SlotEquipo(InventoryBase inventory, int index, int x, int y, IJewelry.JewelryType type) {
        super(inventory, index, x, y);
        this.jewelryType = type;
    }

    @Override
    public int getMaxStackCount() {
        return 1;
    }

    @Override
    public boolean canInsert(ItemInstance arg) {
        if(arg.getType() instanceof IJewelry) {
            return ((IJewelry)arg.getType()).getJewelryType() == jewelryType;
        }
        return false;
    }
}
