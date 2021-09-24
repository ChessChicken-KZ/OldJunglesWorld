package kz.chesschicken.ojw.mixin.dimensionapi.client;

import kz.chesschicken.ojw.utils.MinecraftInstance;
import kz.chesschicken.ojw.utils.dimensionapi.DimensionAPI;
import kz.chesschicken.ojw.utils.dimensionapi.IPlayerTeleport;
import net.minecraft.class_467;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.AbstractClientPlayer;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.level.Level;
import net.minecraft.level.dimension.Dimension;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(AbstractClientPlayer.class)
public abstract class MixinAbstractClientPlayer extends PlayerBase implements IPlayerTeleport {
    public MixinAbstractClientPlayer(Level arg) {
        super(arg);
    }

    @Redirect(method = "updateDespawnCounter", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/Minecraft;switchDimension()V"
    ))
    private void redirectUseDimAPI(Minecraft minecraft) {
        teleport(this.dimensionId == 0 ? -1 : 0, new class_467(), true);
    }

    @Override
    public void teleport(int id, class_467 teleport, boolean nether_travel) {
        this.dimensionId = id;
        this.level.removeEntity(this);
        this.removed = false;

        double calc = nether_travel ? ((id == -1) ? 8.0D : 1.0D) : 1;
        double plX = this.x * calc;
        double plZ = this.z * calc;

        if(this.isAlive())
            this.level.method_193(this, false);

        MinecraftInstance.get().showLevelProgress(new Level(level, Dimension.getByID(id)), (this.dimensionId == 0 ? "Leaving " : "Entering ") + DimensionAPI.getDimensionByInt(id).getDimensionName(), MinecraftInstance.get().player);

        this.level = MinecraftInstance.get().level;
        if(this.isAlive()) {
            this.setPositionAndAngles(plX, this.y, plZ, this.yaw, this.pitch);
            this.level.method_193(this, false);
            teleport.method_1530(this.level, this);
        }
    }
}
