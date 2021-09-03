package kz.chesschicken.ojw.mixin;

import kz.chesschicken.ojw.init.OJWContentListener;
import net.minecraft.block.BlockBase;
import net.minecraft.block.Glass;
import net.minecraft.block.material.Material;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(Glass.class)
public class MixinGlass extends BlockBase {
    protected MixinGlass(int id, Material material) {
        super(id, material);
    }

    @Inject(method = "getDropCount", at = @At("HEAD"), cancellable = true)
    private void setDropNonZero(Random rand, CallbackInfoReturnable<Integer> cir)
    {
        cir.setReturnValue(rand.nextInt(5));
        cir.cancel();
    }

    @Override
    public int getDropId(int meta, Random rand) {
        return OJWContentListener.shard_glass.id;
    }
}
