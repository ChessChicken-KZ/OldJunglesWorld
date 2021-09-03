package kz.chesschicken.ojw.init;

import kz.chesschicken.ojw.block.BlockMelon;
import kz.chesschicken.ojw.block.BlockMelonSeed;
import kz.chesschicken.ojw.block.BlockSpawnerExtended;
import kz.chesschicken.ojw.block.grass.BlockDirtComplex;
import kz.chesschicken.ojw.block.grass.BlockGrassComplex;
import kz.chesschicken.ojw.block.grass.MetaGrass;
import kz.chesschicken.ojw.block.grass.instances.CrystalGrass;
import kz.chesschicken.ojw.block.grass.instances.DarkGrass;
import kz.chesschicken.ojw.block.grass.instances.FrozenGrass;
import kz.chesschicken.ojw.block.grass.instances.GlitchGrass;
import kz.chesschicken.ojw.block.hardmaterial.BlockCobblestoneComplex;
import kz.chesschicken.ojw.block.hardmaterial.BlockGravelComplex;
import kz.chesschicken.ojw.block.hardmaterial.BlockStoneComplex;
import kz.chesschicken.ojw.block.hardmaterial.MetaRock;
import kz.chesschicken.ojw.block.hardmaterial.instances.Empty;
import kz.chesschicken.ojw.block.hardmaterial.instances.FrozenRock;
import kz.chesschicken.ojw.block.hardmaterial.instances.PurpleRock;
import kz.chesschicken.ojw.block.wood.BlockLogComplex;
import kz.chesschicken.ojw.block.wood.BlockPlanksComplex;
import kz.chesschicken.ojw.block.wood.MetaWood;
import kz.chesschicken.ojw.block.wood.instances.GlitchWood;
import kz.chesschicken.ojw.item.ItemSeedsMelon;
import kz.chesschicken.ojw.item.goldenegg.EntityGoldenChicken;
import kz.chesschicken.ojw.item.goldenegg.ItemGoldenEgg;
import kz.chesschicken.ojw.item.infopaper.ItemInfoPaper;
import kz.chesschicken.ojw.item.necklace.ItemNecklace;
import kz.chesschicken.ojw.item.pokeball.ItemCatcher;
import kz.chesschicken.ojw.utils.metarefernce.objects.BlockSimpleMeta;
import net.fabricmc.loader.api.FabricLoader;
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
import net.modificationstation.stationapi.api.event.registry.EntityHandlerRegistryEvent;
import net.modificationstation.stationapi.api.event.registry.ItemRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.recipe.CraftingRegistry;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.registry.ModID;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;
import net.modificationstation.stationapi.api.template.block.TemplatePlant;
import net.modificationstation.stationapi.api.template.item.TemplateItemBase;
import net.modificationstation.stationapi.api.template.item.TemplateSeeds;
import net.modificationstation.stationapi.api.template.item.food.TemplateFoodBase;
import net.modificationstation.stationapi.api.util.Null;

/**
 * Blocks, Items, Recipe
 */
public class OJWContentListener {

    public static TemplateFoodBase itemMelon;
    public static TemplateSeeds itemMelonSeeds;
    public static TemplateBlockBase blockMelon;
    public static TemplatePlant blockMelonSeedsTile;

    public static TemplateItemBase infoPaper;

    public static TemplateItemBase goldenEgg;
    public static TemplateItemBase nuggetGold;

    public static TemplateItemBase goldenNecklace;

    public static TemplateItemBase catcher;

    //Usually for blocks with same params, but different textures.
    public static BlockSimpleMeta blockDirtComplex;
    public static BlockSimpleMeta blockGrassComplex;

    public static BlockSimpleMeta blockStoneComplex;
    public static BlockSimpleMeta blockCobblestoneComplex;
    public static BlockSimpleMeta blockGravelComplex;

    public static BlockSimpleMeta blockLogComplex;
    public static BlockSimpleMeta blockPlanksComplex;
    //end line

    public static TemplateBlockBase spawnerExtended;

    public static TemplateItemBase shard_glass;

    @Entrypoint.ModID public static ModID modID = Null.get();

