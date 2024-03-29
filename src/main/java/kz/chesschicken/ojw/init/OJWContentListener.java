package kz.chesschicken.ojw.init;

import kz.chesschicken.ojw.block.*;
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
import kz.chesschicken.ojw.block.hardmaterial.instances.FrozenRock;
import kz.chesschicken.ojw.block.hardmaterial.instances.PurpleRock;
import kz.chesschicken.ojw.block.wood.BlockLeavesComplex;
import kz.chesschicken.ojw.block.wood.BlockLogComplex;
import kz.chesschicken.ojw.block.wood.BlockPlanksComplex;
import kz.chesschicken.ojw.block.wood.MetaWood;
import kz.chesschicken.ojw.block.wood.instances.GlitchWood;
import kz.chesschicken.ojw.block.wood.instances.SoulWood;
import kz.chesschicken.ojw.item.goldenegg.EntityGoldenChicken;
import kz.chesschicken.ojw.item.goldenegg.ItemGoldenEgg;
import kz.chesschicken.ojw.item.infopaper.ItemInfoPaper;
import kz.chesschicken.ojw.item.necklace.ItemNecklace;
import kz.chesschicken.ojw.item.pokeball.ItemCatcher;
import net.fabricmc.loader.api.FabricLoader;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.BlockBase;
import net.minecraft.item.ItemBase;
import net.minecraft.item.ItemInstance;
import net.modificationstation.stationapi.api.event.entity.EntityRegister;
import net.modificationstation.stationapi.api.event.mod.InitEvent;
import net.modificationstation.stationapi.api.event.recipe.RecipeRegisterEvent;
import net.modificationstation.stationapi.api.event.registry.BlockRegistryEvent;
import net.modificationstation.stationapi.api.event.registry.ItemRegistryEvent;
import net.modificationstation.stationapi.api.event.tileentity.TileEntityRegisterEvent;
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
 * Blocks, Items, Recipe, Entity
 */
public class OJWContentListener {
    public static OJWConfig config;

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
    public static TemplateBlockBase blockDirtComplex;
    public static TemplateBlockBase blockGrassComplex;

    public static TemplateBlockBase blockStoneComplex;
    public static TemplateBlockBase blockCobblestoneComplex;
    public static TemplateBlockBase blockGravelComplex;

    public static TemplateBlockBase blockLogComplex;
    public static TemplateBlockBase blockPlanksComplex;
    public static TemplateBlockBase blockLeavesComplex;
    //end line

    public static TemplateBlockBase stairs_wool;
    public static TemplateBlockBase gallowsBlock;
    public static TemplateBlockBase candleBlock;

    public static TemplateItemBase shard_glass;

    @Entrypoint.ModID public static ModID modID = Null.get();

    @SuppressWarnings("unused")
    @EventListener
    public void registerBlocks(BlockRegistryEvent event)
    {
        OJWLogger.INIT.info("Registering blocks...");
        blockMelon = new BlockMelon(Identifier.of(modID, "melon_block")).setTranslationKey(modID, "melon_block");
        blockMelonSeedsTile = new BlockMelonSeed(Identifier.of(modID, "melon_seeds"), blockMelon.id).setTranslationKey(modID, "melon_seeds");

        blockDirtComplex = new BlockDirtComplex(Identifier.of(modID, "dirt_complex")).setTranslationKey(modID, "dirt_complex");
        blockGrassComplex = new BlockGrassComplex(Identifier.of(modID, "grass_complex")).setTranslationKey(modID, "grass_complex");
        MetaGrass.setMetadataCollection(new FrozenGrass(0), new GlitchGrass(1), new DarkGrass(2), new CrystalGrass(3));

        blockStoneComplex = new BlockStoneComplex(Identifier.of(modID, "stone_complex")).setTranslationKey(modID, "stone_complex");
        blockCobblestoneComplex = new BlockCobblestoneComplex(Identifier.of(modID, "cobblestone_complex")).setTranslationKey(modID, "cobblestone_complex");
        blockGravelComplex = new BlockGravelComplex(Identifier.of(modID, "gravel_complex")).setTranslationKey(modID, "gravel_complex");
        MetaRock.setMetadataCollection(new FrozenRock(0), new PurpleRock(1),
                new kz.chesschicken.ojw.block.hardmaterial.instances.Empty(2),
                new kz.chesschicken.ojw.block.hardmaterial.instances.Empty(3));

        blockLogComplex = new BlockLogComplex(Identifier.of(modID, "log_complex")).setTranslationKey(modID, "log_complex");
        blockPlanksComplex = new BlockPlanksComplex(Identifier.of(modID, "planks_complex")).setTranslationKey(modID, "planks_complex");
        blockLeavesComplex = new BlockLeavesComplex(Identifier.of(modID, "leaves_complex")).setTranslationKey(modID, "leaves_complex");
        MetaWood.setMetadataCollection(new GlitchWood(0), new SoulWood(1),
                new kz.chesschicken.ojw.block.wood.instances.Empty(2),
                new kz.chesschicken.ojw.block.wood.instances.Empty(3));

        stairs_wool = new BlockStairsWool(Identifier.of(modID, "stairs_wool")).setTranslationKey(modID, "stairs_wool");
        gallowsBlock = new BlockGallows(Identifier.of(modID, "gallows")).setTranslationKey(modID, "gallows");
        candleBlock = new BlockCandle(Identifier.of(modID, "candle")).setTranslationKey(modID, "candle");
    }

    @SuppressWarnings("unused")
    @EventListener
    public void registerItems(ItemRegistryEvent event)
    {
        OJWLogger.INIT.info("Registering items...");
        itemMelon = new TemplateFoodBase(Identifier.of(modID, "melon_item"), 2, false).setMaxStackSize(8).setTranslationKey(modID, "melon_item");
        itemMelonSeeds = new TemplateSeeds(Identifier.of(modID, "melon_seeds_item"), OJWContentListener.blockMelonSeedsTile.id).setTranslationKey(modID, "melon_seeds_item");
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
        OJWLogger.INIT.info("Registering recipes of (" + event.recipeId.toString() + ")...");
        Identifier type = event.recipeId;

        if(type == RecipeRegisterEvent.Vanilla.CRAFTING_SHAPED.type() && FabricLoader.getInstance().isDevelopmentEnvironment())
        {
            //FIXME: Delete after releasing
            CraftingRegistry.addShapedRecipe(new ItemInstance(goldenNecklace), "XX", Character.valueOf('X'), BlockBase.SAND);
            CraftingRegistry.addShapedRecipe(new ItemInstance(ItemBase.leatherChestplate), "X", "X", Character.valueOf('X'), BlockBase.SAND);
        }
        if(type == RecipeRegisterEvent.Vanilla.CRAFTING_SHAPELESS.type())
        {
            for(int i = 0; i < MetaWood.metadataCollection.length; i++)
            {
                CraftingRegistry.addShapelessRecipe(new ItemInstance(blockPlanksComplex, 4, i),
                        new ItemInstance(blockLogComplex, 1, i));
            }
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
    public void loadConfig(InitEvent event) {
        config = new OJWConfig();
        config.start();
    }

    @SuppressWarnings("unused")
    @EventListener
    public void registerTileEntity(TileEntityRegisterEvent event) {

    }
}
