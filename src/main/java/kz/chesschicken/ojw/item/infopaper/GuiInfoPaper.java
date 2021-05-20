package kz.chesschicken.ojw.item.infopaper;

import kz.chesschicken.ojw.init.OJWLogger;
import lombok.SneakyThrows;
import net.minecraft.client.gui.screen.ScreenBase;
import net.minecraft.client.util.ScreenScaler;
import org.lwjgl.opengl.GL11;

import java.awt.*;

public class GuiInfoPaper extends ScreenBase {
    private final int id;
    private String textureFile;
    private TextFormatting textFormatting;

    @SneakyThrows
    public GuiInfoPaper(int i)
    {
        this.id = i;
        try
        {
            textureFile = EventInfoPaper.getTexture(i);
            textFormatting = new TextFormatting(i);
        }
        catch (NullPointerException e)
        {
            minecraft.openScreen(null);
            OJWLogger.INSTANCE.RUNTIME.error("InfoPaper with id " + i + " throws NullPointerException!");
        }
    }

    @Override
    public void render(int mouseX, int mouseY, float delta) {
        this.renderBackground();

        ScreenScaler screenScaler = new ScreenScaler(minecraft.options, minecraft.actualWidth, minecraft.actualHeight);

        int guiX = (screenScaler.getScaledWidth() / 2) - ((int) (92 * 0.8));
        int guiY = (screenScaler.getScaledHeight() / 2)  - ((int) (128 * 0.8));

        /* Rendering stuff */

        GL11.glPushMatrix();
        GL11.glScalef(0.8f, 0.8f, 0.8f);
        GL11.glBindTexture(3553, this.minecraft.textureManager.getTextureId(textureFile));
        this.blit(guiX, guiY, 0, 0, 256, 256);
        this.drawTextWithShadowCentred(this.textManager, textFormatting.title, guiX + 128, guiY + 24, Color.WHITE.getRGB());
        for(int i = 0; i < textFormatting.lines.size(); i++)
        {
            this.drawTextWithShadow(this.textManager, textFormatting.lines.get(i), guiX + 24, (guiY + 34) + (i * 10), Color.WHITE.getRGB());
        }
        GL11.glPopMatrix();

        super.render(mouseX, mouseY, delta);
    }
}
