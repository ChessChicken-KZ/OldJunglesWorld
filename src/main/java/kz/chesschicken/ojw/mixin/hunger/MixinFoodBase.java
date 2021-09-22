package kz.chesschicken.ojw.mixin.hunger;

import kz.chesschicken.ojw.utils.playerhunger.IPlayerHunger;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.item.food.FoodBase;
import net.minecraft.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FoodBase.class)
public class MixinFoodBase {
    @Shadow private int healAmount;

    @Inject(method = "use", at = @At("HEAD"), cancellable = true)
    private void getHungerValue(ItemInstance item, Level level, PlayerBase player, CallbackInfoReturnable<ItemInstance> cir)
    {
        --item.count;
        ((IPlayerHunger)player).addHunger(this.healAmount);
        ((IPlayerHunger)player).addAbsorption(this.healAmount / 5);
        cir.setReturnValue(item);
        cir.cancel();
    }
}