    @SuppressWarnings("unused")
    @EventListener
    public void registerBlocks(BlockRegistryEvent event)
    {
        OJWLogger.INSTANCE.INIT.info("Registering blocks...");
        blockMelon = new BlockMelon(Identifier.of(modID, "melon")).setTranslationKey(modID, "melon");
        blockMelonSeedsTile = new BlockMelonSeed(Identifier.of(modID, "melon_seeds"), blockMelon.id).setTranslationKey(modID, "melon_seeds");

        blockDirtComplex = (BlockSimpleMeta) new BlockDirtComplex(Identifier.of(modID, "dirt_complex")).setTranslationKey(modID, "dirt_complex");
        blockGrassComplex = (BlockSimpleMeta) new BlockGrassComplex(Identifier.of(modID, "grass_complex")).setTranslationKey(modID, "grass_complex");

        MetaGrass.registerMeta(new FrozenGrass(0));
        MetaGrass.registerMeta(new GlitchGrass(1));
        MetaGrass.registerMeta(new DarkGrass(2));
        MetaGrass.registerMeta(new CrystalGrass(3));

        blockStoneComplex = (BlockSimpleMeta) new BlockStoneComplex(Identifier.of(modID, "stone_complex")).setTranslationKey(modID, "stone_complex");
        blockCobblestoneComplex = (BlockSimpleMeta) new BlockCobblestoneComplex(Identifier.of(modID, "cobblestone_complex")).setTranslationKey(modID, "cobblestone_complex");
        blockGravelComplex = (BlockSimpleMeta) new BlockGravelComplex(Identifier.of(modID, "gravel_complex")).setTranslationKey(modID, "gravel_complex");

        MetaRock.registerRock(new FrozenRock(0));
        MetaRock.registerRock(new PurpleRock(1));

        MetaRock.registerRock(new Empty(2));
        MetaRock.registerRock(new Empty(3));

        blockLogComplex = (BlockSimpleMeta) new BlockLogComplex(Identifier.of(modID, "log_complex")).setTranslationKey(modID, "log_complex");
        blockPlanksComplex = (BlockSimpleMeta) new BlockPlanksComplex(Identifier.of(modID, "planks_complex")).setTranslationKey(modID, "planks_complex");

        MetaWood.registerWood(new GlitchWood(0));

        spawnerExtended = new BlockSpawnerExtended(Identifier.of(modID, "spawner")).setTranslationKey(modID, "spawner_extended");
    }

    @SuppressWarnings("unused")
    @EventListener
    public void registerItems(ItemRegistryEvent event)
    {
        OJWLogger.INSTANCE.INIT.info("Registering items...");
        itemMelon = new TemplateFoodBase(Identifier.of(modID, "melon_item"), 2, false).setMaxStackSize(8).setTranslationKey(modID, "melon_item");
        itemMelonSeeds = new ItemSeedsMelon(Identifier.of(modID, "melon_seeds_item")).setTranslationKey(modID, "melon_seeds_item");
        infoPaper = new ItemInfoPaper(Identifier.of(modID, "infopaper")).setTranslationKey(modID, "infopaper");
        goldenEgg = new ItemGoldenEgg(Identifier.of(modID, "gold_egg")).setTranslationKey(modID, "gold_egg");
        nuggetGold = new TemplateItemBase(Identifier.of(modID, "nugget_gold")).setTranslationKey(modID, "nugget_gold");
        goldenNecklace = new ItemNecklace(Identifier.of(modID, "golden_necklace")).setTranslationKey(modID, "golden_necklace");
        catcher = new ItemCatcher(Identifier.of(modID, "catcher")).setTranslationKey(modID, "catcher");

        shard_glass = new TemplateItemBase(Identifier.of(modID, "shard_glass")).setTranslationKey(modID, "shard_glass");
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


            //FIXME: Delete after releasing
            if(FabricLoader.getInstance().isDevelopmentEnvironment())
            {
                CraftingRegistry.addShapedRecipe(new ItemInstance(goldenNecklace),
                        "XX", Character.valueOf('X'), BlockBase.SAND);
                CraftingRegistry.addShapedRecipe(new ItemInstance(ItemBase.leatherChestplate),
                        "X", "X", Character.valueOf('X'), BlockBase.SAND);
            }

        }
        if(type == RecipeRegisterEvent.Vanilla.CRAFTING_SHAPELESS.type())
        {
            CraftingRegistry.addShapelessRecipe(new ItemInstance(itemMelonSeeds),
                    itemMelon);
        }
    }

    @SuppressWarnings("unused")
    @EventListener
    public void registerEntity(EntityRegister event)
    {
        event.register(EntityGoldenChicken.class, "ojw:golden_chicken", 20);
        event.register(EntityGoldenChicken.class, "ojw:golden_egg", 21);
    }

    @SuppressWarnings("unused")
    @EventListener
    public void registerEntityRenderers(EntityRendererRegisterEvent event)
    {
        event.renderers.put(EntityGoldenChicken.class, new ChickenRenderer(new Chicken(), 1.0f));
    }

    @SuppressWarnings("unused")
    @EventListener
    public void registerEntityHandlers(EntityHandlerRegistryEvent event)
    {

    }

}
