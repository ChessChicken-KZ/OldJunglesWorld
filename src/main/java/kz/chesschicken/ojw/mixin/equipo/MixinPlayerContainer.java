package kz.chesschicken.ojw.mixin.equipo;

import kz.chesschicken.ojw.utils.equipo.IJewelry;
import kz.chesschicken.ojw.utils.equipo.SlotEquipo;
import net.minecraft.container.ContainerBase;
import net.minecraft.container.slot.Slot;
import net.minecraft.entity.player.PlayerContainer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Crafting;
import net.minecraft.inventory.InventoryBase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerContainer.class)
public abstract class MixinPlayerContainer extends ContainerBase {
    @Shadow public abstract void onContentsChanged(InventoryBase arg);

    @Shadow public Crafting craftingInv;

    @Inject(method = "<init>(Lnet/minecraft/entity/player/PlayerInventory;Z)V", at = @At("TAIL"), cancellable = true)
    private void injectAdditionalInventory(PlayerInventory arg, boolean local, CallbackInfo ci)
    {
        for(int q = 0; q < 8; q++) {
            this.addSlot(new SlotEquipo(arg, /* 48 */ arg.getInventorySize() - 1 - q, -23, 12 + q * 18, IJewelry.JewelryType.HAT));
        }

        this.onContentsChanged(this.craftingInv);
    }

    @Override
    protected void addSlot(Slot arg) {
        if(!(arg instanceof SlotEquipo) && ((AccessorSlot)arg).getIndex() > 43 && ((AccessorSlot)arg).getIndex() < 48)
            ((AccessorSlot)arg).setIndex(((AccessorSlot)arg).getIndex() - 8);
        super.addSlot(arg);
    }
}
