package kz.chesschicken.ojw.mixin;

import net.minecraft.level.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(Biome.class)
public interface AccessorBiome {
    @Accessor("precipitates")
    void invokePrecipitates(boolean b);
}
