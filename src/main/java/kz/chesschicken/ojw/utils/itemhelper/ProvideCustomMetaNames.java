package kz.chesschicken.ojw.utils.itemhelper;

import net.minecraft.item.ItemInstance;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.function.Function;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ProvideCustomMetaNames {
    enum NameType {
        NUMERICAL(itemInstance -> itemInstance.getType().getTranslationKey() + itemInstance.getDamage()),
        EMPTY(itemInstance -> itemInstance.getType().getTranslationKey());

        private final Function<ItemInstance, String> function;
        NameType(Function<ItemInstance, String> a) {
            this.function = a;
        }

        public String format(ItemInstance itemInstance) {
            return function.apply(itemInstance);
        }
    }

    NameType value() default NameType.NUMERICAL;
}
