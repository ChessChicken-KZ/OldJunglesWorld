package kz.chesschicken.ojw.init;

import kz.chesschicken.ojw.item.goldenegg.EntityGoldenChicken;
import kz.chesschicken.ojw.utils.TextureHelper;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.client.render.entity.ChickenRenderer;
import net.minecraft.client.render.entity.model.Chicken;
import net.modificationstation.stationapi.api.client.event.render.entity.EntityRendererRegisterEvent;
import net.modificationstation.stationapi.api.client.event.texture.TextureRegisterEvent;
import net.modificationstation.stationapi.api.client.model.JsonModel;
import net.modificationstation.stationapi.api.registry.Identifier;

import static kz.chesschicken.ojw.init.OJWContentListener.*;

public class OJWClientListener {

    @SuppressWarnings("unused")
    @EventListener
    public void registerTextures(TextureRegisterEvent event)
    {
        OJWLogger.INSTANCE.INIT.info("Registering textures...");

        OJWContainer.textureMelonSide = TextureHelper.getInstance().registerBlockTexture("melonSide");
        OJWContainer.textureMelonTop = TextureHelper.getInstance().registerBlockTexture("melonTop");

        for(int i = 0; i < OJWContainer.textureMelonCrop.length; i++)
            OJWContainer.textureMelonCrop[i] = TextureHelper.getInstance().registerBlockTexture("melonTile_" + (i + 1));

        itemMelon.setTexture("/assets/ojw/textures/item/melon.png");
        itemMelonSeeds.setTexture("/assets/ojw/textures/item/melonSeeds.png");

        blockMelonSeedsTile.texture = OJWContainer.textureMelonCrop[6];

        goldenEgg.setTexture("/assets/ojw/textures/item/goldenEgg.png");
        nuggetGold.setTexture("/assets/ojw/textures/item/nuggetGold.png");
        goldenNecklace.setTexture("/assets/ojw/textures/item/goldenNecklace.png");
        shard_glass.setTexture("/assets/ojw/textures/item/shard_glass.png");

        OJWContainer.textureDirtFrozen = TextureHelper.getInstance().registerBlockTexture("dirtFrozen");
        OJWContainer.textureSnowFrozen = TextureHelper.getInstance().registerBlockTexture("snowFrozen");
        OJWContainer.textureGrassFrozenSide = TextureHelper.getInstance().registerBlockTexture("grassFrozen");

        OJWContainer.textureDirtGlitch = TextureHelper.getInstance().registerBlockTexture("dirtGlitch");
        OJWContainer.textureGrassGlitchTop = TextureHelper.getInstance().registerBlockTexture("grassGlitchTop");
        OJWContainer.textureGrassGlitchSide = TextureHelper.getInstance().registerBlockTexture("grassGlitch");

        OJWContainer.textureDirtDark = TextureHelper.getInstance().registerBlockTexture("dirtDark");
        OJWContainer.textureGrassDarkTop = TextureHelper.getInstance().registerBlockTexture("grassDarkTop");
        OJWContainer.textureGrassDarkSide = TextureHelper.getInstance().registerBlockTexture("grassDark");

        OJWContainer.textureDirtCrystal = TextureHelper.getInstance().registerBlockTexture("dirtCrystal");
        OJWContainer.textureGrassCrystalTop = TextureHelper.getInstance().registerBlockTexture("grassCrystalTop");
        OJWContainer.textureGrassCrystalSide = TextureHelper.getInstance().registerBlockTexture("grassCrystal");

        OJWContainer.textureStoneFrozen = TextureHelper.getInstance().registerBlockTexture("stoneFrozen");
        OJWContainer.textureCobblestoneFrozen = TextureHelper.getInstance().registerBlockTexture("cobblestoneFrozen");
        OJWContainer.textureGravelFrozen = TextureHelper.getInstance().registerBlockTexture("gravelFrozen");

        OJWContainer.textureStonePurple = TextureHelper.getInstance().registerBlockTexture("stonePurple");
        OJWContainer.textureCobblestonePurple = TextureHelper.getInstance().registerBlockTexture("cobblestonePurple");
        OJWContainer.textureGravelPurple = TextureHelper.getInstance().registerBlockTexture("gravelPurple");

        OJWContainer.textureLogGlitchTop = TextureHelper.getInstance().registerBlockTexture("logGlitchTop");
        OJWContainer.textureLogGlitchSide = TextureHelper.getInstance().registerBlockTexture("logGlitch");
        OJWContainer.texturePlanksGlitch = TextureHelper.getInstance().registerBlockTexture("planksGlitch");
        OJWContainer.textureLeavesGlitch = TextureHelper.getInstance().registerBlockTexture("leavesGlitch");

        OJWContainer.textureLogSoulTop = TextureHelper.getInstance().registerBlockTexture("logSoulTop");
        OJWContainer.textureLogSoulSide = TextureHelper.getInstance().registerBlockTexture("logSoul");
        OJWContainer.texturePlanksSoul = TextureHelper.getInstance().registerBlockTexture("planksSoul");
        OJWContainer.textureLeavesSoul = TextureHelper.getInstance().registerBlockTexture("leavesSoul");

        OJWContainer.textureDebug = TextureHelper.getInstance().registerBlockTexture("debug");
        OJWContainer.textureCandleItem = TextureHelper.getInstance().registerItemTexture("candle");

        OJWContainer.spawnerExtended = new JsonModel(Identifier.of(modID, "spawner_extended"));

        OJWContainer.gallowsFirst = new JsonModel(Identifier.of(modID, "gallows_first"));
        OJWContainer.gallowsCenter = new JsonModel(Identifier.of(modID, "gallows_center"));
        OJWContainer.gallowsTop = new JsonModel(Identifier.of(modID, "gallows_top"));
        OJWContainer.gallowsEYE = new JsonModel(Identifier.of(modID, "gallows_eye"));

        OJWContainer.candleSINGLE = new JsonModel(Identifier.of(modID, "candle_single"));
    }

    @SuppressWarnings("unused")
    @EventListener
    public void registerEntityRenderers(EntityRendererRegisterEvent event)
    {
        event.renderers.put(EntityGoldenChicken.class, new ChickenRenderer(new Chicken(), 1.0f));
    }
}
