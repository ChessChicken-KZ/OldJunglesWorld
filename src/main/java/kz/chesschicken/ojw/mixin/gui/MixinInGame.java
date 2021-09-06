package kz.chesschicken.ojw.mixin.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.InGame;
import net.minecraft.client.util.ScreenScaler;
import net.minecraft.util.hit.HitType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGame.class)
public class MixinInGame {
    @Shadow private Minecraft minecraft;

    @Inject(method = "renderHud", at = @At("TAIL"), cancellable = true)
    private void doExtendF3Render(float f, boolean flag, int i, int j, CallbackInfo ci)
    {
        ScreenScaler screenScaler = new ScreenScaler(this.minecraft.options, this.minecraft.actualWidth, this.minecraft.actualHeight);

        if (this.minecraft.options.debugHud) {
            if(this.minecraft.hitResult != null && this.minecraft.hitResult.type == HitType.TILE)
            {
                this.minecraft.textRenderer.drawTextWithShadow("Block: " + minecraft.level.getTileId(this.minecraft.hitResult.x, this.minecraft.hitResult.y, this.minecraft.hitResult.z) +
                        "/" + minecraft.level.getTileMeta(this.minecraft.hitResult.x, this.minecraft.hitResult.y, this.minecraft.hitResult.z), screenScaler.getScaledWidth() / 2 + 5,
                        screenScaler.getScaledHeight() / 2 + 5, 0xFFFFFF);
            }
        }
    }
}
