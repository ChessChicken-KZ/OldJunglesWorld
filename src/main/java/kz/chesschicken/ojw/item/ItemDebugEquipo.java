package kz.chesschicken.ojw.item;

import kz.chesschicken.ojw.utils.MinecraftInstance;
import kz.chesschicken.ojw.utils.equipo.IJewelry;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.common.registry.Identifier;
import net.modificationstation.stationapi.template.common.item.ItemBase;

public class ItemDebugEquipo extends ItemBase implements IJewelry {
    public ItemDebugEquipo(Identifier identifier) {
        super(identifier);
        this.setMaxStackSize(1);
        this.setDurability(1000);
    }

    @Override
    public JewelryType getJewelryType() {
        return JewelryType.HAT;
    }

    @Override
    public void tickJewelry(Level world, PlayerBase player, ItemInstance jewelry) {
        if(player.isTouchingWater() && world.rand.nextInt(3) + 1 == 1)
            jewelry.applyDamage(1, player);
    }

    @Override
    public ItemInstance use(ItemInstance item, Level level, PlayerBase player) {

        if(!level.isClient) {
            MinecraftInstance.INSTANCE.overlay.addChatMessage("Current Durability: " + item.getDurability());
        }

        return item;
    }
}
