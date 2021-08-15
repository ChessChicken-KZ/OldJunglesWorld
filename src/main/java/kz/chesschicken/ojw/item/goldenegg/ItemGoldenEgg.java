package kz.chesschicken.ojw.item.goldenegg;

import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.common.registry.Identifier;
import net.modificationstation.stationapi.template.common.item.ItemBase;

public class ItemGoldenEgg extends ItemBase {
    public ItemGoldenEgg(Identifier i) {
        super(i);
        this.maxStackSize = 16;
    }

    public ItemInstance use(ItemInstance item, Level level, PlayerBase player) {
        --item.count;
        level.playSound(player, "random.bow", 0.5F, 0.4F / (rand.nextFloat() * 0.4F + 0.8F));
        if (!level.isClient) {
            level.spawnEntity(new EntityGoldenEgg(level, player));
        }

        return item;
    }
}
