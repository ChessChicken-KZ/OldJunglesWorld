package kz.chesschicken.ojw.init;

import kz.chesschicken.ojw.block.BlockMelon;
import kz.chesschicken.ojw.block.BlockMelonSeed;
import kz.chesschicken.ojw.block.grass.BlockDirtComplex;
import kz.chesschicken.ojw.block.grass.BlockGrassComplex;
import kz.chesschicken.ojw.block.grass.MetaGrass;
import kz.chesschicken.ojw.block.grass.instances.DarkGrass;
import kz.chesschicken.ojw.block.grass.instances.FrozenGrass;
import kz.chesschicken.ojw.block.grass.instances.GlitchGrass;
import kz.chesschicken.ojw.block.hardmaterial.BlockCobblestoneComplex;
import kz.chesschicken.ojw.block.hardmaterial.BlockGravelComplex;
import kz.chesschicken.ojw.block.hardmaterial.BlockStoneComplex;
import kz.chesschicken.ojw.block.hardmaterial.MetaRock;
import kz.chesschicken.ojw.block.hardmaterial.instances.FrozenRock;
import kz.chesschicken.ojw.item.necklace.ItemNecklace;
import kz.chesschicken.ojw.item.ItemMelon;
import kz.chesschicken.ojw.item.ItemSeedsMelon;
import kz.chesschicken.ojw.item.goldenegg.EntityGoldenChicken;
import kz.chesschicken.ojw.item.goldenegg.ItemGoldenEgg;
import kz.chesschicken.ojw.item.infopaper.ItemInfoPaper;
import kz.chesschicken.ojw.item.pokeball.ItemPokeball;
import kz.chesschicken.ojw.utils.TextureHelper;
import kz.chesschicken.ojw.utils.metarefernce.objects.SimpleBlockWithMeta;
import net.minecraft.client.render.entity.ChickenRenderer;
import net.minecraft.client.render.entity.model.Chicken;
import net.minecraft.item.ItemInstance;
import net.modificationstation.stationapi.api.client.event.render.entity.EntityRendererRegister;
import net.modificationstation.stationapi.api.client.event.texture.TextureRegister;
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
import net.modificationstation.stationapi.template.common.item.ItemBase;

/**
 * Blocks, Items, Textures, Recipe
 */
public class OJWContentListener {

    public static net.minecraft.item.ItemBase itemMelon;
    public static net.minecraft.item.ItemBase itemMelonSeeds;
    public static net.minecraft.block.BlockBase blockMelon;
    public static net.minecraft.block.BlockBase blockMelonSeedsTile;

    public static net.minecraft.item.ItemBase infoPaper;

    public static net.minecraft.item.ItemBase goldenEgg;
    public static net.minecraft.item.ItemBase nuggetGold;

    public static net.minecraft.item.ItemBase goldenNecklace;

    public static net.minecraft.item.ItemBase pokeBall;

    //Usually for blocks with same params, but different textures.
    public static SimpleBlockWithMeta blockDirtComplex;
    public static SimpleBlockWithMeta blockGrassComplex;

    public static SimpleBlockWithMeta blockStoneComplex;
    public static SimpleBlockWithMeta blockCobblestoneComplex;
    public static SimpleBlockWithMeta blockGravelComplex;

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


    public static int texture_MelonSIDE;
    public static int texture_MelonTOP;

    public static int[] texture_MelonTile = new int[7];



    @Entrypoint.ModID public static ModID modID = Null.get();

    @SuppressWarnings("unused")
    @EventListener
    public void registerBlocks(BlockRegister event)
    {
        OJWLogger.INSTANCE.INIT.info("Registering blocks...");
        blockMelon = new BlockMelon(Identifier.of(modID, "melon")).setTranslationKey(modID, "blockMelon");
        blockMelonSeedsTile = new BlockMelonSeed(Identifier.of(modID, "melon_seeds"), blockMelon.id).setTranslationKey(modID, "blockMelonSeedsTile");

        blockDirtComplex = (SimpleBlockWithMeta) new BlockDirtComplex(Identifier.of(modID, "dirt_complex")).setTranslationKey(modID, "blockDirtComplex");
        blockGrassComplex = (SimpleBlockWithMeta) new BlockGrassComplex(Identifier.of(modID, "grass_complex")).setTranslationKey(modID, "blockGrassComplex");

        MetaGrass.registerMeta(new FrozenGrass(0));
        MetaGrass.registerMeta(new GlitchGrass(1));
        MetaGrass.registerMeta(new DarkGrass(2));

        blockStoneComplex = (SimpleBlockWithMeta) new BlockStoneComplex(Identifier.of(modID, "stone_complex")).setTranslationKey(modID, "blockStoneComplex");
        blockCobblestoneComplex = (SimpleBlockWithMeta) new BlockCobblestoneComplex(Identifier.of(modID, "cobblestone_complex")).setTranslationKey(modID, "blockCobblestoneComplex");
        blockGravelComplex = (SimpleBlockWithMeta) new BlockGravelComplex(Identifier.of(modID, "stone_complex")).setTranslationKey(modID, "blockGravelComplex");

        MetaRock.registerRock(new FrozenRock(0));
    }

    @SuppressWarnings("unused")
    @EventListener
    public void registerItems(ItemRegister event)
    {
        OJWLogger.INSTANCE.INIT.info("Registering items...");
        itemMelon = new ItemMelon(Identifier.of(modID, "melon_item")).setTranslationKey(modID, "itemMelon");
        itemMelonSeeds = new ItemSeedsMelon(Identifier.of(modID, "melon_seeds_item")).setTranslationKey(modID, "itemmelonseeds");
        infoPaper = new ItemInfoPaper(Identifier.of(modID, "infopaper")).setTranslationKey(modID, "infoPaper");
        goldenEgg = new ItemGoldenEgg(Identifier.of(modID, "gold_egg")).setTranslationKey(modID, "goldenEgg");
        nuggetGold = new ItemBase(Identifier.of(modID, "nugget_gold")).setTranslationKey(modID, "nuggetGold");
        goldenNecklace = new ItemNecklace(Identifier.of(modID, "golden_necklace")).setTranslationKey(modID, "goldenNecklace");
        pokeBall = new ItemPokeball(Identifier.of(modID, "pokeball")).setTranslationKey(modID, "pokeball");
    }

    @SuppressWarnings({"unused", "UnnecessaryBoxing"})
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

            CraftingRegistry.addShapedRecipe(new ItemInstance(goldenNecklace),
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
        texture_MelonSIDE = TextureHelper.getInstance().registerBlockTexture("melonSide");
        texture_MelonTOP = TextureHelper.getInstance().registerBlockTexture("melonTop");

        for(int i = 0; i < texture_MelonTile.length; i++)
        {
            texture_MelonTile[i] = TextureHelper.getInstance().registerBlockTexture("melonTile_" + (i + 1));
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
