package kz.chesschicken.ojw.item;

import kz.chesschicken.ojw.init.OJWContentListener;
import kz.chesschicken.ojw.level.overworld.structures.HangmanStructure;
import kz.chesschicken.ojw.utils.MinecraftInstance;
import kz.chesschicken.ojw.utils.itemhelper.ProvideCustomMetaNames;
import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.item.TemplateItemBase;

@ProvideCustomMetaNames
public class ItemDebugA extends TemplateItemBase {
    public ItemDebugA(Identifier identifier) {
        super(identifier);
        setHasSubItems(true);
    }

    @Override
    public ItemInstance use(ItemInstance item, Level level, PlayerBase player) {

        if(item.getDamage() == 0)
        {
            if(FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT)
            {
                MinecraftInstance.INSTANCE.overlay.addChatMessage("Biome type: " + level.getBiomeSource().getBiome(player.chunkX, player.chunkZ).biomeName);
            }

            player.inventory.addStack(new ItemInstance(OJWContentListener.hangmanBlock, 1, 0));
            player.inventory.addStack(new ItemInstance(OJWContentListener.hangmanBlock, 1, 1));
            player.inventory.addStack(new ItemInstance(OJWContentListener.hangmanBlock, 1, 2));
            player.inventory.addStack(new ItemInstance(OJWContentListener.hangmanBlock, 1, 3));
        }else if(FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT)
        {
            MinecraftInstance.INSTANCE.overlay.addChatMessage("This is not meta == 0");
        }


        return item;
    }

    @Override
    public boolean useOnTile(ItemInstance item, PlayerBase player, Level level, int x, int y, int z, int facing) {
        HangmanStructure structure = new HangmanStructure();

        structure.generate(level, rand, x, y, z);

        return true;
    }
}
