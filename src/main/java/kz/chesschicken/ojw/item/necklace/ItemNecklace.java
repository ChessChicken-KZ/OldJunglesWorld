package kz.chesschicken.ojw.item.necklace;

import kz.chesschicken.ojw.utils.MinecraftInstance;
import kz.chesschicken.ojw.utils.equipo.IJewelry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.common.registry.Identifier;
import net.modificationstation.stationapi.template.common.item.ItemBase;

public class ItemNecklace extends ItemBase implements IJewelry {
    public ItemNecklace(Identifier identifier) {
        super(identifier);
        this.setMaxStackSize(1);
        this.setDurability(1000);
    }

    @Override
    public JewelryType getJewelryType() {
        return JewelryType.NECKLACE;
    }

    @Override
    public void tickJewelry(Level world, PlayerBase player, ItemInstance jewelry, int slot) {
        if(!player.onGround && player.isAlive()) {
            world.createExplosion(player, player.x, player.y - 0.5D, player.z, 0.1f, false);
            player.velocityY += 0.1D;
        }
    }

    @Override
    public ItemInstance use(ItemInstance item, Level level, PlayerBase player) {

        if(!level.isClient) {
            MinecraftInstance.INSTANCE.overlay.addChatMessage("Current Durability: " + (item.getDurability() - item.getDamage()) + "/" + item.getDurability());
        }

        return item;
    }

    @Environment(EnvType.CLIENT)
    public void renderJewelry(PlayerBase playerBase, double d, double d1, double d2, float f, float f1) {

    }
}
