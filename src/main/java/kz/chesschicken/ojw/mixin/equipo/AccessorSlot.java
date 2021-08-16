package kz.chesschicken.ojw.mixin.equipo;

import net.minecraft.container.slot.Slot;
import net.minecraft.inventory.InventoryBase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(Slot.class)
public interface AccessorSlot {
    @Accessor("invSlot")
    int getIndex();

    @Accessor("invSlot")
    public void setIndex(int i);

    @Accessor("inventory")
    InventoryBase getInventoryBase();
}
