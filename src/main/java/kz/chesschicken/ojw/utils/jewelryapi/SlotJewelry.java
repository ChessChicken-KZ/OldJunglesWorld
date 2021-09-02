package kz.chesschicken.ojw.utils.jewelryapi;

import net.minecraft.container.slot.Slot;
import net.minecraft.inventory.InventoryBase;
import net.minecraft.item.ItemInstance;

public class SlotJewelry extends Slot {
    public static final byte[] arraySlots = new byte[]
            {
                    0, 1, 2, 5,
                    3, 3, 4, 4
            };

    private final JewelryType jewelryType;
    public SlotJewelry(InventoryBase inventory, int index, int x, int y, JewelryType type) {
        super(inventory, index, x, y);
        this.jewelryType = type;
    }

    @Override
    public int getMaxStackCount() {
        return 1;
    }

    @Override
    public boolean canInsert(ItemInstance arg) {
        return arg.getType() instanceof IJewelry && ((IJewelry)arg.getType()).getJewelryType() == jewelryType;
    }
}
