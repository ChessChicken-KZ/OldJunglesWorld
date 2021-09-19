package kz.chesschicken.ojw.mixin;

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
    private void call1(Minecraft minecraft) {
        teleport(-1, new class_467());
    }

    @Override
    public void teleport(int id, class_467 teleport) {
        this.dimensionId = id;

        this.level.removeEntity(this);
        this.removed = false;

        Dimension newQ = Dimension.getByID(id);

        double plX = this.x;
        double plZ = this.z;
        double var7 = ((id == -1) ? 8.0D : 1.0D);
        plX *= var7;
        plZ *= var7;

        Level l = new Level(level, newQ);

        if(this.isAlive()) {
            this.level.method_193(this, false);
        }

        if(this.dimensionId == 0)
            MinecraftInstance.get().showLevelProgress(l, "Leaving " + DimensionAPI.getDimensionByInt(id).getDimensionName(), MinecraftInstance.get().player);
        else
            MinecraftInstance.get().showLevelProgress(l, "Entering " + DimensionAPI.getDimensionByInt(id).getDimensionName(), MinecraftInstance.get().player);

        this.level = MinecraftInstance.get().level;
        if(this.isAlive()) {
            this.setPositionAndAngles(plX, this.y, plZ, this.yaw, this.pitch);
            this.level.method_193(this, false);
            teleport.method_1530(this.level, this);
        }
    }
}
