package kz.chesschicken.ojw.init;

import kz.chesschicken.ojw.utils.TextureHelper;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.client.event.texture.TextureRegisterEvent;
import net.modificationstation.stationapi.api.client.model.JsonModel;
import net.modificationstation.stationapi.api.registry.Identifier;

import static kz.chesschicken.ojw.init.OJWContentListener.*;

public class OJWTextureListener {

    //TODO: HashMap???
    public static int textureDirtFrozen;
    public static int textureSnowFrozen;
    public static int textureGrassFrozenSide;

    public static int textureDirtGlitch;
    public static int textureGrassGlitchTop;
    public static int textureGrassGlitchSide;

    public static int textureDirtDark;
    public static int textureGrassDarkTop;
    public static int textureGrassDarkSide;

    public static int textureDirtCrystal;
    public static int textureGrassCrystalTop;
    public static int textureGrassCrystalSide;

    public static int textureStoneFrozen;
    public static int textureCobblestoneFrozen;
    public static int textureGravelFrozen;

    public static int textureStonePurple;
    public static int textureCobblestonePurple;
    public static int textureGravelPurple;

    public static int textureLogGlitchTop;
    public static int textureLogGlitchSide;
    public static int texturePlanksGlitch;

    public static int textureLogSoulTop;
    public static int textureLogSoulSide;
    public static int texturePlanksSoul;

    public static int textureMelonSide;
    public static int textureMelonTop;

    public static int textureDebug;

    public static int[] textureMelonCrop = new int[7];

    public static JsonModel spawnerExtended;

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

        itemMelon.setTexture("/assets/ojw/textures/item/melon.png");
        itemMelonSeeds.setTexture("/assets/ojw/textures/item/melonSeeds.png");

        blockMelonSeedsTile.texture = textureMelonCrop[6];

        goldenEgg.setTexture("/assets/ojw/textures/item/goldenEgg.png");
        nuggetGold.setTexture("/assets/ojw/textures/item/nuggetGold.png");
        goldenNecklace.setTexture("/assets/ojw/textures/item/goldenNecklace.png");

        textureDirtFrozen = TextureHelper.getInstance().registerBlockTexture("dirtFrozen");
        textureSnowFrozen = TextureHelper.getInstance().registerBlockTexture("snowFrozen");
        textureGrassFrozenSide = TextureHelper.getInstance().registerBlockTexture("grassFrozen");

        textureDirtGlitch = TextureHelper.getInstance().registerBlockTexture("dirtGlitch");
        textureGrassGlitchTop = TextureHelper.getInstance().registerBlockTexture("grassGlitchTop");
        textureGrassGlitchSide = TextureHelper.getInstance().registerBlockTexture("grassGlitch");

        textureDirtDark = TextureHelper.getInstance().registerBlockTexture("dirtDark");
        textureGrassDarkTop = TextureHelper.getInstance().registerBlockTexture("grassDarkTop");
        textureGrassDarkSide = TextureHelper.getInstance().registerBlockTexture("grassDark");

        textureDirtCrystal = TextureHelper.getInstance().registerBlockTexture("dirtCrystal");
        textureGrassCrystalTop = TextureHelper.getInstance().registerBlockTexture("grassCrystalTop");
        textureGrassCrystalSide = TextureHelper.getInstance().registerBlockTexture("grassCrystal");

        textureStoneFrozen = TextureHelper.getInstance().registerBlockTexture("stoneFrozen");
        textureCobblestoneFrozen = TextureHelper.getInstance().registerBlockTexture("cobblestoneFrozen");
        textureGravelFrozen = TextureHelper.getInstance().registerBlockTexture("gravelFrozen");

        textureStonePurple = TextureHelper.getInstance().registerBlockTexture("stonePurple");
        textureCobblestonePurple = TextureHelper.getInstance().registerBlockTexture("cobblestonePurple");
        textureGravelPurple = TextureHelper.getInstance().registerBlockTexture("gravelPurple");

        textureLogGlitchTop = TextureHelper.getInstance().registerBlockTexture("logGlitchTop");
        textureLogGlitchSide = TextureHelper.getInstance().registerBlockTexture("logGlitch");
        texturePlanksGlitch = TextureHelper.getInstance().registerBlockTexture("planksGlitch");

        textureLogSoulTop = TextureHelper.getInstance().registerBlockTexture("logSoulTop");
        textureLogSoulSide = TextureHelper.getInstance().registerBlockTexture("logSoul");
        texturePlanksSoul = TextureHelper.getInstance().registerBlockTexture("planksSoul");

        textureDebug = TextureHelper.getInstance().registerBlockTexture("debug");

        spawnerExtended = new JsonModel(Identifier.of(modID, "spawner_extended"));

        shard_glass.setTexture("/assets/ojw/textures/item/shard_glass.png");
    }
}
