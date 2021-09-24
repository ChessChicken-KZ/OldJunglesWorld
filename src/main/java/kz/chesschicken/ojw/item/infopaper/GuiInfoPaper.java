package kz.chesschicken.ojw.item.infopaper;

import kz.chesschicken.ojw.init.OJWLogger;
import kz.chesschicken.ojw.utils.GlobalScreenScaler;
import lombok.SneakyThrows;
import net.minecraft.client.gui.screen.ScreenBase;
import org.lwjgl.opengl.GL11;

import java.awt.*;

public class GuiInfoPaper extends ScreenBase {
    private String textureFile;
    private String[] textArray;

    @SneakyThrows
    public GuiInfoPaper(int i)
    {
        try
        {
            textureFile = EventInfoPaper.getInstance().getTexture(i);
            textArray = EventInfoPaper.getInstance().getText(i);
        }
        catch (NullPointerException e)
        {
            OJWLogger.RUNTIME.error("InfoPaper with id " + i + " throws NullPointerException!");
            OJWLogger.RUNTIME.throwing(e);
        }
    }

    @Override
    public void render(int mouseX, int mouseY, float delta) {
        this.renderBackground();

        int guiX = (GlobalScreenScaler.getWidth() / 2) - ((int) (92 * 0.8));
        int guiY = (GlobalScreenScaler.getHeight() / 2)  - ((int) (128 * 0.8));

        /* Rendering stuff */

        GL11.glPushMatrix();
        GL11.glScalef(0.8f, 0.8f, 0.8f);
        GL11.glBindTexture(3553, this.minecraft.textureManager.getTextureId(textureFile));
        this.blit(guiX, guiY, 0, 0, 256, 256);
        this.drawTextWithShadowCentred(this.textManager, textArray[0], guiX + 128, guiY + 24, Color.WHITE.getRGB());
        for(int i = 1; i < textArray.length; i++)
        {
            this.drawTextWithShadow(this.textManager, textArray[i], guiX + 24, (guiY + 34) + (i * 10), Color.WHITE.getRGB());
        }
        GL11.glPopMatrix();

        super.render(mouseX, mouseY, delta);
    }
}
