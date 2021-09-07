package kz.chesschicken.ojw.mixin.itemhelper;

import kz.chesschicken.ojw.utils.itemhelper.ProvideCustomMetaNames;
import net.minecraft.item.ItemBase;
import net.minecraft.item.ItemInstance;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemBase.class)
public class MixinItemBase {

    @Inject(method = "getTranslationKey(Lnet/minecraft/item/ItemInstance;)Ljava/lang/String;", at = @At("HEAD"), cancellable = true)
    private void replaceIfAnn(ItemInstance item, CallbackInfoReturnable<String> cir)
    {
        if(item.getType().getClass().isAnnotationPresent(ProvideCustomMetaNames.class)) {
            cir.setReturnValue(item.getType().getClass().getDeclaredAnnotation(ProvideCustomMetaNames.class).value().format(item));
            cir.cancel();
        }
    }
}
