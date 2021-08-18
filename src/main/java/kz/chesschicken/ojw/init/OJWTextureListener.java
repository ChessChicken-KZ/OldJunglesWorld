package kz.chesschicken.ojw.init;

import kz.chesschicken.ojw.utils.TextureHelper;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.client.event.texture.TextureRegisterEvent;

import static kz.chesschicken.ojw.init.OJWContentListener.*;

public class OJWTextureListener {

    //TODO: may-be add HashMap?
    public static int textureDirtFrozen;
    public static int textureSnowFrozen;
    public static int textureGrassFrozenSide;

    public static int textureDirtGlitch;
    public static int textureGrassGlitchTop;
    public static int textureGrassGlitchSide;

    public static int textureDirtDark;
    public static int textureGrassDarkTop;
    public static int textureGrassDarkSide;

    public static int textureStoneFrozen;
    public static int textureCobblestoneFrozen;
    public static int textureGravelFrozen;

    public static int textureMelonSide;
    public static int textureMelonTop;
    public static int[] textureMelonCrop = new int[7];

    @SuppressWarnings("unused")
    @EventListener
    public void registerTextures(TextureRegisterEvent event)
    {
        OJWLogger.INSTANCE.INIT.info("Registering textures...");
        textureMelonSide = TextureHelper.getInstance().registerBlockTexture("melonSide");
        textureMelonTop = TextureHelper.getInstance().registerBlockTexture("melonTop");

        for(int i = 0; i < textureMelonCrop.length; i++)
        {
            textureMelonCrop[i] = TextureHelper.getInstance().registerBlockTexture("melonTile_" + (i + 1));
        }

        itemMelon.setTexturePosition(TextureHelper.getInstance().registerItemTexture("melon"));
        itemMelonSeeds.setTexturePosition(TextureHelper.getInstance().registerItemTexture("melonSeeds"));

        goldenEgg.setTexturePosition(TextureHelper.getInstance().registerItemTexture("goldenEgg"));
        nuggetGold.setTexturePosition(TextureHelper.getInstance().registerItemTexture("nuggetGold"));
        goldenNecklace.setTexturePosition(TextureHelper.getInstance().registerItemTexture("goldenNecklace"));

        textureDirtFrozen = TextureHelper.getInstance().registerBlockTexture("dirtFrozen");
        textureSnowFrozen = TextureHelper.getInstance().registerBlockTexture("snowFrozen");
        textureGrassFrozenSide = TextureHelper.getInstance().registerBlockTexture("grassFrozen");

        textureDirtGlitch = TextureHelper.getInstance().registerBlockTexture("dirtGlitch");
        textureGrassGlitchTop = TextureHelper.getInstance().registerBlockTexture("grassGlitchTop");
        textureGrassGlitchSide = TextureHelper.getInstance().registerBlockTexture("grassGlitch");

        textureDirtDark = TextureHelper.getInstance().registerBlockTexture("dirtDark");
        textureGrassDarkTop = TextureHelper.getInstance().registerBlockTexture("grassDarkTop");
        textureGrassDarkSide = TextureHelper.getInstance().registerBlockTexture("grassDark");

        textureStoneFrozen = TextureHelper.getInstance().registerBlockTexture("stoneFrozen");
        textureCobblestoneFrozen = TextureHelper.getInstance().registerBlockTexture("cobblestoneFrozen");
        textureGravelFrozen = TextureHelper.getInstance().registerBlockTexture("gravelFrozen");
    }
}
