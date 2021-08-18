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
import kz.chesschicken.ojw.item.ItemMelon;
import kz.chesschicken.ojw.item.ItemSeedsMelon;
import kz.chesschicken.ojw.item.goldenegg.EntityGoldenChicken;
import kz.chesschicken.ojw.item.goldenegg.ItemGoldenEgg;
import kz.chesschicken.ojw.item.infopaper.ItemInfoPaper;
import kz.chesschicken.ojw.item.necklace.ItemNecklace;
import kz.chesschicken.ojw.item.pokeball.ItemPokeball;
import kz.chesschicken.ojw.utils.metarefernce.objects.SimpleBlockWithMeta;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.BlockBase;
import net.minecraft.client.render.entity.ChickenRenderer;
import net.minecraft.client.render.entity.model.Chicken;
import net.minecraft.item.ItemBase;
import net.minecraft.item.ItemInstance;
import net.modificationstation.stationapi.api.client.event.render.entity.EntityRendererRegisterEvent;
import net.modificationstation.stationapi.api.event.entity.EntityRegister;
import net.modificationstation.stationapi.api.event.recipe.RecipeRegisterEvent;
import net.modificationstation.stationapi.api.event.registry.BlockRegistryEvent;
import net.modificationstation.stationapi.api.event.registry.ItemRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.recipe.CraftingRegistry;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.registry.ModID;
import net.modificationstation.stationapi.api.template.item.TemplateItemBase;
import net.modificationstation.stationapi.api.util.Null;

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

    @Entrypoint.ModID public static ModID modID = Null.get();

    @SuppressWarnings("unused")
    @EventListener
    public void registerBlocks(BlockRegistryEvent event)
    {
        OJWLogger.INSTANCE.INIT.info("Registering blocks...");
        blockMelon = new BlockMelon(Identifier.of(modID, "melon")).setTranslationKey(modID, "blockMelon");
        blockMelonSeedsTile = new BlockMelonSeed(Identifier.of(modID, "melon_seeds"), blockMelon.id).setTranslationKey(modID, "blockMelonSeedsTile");

        blockDirtComplex = (SimpleBlockWithMeta) new BlockDirtComplex(Identifier.of(modID, "dirt_complex")).setTranslationKey(modID, "dirt_complex");
        blockGrassComplex = (SimpleBlockWithMeta) new BlockGrassComplex(Identifier.of(modID, "grass_complex")).setTranslationKey(modID, "grass_complex");

        MetaGrass.registerMeta(new FrozenGrass(0));
        MetaGrass.registerMeta(new GlitchGrass(1));
        MetaGrass.registerMeta(new DarkGrass(2));

        blockStoneComplex = (SimpleBlockWithMeta) new BlockStoneComplex(Identifier.of(modID, "stone_complex")).setTranslationKey(modID, "stone_complex");
        blockCobblestoneComplex = (SimpleBlockWithMeta) new BlockCobblestoneComplex(Identifier.of(modID, "cobblestone_complex")).setTranslationKey(modID, "cobblestone_complex");
        blockGravelComplex = (SimpleBlockWithMeta) new BlockGravelComplex(Identifier.of(modID, "gravel_complex")).setTranslationKey(modID, "gravel_complex");

        MetaRock.registerRock(new FrozenRock(0));
    }

    @SuppressWarnings("unused")
    @EventListener
    public void registerItems(ItemRegistryEvent event)
    {
        OJWLogger.INSTANCE.INIT.info("Registering items...");
        itemMelon = new ItemMelon(Identifier.of(modID, "melon_item")).setTranslationKey(modID, "itemMelon");
        itemMelonSeeds = new ItemSeedsMelon(Identifier.of(modID, "melon_seeds_item")).setTranslationKey(modID, "itemmelonseeds");
        infoPaper = new ItemInfoPaper(Identifier.of(modID, "infopaper")).setTranslationKey(modID, "infoPaper");
        goldenEgg = new ItemGoldenEgg(Identifier.of(modID, "gold_egg")).setTranslationKey(modID, "goldenEgg");
        nuggetGold = new TemplateItemBase(Identifier.of(modID, "nugget_gold")).setTranslationKey(modID, "nuggetGold");
        goldenNecklace = new ItemNecklace(Identifier.of(modID, "golden_necklace")).setTranslationKey(modID, "goldenNecklace");
        pokeBall = new ItemPokeball(Identifier.of(modID, "pokeball")).setTranslationKey(modID, "pokeball");
    }

    @SuppressWarnings({"unused", "UnnecessaryBoxing"})
    @EventListener
    public void registerRecipe(RecipeRegisterEvent event)
    {
        OJWLogger.INSTANCE.INIT.info("Registering recipes (" + event.recipeId.toString() + ")...");
        Identifier type = event.recipeId;

        if(type == RecipeRegisterEvent.Vanilla.CRAFTING_SHAPED.type())
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
        if(type == RecipeRegisterEvent.Vanilla.CRAFTING_SHAPELESS.type())
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
        event.register(EntityGoldenChicken.class, "ojw:goldenchicken", 20);
        event.register(EntityGoldenChicken.class, "ojw:goldenegg", 21);
    }

    @SuppressWarnings("unused")
    @EventListener
    public void registerEntityRenderers(EntityRendererRegisterEvent event)
    {
        event.renderers.put(EntityGoldenChicken.class, new ChickenRenderer(new Chicken(), 1.0f));
    }

}
