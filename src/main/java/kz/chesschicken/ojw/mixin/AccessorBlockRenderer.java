package kz.chesschicken.ojw.mixin;

import net.minecraft.client.render.block.BlockRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(BlockRenderer.class)
public interface AccessorBlockRenderer {
    @Accessor("textureOverride")
    int getTextureRendering();

    @Accessor("textureOverride")
    void setTextureRendering(int i);
}
