package kz.chesschicken.ojw.item.infopaper;

import com.google.gson.Gson;
import kz.chesschicken.ojw.init.OJWContentListener;
import kz.chesschicken.ojw.init.OJWLogger;
import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerBase;
import net.modificationstation.stationapi.api.event.mod.InitEvent;
import net.modificationstation.stationapi.api.event.registry.MessageListenerRegistryEvent;
import net.modificationstation.stationapi.api.factory.GeneralFactory;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.packet.Message;
import net.modificationstation.stationapi.api.packet.PacketHelper;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.registry.ModID;
import net.modificationstation.stationapi.api.util.Null;

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
    private final HashMap<Integer, String[]> infopaperIDS = new HashMap<>();

    /**
     * @param i ID of InfoPaper.
     * @return InfoPaper's existence.
     */
    public boolean doesExist(int i) { return infopaperIDS.containsKey(i); }

    /**
     * @param i ID of InfoPaper
     * @return Text from JSON file of InfoPaper
     */
    public String[] getText(int i) {
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
    public String getTexture(int i) { return infopaperIDS.get(i)[1]; }


    /**
     * Allows you to register your InfoPaper
     * @param id ID of InfoPaper
     * @param info File text (example: "/assets/examplemod/something/bla/text.pnh")
     *             File texture location (example: "/assets/examplemod/something/picture.png")
     */
    private void register(int id, String... info)
    {
        if(info[0].startsWith("LOCAL:")) info[0] = info[0].replace("LOCAL:","assets/ojw/eldritch/string/");
        if(info[1].startsWith("LOCAL:")) info[1] = info[1].replace("LOCAL:","/assets/ojw/eldritch/textures/");

        infopaperIDS.put(id, new String[]
                {
                        info[0],
                        info[1]
                });
    }

    @Entrypoint.ModID public final ModID modid = Null.get();

    /**
     * Event for registering packets.
     * @param messageListenerRegister Event
     */
    @EventListener
    public void registerInfoPaper_PACKET(MessageListenerRegistryEvent messageListenerRegister)
    {
        messageListenerRegister.registry.register(Identifier.of(modid, "openinfopaper"), this::handlePaper);
        messageListenerRegister.registry.register(Identifier.of(modid, "resultoip"), this::handleClientPaper);
    }

    public void handlePaper(PlayerBase playerBase, Message customData) {
        int id = customData.ints[0];
        if (playerBase.inventory.getHeldItem() != null)
        {
            if (playerBase.inventory.getHeldItem().itemId == OJWContentListener.infoPaper.id)
            {
                if(doesExist(playerBase.inventory.getHeldItem().getDamage()))
                {
                    Message packet = GeneralFactory.INSTANCE.newInst(Message.class, "eldritch:resultoip");
                    packet.ints = customData.ints;
                    PacketHelper.send(packet);
                    OJWLogger.INSTANCE.RUNTIME.info("SERVER SIDE! Sent a packet of InfoPaper with id: " + customData.ints[0]);
                }
            }
        }
    }

    public void handleClientPaper(PlayerBase playerBase, Message customData)
    {
        if(FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT)
        {
            Minecraft mc = (Minecraft) FabricLoader.getInstance().getGameInstance();
            mc.openScreen(new GuiInfoPaper(customData.ints[0]));
            OJWLogger.INSTANCE.RUNTIME.info("CLIENT SIDE! Got a message to open InfoPaper with id: " + customData.ints[0]);
        }
    }

    /**
     * Event for parsing documents
     * @param init Event
     */
    @SuppressWarnings("unused")
    @EventListener
    public void initializeDocuments(InitEvent init)
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
                    OJWLogger.INSTANCE.INIT.error("Could not normally parse InfoPaper: " + path);
                    OJWLogger.INSTANCE.INIT.error("Error: " + e.getMessage());
                }

            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        OJWLogger.INSTANCE.INIT.info("Totally parsed " + infopaperIDS.size() + " InfoPaper pages...");

    }

    private static final EventInfoPaper instance = new EventInfoPaper();
    public static EventInfoPaper getInstance() {
        return instance;
    }
}
