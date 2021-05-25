package kz.chesschicken.ojw.mixin.dimapi;

import net.minecraft.level.chunk.ChunkIO;
import net.minecraft.level.chunk.LevelChunkLoader;
import net.minecraft.level.dimension.Dimension;
import net.minecraft.level.dimension.DimensionData;
import net.minecraft.level.dimension.DimensionFile;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.io.File;

@Mixin(DimensionFile.class)
public abstract class MixinDimensionFile implements DimensionData {

    @Shadow protected abstract File getParentFolder();

    @Inject(method = "getChunkIO", at = @At("HEAD"), cancellable = true)
    private void replaceSystem1(Dimension dimension, CallbackInfoReturnable<ChunkIO> cir)
    {
        if(dimension.id == 0)
        {
            cir.setReturnValue(new LevelChunkLoader(getParentFolder()));
        }else
        {
            File newFolder = new File(getParentFolder(), "DIM"+dimension.id);
            newFolder.mkdirs();
            cir.setReturnValue(new LevelChunkLoader(newFolder));
        }
        cir.cancel();
    }
}
