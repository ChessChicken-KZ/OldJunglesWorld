package kz.chesschicken.ojw.mixin;

import kz.chesschicken.ojw.utils.ArrayUtils;
import net.minecraft.level.source.NetherLevelSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(NetherLevelSource.class)
public class MixinNetherLevelSource {
    @ModifyArg(method = "getChunk", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/level/gen/Cave;generate(Lnet/minecraft/level/source/LevelSource;Lnet/minecraft/level/Level;II[B)V"
    ), index = 4)
    private byte[] injectReverseByteArray(byte[] bs) {
        ArrayUtils.reverse(bs);
        return bs;
    }

}
