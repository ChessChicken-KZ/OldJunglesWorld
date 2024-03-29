package kz.chesschicken.ojw.mixin.hunger.client;

import kz.chesschicken.ojw.utils.client.GlobalScreenScaler;
import kz.chesschicken.ojw.utils.playerhunger.IPlayerHunger;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.InGame;
import net.minecraft.entity.player.PlayerBase;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGame.class)
public abstract class MixinOverlay extends DrawableHelper {
    @Shadow private Minecraft minecraft;

    @Inject(method = "renderHud", at = @At("TAIL"), cancellable = true)
    private void renderHunger(float f, boolean flag, int i, int j, CallbackInfo ci)
    {
        GL11.glBindTexture(3553, this.minecraft.textureManager.getTextureId("/assets/ojw/textures/gui/playericon.png"));
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        int a = ((IPlayerHunger)minecraft.player).getHunger();
        byte q = (byte) ((a % 2 != 0) ? 1 : 0);

        a = (a % 2 == 0) ? (a / 2) : ((a - 1) / 2);

        for(int t = 0; t < 10; t++)
        {
            blit(GlobalScreenScaler.getWidth() / 2 + (8 * t) + 9, GlobalScreenScaler.getHeight() - 32 + (armorExists(minecraft.player) ? -9 : 0 ), ((IPlayerHunger) minecraft.player).isPoisoned() ? 9 : 0, 0, 9, 9);
        }

        for(int t = 0; t < a + q; t++)
        {
            blit(GlobalScreenScaler.getWidth() / 2 + (8 * t) + 9, GlobalScreenScaler.getHeight() - 32 + (armorExists(minecraft.player) ? -9 : 0 ), ((t + 1 == a + q && q == 1) ? 27 : 18) + (((IPlayerHunger) minecraft.player).isPoisoned() ? 18 : 0), 0, 9, 9);
        }
    }

    private boolean armorExists(PlayerBase playerBase)
    {
        return playerBase.inventory.getArmourValue() > 0;
    }
}
