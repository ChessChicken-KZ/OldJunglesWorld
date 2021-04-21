package kz.chesschicken.ojw.init;

import kz.chesschicken.ojw.block.BlockMelon;
import kz.chesschicken.ojw.block.ItemSeedsMelon;
import kz.chesschicken.ojw.block.TileMelonSeed;
import kz.chesschicken.ojw.level.biome.*;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.biome.Biome;
import net.modificationstation.stationapi.api.client.event.texture.TextureRegister;
import net.modificationstation.stationapi.api.client.texture.TextureFactory;
import net.modificationstation.stationapi.api.client.texture.TextureRegistry;
import net.modificationstation.stationapi.api.common.event.EventListener;
import net.modificationstation.stationapi.api.common.event.ListenerPriority;
import net.modificationstation.stationapi.api.common.event.block.BlockRegister;
import net.modificationstation.stationapi.api.common.event.item.ItemRegister;
import net.modificationstation.stationapi.api.common.event.level.biome.BiomeRegister;
import net.modificationstation.stationapi.api.common.event.recipe.RecipeRegister;
import net.modificationstation.stationapi.api.common.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.common.recipe.CraftingRegistry;
import net.modificationstation.stationapi.api.common.registry.Identifier;
import net.modificationstation.stationapi.api.common.registry.ModID;
import net.modificationstation.stationapi.api.common.util.Null;
import net.modificationstation.stationapi.template.common.item.food.FoodBase;

public class OldJunglesWorldListener {
    public static Biome bBirchForest;
    public static Biome bConiferousForest;
    public static Biome bJungle;
    public static Biome cShrubland;
    public static Biome cSavanna;
    public static Biome cSwampland;

    public static net.minecraft.item.ItemBase itemMelon;
    public static net.minecraft.item.ItemBase itemMelonSeeds;
    public static net.minecraft.block.BlockBase blockMelon;
    public static net.minecraft.block.BlockBase blockMelonSeedsTile;

    public static int texture_MelonSIDE;
    public static int texture_MelonTOP;

    public static int[] texture_MelonTile = new int[7];


    @Entrypoint.ModID public static ModID modID = Null.get();


    @SuppressWarnings("unused")
    @EventListener
    public void registerBiome(BiomeRegister event)
    {
        bBirchForest = new BirchForest();
        bConiferousForest = new ConiferousForest();
        bJungle = new Jungle();
        cShrubland = new Shrubland();
        cSavanna = new Savanna();
        cSwampland = new Swampland();
    }

    @SuppressWarnings("unused")
    @EventListener(priority = ListenerPriority.HIGH)
    public void registerBlocks(BlockRegister event)
    {
        blockMelon = new BlockMelon(Identifier.of(modID, "blockmelon")).setTranslationKey(modID, "blockMelon");
        blockMelonSeedsTile = new TileMelonSeed(Identifier.of(modID, "blockmelonseedstile"), blockMelon.id).setTranslationKey(modID, "blockMelonSeedsTile");
    }

    @SuppressWarnings("unused")
    @EventListener(priority = ListenerPriority.LOW)
    public void registerItems(ItemRegister event)
    {
        itemMelon = new FoodBase(Identifier.of(modID, "itemmelon"), 2, false).setTranslationKey(modID, "itemMelon");
        itemMelonSeeds = new ItemSeedsMelon(Identifier.of(modID, "itemmelonseeds")).setTranslationKey(modID, "itemmelonseeds");
    }

    @SuppressWarnings("unused")
    @EventListener
    public void registerRecipe(RecipeRegister event)
    {
        Identifier type = event.recipeId;

        if(type == RecipeRegister.Vanilla.CRAFTING_SHAPED.type())
        {
            CraftingRegistry.addShapedRecipe(new ItemInstance(blockMelon),
                    "XXX", "XXX", "XXX", Character.valueOf('X'), itemMelon);
        }
        if(type == RecipeRegister.Vanilla.CRAFTING_SHAPELESS.type())
        {
            CraftingRegistry.addShapelessRecipe(new ItemInstance(itemMelonSeeds),
                    itemMelon);
        }
    }

    @SuppressWarnings("unused")
    @EventListener
    public void registerTextures(TextureRegister event)
    {
        texture_MelonSIDE = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/ojw/textures/block/melonSide.png");
        texture_MelonTOP = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/ojw/textures/block/melonTop.png");

        texture_MelonTile[0] = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/ojw/textures/block/melonTile_1.png");
        texture_MelonTile[1] = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/ojw/textures/block/melonTile_2.png");
        texture_MelonTile[2] = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/ojw/textures/block/melonTile_3.png");
        texture_MelonTile[3] = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/ojw/textures/block/melonTile_4.png");
        texture_MelonTile[4] = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/ojw/textures/block/melonTile_5.png");
        texture_MelonTile[5] = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/ojw/textures/block/melonTile_6.png");
        texture_MelonTile[6] = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/ojw/textures/block/melonTile_7.png");

        itemMelon.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/ojw/textures/item/melon.png"));
        itemMelonSeeds.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/ojw/textures/item/melonSeeds.png"));
    }
}
