package kz.chesschicken.ojw.item;

import kz.chesschicken.ojw.utils.MinecraftInstance;
import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.minecraft.level.biome.Biome;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.item.TemplateItemBase;

public class ItemBiomeCompass extends TemplateItemBase {
    public ItemBiomeCompass(Identifier identifier) {
        super(identifier);
    }

    @Override
    public ItemInstance use(ItemInstance item, Level level, PlayerBase player) {
        if(FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT)
        {
            MinecraftInstance.INSTANCE.overlay.addChatMessage("Biome type: " + level.getBiomeSource().getBiome(player.chunkX, player.chunkZ).biomeName);
        }

        return item;
    }
}
