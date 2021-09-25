package kz.chesschicken.ojw.init;

import kz.chesschicken.ojw.item.goldenegg.EntityGoldenChicken;
import kz.chesschicken.ojw.utils.TextureHelper;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.client.render.entity.ChickenRenderer;
import net.minecraft.client.render.entity.model.Chicken;
import net.modificationstation.stationapi.api.client.event.option.KeyBindingRegisterEvent;
import net.modificationstation.stationapi.api.client.event.render.entity.EntityRendererRegisterEvent;
import net.modificationstation.stationapi.api.client.event.texture.TextureRegisterEvent;
import net.modificationstation.stationapi.api.client.model.json.JsonModel;
import net.modificationstation.stationapi.api.client.texture.atlas.ExpandableAtlas;
import net.modificationstation.stationapi.api.registry.Identifier;

import static kz.chesschicken.ojw.init.OJWContentListener.*;

public class OJWClientListener {

    public static int generate(String s) {
        return OJWContainer.ATLAS_TERRAIN.addTexture(Identifier.of(modID, s)).index;
    }

    @SuppressWarnings("unused")
    @EventListener
    public void registerTextures(TextureRegisterEvent event)
    {
        OJWContainer.ATLAS_TERRAIN = new ExpandableAtlas(Identifier.of(modID, "atlas_terrain")).initTessellator();
        OJWLogger.INIT.info("Registering textures...");


        OJWContainer.textureMelonSide = generate("blocks/melon_side");
        OJWContainer.textureMelonTop = generate("blocks/melon_top");

        for(int i = 0; i < OJWContainer.textureMelonCrop.length; i++)
            OJWContainer.textureMelonCrop[i] = TextureHelper.getInstance().registerBlockTexture("melonTile_" + (i + 1));
        blockMelonSeedsTile.texture = OJWContainer.textureMelonCrop[6];

        itemMelon.setTexture("/assets/ojw/textures/item/melon.png");
        itemMelonSeeds.setTexture("/assets/ojw/textures/item/melonSeeds.png");

        goldenEgg.setTexture("/assets/ojw/textures/item/goldenEgg.png");
        nuggetGold.setTexture("/assets/ojw/textures/item/nuggetGold.png");
        goldenNecklace.setTexture("/assets/ojw/textures/item/goldenNecklace.png");
        shard_glass.setTexture("/assets/ojw/textures/item/shard_glass.png");

        OJWContainer.textureDirtFrozen = generate("blocks/dirtFrozen");
        OJWContainer.textureSnowFrozen = generate("blocks/snowFrozen");
        OJWContainer.textureGrassFrozenSide = generate("blocks/grassFrozen");

        OJWContainer.textureDirtGlitch = generate("blocks/dirtGlitch");
        OJWContainer.textureGrassGlitchTop = generate("blocks/grassGlitchTop");
        OJWContainer.textureGrassGlitchSide = generate("blocks/grassGlitch");

        OJWContainer.textureDirtDark = generate("blocks/dirtDark");
        OJWContainer.textureGrassDarkTop = generate("blocks/grassDarkTop");
        OJWContainer.textureGrassDarkSide = generate("blocks/grassDark");

        OJWContainer.textureDirtCrystal = generate("blocks/dirtCrystal");
        OJWContainer.textureGrassCrystalTop = generate("blocks/grassCrystalTop");
        OJWContainer.textureGrassCrystalSide = generate("blocks/grassCrystal");

        OJWContainer.textureStoneFrozen = generate("blocks/stoneFrozen");
        OJWContainer.textureCobblestoneFrozen = generate("blocks/cobblestoneFrozen");
        OJWContainer.textureGravelFrozen = generate("blocks/gravelFrozen");

        OJWContainer.textureStonePurple = generate("blocks/stonePurple");
        OJWContainer.textureCobblestonePurple = generate("blocks/cobblestonePurple");
        OJWContainer.textureGravelPurple = generate("blocks/gravelPurple");

        OJWContainer.textureLogGlitchTop = generate("blocks/logGlitchTop");
        OJWContainer.textureLogGlitchSide = generate("blocks/logGlitch");
        OJWContainer.texturePlanksGlitch = generate("blocks/planksGlitch");
        OJWContainer.textureLeavesGlitch = generate("blocks/leavesGlitch");

        OJWContainer.textureLogSoulTop = generate("blocks/logSoulTop");
        OJWContainer.textureLogSoulSide = generate("blocks/logSoul");
        OJWContainer.texturePlanksSoul = generate("blocks/planksSoul");
        OJWContainer.textureLeavesSoul = generate("blocks/leavesSoul");

        OJWContainer.textureDebug = generate("blocks/debug");
        OJWContainer.textureCandleItem = TextureHelper.getInstance().registerItemTexture("candle");

        OJWContainer.spawnerExtended = JsonModel.get(Identifier.of(modID, "spawner_extended"));

        OJWContainer.gallowsFirst = JsonModel.get(Identifier.of(modID, "gallows_first"));
        OJWContainer.gallowsCenter = JsonModel.get(Identifier.of(modID, "gallows_center"));
        OJWContainer.gallowsTop = JsonModel.get(Identifier.of(modID, "gallows_top"));
        OJWContainer.gallowsEYE = JsonModel.get(Identifier.of(modID, "gallows_eye"));

        OJWContainer.candleSINGLE = JsonModel.get(Identifier.of(modID, "candle_single"));
    }

    @SuppressWarnings("unused")
    @EventListener
    public void registerEntityRenderers(EntityRendererRegisterEvent event)
    {
        event.renderers.put(EntityGoldenChicken.class, new ChickenRenderer(new Chicken(), 1.0f));
    }

    @SuppressWarnings("unused")
    @EventListener
    public void registerKeyBinding(KeyBindingRegisterEvent event) {
        int q = event.hashCode();
    }
}
