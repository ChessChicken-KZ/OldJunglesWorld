package kz.chesschicken.ojw.init;

import kz.chesschicken.ojw.block.BlockMelon;
import kz.chesschicken.ojw.block.TileMelonSeed;
import kz.chesschicken.ojw.item.ItemMelon;
import kz.chesschicken.ojw.item.ItemSeedsMelon;
import kz.chesschicken.ojw.item.infopaper.ItemInfoPaper;
import kz.chesschicken.ojw.level.biome.*;
import kz.chesschicken.ojw.level.biome.varitations.EverTundra;
import kz.chesschicken.ojw.level.biome.varitations.SwampTundra;
import kz.chesschicken.ojw.structure.PlantGroup;
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
import net.modificationstation.stationapi.api.common.event.level.gen.ChunkDecoration;
import net.modificationstation.stationapi.api.common.event.recipe.RecipeRegister;
import net.modificationstation.stationapi.api.common.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.common.recipe.CraftingRegistry;
import net.modificationstation.stationapi.api.common.registry.Identifier;
import net.modificationstation.stationapi.api.common.registry.ModID;
import net.modificationstation.stationapi.api.common.util.Null;
import net.modificationstation.stationapi.template.common.block.Dirt;

public class OldJunglesWorldListener {
    public static Biome bBirchForest;
    public static Biome bConiferousForest;
    public static Biome bJungle;
    public static Biome cShrubland;
    public static Biome cSavanna;
    public static Biome cSwampland;

    public static Biome vEverTundra;
    public static Biome vSwampTundra;

    public static net.minecraft.item.ItemBase itemMelon;
    public static net.minecraft.item.ItemBase itemMelonSeeds;
    public static net.minecraft.block.BlockBase blockMelon;
    public static net.minecraft.block.BlockBase blockMelonSeedsTile;

    public static net.minecraft.block.BlockBase blockFrozenDirt;

    public static net.minecraft.item.ItemBase infoPaper;

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

        vEverTundra = new EverTundra();
        vSwampTundra = new SwampTundra();
    }

    @SuppressWarnings("unused")
    @EventListener(priority = ListenerPriority.HIGH)
    public void registerBlocks(BlockRegister event)
    {
        OldJunglesWorld.INSTANCE.INIT.info("Registering blocks...");
        blockMelon = new BlockMelon(Identifier.of(modID, "blockmelon")).setTranslationKey(modID, "blockMelon");
        blockMelonSeedsTile = new TileMelonSeed(Identifier.of(modID, "blockmelonseedstile"), blockMelon.id).setTranslationKey(modID, "blockMelonSeedsTile");
        blockFrozenDirt = new Dirt(Identifier.of(modID, "blockfrozendirt"), 0).setTranslationKey(modID, "blockFrozenDirt");
    }

    @SuppressWarnings("unused")
    @EventListener(priority = ListenerPriority.LOW)
    public void registerItems(ItemRegister event)
    {
        OldJunglesWorld.INSTANCE.INIT.info("Registering items...");
        itemMelon = new ItemMelon(Identifier.of(modID, "itemmelon")).setTranslationKey(modID, "itemMelon");
        itemMelonSeeds = new ItemSeedsMelon(Identifier.of(modID, "itemmelonseeds")).setTranslationKey(modID, "itemmelonseeds");
        infoPaper = new ItemInfoPaper(Identifier.of(modID, "infopaper")).setTranslationKey(modID, "infoPaper");
    }

    @SuppressWarnings("unused")
    @EventListener
    public void registerRecipe(RecipeRegister event)
    {
        OldJunglesWorld.INSTANCE.INIT.info("Registering recipes (" + event.recipeId.toString() + ")...");
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
        OldJunglesWorld.INSTANCE.INIT.info("Registering textures...");
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

    }

    @SuppressWarnings("unused")
    @EventListener
    public void registerGeneration(ChunkDecoration chunkDecoration)
    {
        if (chunkDecoration.random.nextInt(8) == 0 && chunkDecoration.biome == OldJunglesWorldListener.bJungle) {
            int ix = chunkDecoration.x + chunkDecoration.random.nextInt(16) + 8;
            int iy = chunkDecoration.random.nextInt(128);
            int iz = chunkDecoration.z + chunkDecoration.random.nextInt(16) + 8;
            (new PlantGroup(blockMelon.id)).generate(chunkDecoration.level, chunkDecoration.random, ix, iy, iz);
        }
    }
}
