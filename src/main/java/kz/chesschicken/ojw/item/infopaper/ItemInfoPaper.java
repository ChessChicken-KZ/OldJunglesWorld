package kz.chesschicken.ojw.item.infopaper;

import kz.chesschicken.ojw.init.OJWLogger;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.packet.Message;
import net.modificationstation.stationapi.api.packet.PacketHelper;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.item.TemplateItemBase;

public class ItemInfoPaper extends TemplateItemBase {

    public ItemInfoPaper(Identifier identifier) {
        super(identifier);
        this.setHasSubItems(true);
        this.setMaxStackSize(1);
        this.setDurability(0);
    }

    @Environment(EnvType.CLIENT)
    public String getTranslationKey(ItemInstance item) {
        return super.getTranslationKey()+"_"+item.getDamage();
    }

    @Override
    public ItemInstance use(ItemInstance item, Level level, PlayerBase player)
    {
        Message packet = new Message(Identifier.of("ojw:eldritch_openinfopaper"));
        packet.ints = new int[] { item.getDamage() };
        PacketHelper.send(packet);

        OJWLogger.RUNTIME.info("CLIENT SIDE! Sent packet of InfoPaper with id: " + item.getDamage());
        return item;
    }

}
