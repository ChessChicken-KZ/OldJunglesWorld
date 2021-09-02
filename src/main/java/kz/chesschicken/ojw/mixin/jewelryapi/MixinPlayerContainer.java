package kz.chesschicken.ojw.mixin.jewelryapi;

import kz.chesschicken.ojw.utils.jewelryapi.JewelryType;
import kz.chesschicken.ojw.utils.jewelryapi.SlotJewelry;
import lombok.SneakyThrows;
import net.minecraft.container.ContainerBase;
import net.minecraft.container.slot.CraftingResult;
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
            this.addSlot(new SlotJewelry(arg, /* 48 */ arg.getInventorySize() - 1 - q, 80 + (q > 3 ? 18 : 0), 8 + q * 18 - (q > 3 ? 72 : 0), JewelryType.getByID(SlotJewelry.arraySlots[q])));
        }

        this.onContentsChanged(this.craftingInv);
    }

    @SneakyThrows
    @Override
    protected void addSlot(Slot arg)
    {
        if(arg instanceof CraftingResult && ((AccessorSlot)arg).getIndex() == 0)
        {
            arg.x = 143;
            arg.y = 62;
        }

        if(((AccessorSlot)arg).getInventoryBase() instanceof Crafting)
        {
            arg.x += 46;
            arg.y -= 18;
        }

        if(!(arg instanceof SlotJewelry) && ((AccessorSlot)arg).getIndex() > 43 && ((AccessorSlot)arg).getIndex() < 48)
            ((AccessorSlot)arg).setIndex(((AccessorSlot)arg).getIndex() - 8);
        super.addSlot(arg);
    }
}
