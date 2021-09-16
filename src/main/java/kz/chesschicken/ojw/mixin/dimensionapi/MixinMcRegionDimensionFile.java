package kz.chesschicken.ojw.mixin.dimensionapi;

import kz.chesschicken.ojw.utils.dimensionapi.ExtendedDimension;
import net.minecraft.level.chunk.ChunkIO;
import net.minecraft.level.chunk.LevelChunkLoader;
import net.minecraft.level.dimension.Dimension;
import net.minecraft.level.dimension.DimensionFile;
import net.minecraft.level.dimension.McRegionDimensionFile;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.io.File;

@Mixin(McRegionDimensionFile.class)
public abstract class MixinMcRegionDimensionFile extends DimensionFile {

    public MixinMcRegionDimensionFile(File file, String worldName, boolean mkdirs) {
        super(file, worldName, mkdirs);

    }

    @Inject(method = "getChunkIO", at = @At("HEAD"), cancellable = true)
    private void doNewFileInstance(Dimension dimension, CallbackInfoReturnable<ChunkIO> cir) {
        if(dimension instanceof ExtendedDimension) {
            File file = new File(this.getParentFolder(), ((ExtendedDimension)dimension).getDimensionName());
            file.mkdirs();
            cir.setReturnValue(new LevelChunkLoader(file));
            cir.cancel();
        }
    }
}
