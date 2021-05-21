package kz.chesschicken.ojw.item.infopaper;

import com.google.gson.Gson;
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

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class EventInfoPaper {
    private static final HashMap<Integer, String[]> infopaperIDS = new HashMap<>();

    /**
     * @param i ID of InfoPaper.
     * @return InfoPaper's existence.
     */
    public static boolean doesExist(int i) { return infopaperIDS.containsKey(i); }

    /**
     * @param i ID of InfoPaper
     * @return Text from JSON file of InfoPaper
     */
    public static String[] getText(int i) {
        try
        {
            List<String> toSend = new ArrayList<>();

            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(FabricLoader.getInstance().getModContainer("ojw").get().getPath(infopaperIDS.get(i)[0]));

            Map<?, ?> map = gson.fromJson(reader, Map.class);

            toSend.add((String) map.get("title"));
            toSend.addAll(((List<String>) map.get("text")));
            return toSend.toArray(new String[0]);
        }catch (IOException e)
        {
            OJWLogger.INSTANCE.INIT.error("Could not normally parse text for InfoPaper with id: " + i);
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param i ID of InfoPaper
     * @return Texture File of InfoPaper
     */
    public static String getTexture(int i) { return infopaperIDS.get(i)[1]; }


    /**
     * Allows you to register your InfoPaper
     * @param id ID of InfoPaper
     * @param info File text (example: "/assets/examplemod/something/bla/text.pnh")
     *             File texture location (example: "/assets/examplemod/something/picture.png")
     */
    private static void register(int id, String... info)
    {
        if(info[0].startsWith("LOCAL:")) info[0] = info[0].replace("LOCAL:","assets/ojw/eldritch/string/");
        if(info[1].startsWith("LOCAL:")) info[1] = info[1].replace("LOCAL:","/assets/ojw/eldritch/textures/");

        infopaperIDS.put(id, new String[]
                {
                        info[0],
                        info[1]
                });
    }

    @Entrypoint.ModID public static final ModID modid = Null.get();

    /**
     * Event for registering packets.
     * @param messageListenerRegister Event
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
     * Event for parsing documents
     * @param init Event
     */
    @SuppressWarnings("unused")
    @EventListener
    public void initializeDocuments(Init init)
    {
        try
        {
            Stream<Path> paths = Files.walk(FabricLoader.getInstance().getModContainer("ojw").get().getPath("assets/ojw/eldritch/string"));
            paths.filter(Files::isRegularFile).forEach(path -> {
                try {
                    if (path.toFile().getName().contains(".json")) {
                        Gson gson = new Gson();
                        Reader reader = Files.newBufferedReader(path);

                        Map<?, ?> map = gson.fromJson(reader, Map.class);

                        int id = Integer.parseInt((String) map.get("id"));
                        String texture = (String) map.get("texture");

                        register(id, "LOCAL:"+path.toFile().getName(), "LOCAL:"+texture);
                        reader.close();
                    }
                } catch (IOException e) {
                    OJWLogger.INSTANCE.INIT.error("Could not normally parse InfoPaper: " + path.toString());
                    OJWLogger.INSTANCE.INIT.error("Error: " + e.getMessage());
                }

            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        OJWLogger.INSTANCE.INIT.info("Totally parsed " + infopaperIDS.size() + " InfoPaper pages...");

    }




}
