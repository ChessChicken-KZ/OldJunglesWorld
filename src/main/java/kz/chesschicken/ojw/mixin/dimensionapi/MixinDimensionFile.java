package kz.chesschicken.ojw.mixin.dimensionapi;

import kz.chesschicken.ojw.utils.dimensionapi.ExtendedDimension;
import net.minecraft.level.LevelManager;
import net.minecraft.level.chunk.ChunkIO;
import net.minecraft.level.dimension.Dimension;
import net.minecraft.level.dimension.DimensionFile;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.io.File;

@Mixin(DimensionFile.class)
public class MixinDimensionFile {
    @Shadow @Final private File parentFolder;

    @Inject(method = "getChunkIO", at = @At("HEAD"), cancellable = true)
    private void doNewFileInstance(Dimension dimension, CallbackInfoReturnable<ChunkIO> cir) {
        if(dimension instanceof ExtendedDimension) {
            File file = new File(this.parentFolder, ((ExtendedDimension)dimension).getDimensionName());
            file.mkdirs();
            cir.setReturnValue(new LevelManager(file, true));
            cir.cancel();
        }
    }
}
