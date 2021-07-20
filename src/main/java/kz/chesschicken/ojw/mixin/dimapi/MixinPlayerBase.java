package kz.chesschicken.ojw.mixin.dimapi;

import kz.chesschicken.ojw.utils.portalworks.OJWPlayer;
import net.minecraft.entity.Living;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin(PlayerBase.class)
public abstract class MixinPlayerBase extends Living implements OJWPlayer {
    @Unique private double time1 = 20;
    @Unique private boolean portalReady = false;

    @Override
    public boolean getIsPortalReady() {
        return portalReady;
    }

    @Override
    public double getTime1() {
        return time1;
    }

    @Override
    public void setPortalReady(boolean portalReady) {
        this.portalReady = portalReady;
    }

    @Override
    public void setTime1(double time1) {
        this.time1 = time1;
    }

    public MixinPlayerBase(Level arg) {
        super(arg);
    }

    @Override
    public void teleport(int id, net.minecraft.class_467 Te) {
    }
}
