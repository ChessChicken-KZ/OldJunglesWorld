package kz.chesschicken.ojw.init;

import kz.chesschicken.ojw.block.BlockMelon;
import kz.chesschicken.ojw.block.BlockMelonSeed;
import kz.chesschicken.ojw.item.ItemDebugEquipo;
import kz.chesschicken.ojw.item.ItemMelon;
import kz.chesschicken.ojw.item.ItemSeedsMelon;
import kz.chesschicken.ojw.item.goldenegg.EntityGoldenChicken;
import kz.chesschicken.ojw.item.goldenegg.ItemGoldenEgg;
import kz.chesschicken.ojw.item.infopaper.ItemInfoPaper;
import net.minecraft.client.render.entity.ChickenRenderer;
import net.minecraft.client.render.entity.model.Chicken;
import net.minecraft.item.ItemInstance;
import net.modificationstation.stationapi.api.client.event.render.entity.EntityRendererRegister;
import net.modificationstation.stationapi.api.client.event.texture.TextureRegister;
import net.modificationstation.stationapi.api.client.texture.TextureFactory;
import net.modificationstation.stationapi.api.client.texture.TextureRegistry;
import net.modificationstation.stationapi.api.common.event.EventListener;
import net.modificationstation.stationapi.api.common.event.block.BlockRegister;
import net.modificationstation.stationapi.api.common.event.entity.EntityRegister;
import net.modificationstation.stationapi.api.common.event.item.ItemRegister;
import net.modificationstation.stationapi.api.common.event.recipe.RecipeRegister;
import net.modificationstation.stationapi.api.common.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.common.recipe.CraftingRegistry;
import net.modificationstation.stationapi.api.common.registry.Identifier;
import net.modificationstation.stationapi.api.common.registry.ModID;
import net.modificationstation.stationapi.api.common.util.Null;
import net.modificationstation.stationapi.template.common.block.BlockBase;
import net.modificationstation.stationapi.template.common.block.Dirt;
import net.modificationstation.stationapi.template.common.item.ItemBase;

/**
 * Blocks, Items, Textures, Recipe
 */
public class OJWContentListener {


    public static net.minecraft.item.ItemBase itemMelon;
    public static net.minecraft.item.ItemBase itemMelonSeeds;
    public static net.minecraft.block.BlockBase blockMelon;
    public static net.minecraft.block.BlockBase blockMelonSeedsTile;

    public static net.minecraft.block.BlockBase blockFrozenDirt;

    public static net.minecraft.item.ItemBase infoPaper;

    public static net.minecraft.item.ItemBase goldenEgg;
    public static net.minecraft.item.ItemBase nuggetGold;

    public static net.minecraft.item.ItemBase debugItem;

    public static int texture_MelonSIDE;
    public static int texture_MelonTOP;

    public static int[] texture_MelonTile = new int[7];


    @Entrypoint.ModID public static ModID modID = Null.get();




    @SuppressWarnings("unused")
    @EventListener
    public void registerBlocks(BlockRegister event)
    {
        OJWLogger.INSTANCE.INIT.info("Registering blocks...");
        blockMelon = new BlockMelon(Identifier.of(modID, "blockmelon")).setTranslationKey(modID, "blockMelon");
        blockMelonSeedsTile = new BlockMelonSeed(Identifier.of(modID, "blockmelonseedstile"), blockMelon.id).setTranslationKey(modID, "blockMelonSeedsTile");
        blockFrozenDirt = new Dirt(Identifier.of(modID, "blockfrozendirt"), 0).setTranslationKey(modID, "blockFrozenDirt");
    }

    @SuppressWarnings("unused")
    @EventListener
    public void registerItems(ItemRegister event)
    {
        OJWLogger.INSTANCE.INIT.info("Registering items...");
        itemMelon = new ItemMelon(Identifier.of(modID, "itemmelon")).setTranslationKey(modID, "itemMelon");
        itemMelonSeeds = new ItemSeedsMelon(Identifier.of(modID, "itemmelonseeds")).setTranslationKey(modID, "itemmelonseeds");
        infoPaper = new ItemInfoPaper(Identifier.of(modID, "infopaper")).setTranslationKey(modID, "infoPaper");
        goldenEgg = new ItemGoldenEgg(Identifier.of(modID, "goldenegg")).setTranslationKey(modID, "goldenEgg");
        nuggetGold = new ItemBase(Identifier.of(modID, "nuggetgold")).setTranslationKey(modID, "nuggetGold");
        debugItem = new ItemDebugEquipo(Identifier.of(modID, "debugitem")).setTranslationKey(modID, "debugitem");
    }

    @SuppressWarnings("unused")
    @EventListener
    public void registerRecipe(RecipeRegister event)
    {
        OJWLogger.INSTANCE.INIT.info("Registering recipes (" + event.recipeId.toString() + ")...");
        Identifier type = event.recipeId;

        if(type == RecipeRegister.Vanilla.CRAFTING_SHAPED.type())
        {
            CraftingRegistry.addShapedRecipe(new ItemInstance(blockMelon),
                    "XXX", "XXX", "XXX", Character.valueOf('X'), itemMelon);

            CraftingRegistry.addShapedRecipe(new ItemInstance(ItemBase.goldIngot),
                    "XXX", "XXX", "XXX", Character.valueOf('X'), nuggetGold);


            //FIXME: Delete after releasing
            CraftingRegistry.addShapedRecipe(new ItemInstance(debugItem),
                    "XX", Character.valueOf('X'), BlockBase.SAND);
            CraftingRegistry.addShapedRecipe(new ItemInstance(ItemBase.leatherChestplate),
                    "X", "X", Character.valueOf('X'), BlockBase.SAND);


        }
        if(type == RecipeRegister.Vanilla.CRAFTING_SHAPELESS.type())
        {
            CraftingRegistry.addShapelessRecipe(new ItemInstance(itemMelonSeeds),
                    itemMelon);
            CraftingRegistry.addShapelessRecipe(new ItemInstance(nuggetGold, 9),
                    ItemBase.goldIngot);
        }
    }

    @SuppressWarnings("unused")
    @EventListener
    public void registerEntity(EntityRegister event)
    {
        event.register.accept(EntityGoldenChicken.class, "ojw:goldenchicken", 20);
        event.register.accept(EntityGoldenChicken.class, "ojw:goldenegg", 21);
    }

    @SuppressWarnings("unused")
    @EventListener
    public void registerEntityRenderers(EntityRendererRegister event)
    {
        event.renderers.put(EntityGoldenChicken.class, new ChickenRenderer(new Chicken(), 1.0f));
    }

    @SuppressWarnings("unused")
    @EventListener
    public void registerTextures(TextureRegister event)
    {
        OJWLogger.INSTANCE.INIT.info("Registering textures...");
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

        blockFrozenDirt.texture = TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/ojw/textures/block/melonTile_7.png");

        goldenEgg.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/ojw/textures/item/goldenEgg.png"));
        nuggetGold.setTexturePosition(TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("GUI_ITEMS"), "/assets/ojw/textures/item/nuggetGold.png"));
    }

}
