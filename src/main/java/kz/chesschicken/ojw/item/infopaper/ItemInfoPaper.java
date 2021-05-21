package kz.chesschicken.ojw.item.infopaper;

import kz.chesschicken.ojw.init.OJWLogger;
import kz.chesschicken.ojw.utils.MinecraftInstance;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.common.factory.GeneralFactory;
import net.modificationstation.stationapi.api.common.packet.Message;
import net.modificationstation.stationapi.api.common.packet.PacketHelper;
import net.modificationstation.stationapi.api.common.registry.Identifier;
import net.modificationstation.stationapi.template.common.item.ItemBase;

public class ItemInfoPaper extends ItemBase {

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
        if(level.isClient)
        {
            Message packet = GeneralFactory.INSTANCE.newInst(Message.class, "eldritch:openinfopaper");
            packet.put(new int[] { item.getDamage() });
            PacketHelper.send(packet);
        }else {
            MinecraftInstance.INSTANCE.openScreen(new GuiInfoPaper(item.getDamage()));
        }
        OJWLogger.INSTANCE.RUNTIME.info("CLIENT SIDE! Sent packet of InfoPaper with id: " + item.getDamage());
        return item;
    }





}
