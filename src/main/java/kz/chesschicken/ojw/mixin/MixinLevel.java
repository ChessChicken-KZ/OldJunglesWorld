package kz.chesschicken.ojw.mixin;

import net.minecraft.level.Level;
import net.minecraft.level.dimension.Dimension;
import net.minecraft.level.dimension.DimensionData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Level.class)
public abstract class MixinLevel {

    @Inject(method = "<init>(Lnet/minecraft/level/dimension/DimensionData;Ljava/lang/String;JLnet/minecraft/level/dimension/Dimension;)V", at = @At("RETURN"))
    private void handleLevelQ1(DimensionData arg, String name, long seed, Dimension dimension, CallbackInfo ci)
    {
        //TODO("Not implemented yet!")
    }

    @Inject(method = "<init>(Lnet/minecraft/level/Level;Lnet/minecraft/level/dimension/Dimension;)V", at = @At("RETURN"))
    private void handleLevelQ2(Level level, Dimension dimension, CallbackInfo ci)
    {
        //TODO("Not implemented yet!")
    }

    @Inject(method = "<init>(Lnet/minecraft/level/dimension/DimensionData;Ljava/lang/String;J)V", at = @At("RETURN"))
    private void handleLevelQ3(DimensionData arg, String string, long l, CallbackInfo ci)
    {
        //TODO("Not implemented yet!")
    }

    @Inject(method = "<init>(Lnet/minecraft/level/dimension/DimensionData;Ljava/lang/String;Lnet/minecraft/level/dimension/Dimension;J)V", at = @At("RETURN"))
    private void handleLevelQ4(DimensionData dimensionData, String name, Dimension dimension, long seed, CallbackInfo ci)
    {
        //TODO("Not implemented yet!")
    }

}
