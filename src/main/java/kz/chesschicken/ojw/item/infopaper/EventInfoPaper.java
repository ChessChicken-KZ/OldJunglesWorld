package kz.chesschicken.ojw.item.infopaper;

import kz.chesschicken.ojw.init.OJWListener1;
import kz.chesschicken.ojw.init.OJWLogger;
import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerBase;
import net.modificationstation.stationapi.api.common.event.EventListener;
import net.modificationstation.stationapi.api.common.event.mod.Init;
import net.modificationstation.stationapi.api.common.event.packet.MessageListenerRegister;
import net.modificationstation.stationapi.api.common.factory.GeneralFactory;
import net.modificationstation.stationapi.api.common.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.common.packet.Message;
import net.modificationstation.stationapi.api.common.packet.PacketHelper;
import net.modificationstation.stationapi.api.common.registry.Identifier;
import net.modificationstation.stationapi.api.common.registry.ModID;
import net.modificationstation.stationapi.api.common.util.Null;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EventInfoPaper {
    private static final HashMap<Integer, String[]> infopaperIDS = new HashMap<>();

    public static boolean doesExist(int i) { return infopaperIDS.containsKey(i); }

    public static String[] getText(int i) {
        try
        {
            List<String> arl = new ArrayList<>();
            InputStream in = EventInfoPaper.class.getResourceAsStream(infopaperIDS.get(i)[0]);
            BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
            String s;
            while( (s = br.readLine()) != null)
            {
                arl.add(s);
            }
            br.close();
            in.close();
            return arl.toArray(new String[0]);
        } catch (Exception e) {
            OJWLogger.INSTANCE.RUNTIME.error("Oh noes! " + e.getMessage());
        }
        return null;
    }
    public static String getTexture(int i) { return infopaperIDS.get(i)[1]; }


    /**
     * id - id
     * Strings:
     * 0 - File text location,
     * 1 - File texture location
     * @param id
     * @param info
     */
    private static void register(int id, String... info)
    {
        infopaperIDS.put(id, new String[]
                {
                        "/assets/ojw/eldritch/string/"+info[0],
                        "/assets/ojw/eldritch/textures/"+info[1]
                });
    }

    @Entrypoint.ModID public static final ModID modid = Null.get();

    /**
     * Event for registering packets.
     * @param messageListenerRegister
     */
    @EventListener
    public void registerInfoPaper_PACKET(MessageListenerRegister messageListenerRegister)
    {
        messageListenerRegister.registry.registerValue(Identifier.of(modid, "openinfopaper"), this::handlePaper);
        messageListenerRegister.registry.registerValue(Identifier.of(modid, "resultoip"), this::handleClientPaper);
    }

    public void handlePaper(PlayerBase playerBase, Message customData) {
        int id = customData.ints()[0];
        if (playerBase.inventory.getHeldItem() != null)
        {
            if (playerBase.inventory.getHeldItem().itemId == OJWListener1.infoPaper.id)
            {
                if(doesExist(playerBase.inventory.getHeldItem().getDamage()))
                {
                    Message packet = GeneralFactory.INSTANCE.newInst(Message.class, "eldritch:resultoip");
                    packet.put(customData.ints());
                    PacketHelper.send(packet);
                    OJWLogger.INSTANCE.RUNTIME.info("SERVER SIDE! Sent a packet of InfoPaper with id: " + customData.ints()[0]);
                }
            }
        }
    }

    public void handleClientPaper(PlayerBase playerBase, Message customData)
    {
        if(FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT)
        {
            Minecraft mc = (Minecraft) FabricLoader.getInstance().getGameInstance();
            mc.openScreen(new GuiInfoPaper(customData.ints()[0]));
            OJWLogger.INSTANCE.RUNTIME.info("CLIENT SIDE! Got a message to open InfoPaper with id: " + customData.ints()[0]);
        }
    }

    /**
     * Event for initializing some mod things. :)
     * @param init
     */
    @SuppressWarnings("unused")
    @EventListener
    public void initializeDocuments(Init init)
    {

        register(0, "_0.txt", "global.png");
        OJWLogger.INSTANCE.RUNTIME.info("INITIALIZATION! Totally parsed " + infopaperIDS.size() + " InfoPaper pages...");
    }


}
