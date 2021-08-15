package kz.chesschicken.ojw.mixin.equipo;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.InventoryBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.util.io.CompoundTag;
import net.minecraft.util.io.ListTag;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerInventory.class)
public abstract class MixinPlayerInventory implements InventoryBase {
    @Shadow public ItemInstance[] main;
    @Shadow public ItemInstance[] armour;
    @Unique private ItemInstance[] jewelry = new ItemInstance[8];

    @Inject(method = "takeInventoryItem", at = @At("HEAD"), cancellable = true)
    private void changeTakeItem(int index, int j, CallbackInfoReturnable<ItemInstance> cir)
    {
        if(index >= this.main.length + this.armour.length)
        {
            index -= (this.main.length + this.armour.length);
            if(this.jewelry[index] != null)
            {
                ItemInstance item;
                if (this.jewelry[index].count <= j)
                {
                    item = this.jewelry[index];
                    this.jewelry[index] = null;
                } else
                {
                    item = this.jewelry[index].split(j);
                    if (this.jewelry[index].count == 0)
                        this.jewelry[index] = null;
                }
                cir.setReturnValue(item);
            }else cir.setReturnValue(null);
            cir.cancel();
        }
    }

    @Inject(method = "setInventoryItem", at = @At("HEAD"), cancellable = true)
    private void changeSetItem(int slot, ItemInstance arg, CallbackInfo ci)
    {
        if(slot >= this.main.length + this.armour.length)
        {
            slot -= (this.main.length + this.armour.length);
            this.jewelry[slot] = arg;
            ci.cancel();
        }
    }

    @Inject(method = "toTag", at = @At("TAIL"))
    private void injectWriteNBT(ListTag arg, CallbackInfoReturnable<ListTag> cir)
    {
        for(int i = 0; i < this.jewelry.length; i++)
        {
            if(this.jewelry[i] != null) {
                CompoundTag send = new CompoundTag();
                send.put("SlotJewelry", (byte) i);
                this.jewelry[i].toTag(send);
                arg.add(send);
            }
        }
    }

    @Inject(method = "fromTag", at = @At("TAIL"))
    private void injectReadNBT(ListTag arg, CallbackInfo ci)
    {
        this.jewelry = new ItemInstance[8];
        for(int i = 0; i < arg.size(); i++)
        {
            CompoundTag compoundTag = (CompoundTag) arg.get(i);
            if(compoundTag.containsKey("SlotJewelry"))
            {
                ItemInstance item = new ItemInstance(compoundTag);
                if(item.getType() != null)
                {
                    this.jewelry[compoundTag.getByte("SlotJewelry") & 255] = item;
                }
            }
        }
    }

    @Inject(method = "getInventoryItem", at = @At("HEAD"), cancellable = true)
    private void changeGetItem(int index, CallbackInfoReturnable<ItemInstance> cir)
    {
        if(index >= (this.main.length + this.armour.length))
        {
            index -= (this.main.length + this.armour.length);
            cir.setReturnValue(this.jewelry[index]);
        }
    }


    @Inject(method = "getInventorySize", at = @At("RETURN"), cancellable = true)
    private void changeReturnSize(CallbackInfoReturnable<Integer> cir)
    {
        cir.setReturnValue(this.main.length + 12);
    }

}
