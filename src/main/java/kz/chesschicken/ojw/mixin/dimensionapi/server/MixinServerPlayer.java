package kz.chesschicken.ojw.mixin.dimensionapi.server;

import kz.chesschicken.ojw.mixin.AccessorServerPlayerConnectionManager;
import kz.chesschicken.ojw.utils.MinecraftServerInstance;
import kz.chesschicken.ojw.utils.dimensionapi.IPlayerTeleport;
import net.minecraft.class_467;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.entity.player.ServerPlayer;
import net.minecraft.level.Level;
import net.minecraft.packet.play.InvalidateState0x46S2CPacket;
import net.minecraft.packet.play.Respawn0x9C2SPacket;
import net.minecraft.packet.play.TimeUpdate0x4S2CPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.network.ServerPlayerPacketHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin(ServerPlayer.class)
public abstract class MixinServerPlayer extends PlayerBase implements IPlayerTeleport {
    @Shadow public ServerPlayerPacketHandler packetHandler;

    public MixinServerPlayer(Level arg) {
        super(arg);
    }

    @Override
    public void teleport(int id, class_467 teleport, boolean nether_travel) {
        ServerLevel currentWorld = MinecraftServerInstance.get().getLevel(this.dimensionId);
        ServerLevel newWorld = MinecraftServerInstance.get().getLevel(id);
        this.dimensionId = id;

        this.packetHandler.send(new Respawn0x9C2SPacket((byte)this.dimensionId));
        currentWorld.removeEntityServer(this);
        this.removed = false;

        double calc = nether_travel ? ((id == -1) ? 8.0D : 1.0D) : 1;
        double plX = this.x * calc;
        double plZ = this.z * calc;


        this.setPositionAndAngles(plX, this.y, plZ, this.yaw, this.pitch);
        if (this.isAlive())
            currentWorld.method_193(this, false);

        if (this.isAlive()) {
            newWorld.spawnEntity(this);
            this.setPositionAndAngles(plX, this.y, plZ, this.yaw, this.pitch);
            newWorld.method_193(this, false);
            newWorld.serverLevelSource.field_933 = true;
            (new class_467()).method_1530(newWorld, this);
            newWorld.serverLevelSource.field_933 = false;
        }

        setAttraction(this);
        this.packetHandler.method_832(this.x, this.y, this.z, this.yaw, this.pitch);
        this.setLevel(newWorld);
        sendTime(this, newWorld);
        doMagik(this);
    }

    @Unique
    private void setAttraction(PlayerBase player) {
        ((AccessorServerPlayerConnectionManager)MinecraftServerInstance.get().serverPlayerConnectionManager).getEyes()[0].addPlayer((ServerPlayer) player);
        ((AccessorServerPlayerConnectionManager)MinecraftServerInstance.get().serverPlayerConnectionManager).getEyes()[1].addPlayer((ServerPlayer) player);
        ((AccessorServerPlayerConnectionManager)MinecraftServerInstance.get().serverPlayerConnectionManager).invokeGetEye(player.dimensionId).method_1745((ServerPlayer) player);
        MinecraftServerInstance.get().getLevel(player.dimensionId).serverLevelSource.loadChunk((int)player.x >> 4, (int)player.z >> 4);
    }

    @Unique
    private void sendTime(PlayerBase player, ServerLevel level) {
        ((ServerPlayer)player).packetHandler.send(new TimeUpdate0x4S2CPacket(level.getLevelTime()));
        if (level.isRaining())
            ((ServerPlayer)player).packetHandler.send(new InvalidateState0x46S2CPacket(1));
    }

    @Unique
    private void doMagik(PlayerBase player) {
        ((ServerPlayer)player).method_311(player.playerContainer);
        ((ServerPlayer)player).method_309();
    }
}
