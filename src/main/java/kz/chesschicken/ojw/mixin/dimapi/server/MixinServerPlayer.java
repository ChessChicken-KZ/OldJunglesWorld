package kz.chesschicken.ojw.mixin.dimapi.server;

import kz.chesschicken.ojw.utils.portalworks.OJWPlayer;
import net.minecraft.class_467;
import net.minecraft.class_70;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.entity.player.ServerPlayer;
import net.minecraft.level.Level;
import net.minecraft.packet.Id9Packet;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.network.ServerPlayerPacketHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ServerPlayer.class)
public abstract class MixinServerPlayer extends PlayerBase implements OJWPlayer {
    @Shadow public ServerPlayerPacketHandler packetHandler;

    @Shadow public MinecraftServer server;

    @Shadow public class_70 field_261;

    public MixinServerPlayer(Level arg) {
        super(arg);
    }


    @Override
    public void teleport(int id, class_467 t) {
        ServerLevel var2 = this.server.getLevel(this.dimensionId);
        byte var11;
        if (this.dimensionId == id) {
            var11 = 0;
        } else {
            var11 = (byte) id;
        }

        this.dimensionId = var11;
        ServerLevel var4 = this.server.getLevel(this.dimensionId);
        this.packetHandler.send(new Id9Packet((byte)this.dimensionId));
        var2.removeEntityServer(this);
        this.removed = false;
        double var5 = this.x;
        double var7 = this.z;
        double var9 = 8.0D;
        if (this.dimensionId == -1) {
            var5 /= var9;
            var7 /= var9;
            this.setPositionAndAngles(var5, this.y, var7, this.yaw, this.pitch);
            if (this.isAlive()) {
                var2.method_193(this, false);
            }
        } else {
            var5 *= var9;
            var7 *= var9;
            this.setPositionAndAngles(var5, this.y, var7, this.yaw, this.pitch);
            if (this.isAlive()) {
                var2.method_193(this, false);
            }
        }

        if (this.isAlive()) {
            var4.spawnEntity(this);
            this.setPositionAndAngles(var5, this.y, var7, this.yaw, this.pitch);
            var4.method_193(this, false);
            var4.serverLevelSource.field_933 = true;
            t.method_1530(var4, this);
            var4.serverLevelSource.field_933 = false;
        }


        ServerPlayer fakeP = new ServerPlayer(this.server, this.level, this.name, this.field_261);
        server.serverPlayerConnectionManager.method_554( fakeP );
        this.packetHandler.method_832(this.x, this.y, this.z, this.yaw, this.pitch);
        this.setLevel(var4);
        server.serverPlayerConnectionManager.sendPlayerTime(fakeP, var4);
        server.serverPlayerConnectionManager.method_581(fakeP);
    }
}
