package kz.chesschicken.ojw.item.pokeball;

import net.minecraft.util.io.CompoundTag;
import net.modificationstation.stationapi.api.item.nbt.ItemEntity;

//TODO: Implement other stuff.
public class NBTCatcher implements ItemEntity {
    private final String catchedMob;
    private final int health;

    public NBTCatcher(String s, int i)
    {
        this.catchedMob = s;
        this.health = i;
    }

    public NBTCatcher()
    {
        this.catchedMob = "";
        this.health = 0;
    }

    public NBTCatcher(CompoundTag compoundTag)
    {
        this(compoundTag.getString("ojw.catchedmob"), compoundTag.getInt("ojw.healthmob"));
    }

    @Override
    public ItemEntity copy() {
        return new NBTCatcher(this.catchedMob, this.health);
    }

    @Override
    public void writeToNBT(CompoundTag compoundTag) {
        compoundTag.put("ojw.catchedmob", this.catchedMob);
        compoundTag.put("ojw.catchedmob", this.health);
    }

    public String getCatchedMob() {
        return this.catchedMob;
    }

    public int getHealth() {
        return this.health;
    }
}
