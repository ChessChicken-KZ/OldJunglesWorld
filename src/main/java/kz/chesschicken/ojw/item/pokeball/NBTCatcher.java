package kz.chesschicken.ojw.item.pokeball;

import net.minecraft.util.io.CompoundTag;
import net.modificationstation.stationapi.api.item.nbt.ItemEntity;

//TODO: Implement other stuff.
public class NBTCatcher implements ItemEntity {
    private final String caughtMob;
    private final int health;

    public NBTCatcher(String s, int i)
    {
        this.caughtMob = s;
        this.health = i;
    }

    public NBTCatcher()
    {
        this.caughtMob = "";
        this.health = 0;
    }

    public NBTCatcher(CompoundTag compoundTag)
    {
        this(compoundTag.getString("ojw.catchedmob"), compoundTag.getInt("ojw.healthmob"));
    }

    @Override
    public ItemEntity copy() {
        return new NBTCatcher(this.caughtMob, this.health);
    }

    @Override
    public void writeToNBT(CompoundTag compoundTag) {
        compoundTag.put("ojw.caughtmob", this.caughtMob);
        compoundTag.put("ojw.healthmob", this.health);
    }

    public String getCaughtMob() {
        return this.caughtMob;
    }

    public int getHealth() {
        return this.health;
    }
}
