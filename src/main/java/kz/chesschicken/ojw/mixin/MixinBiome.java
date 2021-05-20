package kz.chesschicken.ojw.mixin;

import kz.chesschicken.ojw.init.OJWListener2;
import net.minecraft.level.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(Biome.class)
public class MixinBiome {

    @Inject(method = "getClimateBiome", at = @At("HEAD"), cancellable = true)
    private static void setBOPbiomes(float f, float f1, CallbackInfoReturnable<Biome> cir)
    {
        f1 *= f;
        if (f < 0.1F) {
            cir.setReturnValue(Biome.TUNDRA);
        } else if (f1 < 0.2F) {
            if (f < 0.5F) {
                cir.setReturnValue(Biome.TUNDRA);
            } else if (f < 0.95F) {
                cir.setReturnValue(f > 0.85F ?  OJWListener2.cSavanna :  OJWListener2.cShrubland);
            } else {
                cir.setReturnValue(Biome.DESERT);
            }
        } else if (f < 0.5F) {
            cir.setReturnValue(Biome.TAIGA);
        } else if (f < 0.7F && f > 0.5F) {
            if (f1 < 0.5F) {
                cir.setReturnValue(OJWListener2.bBirchForest);
            } else {
                cir.setReturnValue(f1 > 0.75F ? OJWListener2.cSwampland : OJWListener2.bConiferousForest);
            }
        } else if (f < 0.97F) {
            if (f1 < 0.35F) {
                cir.setReturnValue(OJWListener2.cShrubland);
            } else {
                cir.setReturnValue(f1 < 0.7F ? Biome.FOREST : OJWListener2.cSwampland);
            }
        } else if (f1 < 0.45F) {
            cir.setReturnValue(Biome.PLAINS);
        } else if (f1 < 0.75F) {
            cir.setReturnValue(Biome.SEASONAL_FOREST);
        } else {
            cir.setReturnValue(f1 < 0.85F ? Biome.RAINFOREST : OJWListener2.bJungle);
        }
    }
}
