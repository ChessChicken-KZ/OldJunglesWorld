package kz.chesschicken.ojw.mixin.hunger;

import kz.chesschicken.ojw.utils.playerhunger.IPlayerHunger;
import net.minecraft.entity.Living;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.level.Level;
import net.minecraft.util.io.CompoundTag;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerBase.class)
public abstract class MixinPlayer extends Living implements IPlayerHunger {

    @Shadow protected abstract void applyDamage(int damageAmount);

    @Unique private int hunger;
    @Unique private int absorption;
    @Unique private final int maxHunger = 20;

    @Unique private int tickHunger = 0;
    @Unique private int tickPoisoned_revert = 0;

    public MixinPlayer(Level arg) {
        super(arg);
    }

    /*
     * Used only for a initializing.
     * Anyway, NBT things will do their stuff.
     */
    @Inject(method = "<init>", at = @At("TAIL"))
    private void setupPlayerData(Level arg, CallbackInfo ci)
    {
        this.hunger = this.maxHunger;
        this.absorption = 0;
    }

    @Inject(method = "writeCustomDataToTag", at = @At("TAIL"))
    private void injectNBTData(CompoundTag tag, CallbackInfo ci)
    {
        tag.put("Hunger", (byte) this.hunger);
        tag.put("Absorption", (byte) this.absorption);
    }

    @Inject(method = "readCustomDataFromTag", at = @At("TAIL"))
    private void parseNBTData(CompoundTag tag, CallbackInfo ci)
    {
        this.hunger = tag.getByte("Hunger");
        this.absorption = tag.getByte("Absorption");
    }

    @Inject(method = "updateDespawnCounter", at = @At("TAIL"))
    private void updateHunger(CallbackInfo ci)
    {

        if(tickPoisoned_revert > 0) {
            if(tickPoisoned_revert % 20 == 0) {
                applyDamage(1);
            }
            tickPoisoned_revert--;
        }

        if(getHunger() < 1 && tickHunger == 40)
        {
            applyDamage(1);
            tickHunger = 0;
        }

        if(getAbsorption() > 0 && this.health < 20 && tickHunger == 30)
        {
            setAbsorption(getAbsorption() - 1);
            addHealth(1);
            tickHunger = 0;
        }else if(getHunger() > 14 && this.health < 20 && tickHunger == 30)
        {
            setHunger(getHunger() - 1);
            addHealth(1);
            tickHunger = 0;
        }

        if(rand.nextInt(5) == 0 && tickHunger == 400)
        {
            if(getAbsorption() > 0)
                setAbsorption(getAbsorption() - 1);
            else if(getHunger() > 0)
                setHunger(getHunger() - 1);
            tickHunger = 0;
        }

        tickHunger++;
    }

    @Override
    public int maxHunger() {
        return this.maxHunger;
    }

    @Override
    public int getHunger() {
        return this.hunger;
    }

    @Override
    public int getAbsorption() {
        return this.absorption;
    }

    @Override
    public void setHunger(int i) {
        this.hunger = i;
    }

    @Override
    public void setAbsorption(int i) {
        this.absorption = i;
    }

    @Override
    public void addHunger(int i) {
        if(this.hunger + i > maxHunger)
            this.hunger = maxHunger;
        else
            this.hunger += i;
    }

    @Override
    public void addAbsorption(int i) {
        if(this.hunger + i > maxHunger)
            this.absorption = maxHunger;
        else
            this.absorption += i;
    }

    @Override
    public void setPoison(int i) {
        this.tickPoisoned_revert = i;
    }

    @Override
    public int getPoison() {
        return this.tickPoisoned_revert;
    }

    @Override
    public boolean isPoisoned() {
        return this.tickPoisoned_revert > 0;
    }
}

