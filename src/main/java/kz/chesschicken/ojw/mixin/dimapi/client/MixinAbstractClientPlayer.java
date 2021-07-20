package kz.chesschicken.ojw.mixin.dimapi.client;

import kz.chesschicken.ojw.utils.MinecraftInstance;
import kz.chesschicken.ojw.utils.portalworks.OJWPlayer;
import net.minecraft.class_467;
import net.minecraft.entity.player.AbstractClientPlayer;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.level.Level;
import net.minecraft.level.dimension.Dimension;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(AbstractClientPlayer.class)
public abstract class MixinAbstractClientPlayer extends PlayerBase implements OJWPlayer {
    public MixinAbstractClientPlayer(Level arg) {
        super(arg);
    }

    @Override
    public void teleport(int id, class_467 t) {
        //int var2 = this.dimensionId;
        this.dimensionId = id;

        this.level.removeEntity(this);
        this.removed = false;

        Dimension newQ = Dimension.getByID(id);
        //Dimension oldQ = Dimension.getByID(var2);

        double plX = this.x;
        double plZ = this.z;

        double var7 = ((id == -1) ? 8.0D : 1.0D);
        plX *= var7;
        plZ *= var7;

        Level l = new Level(level, newQ);

        if(this.isAlive())
        {
            this.level.method_193(this, false);
        }

        if(this.dimensionId == 0)
        {
            MinecraftInstance.INSTANCE.showLevelProgress(l, "Leaving" + Dimension.getByID(id).toString(), MinecraftInstance.INSTANCE.player);
        }
        else
        {
            MinecraftInstance.INSTANCE.showLevelProgress(l, "Entering" + Dimension.getByID(id).toString(), MinecraftInstance.INSTANCE.player);
        }

        this.level = MinecraftInstance.INSTANCE.level;
        System.out.println("Teleporting ");

        if(this.isAlive())
        {
            this.setPositionAndAngles(plX, this.y, plZ, this.yaw, this.pitch);
            this.level.method_193(this, false);
            t.method_1530(this.level, this);
        }
    }
}
